-- insert-test-brands.sql

-- Wstawienie marek samochodów
INSERT INTO car_brand (id, name, country, description) VALUES (1, 'TestBrand1', 'TestCountry1', 'TestDescription1');
INSERT INTO car_brand (id, name, country, description) VALUES (2, 'TestBrand2', 'TestCountry2', 'TestDescription2');

-- Zakładając, że tabela modeli nazywa się `model` i ma kolumnę `brand_id`
-- Wstawienie modeli dla marki o id 1
INSERT INTO car_model (id, name, brand_id, description) VALUES (1, 'Model1', 1, 'TestDescription1');
INSERT INTO car_model (id, name, brand_id, description) VALUES (2, 'Model2', 1, 'TestDescription2');

-- Wstawienie modeli dla marki o id 2
INSERT INTO car_model (id, name, brand_id, description) VALUES (3, 'Model3', 2, 'TestDescription3');
INSERT INTO car_model (id, name, brand_id, description) VALUES (4, 'Model4', 2, 'TestDescription4');
