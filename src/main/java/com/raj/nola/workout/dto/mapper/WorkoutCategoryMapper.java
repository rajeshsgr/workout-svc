package com.raj.nola.workout.dto.mapper;

import org.mapstruct.Mapper;

import com.raj.nola.workout.domain.Workout;
import com.raj.nola.workout.domain.WorkoutCategory;
import com.raj.nola.workout.dto.WorkoutCategoryDto;
import com.raj.nola.workout.dto.WorkoutDto;


@Mapper(componentModel = "spring", uses = {})
public interface WorkoutCategoryMapper extends EntityMapper<WorkoutCategoryDto, WorkoutCategory>{
	
	

}
