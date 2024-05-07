create database zara;
use zara;

CREATE TABLE Categories (
                            CategoryID INT AUTO_INCREMENT PRIMARY KEY,
                            Name VARCHAR(255)
);

CREATE TABLE Manufacturers (
                               ManufacturerID INT AUTO_INCREMENT PRIMARY KEY,
                               Name VARCHAR(255)
);
CREATE TABLE Warehouses (
                            WarehouseID INT AUTO_INCREMENT PRIMARY KEY,
                            Name VARCHAR(255),
                            Location VARCHAR(255)
);
CREATE TABLE Products
(
    ProductID      INT AUTO_INCREMENT PRIMARY KEY,
    Name           VARCHAR(255),
    Price          DECIMAL(10, 2),
    CategoryID     INT,
    ManufacturerID INT,
    WarehouseID    INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID),
    FOREIGN KEY (ManufacturerID) REFERENCES Manufacturers (ManufacturerID),
    FOREIGN KEY (WarehouseID) REFERENCES Warehouses (WarehouseID)
);

ALTER TABLE Products
    ADD COLUMN Image text;

SELECT * FROM Products;
SELECT * FROM Categories where CategoryID = 1;
select count(*) from Products;