-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 19 Lut 2024, 17:38
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `buy4wheels`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `car_brand`
--

CREATE TABLE `car_brand` (
  `id` int(11) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `car_brand`
--

INSERT INTO `car_brand` (`id`, `country`, `description`, `name`) VALUES
(1, 'Niemcy', 'Niemiecka marka samochodów luksusowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Audi'),
(2, 'Niemcy', 'Niemiecka marka samochodów luksusowych, znana z produkcji pojazdów o sportowym charakterze, wysokiej jakości wykonania i nowoczesnych technologii.', 'BMW'),
(3, 'Niemcy', 'Niemiecka marka samochodów luksusowych, należąca do koncernu Daimler AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Mercedes-Benz'),
(4, 'Niemcy', 'Niemiecka marka samochodów, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Volkswagen'),
(5, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Toyota Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, niezawodności i przystępnej cenie.', 'Toyota'),
(6, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Honda Motor Co., Ltd. Znana z produkcji pojazdów o wysokiej jakości wykonania, niezawodności i sportowym charakterze.', 'Honda'),
(7, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Nissan Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Nissan'),
(8, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Mazda Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Mazda'),
(9, 'Włochy', 'Włoska marka samochodów, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Fiat'),
(10, 'Włochy', 'Włoska marka samochodów, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Alfa Romeo'),
(11, 'Włochy', 'Włoska marka samochodów, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Lancia'),
(12, 'Włochy', 'Włoska marka samochodów sportowych, należąca do koncernu Ferrari S.p.A. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Ferrari'),
(13, 'Niemcy', 'Niemiecka marka samochodów sportowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Porsche'),
(14, 'Włochy', 'Włoska marka samochodów sportowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Lamborghini'),
(15, 'Włochy', 'Włoska marka samochodów luksusowych, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Maserati'),
(16, 'Wielka Brytania', 'Brytyjska marka samochodów luksusowych, należąca do koncernu Jaguar Land Rover. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Jaguar'),
(17, 'Wielka Brytania', 'Brytyjska marka samochodów terenowych, należąca do koncernu Jaguar Land Rover. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i terenowym charakterze.', 'Land Rover'),
(18, 'Wielka Brytania', 'Brytyjska marka samochodów luksusowych, należąca do koncernu BMW. Znana z produkcji pojazdów o najwyższej jakości wykonania, luksusowym charakterze i ekskluzywnym wyposażeniu.', 'Rolls-Royce'),
(19, 'Wielka Brytania', 'Brytyjska marka samochodów luksusowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o najwyższej jakości wykonania, luksusowym charakterze i ekskluzywnym wyposażeniu.', 'Bentley'),
(20, 'Wielka Brytania', 'Brytyjska marka samochodów sportowych, należąca do koncernu Aston Martin Lagonda Global Holdings. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Aston Martin'),
(21, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu General Motors Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Chevrolet'),
(22, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu Ford Motor Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Ford'),
(23, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Dodge'),
(24, 'Stany Zjednoczone', 'Amerykańska marka samochodów terenowych, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i terenowym charakterze.', 'Jeep'),
(25, 'Stany Zjednoczone', 'Amerykańska marka samochodów luksusowych, należąca do koncernu General Motors Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, luksusowym charakterze i ekskluzywnym wyposażeniu.', 'Cadillac'),
(26, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Chrysler'),
(27, 'Stany Zjednoczone', 'Amerykańska marka samochodów luksusowych, należąca do koncernu Ford Motor Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, luksusowym charakterze i ekskluzywnym wyposażeniu.', 'Lincoln'),
(28, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu General Motors Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Buick'),
(29, 'Stany Zjednoczone', 'Amerykańska marka samochodów, należąca do koncernu General Motors Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i terenowym charakterze.', 'GMC'),
(30, 'Stany Zjednoczone', 'Amerykańska marka samochodów elektrycznych, należąca do koncernu Tesla, Inc. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i ekologicznym charakterze.', 'Tesla'),
(31, 'Szwecja', 'Szwedzka marka samochodów, należąca do koncernu Volvo Car Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i bezpiecznym charakterze.', 'Volvo'),
(32, 'Szwecja', 'Szwedzka marka samochodów, należąca do koncernu Saab Automobile AB. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Saab'),
(33, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Suzuki Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, niezawodności i przystępnej cenie.', 'Suzuki'),
(34, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Subaru Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, niezawodności i terenowym charakterze.', 'Subaru'),
(35, 'Korea Południowa', 'Koreańska marka samochodów, należąca do koncernu Kia Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Kia'),
(36, 'Korea Południowa', 'Koreańska marka samochodów, należąca do koncernu Hyundai Motor Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Hyundai'),
(37, 'Korea Południowa', 'Koreańska marka samochodów, należąca do koncernu Daewoo Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Daewoo'),
(38, 'Francja', 'Francuska marka samochodów, należąca do koncernu Renault Group. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Renault'),
(39, 'Francja', 'Francuska marka samochodów, należąca do koncernu Peugeot S.A. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Peugeot'),
(40, 'Francja', 'Francuska marka samochodów, należąca do koncernu Citroën S.A. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Citroën'),
(41, 'Rumunia', 'Rumuńska marka samochodów, należąca do koncernu Dacia S.A. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Dacia'),
(42, 'Czechy', 'Czeska marka samochodów, należąca do koncernu Škoda Auto a.s. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Skoda'),
(43, 'Hiszpania', 'Hiszpańska marka samochodów, należąca do koncernu SEAT, S.A. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Seat'),
(44, 'Francja', 'Francuska marka samochodów sportowych, należąca do koncernu Renault Group. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Alpine'),
(45, 'Wielka Brytania', 'Brytyjska marka samochodów sportowych, należąca do koncernu Lotus Cars. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Lotus'),
(46, 'Wielka Brytania', 'Brytyjska marka samochodów sportowych, należąca do koncernu McLaren Automotive. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'McLaren'),
(47, 'Francja', 'Francuska marka samochodów sportowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Bugatti'),
(48, 'Szwecja', 'Szwedzka marka samochodów sportowych, należąca do koncernu Koenigsegg Automotive AB. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Koenigsegg'),
(49, 'Włochy', 'Włoska marka samochodów sportowych, należąca do koncernu Pagani Automobili S.p.A. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Pagani'),
(50, 'Włochy', 'Włoska marka samochodów sportowych, należąca do koncernu Fiat Chrysler Automobiles. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Abarth'),
(51, 'Japonia', 'Japońska marka samochodów luksusowych, należąca do koncernu Toyota Motor Corporation. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Lexus'),
(52, 'Japonia', 'Japońska marka samochodów luksusowych, należąca do koncernu Nissan Motor Corporation. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Infiniti'),
(53, 'Japonia', 'Japońska marka samochodów luksusowych, należąca do koncernu Honda Motor Co., Ltd. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Acura'),
(54, 'Korea Południowa', 'Koreańska marka samochodów luksusowych, należąca do koncernu Hyundai Motor Company. Znana z produkcji pojazdów o najwyższej jakości wykonania, nowoczesnych technologii i komfortowym charakterze.', 'Genesis'),
(55, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Nissan Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Datsun'),
(56, 'Chiny', 'Chińska marka samochodów, należąca do koncernu Geely Automobile Holdings. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Geely'),
(57, 'Wielka Brytania', 'Brytyjska marka samochodów, należąca do koncernu SAIC Motor Corporation. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'MG'),
(58, 'Wielka Brytania', 'Brytyjska marka samochodów, należąca do koncernu BMW. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Mini'),
(59, 'Niemcy', 'Niemiecka marka samochodów, należąca do koncernu Daimler AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i kompaktowym charakterze.', 'Smart'),
(60, 'Niemcy', 'Niemiecka marka samochodów, należąca do koncernu Opel Automobile GmbH. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Opel'),
(61, 'Wielka Brytania', 'Brytyjska marka samochodów, należąca do koncernu Vauxhall Motors. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Vauxhall'),
(62, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Daihatsu Motor Co., Ltd. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Daihatsu'),
(63, 'Japonia', 'Japońska marka samochodów, należąca do koncernu Isuzu Motors Ltd. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Isuzu'),
(64, 'Korea Południowa', 'Koreańska marka samochodów, należąca do koncernu SsangYong Motor Company. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'SsangYong'),
(65, 'Indie', 'Indyjska marka samochodów, należąca do koncernu Tata Motors Limited. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Tata'),
(66, 'Rosja', 'Rosyjska marka samochodów, należąca do koncernu AvtoVAZ. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Lada'),
(67, 'Niemcy', 'Niemiecka marka samochodów, należąca do koncernu VEB Sachsenring Automobilwerke Zwickau. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Trabant'),
(68, 'Rosja', 'Rosyjska marka samochodów, należąca do koncernu Moskwicz. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Moskwicz'),
(69, 'Polska', 'Polska marka samochodów, należąca do koncernu Fabryka Samochodów Osobowych. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'FSO'),
(70, 'Polska', 'Polska marka samochodów, należąca do koncernu Fabryka Samochodów Osobowych. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Polonez'),
(71, 'Polska', 'Polska marka samochodów, należąca do koncernu Fabryka Samochodów Osobowych. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Syrena'),
(72, 'Polska', 'Polska marka samochodów, należąca do koncernu Fabryka Samochodów Osobowych. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i przystępnej cenie.', 'Warszawa'),
(73, 'Niemcy', 'Niemiecka marka samochodów luksusowych, należąca do koncernu Volkswagen AG. Znana z produkcji pojazdów o wysokiej jakości wykonania, nowoczesnych technologii i sportowym charakterze.', 'Poldek');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `car_model`
--

CREATE TABLE `car_model` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `car_model`
--

INSERT INTO `car_model` (`id`, `description`, `name`, `brand_id`) VALUES
(1, 'Audi A4 - komfortowy sedan klasy średniej.', 'A4', 1),
(2, 'BMW Seria 3 - dynamiczny sedan klasy średniej.', 'Seria 3', 2),
(3, 'Mercedes-Benz C-Klasa - luksusowy sedan klasy średniej.', 'C-Klasa', 3),
(4, 'Volkswagen Golf - kompaktowy hatchback, ikona klasy.', 'Golf', 4),
(5, 'Toyota Corolla - niezawodny sedan dla każdego.', 'Corolla', 5),
(6, 'Honda Civic - sportowy charakter i nowoczesne technologie.', 'Civic', 6),
(7, 'Nissan Qashqai - przestronny i komfortowy SUV.', 'Qashqai', 7),
(8, 'Mazda MX-5 - kultowy, lekki roadster.', 'MX-5', 8),
(9, 'Fiat 500 - stylowy i miejski samochód o kompaktowych wymiarach.', '500', 9),
(10, 'Alfa Romeo Giulia - włoski sedan z duszą sportowca.', 'Giulia', 10),
(11, 'Lancia Ypsilon - elegancki i kompaktowy hatchback.', 'Ypsilon', 11),
(12, 'Ferrari 488 GTB - supercar z nieziemską mocą.', '488 GTB', 12),
(13, 'Porsche 911 - ikona sportowych samochodów.', '911', 13),
(14, 'Lamborghini Huracan - emocje na każdej drodze.', 'Huracan', 14),
(15, 'Maserati Ghibli - luksus i moc w eleganckim opakowaniu.', 'Ghibli', 15),
(16, 'Jaguar F-Pace - połączenie luksusu i sportowych osiągów w SUV-ie.', 'F-Pace', 16),
(17, 'Land Rover Defender - legendarny i niezawodny terenowiec.', 'Defender', 17),
(18, 'Rolls-Royce Phantom - szczyt luksusu i elegancji.', 'Phantom', 18),
(19, 'Bentley Continental GT - luksusowe coupe dla koneserów.', 'Continental GT', 19),
(20, 'Aston Martin DB11 - piękno i moc zamknięte w sportowym coupe.', 'DB11', 20),
(21, 'Chevrolet Camaro - amerykańska legenda muscle car.', 'Camaro', 21),
(22, 'Ford Mustang - ikona amerykańskiej motoryzacji.', 'Mustang', 22),
(23, 'Dodge Charger - połączenie mocy i stylu retro.', 'Charger', 23),
(24, 'Jeep Wrangler - niezawodność w każdym terenie.', 'Wrangler', 24),
(25, 'Cadillac Escalade - synonim luksusu w kategorii SUV.', 'Escalade', 25),
(26, 'Chrysler 300 - elegancja i moc w jednym.', '300', 26),
(27, 'Lincoln Navigator - przestronność i luksus.', 'Navigator', 27),
(28, 'Buick Enclave - komfortowy i przestronny SUV.', 'Enclave', 28),
(29, 'GMC Sierra - wytrzymałość i nowoczesne technologie.', 'Sierra', 29),
(30, 'Tesla Model S - przyszłość motoryzacji jest elektryczna.', 'Model S', 30),
(31, 'Volvo XC90 - bezpieczeństwo i szwedzki design.', 'XC90', 31),
(32, 'Saab 9-3 - unikalny design i inżynieria.', '9-3', 32),
(33, 'Suzuki Swift - mały hatchback, wielka zabawa.', 'Swift', 33),
(34, 'Subaru Outback - przygoda czeka za rogiem.', 'Outback', 34),
(35, 'Kia Stinger - sportowy charakter i elegancka linia.', 'Stinger', 35),
(36, 'Hyundai Tucson - dynamiczny design i funkcjonalność.', 'Tucson', 36),
(37, 'Daewoo Nubira - przestronny i dostępny dla każdego.', 'Nubira', 37),
(38, 'Renault Megane - stylowy francuski kompakt.', 'Megane', 38),
(39, 'Peugeot 308 - dynamika jazdy i innowacyjność.', '308', 39),
(40, 'Citroën C3 - kolorowy i wygodny miejski samochód.', 'C3', 40);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `offer`
--

CREATE TABLE `offer` (
  `id` binary(16) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `engine_power` int(11) DEFAULT NULL,
  `fuel_type` varchar(255) DEFAULT NULL,
  `is_available` bit(1) DEFAULT NULL,
  `mileage` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `offer`
--
INSERT INTO `offer` (`id`, `color`, `description`, `engine_power`, `fuel_type`, `is_available`, `mileage`, `price`, `transmission`, `year`, `brand_id`, `model_id`) VALUES
(0x011a01d340684b889009ea8d90cf9128, 'Czarny', 'Audi A4 w idealnym stanie, bogate wyposażenie.', 150, 'Benzyna', b'1', 50000, 85000, 'Automatyczna', 2018, 1, 1),
(0x6996eed59e60477f91b56a31f4cc9126, 'Biały', 'BMW Seria 3 z niskim przebiegiem i pełną historią serwisową.', 180, 'Diesel', b'1', 30000, 95000, 'Manualna', 2019, 2, 2),
(0xc625996f6a5d47f2a91dbba25944357c, 'Niebieski', 'Mercedes-Benz C-Klasa, luksus i komfort jazdy.', 170, 'Benzyna', b'1', 40000, 115000, 'Automatyczna', 2020, 3, 3),
(0xd3f6dc97876845e791b7ce347eaa5585, 'Szary', 'Volkswagen Golf, ekonomiczny i niezawodny.', 110, 'Diesel', b'1', 80000, 65000, 'Manualna', 2017, 4, 4),
(0xf1d57e1d88434466a6c088ca2d62d1d4, 'Czerwony', 'Toyota Corolla, świetny stan, pierwszy właściciel.', 132, 'Benzyna', b'1', 25000, 72000, 'Automatyczna', 2021, 5, 5);


--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `car_brand`
--
ALTER TABLE `car_brand`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indeksy dla tabeli `car_model`
--
ALTER TABLE `car_model`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `FKkjuahqawslw96v9vehbngtuti` (`brand_id`);

--
-- Indeksy dla tabeli `offer`
--
ALTER TABLE `offer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK98fci7qmftdo2idb4ob90gj8s` (`brand_id`),
  ADD KEY `FK5rh2kp6v91r7k92walkc1rll` (`model_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `car_brand`
--
ALTER TABLE `car_brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT dla tabeli `car_model`
--
ALTER TABLE `car_model`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `car_model`
--
ALTER TABLE `car_model`
  ADD CONSTRAINT `FKkjuahqawslw96v9vehbngtuti` FOREIGN KEY (`brand_id`) REFERENCES `car_brand` (`id`);

--
-- Ograniczenia dla tabeli `offer`
--
ALTER TABLE `offer`
  ADD CONSTRAINT `FK5rh2kp6v91r7k92walkc1rll` FOREIGN KEY (`model_id`) REFERENCES `car_model` (`id`),
  ADD CONSTRAINT `FK98fci7qmftdo2idb4ob90gj8s` FOREIGN KEY (`brand_id`) REFERENCES `car_brand` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;