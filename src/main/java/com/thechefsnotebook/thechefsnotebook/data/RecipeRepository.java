package com.thechefsnotebook.thechefsnotebook.data;

import com.thechefsnotebook.thechefsnotebook.model.Recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
