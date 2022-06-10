package com.thechefsnotebook.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.thechefsnotebook.enums.CuisineEnum;

public class CuisineData {

    private static final List<String> cuisines = new ArrayList<>();
    private static boolean singleUse = true;

    // add cuisine enum to list
    public static void add() {
        for (CuisineEnum cuisine : CuisineEnum.values()) {
            cuisines.add(cuisine.getCuisine());
        }
    }

    // get cuisines from list
    public static List<String> getAll() {
        // add cuisine enums to list only once
        if (singleUse == true) {
            add();
            singleUse = false;
        }

        Collections.sort(cuisines);
        return cuisines;
    }
    
}
