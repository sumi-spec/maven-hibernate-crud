package com.example.hibernate;

import com.example.hibernate.dao.CourseDAO;
import com.example.hibernate.dao.StudentDAO;
import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Student;
import com.example.hibernate.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();

        Student student = studentDAO.findByEmail("rahul@example.com");
        if (student == null) {
            student = new Student("Rahul Sharma", "rahul@example.com", "Bengaluru");
            studentDAO.save(student);
        }

        Course course = new Course("Java + Hibernate", 3);
        courseDAO.save(course);

        System.out.println("\n--- All Students ---");
        studentDAO.findAll().forEach(System.out::println);

        System.out.println("\n--- All Courses ---");
        courseDAO.findAll().forEach(System.out::println);

        System.out.println("\n--- Find Student By ID ---");
        System.out.println(studentDAO.findById(student.getId()));

        student.setCity("Lucknow");
        studentDAO.update(student);

        System.out.println("\n--- Updated Student ---");
        System.out.println(studentDAO.findById(student.getId()));

        // Uncomment to test delete:
        // studentDAO.delete(student.getId());

        HibernateUtil.shutdown();
    }
}
