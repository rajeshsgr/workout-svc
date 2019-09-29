package com.raj.nola.workout.dto;

public class WorkoutDto {
	
	private Long id;
	private String workoutName;
	
	private WorkoutCategoryDto workoutCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public WorkoutCategoryDto getWorkoutCategory() {
		return workoutCategory;
	}

	public void setWorkoutCategory(WorkoutCategoryDto workoutCategory) {
		this.workoutCategory = workoutCategory;
	}
	

	
	

}
