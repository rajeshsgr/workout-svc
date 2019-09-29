package com.raj.nola.workout.dto;

import java.util.ArrayList;
import java.util.List;

import com.raj.nola.workout.domain.Workout;

public class WorkoutCategoryDto {
	
	private Long id;
	
	private String category;

    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	

}
