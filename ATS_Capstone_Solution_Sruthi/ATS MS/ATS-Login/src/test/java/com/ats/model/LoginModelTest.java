package com.ats.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class LoginModelTest {

        LoginModel loginModel1 = new LoginModel(1L, "sruthi@812", "Sruthi@812",
                "1234567890", 3,  LocalDateTime.now(),true);
        @Test
         void testIdField() {
            Long actualId = loginModel1.getId();
            Assertions.assertEquals(1L, actualId);
        }

        @Test
        void testEmailIdField() {
            String actualEmailId = loginModel1.getEmailId();
            Assertions.assertEquals("sruthi@812", actualEmailId);
        }

        @Test
        void testPasswordField() {
            String actualPassword = loginModel1.getPassword();
            Assertions.assertEquals("Sruthi@812", actualPassword);
        }

        @Test
        void testPhoneNumberField() {
            String actualPhoneNumber = loginModel1.getPhoneNumber();
            Assertions.assertEquals("1234567890", actualPhoneNumber);
        }

        @Test
        void testFailedAttemptsField() {
            int actualFailedAttempts = loginModel1.getFailedAttempts();
            Assertions.assertEquals(3, actualFailedAttempts);
        }

        @Test
        void testIsLockedField() {
            LoginModel loginDetailsLocked = new LoginModel(2L, "sameera@114", "Sameera@114",
                    "9876543210", 3, LocalDateTime.now(), true);
            LoginModel loginDetailsNotLocked = new LoginModel(3L, "priya@101", "Priya@101",
                    "8976543210", 3, LocalDateTime.now(),false);

            Assertions.assertTrue(loginDetailsLocked.isLocked());
            Assertions.assertFalse(loginDetailsNotLocked.isLocked());
        }

        @Test
        void testLockTimeField() {
            LocalDateTime expectedLockTime = LocalDateTime.now();
            LoginModel loginModel = new LoginModel(4L, "Nandhini@79", "nandhini@79",
                    "7654389764", 3,  expectedLockTime,true);

            LocalDateTime actualLockTime = loginModel.getLastAttemptTime();
            Assertions.assertEquals(expectedLockTime, actualLockTime);
        }
    }


