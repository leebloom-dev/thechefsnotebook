package com.thechefsnotebook.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thechefsnotebook.enums.CuisineEnum;

public class CuisineData {

    private static final List<CuisineEnum> cuisines = new ArrayList<>();
    private static boolean valid = true; 

    // get all cuisines
    public static Collection<CuisineEnum> getAll() {
        if (valid == true) {
            add();
            valid = false;
        }

        return cuisines;
    }

    // add all cuisines
    public static void add() {
        for (CuisineEnum cuisine : CuisineEnum.values()) {
            cuisines.add(cuisine);
        }
    }

    // delete all cuisines
    public static void delete() {
        cuisines.clear();
    }
    
}
