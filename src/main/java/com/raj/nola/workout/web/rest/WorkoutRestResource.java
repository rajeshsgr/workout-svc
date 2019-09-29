package com.raj.nola.workout.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.raj.nola.workout.domain.WorkoutCategory;
import com.raj.nola.workout.dto.WorkoutCategoryDto;
import com.raj.nola.workout.dto.WorkoutDto;
import com.raj.nola.workout.repository.WorkoutCategoryRepository;
import com.raj.nola.workout.repository.WorkoutRepository;
import com.raj.nola.workout.service.WorkoutCategoryService;
import com.raj.nola.workout.service.WorkoutService;
import com.raj.nola.workout.web.rest.errors.BadRequestAlertException;
import com.raj.nola.workout.web.rest.util.HeaderUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * WorkoutRestResource controller
 */
/**
 * @author rajeshp
 *
 */
/**
 * @author rajeshp
 *
 */
@RestController
@RequestMapping("/api")
public class WorkoutRestResource {

	private final Logger log = LoggerFactory.getLogger(WorkoutRestResource.class);

	private static final String ENTITY_NAME = "workoutSvc";

	private final WorkoutService workoutSvc;



	public WorkoutRestResource(WorkoutService workoutSvc) {
		super();
		this.workoutSvc = workoutSvc;
	}

	

	@RequestMapping(value = "workout/{categoryId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public WorkoutDto createBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody WorkoutDto workout) {
		
		return workoutSvc.createWorkout(categoryId, workout);
				
		
	}

	/**
	 * POST /users : Create a new workout.
	 *
	 
	 */
	@PostMapping("/workout")
	@Timed
	public ResponseEntity<WorkoutDto> createWorkout(@Valid @RequestBody WorkoutDto workoutDTO)
			throws URISyntaxException {

		log.debug("REST request to save Workout  : {}", workoutDTO);

		if (workoutDTO.getId() != null) {
			throw new BadRequestAlertException("A new workout cannot already have an ID", ENTITY_NAME, "idexists");
		}

		WorkoutDto result = workoutSvc.save(workoutDTO);

		return ResponseEntity.created(new URI("/api/workout/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}
	
	
	
	
    @GetMapping("/workout")
    @Timed
    public List<WorkoutDto> getAllWorkouts() {
        log.debug("REST request to get all Workout");
        
        return workoutSvc.findAll();
    }

	
	
    
    @GetMapping("/workout/{id}")
    @Timed
    public ResponseEntity<WorkoutDto> getWorkout(@PathVariable Long id) {
        log.debug("REST request to get Workout : {}", id);
        Optional<WorkoutDto> usersDTO = workoutSvc.findOne(id);
        
        return ResponseUtil.wrapOrNotFound(usersDTO);
    }

   
    @DeleteMapping("/workout/{id}")
    @Timed
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        log.debug("REST request to delete Workout : {}", id);
        workoutSvc.delete(id);
        
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
    
    
    

}
