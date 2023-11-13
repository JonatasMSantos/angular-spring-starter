package me.reporte.course.dto.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import me.reporte.course.dto.CourseDTO;
import me.reporte.course.dto.CourseRequestDTO;
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
        List<LessonDTO> lessonDTOList = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getUrl()))
                .toList();
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(),
                lessonDTOList);
    }

    public Course toModel(CourseRequestDTO courseRequestDTO) {

        Course course = new Course();
        course.setName(courseRequestDTO.name());
        course.setCategory(convertCategoryValue(courseRequestDTO.category()));

        Set<Lesson> lessons = courseRequestDTO.lessons().stream()
                .map(lessonDTO -> {
                    Lesson lesson = new Lesson();
                    if (lesson.getId() > 0) {
                        lesson.setId(lessonDTO.id());
                    }
                    lesson.setName(lessonDTO.name());
                    lesson.setUrl(lessonDTO.url());
                    lesson.setCourse(course);
                    return lesson;
                }).collect(Collectors.toSet());
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

    public Lesson convertLessonDTOToLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonDTO.id());
        lesson.setName(lessonDTO.name());
        lesson.setUrl(lessonDTO.url());
        return lesson;
    }
}
