package com.thechefsnotebook.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thechefsnotebook.models.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
