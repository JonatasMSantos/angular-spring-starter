package me.reporte.course.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import me.reporte.course.enums.CategoryEnum;
import me.reporte.shared.validation.ValueOfEnum;

public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @NotNull @Length(max = 10) @ValueOfEnum(enumClass = CategoryEnum.class) String category,
        @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
}