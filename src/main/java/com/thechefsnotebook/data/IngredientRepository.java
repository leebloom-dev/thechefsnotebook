package com.thechefsnotebook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thechefsnotebook.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    
}
