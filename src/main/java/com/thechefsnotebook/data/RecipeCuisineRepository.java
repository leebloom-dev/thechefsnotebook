package com.thechefsnotebook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thechefsnotebook.models.RecipeCuisine;

@Repository
public interface RecipeCuisineRepository extends CrudRepository<RecipeCuisine, Integer> {
    
}
