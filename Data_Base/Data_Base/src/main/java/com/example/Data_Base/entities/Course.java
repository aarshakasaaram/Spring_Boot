package com.example.Data_Base.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CourseTable")
public class Course {
    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_category")
    private String courseCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "title")
    private String title;

    // No-argument constructor (required by JPA)
    public Course() {
    }

    // Parameterized constructor
    public Course(int courseId, String courseCategory, String description, int price, String title) {
        super();
        this.courseId = courseId;
        this.courseCategory = courseCategory;
        this.description = description;
        this.price = price;
        this.title = title;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseCategory=" + courseCategory + ", description=" + description
                + ", price=" + price + ", title=" + title + "]";
    }
}
