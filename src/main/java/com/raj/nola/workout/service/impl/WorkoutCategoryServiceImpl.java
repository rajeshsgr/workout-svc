package com.raj.nola.workout.service.impl;

import com.raj.nola.workout.domain.Workout;
import com.raj.nola.workout.domain.WorkoutCategory;
import com.raj.nola.workout.dto.WorkoutCategoryDto;
import com.raj.nola.workout.dto.mapper.WorkoutCategoryMapper;
import com.raj.nola.workout.dto.mapper.WorkoutMapper;
import com.raj.nola.workout.repository.WorkoutCategoryRepository;
import com.raj.nola.workout.repository.WorkoutRepository;
import com.raj.nola.workout.service.WorkoutCategoryService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkoutCategoryServiceImpl implements WorkoutCategoryService {

    private final Logger log = LoggerFactory.getLogger(WorkoutCategoryServiceImpl.class);

    private final WorkoutCategoryRepository workoutCategoryRepository;
    
    private final WorkoutRepository workoutRepository;


    private final WorkoutCategoryMapper workoutCategoryMapper;
    
    
    
    
	public WorkoutCategoryServiceImpl(WorkoutCategoryRepository workoutCategoryRepository,
			WorkoutCategoryMapper workoutCategoryMapper, WorkoutRepository workoutRepository ) {
		super();
		this.workoutCategoryRepository = workoutCategoryRepository;
		this.workoutCategoryMapper = workoutCategoryMapper;
		this.workoutRepository=workoutRepository;
	}



	@Override
	public WorkoutCategoryDto save(WorkoutCategoryDto workoutCategoryDTO) {
		// TODO Auto-generated method stub
		
		
		log.debug("Request to save WorkoutCategory : {}", workoutCategoryDTO);

        WorkoutCategory workoutCategoryDomain = workoutCategoryMapper.toDomain(workoutCategoryDTO);
        
        WorkoutCategory workoutCategorySaved=  workoutCategoryRepository.save(workoutCategoryDomain);
        
        return workoutCategoryMapper.toDto(workoutCategorySaved);
	}



	@Override
	public List<WorkoutCategoryDto> findAll() {
		// TODO Auto-generated method stub
		
		log.debug("Request to get all workout categories");

		return workoutCategoryRepository.findAll()
				.stream()
				.map(workoutCategoryMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}



	@Override
	public Optional<WorkoutCategoryDto> findOne(Long id) {
		// TODO Auto-generated method stub
		
		log.debug("Request to find a workout category by id");
		
		return workoutCategoryRepository.findById(id).map(workoutCategoryMapper::toDto);
		
	}



	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		log.debug("Request to delete Workout Category : {}", id);
		
		List<Workout> workoutList=workoutRepository.findByWorkoutCategory(id);
		
		
		if(workoutList.isEmpty()) {
			
			workoutCategoryRepository.deleteById(id);
			
		}else {
			
			System.out.println("Sorry Cannot Delete");
		
		}
		
	}
	
	
	
	

}
