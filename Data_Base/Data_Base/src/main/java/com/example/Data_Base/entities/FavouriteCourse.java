package com.example.Data_Base.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "favouriteTable")
public class FavouriteCourse {
	
	@Id
	@Column(name = "favourite_id")
	private int favouriteId;

	@ManyToOne
	@JoinColumn(name = "registration_id")
//	@Column(name = "registration_id")
	private RegisterdCourses registrationId;

	public FavouriteCourse(int favouriteId, RegisterdCourses registrationId) {
		super();
		this.favouriteId = favouriteId;
		this.registrationId = registrationId;
	}

	public int getFavouriteId() {
		return favouriteId;
	}

	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}

	public RegisterdCourses getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(RegisterdCourses registrationId) {
		this.registrationId = registrationId;
	}

	@Override
	public String toString() {
		return "FavouriteCourse [favouriteId=" + favouriteId + ", registrationId=" + registrationId + "]";
	}

	
}
