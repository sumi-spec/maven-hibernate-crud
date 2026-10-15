package com.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int durationMonths;

    public Course() {}

    public Course(String name, int durationMonths) {
        this.name = name;
        this.durationMonths = durationMonths;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getDurationMonths() { return durationMonths; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDurationMonths(int durationMonths) { this.durationMonths = durationMonths; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', durationMonths=" + durationMonths + "}";
    }
}
