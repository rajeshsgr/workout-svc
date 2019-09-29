package com.raj.nola.workout.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workout_id")
	private Long id;

	@Column(name = "workout_name")
	private String workoutName;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	@JsonIgnore
	private WorkoutCategory workoutCategory;

	public Workout() {

	}

	public Workout(String workoutName, WorkoutCategory workoutCategory) {

		this.workoutName = workoutName;
		this.workoutCategory = workoutCategory;
	}

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

	public WorkoutCategory getWorkoutCategory() {
		return workoutCategory;
	}

	public void setWorkoutCategory(WorkoutCategory workoutCategory) {
		this.workoutCategory = workoutCategory;
	}
	
	
	

}
