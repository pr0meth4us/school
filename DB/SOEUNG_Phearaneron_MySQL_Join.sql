-- 1. Create the following table and also Insert all the records into the tables as shown below.
-- Table 1: Customers
CREATE database MYSQL_JOIN;
USE MYSQL_JOIN;
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(255)
);

INSERT INTO Customers (CustomerID, CustomerName) VALUES
(1, 'John Doe'),
(2, 'Jane Smith'),
(3, 'Mike Brown'),
(4, 'Lisa White'),
(5, 'Mark Black'),
(6, 'Lucy Green'),
(7, 'Tony Yellow'),
(8, 'Gina Red'),
(9, 'Alex Blue'),
(10, 'Sara Purple');

-- 2. Create the following table and also Insert all the records into the tables as shown below.
-- Table 2: Orders
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Orders (OrderID, CustomerID, ProductID, Quantity) VALUES
(1, 1, 2, 1),
(2, 2, 1, 2),
(3, 3, 4, 1),
(4, 4, 3, 3),
(5, 5, 2, 2),
(6, 6, 1, 1),
(7, 7, 3, 2),
(8, 8, 4, 1),
(9, 9, 2, 3),
(10, 10, 5, 1);

-- 3. Create the following table and also Insert all the records into the tables as shown below.
-- Table 3: Products
CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(255),
    Price DECIMAL(10, 2)
);

INSERT INTO Products (ProductID, ProductName, Price) VALUES
(1, 'Laptop', 1000),
(2, 'Smartphone', 500),
(3, 'Tablet', 600),
(4, 'Monitor', 300),
(5, 'Keyboard', 50),
(6, 'Mouse', 25),
(7, 'Headphones', 75),
(8, 'Webcam', 80),
(9, 'Microphone', 90),
(10, 'Chair', 150);

-- 4. Write the Query to Retrieve the total quantity of products ordered by each customer, only including customers who have made orders.
SELECT Customers.CustomerName, SUM(Orders.Quantity) AS TotalQuantity
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID
GROUP BY Customers.CustomerName;

-- 5. Write the Query to List all customers and their total order quantity, including customers who have not made any orders.
SELECT Customers.CustomerName, COALESCE(SUM(Orders.Quantity), 0) AS TotalQuantity
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
GROUP BY Customers.CustomerName;

-- 7. Write the Query to List all products and the number of times they have been ordered, including products that have never been ordered.
SELECT Products.ProductName, COALESCE(SUM(Orders.Quantity), 0) AS OrderCount
FROM Products
LEFT JOIN Orders ON Products.ProductID = Orders.ProductID
GROUP BY Products.ProductName;

-- 8. Write the Query to Find all products that have never been ordered.
SELECT ProductName
FROM Products
LEFT JOIN Orders ON Products.ProductID = Orders.ProductID
WHERE Orders.ProductID IS NULL;

-- 9. Write the Query to Retrieve all orders, including customer names and product names (not just IDs)
SELECT Orders.OrderID, Customers.CustomerName, Products.ProductName, Orders.Quantity
FROM Orders
JOIN Customers ON Orders.CustomerID = Customers.CustomerID
JOIN Products ON Orders.ProductID = Products.ProductID;

-- 10. Write the Query to List all customers and the total value of all orders they've made, assuming any customer might not have made an order.
SELECT Customers.CustomerName, COALESCE(SUM(Orders.Quantity * Products.Price), 0) AS TotalValue
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
LEFT JOIN Products ON Orders.ProductID = Products.ProductID
GROUP BY Customers.CustomerName;

-- 11. Write the Query to Identify all customers who have never made an order.
SELECT CustomerName
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
WHERE Orders.CustomerID IS NULL;

-- 12. Write the Query to Find orders for products priced above $500, listing customer and product names
SELECT Customers.CustomerName, Products.ProductName
FROM Orders
JOIN Customers ON Orders.CustomerID = Customers.CustomerID
JOIN Products ON Orders.ProductID = Products.ProductID
WHERE Products.Price > 500;

-- 13. Write the Query to Identify customers who have ordered more than 5 items in total across all their orders.
SELECT Customers.CustomerName
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID
GROUP BY Customers.CustomerName
HAVING SUM(Orders.Quantity) > 5;

-- 14. Write the Query to Retrieve order details where customers and products have matching IDs in their respective tables.
SELECT Orders.OrderID, Customers.CustomerName, Products.ProductName, Orders.Quantity
FROM Orders
JOIN Customers ON Orders.CustomerID = Customers.CustomerID
JOIN Products ON Orders.ProductID = Products.ProductID;
