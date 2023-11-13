package me.reporte.course.enums;

public enum CategoryEnum {
    BACKEND("back-end"), 
    FRONTEND("front-end");

    private String value;

    private CategoryEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
    
}
