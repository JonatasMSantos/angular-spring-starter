package me.reporte.course.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import me.reporte.course.enums.CategoryEnum;
import me.reporte.shared.validation.ValueOfEnum;

/**
 * Used as request object that represents a Course.
 */
public record CourseRequestDTO(
        @NotBlank @NotNull @Length(min = 5, max = 200) String name,
        @NotBlank @NotNull @ValueOfEnum(enumClass = CategoryEnum.class) String category,
        @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
}