package me.reporte.course;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.reporte.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByVisible(Pageable pageable, boolean visible);

    List<Course> findByName(String name);
}
