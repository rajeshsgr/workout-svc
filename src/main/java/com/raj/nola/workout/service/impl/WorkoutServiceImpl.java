package com.raj.nola.workout.service.impl;

import com.raj.nola.workout.domain.Workout;
import com.raj.nola.workout.domain.WorkoutCategory;
import com.raj.nola.workout.dto.WorkoutDto;
import com.raj.nola.workout.dto.mapper.WorkoutCategoryMapper;
import com.raj.nola.workout.dto.mapper.WorkoutMapper;
import com.raj.nola.workout.repository.WorkoutCategoryRepository;
import com.raj.nola.workout.repository.WorkoutRepository;
import com.raj.nola.workout.service.WorkoutService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkoutServiceImpl implements WorkoutService {

	private final Logger log = LoggerFactory.getLogger(WorkoutServiceImpl.class);

	private final WorkoutRepository workoutRepository;

	private final WorkoutCategoryRepository workoutCategoryRepository;

	private final WorkoutMapper workoutMapper;

	private final WorkoutCategoryMapper workoutCategoryMapper;

	public WorkoutServiceImpl(WorkoutRepository workoutRepository, WorkoutCategoryRepository workoutCategoryRepository,
			WorkoutMapper workoutMapper, WorkoutCategoryMapper workoutCategoryMapper) {
		this.workoutRepository = workoutRepository;
		this.workoutCategoryRepository = workoutCategoryRepository;
		this.workoutMapper = workoutMapper;
		this.workoutCategoryMapper = workoutCategoryMapper;
	}

	@Override
	public WorkoutDto save(WorkoutDto workoutDTO) {
		// TODO Auto-generated method stub

		log.debug("Request to save Workout : {}", workoutDTO);

		Workout workoutDomain = workoutMapper.toDomain(workoutDTO);

		Workout workoutSaved = workoutRepository.save(workoutDomain);

		return workoutMapper.toDto(workoutSaved);

	}

	@Override
	public List<WorkoutDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<WorkoutDto> findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		workoutRepository.deleteById(id);
		//System.out.println(l.isEmpty());

	}

	@Override
	public WorkoutDto createWorkout(Long categoryId, WorkoutDto workoutDTO) {
		// TODO Auto-generated method stub

		log.debug("Category ID to be associated : {}", categoryId);

		Optional<WorkoutCategory> byId = workoutCategoryRepository.findById(categoryId);

		if (!byId.isPresent()) {
			log.debug("Category id : {} doesnt exist", categoryId);

		}

		WorkoutCategory category = byId.get();

		workoutDTO.setWorkoutCategory(workoutCategoryMapper.toDto(category));

		Workout workoutSaved = workoutRepository.save(workoutMapper.toDomain(workoutDTO));

		return workoutMapper.toDto(workoutSaved);
	}

}
