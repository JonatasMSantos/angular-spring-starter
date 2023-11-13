package me.reporte.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.reporte.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
