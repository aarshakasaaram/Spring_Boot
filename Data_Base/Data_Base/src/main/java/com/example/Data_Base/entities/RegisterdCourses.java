package com.example.Data_Base.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Registered_table")
public class RegisterdCourses {
	@Id
	private int registrationId;

	@ManyToOne
	@JoinColumn(name = "user_id")
//	@Column(name = "user_id")
	private Users userId;

	@ManyToOne
	@JoinColumn(name = "course_id")
//	@Column(name = "course_id")
	private Course courseId;

	public RegisterdCourses(int registrationId, Users userId, Course courseId) {
		super();
		this.registrationId = registrationId;
		this.userId = userId;
		this.courseId = courseId;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "RegisterdCourses [registrationId=" + registrationId + ", userId=" + userId + ", courseId=" + courseId
				+ "]";
	}

	

}
