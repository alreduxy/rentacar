INSERT INTO users (username, password, enabled, first_name, last_name, email, phone, create_at) VALUES ('aaldama', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', 'true', 'Andres', 'Aldama', 'let.aldama@gmail.com','937287385',NOW());
INSERT INTO users (username, password, enabled, first_name, last_name, email, phone, create_at) VALUES ('admin', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', 'true' ,'Mr. John', 'Doe', 'john.doe@gmail.com','937287385', NOW());

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);

INSERT INTO menu (menu_id, icon, name, url) VALUES (1, 'manufacturer', '/manufacturer', 'manufacturer');
INSERT INTO menu (menu_id, icon, name, url) VALUES (2, 'model', '/model', 'model');
INSERT INTO menu (menu_id, icon, name, url) VALUES (3, 'location', '/location', 'location');
INSERT INTO menu (menu_id, icon, name, url) VALUES (4, 'user', '/user', 'user');
INSERT INTO menu (menu_id, icon, name, url) VALUES (5, 'role', '/role', 'role');
INSERT INTO menu (menu_id, icon, name, url) VALUES (6, 'rental-status', '/rental-status', 'rental-status');
INSERT INTO menu (menu_id, icon, name, url) VALUES (7, 'vehicle', '/vehicle', 'vehicle');
INSERT INTO menu (menu_id, icon, name, url) VALUES (8, 'vehicle-rented', '/vehicle-rented', 'vehicle-rented');
INSERT INTO menu (menu_id, icon, name, url) VALUES (9, 'menus', '/menus', 'menus');
INSERT INTO menu (menu_id, icon, name, url) VALUES (10, 'tokens', '/tokens', 'tokens');
INSERT INTO menu (menu_id, icon, name, url) VALUES (11, 'login', '/login', 'login');

INSERT INTO menu_rol (menu_id, role_id) VALUES (1, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (2, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (3, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (4, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (5, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (6, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (7, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (8, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (8, 2);
INSERT INTO menu_rol (menu_id, role_id) VALUES (10, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (10, 1);
INSERT INTO menu_rol (menu_id, role_id) VALUES (11, 1);


--Marcas de nuestros vehiculos
INSERT INTO manufacturers (manufacturer_name) VALUES ('Subaru');
INSERT INTO manufacturers (manufacturer_name) VALUES ('Suzuki');
INSERT INTO manufacturers (manufacturer_name) VALUES ('Ford');
INSERT INTO manufacturers (manufacturer_name) VALUES ('Chevrolet');
INSERT INTO manufacturers (manufacturer_name) VALUES ('Honda');
INSERT INTO manufacturers (manufacturer_name) VALUES ('Toyota');


--Modelos de vehiculos
INSERT INTO models (model_name, manufacturer_id) VALUES ('Forester', 1);
INSERT INTO models (model_name, manufacturer_id) VALUES ('Imprezza', 1);
INSERT INTO models (model_name, manufacturer_id) VALUES ('Legacy', 1);
INSERT INTO models (model_name, manufacturer_id) VALUES ('Outback', 1);
INSERT INTO models (model_name, manufacturer_id) VALUES ('Swift', 2);

--Ubicacion de nuestras sucursal
INSERT INTO locations (location_zip_code, location_name) VALUES (8320000, 'Santiago');
INSERT INTO locations (location_zip_code, location_name) VALUES (5090000, 'Valdivia');

--Tipos de vehiculos que podes alquilar
INSERT INTO vehicle_types (vehicle_type_desc) VALUES ('Car');
INSERT INTO vehicle_types (vehicle_type_desc) VALUES ('Suv');

--Estados para cambiar a nuestros vehiculos
INSERT INTO rental_status (rental_status_id, rental_status_desc) VALUES (1, 'Available');
INSERT INTO rental_status (rental_status_id, rental_status_desc) VALUES (2, 'Not available');

--vehiculos segun caracteristicas y ubicacion
INSERT INTO vehicles (daily_price, current_km, plate_number, color, vehicle_stock, full_tank, rental_status_id, location_id, model_id, vehicle_type_id) VALUES (12000, 10, 'JRTR32', 'Blue', 1, true, 1, 1, 1, 1 );
INSERT INTO vehicles (daily_price, current_km, plate_number, color, vehicle_stock, full_tank, rental_status_id, location_id, model_id, vehicle_type_id) VALUES (13000, 20, 'JRTR33', 'Black', 1, true, 1, 1, 2, 1 );
INSERT INTO vehicles (daily_price, current_km, plate_number, color, vehicle_stock, full_tank, rental_status_id, location_id, model_id, vehicle_type_id) VALUES (14000, 30, 'JRTR34', 'White', 1, true, 1, 2, 3, 1 );
INSERT INTO vehicles (daily_price, current_km, plate_number, color, vehicle_stock, full_tank, rental_status_id, location_id, model_id, vehicle_type_id) VALUES (15000, 40, 'JRTR35', 'Red Fiesta', 1, true, 1, 2, 4, 1 );
INSERT INTO vehicles (daily_price, current_km, plate_number, color, vehicle_stock, full_tank, rental_status_id, location_id, model_id, vehicle_type_id) VALUES (16000, 50, 'JRTR36', 'Black', 1, true, 1, 2, 5, 2 );

--sample data for users
INSERT INTO vehicle_rentals (date_from, date_to, quantity_days, total_price, user_id, vehicle_id) values ('2022-06-22','2022-06-30',8,104000,1,2);



