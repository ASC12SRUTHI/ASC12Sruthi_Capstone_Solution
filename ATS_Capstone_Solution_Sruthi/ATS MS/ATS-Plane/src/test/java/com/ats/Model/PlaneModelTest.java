package com.ats.Model;

import com.ats.model.PlaneModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlaneModelTest {
    PlaneModel planeModel = new PlaneModel("PL0001", "Boeing", "777" , 200);

    @Test
    void testId() {
        String actualId = planeModel.getId();
        Assertions.assertEquals("PL0001", actualId);
    }

    @Test
    void testPlaneMaker() {
        String actualPlaneMaker = planeModel.getPlaneMaker();
        Assertions.assertEquals("Boeing", actualPlaneMaker);
    }

    @Test
    void testModel() {
        String actualModel = planeModel.getModel();
        Assertions.assertEquals("777", actualModel);
    }
    @Test
    void testSeatingCapacity() {
        int actualSeatingCapacity = planeModel.getSeatingCapacity();
        Assertions.assertEquals(200, actualSeatingCapacity);
    }
}

