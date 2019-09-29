package com.raj.nola.workout.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WorkoutCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
    private Long id;
	
    private String category;

    
    @OneToMany(mappedBy = "workoutCategory", cascade = CascadeType.ALL)
    private Set<Workout> workouts;


	public WorkoutCategory() {
		
	}


	public WorkoutCategory(String category) {
	
		this.category = category;
	}


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


	public Set<Workout> getWorkout() {
		return workouts;
	}


	public void setWorkout(Set<Workout> workouts) {
		this.workouts = workouts;
	}


	
	
    
    

}
