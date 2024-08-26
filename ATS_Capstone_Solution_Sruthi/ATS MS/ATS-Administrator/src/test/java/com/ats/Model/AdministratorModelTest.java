package com.ats.Model;

import com.ats.model.AdministratorModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

 class AdministratorModelTest {
    AdministratorModel administratorModel = new AdministratorModel(1L, "sruthi@812", "Sruthi@812",
            "1234567890", 3,  LocalDateTime.now(),true);
    @Test
    void testIdField() {
        Long actualId = administratorModel.getId();
        Assertions.assertEquals(1L, actualId);
    }

    @Test
    void testEmailIdField() {
        String actualEmailId = administratorModel.getEmailId();
        Assertions.assertEquals("sruthi@812", actualEmailId);
    }

    @Test
    void testPasswordField() {
        String actualPassword = administratorModel.getPassword();
        Assertions.assertEquals("Sruthi@812", actualPassword);
    }

    @Test
    void testPhoneNumberField() {
        String actualPhoneNumber = administratorModel.getPhoneNumber();
        Assertions.assertEquals("1234567890", actualPhoneNumber);
    }

    @Test
    void testFailedAttemptsField() {
        int actualFailedAttempts = administratorModel.getFailedAttempts();
        Assertions.assertEquals(3, actualFailedAttempts);
    }

    @Test
    void testIsLockedField() {
        AdministratorModel administratorModelLocked = new AdministratorModel(2L, "sameera@114", "Sameera@114",
                "9876543210", 3, LocalDateTime.now(), true);
        AdministratorModel administratorModelLocked1 = new AdministratorModel(3L, "priya@101", "Priya@101",
                "8976543210", 3, LocalDateTime.now(),false);

        Assertions.assertTrue(administratorModelLocked.isLocked());
        Assertions.assertFalse(administratorModelLocked1.isLocked());
    }

    @Test
    void testLockTimeField() {
        LocalDateTime expectedLockTime = LocalDateTime.now();
        AdministratorModel administratorModel1 = new AdministratorModel(4L, "Nandhini@79", "nandhini@79",
                "7654389764", 3,  expectedLockTime,true);

        LocalDateTime actualLockTime = administratorModel1.getLastAttemptTime();
        Assertions.assertEquals(expectedLockTime, actualLockTime);
    }
}


