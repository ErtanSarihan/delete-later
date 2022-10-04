package com.silva.databaselearningproject.runner;

import com.silva.databaselearningproject.model.Course;
import com.silva.databaselearningproject.repository.CourseJpaRepository;
import com.silva.databaselearningproject.repository.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    private final CourseSpringDataJpaRepository courseSpringDataJpaRepository;


    @Autowired
    public CourseCommandLineRunner(CourseSpringDataJpaRepository courseSpringDataJpaRepository) {
        this.courseSpringDataJpaRepository = courseSpringDataJpaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        courseSpringDataJpaRepository.save(new Course(1, "Learning to walk again", "Taylor Hawkins"));
        courseSpringDataJpaRepository.save(new Course(2, "Learning to talk again", "Alice Cooper"));
        courseSpringDataJpaRepository.save(new Course(3, "Learning to love again", "Ozzy Osbourne"));

        courseSpringDataJpaRepository.deleteById(1L);

        System.out.println(courseSpringDataJpaRepository.findById(2L));
        System.out.println(courseSpringDataJpaRepository.findById(3L));

    }
}
