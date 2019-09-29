package com.raj.nola.workout.web.rest;

import com.raj.nola.workout.WorkoutsvcApp;
import com.raj.nola.workout.service.WorkoutCategoryService;
import com.raj.nola.workout.service.WorkoutService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the WorkoutRestResource REST controller.
 *
 * @see WorkoutRestResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkoutsvcApp.class)
public class WorkoutRestResourceIntTest {

    private MockMvc restMockMvc;

    @Autowired
    private WorkoutService workoutService;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        WorkoutRestResource workoutRestResource = new WorkoutRestResource(workoutService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(workoutRestResource)
            .build();
    }

    /**
     * Test defaultAction
     */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/workout-rest/default-action"))
            .andExpect(status().isOk());
    }
}
