package me.reporte.course.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import me.reporte.course.enums.CategoryEnum;
import me.reporte.course.enums.converters.CategoryEnumConverter;

@Entity
@SQLDelete(sql = "UPDATE Course SET visible = false WHERE id = ?")
@Where(clause = "visible = true")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryEnumConverter.class)
    private CategoryEnum category;

    @Column(nullable = false)
    private boolean visible = true;

    @NotNull
    @NotEmpty
    @Valid
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<Lesson> lessons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        if (lessons == null) {
            throw new IllegalArgumentException("Lessons cannot be null.");
        }
        this.lessons.clear();
        this.lessons.addAll(lessons);
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson cannot be null.");
        }
        lesson.setCourse(this);
        this.lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson cannot be null.");
        }
        lesson.setCourse(null);
        this.lessons.remove(lesson);
    }

}
