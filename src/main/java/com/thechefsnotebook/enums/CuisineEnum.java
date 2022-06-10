package com.thechefsnotebook.enums;

public enum CuisineEnum {
    JAPANESE("Japanese"),
    AMERICAN("American"),
    KOREAN("Korean");

    private final String cuisine;

    private CuisineEnum(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }
}
