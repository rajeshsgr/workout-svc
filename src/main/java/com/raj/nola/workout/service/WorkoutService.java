package com.raj.nola.workout.service;

import java.util.List;
import java.util.Optional;

import com.raj.nola.workout.dto.WorkoutDto;

/**
 * Service Interface for managing Workout.
 */
public interface WorkoutService {
	
	
	/**
     * Save a workout.
     *
     * @param usersDTO the entity to save
     * @return the persisted entity
     */
    WorkoutDto save(WorkoutDto workoutDTO);
    
    
    /**
     * Get all the workout list.
     *
     * @return the list of entities
     */
    List<WorkoutDto> findAll();


    /**
     * Get the workout based on id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WorkoutDto> findOne(Long id);

    /**
     * Delete the "id" workout.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    
    WorkoutDto createWorkout(Long categoryId, WorkoutDto workoutDTO);

}
