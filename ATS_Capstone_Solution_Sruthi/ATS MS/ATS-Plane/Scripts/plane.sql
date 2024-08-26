CREATE TABLE Plane(
    id VARCHAR(50),
    Plane_Maker VARCHAR(50),
    Model VARCHAR(50),
    Seating_Capacity INT
);
SELECT * FROM Plane;
INSERT INTO Plane VALUES("PL0001","Voronezh Aircraft Production","Ilyushin II-96",300);
INSERT INTO Plane VALUES("PL0002","Boeing","Boeing 767",245);
INSERT INTO Plane VALUES("PL0003","Airbus","Airbus A380",853);
DROP TABLE Plane;