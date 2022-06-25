package com.thechefsnotebook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thechefsnotebook.models.RecipeCategory;

@Repository
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
    
}
