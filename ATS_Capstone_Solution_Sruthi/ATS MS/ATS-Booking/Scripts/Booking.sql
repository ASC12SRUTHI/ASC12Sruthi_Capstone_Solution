CREATE TABLE bookings (
    booking_id VARCHAR(5) PRIMARY KEY,
    passenger_name VARCHAR(100) NOT NULL,
    booking_date DATE NOT NULL,
    seat_number int,
    cost DECIMAL(10, 2) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    departure_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_date VARCHAR(100),
    arrival_time VARCHAR(100)
);
SELECT * FROM bookings;
INSERT INTO bookings (booking_id, passenger_name, booking_date, seat_number, cost, total_amount, departure_date, departure_time, arrival_date, arrival_time)
VALUES ('B0001', 'John Doe', '2024-08-01', 12, 150.00, 150.00, '2024-08-10', '08:30:00', '2024-08-10', '11:30:00');

INSERT INTO bookings (booking_id, passenger_name, booking_date, seat_number, cost, total_amount, departure_date, departure_time, arrival_date, arrival_time)
VALUES ('B0002', 'Jane Smith', '2024-08-02', 15, 200.00, 200.00, '2024-08-15', '09:00:00', '2024-08-15', '12:00:00');

INSERT INTO bookings (booking_id, passenger_name, booking_date, seat_number, cost, total_amount, departure_date, departure_time, arrival_date, arrival_time)
VALUES ('B0003', 'Alice Johnson', '2024-08-03', 20, 250.00, 250.00, '2024-08-20', '10:00:00', '2024-08-20', '13:00:00');
DROP TABLE bookings;


