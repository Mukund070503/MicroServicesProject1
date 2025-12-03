package com.Icwd.user.service.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_users")
public class User {

	@Id
	@Column(name="ID")
	private String userId;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings; 
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
