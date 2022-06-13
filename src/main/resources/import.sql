INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Andrés', 'Aldama', 'let.aldama@gmail.com', '06-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '06-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '07-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '08-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '05-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '03-06-2022');
INSERT INTO customers (first_name, last_name, email, create_at) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '03-06-2022');


INSERT INTO users (username, password, enabled, first_name, last_name, email) VALUES ('jossenino', '$2a$10$5CfM9kwD8j6IkbpMoDEF4uCb8OroB2sKixAcHQXA1XDoQ5daEHqAS', true,'Andres', 'Aldama', 'let.aldama@gmail.com');
INSERT INTO users (username, password, enabled, first_name, last_name, email) VALUES ('admin', '$2a$10$nGXK.Ym.NCDuQdVqxfrIz.h/lWzUIdzCPeMJlPfHxTFoRwMe3rBu.', true,'Mr. John', 'Doe', 'john.doe@gmail.com');


INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);

--Marcas de nuestros vehiculos
INSERT INTO manufacturers (manufacturer_id, manufacturer_name) VALUES (1, 'Subaru');
INSERT INTO manufacturers (manufacturer_id, manufacturer_name) VALUES (2, 'Suzuki');


--Modelos de nuestros vehiculos y el valor por día
INSERT INTO models (model_id, model_name, daily_price, manufacturer_id) VALUES (1, 'Forester', 15000, 1);
INSERT INTO models (model_id, model_name, daily_price, manufacturer_id) VALUES (2, 'Imprezza', 12000, 1);
INSERT INTO models (model_id, model_name, daily_price, manufacturer_id) VALUES (3, 'Legacy', 10000, 1);
INSERT INTO models (model_id, model_name, daily_price, manufacturer_id) VALUES (4, 'Outback', 13000, 1);
INSERT INTO models (model_id, model_name, daily_price, manufacturer_id) VALUES (5, 'Swift', 8000, 2);

--Ubicacion de nuestras única sucursal
INSERT INTO locations (location_id, location_zip_code, location_name) VALUES (1, 8320000, 'Santiago');
INSERT INTO locations (location_id, location_zip_code, location_name) VALUES (2, 5090000, 'Valdivia');

--Tipos de vehiculos que podes alquilar
INSERT INTO vehicle_types (vehicle_type_desc) VALUES ('Car');
INSERT INTO vehicle_types (vehicle_type_desc) VALUES ('Suv');

--Estados para cambiar a nuestros vehiculos
INSERT INTO rental_status (rental_status_desc) VALUES ('Available');
INSERT INTO rental_status (rental_status_desc) VALUES ('Not available');
INSERT INTO rental_status (rental_status_desc) VALUES ('In Manteinance');

--vehiculos segun caracteristicas y ubicacion
INSERT INTO vehicles (current_km, due_date, engine_size, full_tank, location_id, model_id, vehicle_type_id) VALUES (10, '30-06-2022', 2.5, true, 1, 1, 1 );
INSERT INTO vehicles (current_km, due_date, engine_size, full_tank, location_id, model_id, vehicle_type_id) VALUES (20, '05-06-2022', 1.2, true, 1, 2, 1 );
INSERT INTO vehicles (current_km, due_date, engine_size, full_tank, location_id, model_id, vehicle_type_id) VALUES (30, '13-06-2022', 2.4, true, 2, 3, 1 );
INSERT INTO vehicles (current_km, due_date, engine_size, full_tank, location_id, model_id, vehicle_type_id) VALUES (40, '13-06-2022', 2.4, true, 2, 4, 1 );
INSERT INTO vehicles (current_km, due_date, engine_size, full_tank, location_id, model_id, vehicle_type_id) VALUES (50, '13-06-2022', 2.4, true, 2, 5, 2 );

--Vehiculos disponibles para ser arrendados en el sitio web
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (1, 1, 1, NOW(), '30-06-2022', null);
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (1, 1, 2, NOW(), '30-06-2022', null);
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (1, 1, 3, NOW(), '30-06-2022', null);
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (2, 1, 3, NOW(), '30-06-2023', null);
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (2, 1, 3, NOW(), '30-06-2022', null);
INSERT INTO vehicle_rentals (customer_id, rental_status_id, vehicle_id, date_from, date_to, quantity_days) VALUES (2, 1, 3, NOW(), '08-08-2022', null);

