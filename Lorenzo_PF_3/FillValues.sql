-- Add five restaurants
INSERT INTO restaurant_model (location, name) VALUES 
('123 Maple Street, Springfield', 'Maple Diner'),
('456 Oak Road, Hill Valley', 'Oak Road Bistro'),
('789 Pine Avenue, Metropolis', 'Pine Tree Cafe'),
('101 Elm Street, Gotham', 'Elm Street Eatery'),
('202 Birch Boulevard, Star City', 'Birch Bistro');

-- Add ten menu items
INSERT INTO menu_item_model (name, price, restaurant_id) VALUES 
('Pancakes', 5.99, 1),
('Burger', 8.99, 1),
('Salad', 6.99, 2),
('Soup', 4.99, 2),
('Pizza', 10.99, 3),
('Pasta', 9.99, 3),
('Sandwich', 7.99, 4),
('Fries', 3.99, 4),
('Steak', 14.99, 5),
('Ice Cream', 4.49, 5);

-- Add one user
INSERT INTO user_model (address, email, name, password) VALUES 
('789 Elm Street, Gotham', 'prueba', 'John Doe', 'prueba');

-- Query tables
SELECT * FROM october_eats.order_item_model;
SELECT * FROM october_eats.order_model;
SELECT * FROM october_eats.restaurant_model;
SELECT * FROM october_eats.user_model;
SELECT * FROM october_eats.menu_item_model;
