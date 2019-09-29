package com.raj.nola.workout.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.raj.nola.workout.dto.WorkoutCategoryDto;
import com.raj.nola.workout.dto.WorkoutDto;
import com.raj.nola.workout.service.WorkoutCategoryService;
import com.raj.nola.workout.web.rest.errors.BadRequestAlertException;
import com.raj.nola.workout.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * WorkoutCategoryRestResource controller
 */
@RestController
@RequestMapping("/api")
public class WorkoutCategoryRestResource {

    private final Logger log = LoggerFactory.getLogger(WorkoutCategoryRestResource.class);
    
    
    private static final String ENTITY_NAME = "workoutCategorySvc";
    
    private final WorkoutCategoryService workoutCategorySvc;
    
    

    public WorkoutCategoryRestResource(WorkoutCategoryService workoutCategorySvc) {
		super();
		this.workoutCategorySvc = workoutCategorySvc;
	}

	
    
   
    @PostMapping("/workout-category")
    @Timed
    public ResponseEntity<WorkoutCategoryDto> createWorkoutCategory(@Valid @RequestBody WorkoutCategoryDto workoutCategoryDTO) throws URISyntaxException {
        
    	log.debug("REST request to save Workout Category : {}", workoutCategoryDTO);
    	
        if (workoutCategoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new workout cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        
        WorkoutCategoryDto result=workoutCategorySvc.save(workoutCategoryDTO);
        
        return ResponseEntity.created(new URI("/api/workout-category/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
    
    @GetMapping("/workout-category")
    @Timed
    public List<WorkoutCategoryDto> getAllWorkoutCategory() {
        
    	log.debug("REST request to get all Workout category");
        
        return workoutCategorySvc.findAll();
    }

	
	
    
    @GetMapping("/workout-category/{id}")
    @Timed
    
    public ResponseEntity<WorkoutCategoryDto> getWorkoutCategoryById(@PathVariable Long id) {
       
    	log.debug("REST request to get Workout : {}", id);
        Optional<WorkoutCategoryDto> result = workoutCategorySvc.findOne(id);
        
        return ResponseUtil.wrapOrNotFound(result);
    }

   
    @DeleteMapping("/workout-category/{id}")
    @Timed
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
    	
        log.debug("REST request to delete Workout Category: {}", id);
        
        workoutCategorySvc.delete(id);
        
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
    

}
