CREATE DATABASE AtsMicroservice;
USE AtsMicroservice;
CREATE TABLE Login(
    id BIGINT PRIMARY KEY,
    email_Id VARCHAR(20),
    password VARCHAR(20),
    phone_Number VARCHAR(10),
    failed_Attempts INT DEFAULT 0,
    last_Attempt_Time DATETIME,
    locked BOOLEAN DEFAULT FALSE
);
SELECT * FROM Login;
INSERT INTO Login VALUES(1,"sruthi812@gmail.com","Sruthi@812",9876543210,0,'2024-08-21 12:45:34',0);
INSERT INTO Login VALUES(2,"sameera117@gmail.com","Sameera@117",6785439802,0,'2024-08-21 10:45:23',false);
DROP TABLE Login;
