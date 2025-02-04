package com.example.Data_Base.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
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

 }

   
