-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-10-2021 a las 19:14:04
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alumnes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumne`
--

CREATE TABLE `alumne` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `data_naixement` date DEFAULT NULL,
  `adreça` varchar(50) DEFAULT NULL,
  `sexe` enum('Home','Dona','Altres') DEFAULT NULL,
  `codi_postal` varchar(5) DEFAULT NULL,
  `poblacio` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumne`
--

INSERT INTO `alumne` (`id`, `nom`, `DNI`, `data_naixement`, `adreça`, `sexe`, `codi_postal`, `poblacio`) VALUES
(1, 'Joel', '39931225M', '1999-08-26', 'C/Antoni de Bofarull', 'Dona', '43202', 'Tarragona'),
(2, 'Joel', '39931225M', '1999-08-26', 'C/Antoni de Bofarull', 'Home', '43202', 'Tarragona'),
(3, 'Hugo', '36532112M', '2008-04-14', 'dsfdsjbf', 'Dona', '43202', 'tarragona'),
(5, 'Marta', '45612458M', '1998-11-14', 'hdsfdsgds', 'Dona', '43202', 'Barcelona');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumne`
--
ALTER TABLE `alumne`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumne`
--
ALTER TABLE `alumne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
