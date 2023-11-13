package me.reporte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.reporte.course.CourseRepository;
import me.reporte.course.enums.CategoryEnum;
import me.reporte.course.model.Course;
import me.reporte.course.model.Lesson;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
 
	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 80; i++) {

				Course c = new Course();
				c.setName("Angular com Spring " + i);
				c.setCategory(CategoryEnum.BACKEND);

				Lesson lesson = new Lesson();
				lesson.setName("Introdução");
				lesson.setUrl("https://google.com");
				lesson.setCourse(c);
				c.getLessons().add(lesson);

				Lesson lesson2 = new Lesson();
				lesson2.setName("Angular");
				lesson2.setUrl("https://google.com");
				lesson2.setCourse(c);
				c.getLessons().add(lesson2);

				courseRepository.save(c);
			}
		};
	}

}
