package me.reporte.course.dto.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import me.reporte.course.dto.CourseDTO;
import me.reporte.course.dto.LessonDTO;
import me.reporte.course.enums.CategoryEnum;
import me.reporte.course.model.Course;
import me.reporte.course.model.Lesson;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        List<LessonDTO> lessons = course.getLessons().stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getUrl()))
                .toList();

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));


        List<Lesson> lessons = courseDTO.lessons().stream().map(lessonDTO -> {
            var lesson = new Lesson();
            lesson.setId(lessonDTO.id());
            lesson.setName(lessonDTO.name());
            lesson.setUrl(lessonDTO.url());
            lesson.setCourse(course);
            return lesson;
        }).toList();

        course.setLessons(lessons);

        return course;
    }

    public CategoryEnum convertCategoryValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "front-end" -> CategoryEnum.FRONTEND;
            case "back-end" -> CategoryEnum.BACKEND;
            default -> throw new IllegalArgumentException("invalid category");
        };
    }
}
