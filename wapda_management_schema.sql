
-- Database: wapda

CREATE DATABASE IF NOT EXISTS wapda;
USE wapda;

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role ENUM('customer', 'admin') NOT NULL
);

-- Table: meter_info
CREATE TABLE IF NOT EXISTS meter_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    meter_number VARCHAR(50) UNIQUE NOT NULL,
    address TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table: bills
CREATE TABLE IF NOT EXISTS bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    month VARCHAR(20),
    year INT,
    units_consumed INT,
    unit_price DECIMAL(10, 2),
    total_amount DECIMAL(10, 2),
    bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('unpaid', 'paid') DEFAULT 'unpaid',
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table: transactions
CREATE TABLE IF NOT EXISTS transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bill_id INT,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount_paid DECIMAL(10, 2),
    FOREIGN KEY (bill_id) REFERENCES bills(id)
);
