package me.reporte.crudspring.enums.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import me.reporte.crudspring.enums.CategoryEnum;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryEnumConverter implements AttributeConverter<CategoryEnum, String> {

    @Override
    public String convertToDatabaseColumn(CategoryEnum category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public CategoryEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(CategoryEnum.values())
                .filter(c -> c.getValue().equals(value)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
