package com.raj.nola.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.nola.workout.domain.WorkoutCategory;

@Repository
public interface WorkoutCategoryRepository  extends JpaRepository<WorkoutCategory, Long>{

}
