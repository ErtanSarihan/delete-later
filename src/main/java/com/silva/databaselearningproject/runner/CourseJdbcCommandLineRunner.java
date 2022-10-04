package com.silva.databaselearningproject.runner;

import com.silva.databaselearningproject.model.Course;
import com.silva.databaselearningproject.repository.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository courseJdbcRepository;

    @Autowired
    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "learning databases", "edward hyde"));
        courseJdbcRepository.insert(new Course(2, "learning something", "henry hyde"));
        courseJdbcRepository.insert(new Course(3, "learning anything", "edward jekyll"));

        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }
}
