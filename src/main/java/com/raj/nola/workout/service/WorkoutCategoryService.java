package com.raj.nola.workout.service;

import java.util.List;
import java.util.Optional;

import com.raj.nola.workout.dto.WorkoutCategoryDto;

/**
 * Service Interface for managing Workout Category.
 */
public interface WorkoutCategoryService {
	
	
	/**
     * Save a workout.
     *
     * @param usersDTO the entity to save
     * @return the persisted entity
     */
    WorkoutCategoryDto save(WorkoutCategoryDto workoutCategoryDTO);
    
    
    /**
     * Get all the workout category list.
     *
     * @return the list of entities
     */
    List<WorkoutCategoryDto> findAll();


    /**
     * Get a workout category by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WorkoutCategoryDto> findOne(Long id);

    /**
     * Delete a workout category by id.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

}
