package com.raj.nola.workout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raj.nola.workout.domain.Workout;


@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long>{
	

	
	
	
	@Query("select p from Workout p where p.workoutCategory.id = :id ")
	List<Workout> findByWorkoutCategory(@Param("id") Long id);
	
}
