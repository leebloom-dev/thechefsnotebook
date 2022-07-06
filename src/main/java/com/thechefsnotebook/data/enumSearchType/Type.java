package com.thechefsnotebook.data.enumSearchType;

public enum Type {

    CATEGORY("category"),
    CUISINE("cuisine");

    private final String type;

    Type (String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
