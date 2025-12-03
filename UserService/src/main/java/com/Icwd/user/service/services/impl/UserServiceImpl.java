package com.Icwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Icwd.user.service.entities.Hotel;
import com.Icwd.user.service.entities.Rating;
import com.Icwd.user.service.entities.User;
import com.Icwd.user.service.external.service.HotelService;
import com.Icwd.user.service.repositories.UserRepository;
import com.Icwd.user.service.services.UserService;
import com.Icwd.user.service.services.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for id: "+userId));
		 Rating[] ratings = restTemplate.getForObject(
		            "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
		            Rating[].class
		    );

		    // For each rating → fetch hotel → set hotel in rating
		    for (Rating rating : ratings) {
		       // Hotel hotel = restTemplate.getForObject(
		              //  "http://HOTELSERVICE/hotels/" + rating.getHotelId(),
		             //   Hotel.class
		       // );
		    	
		       // rating.setHotel(hotel);
		    	rating.setHotel(hotelService.getHotel(rating.getHotelId()));
		    }

		    // Convert array to List
		    user.setRatings(List.of(ratings));
		return user;
	}
}
