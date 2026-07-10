-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2025 a las 18:39:34
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `smartocupation`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquileres`
--

CREATE TABLE `alquileres` (
  `id_alquiler` int(11) NOT NULL,
  `num_expediente` varchar(50) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `tiempo_estimado_meses` int(11) NOT NULL,
  `estado_cobro` varchar(50) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `id_vivienda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alquileres`
--

INSERT INTO `alquileres` (`id_alquiler`, `num_expediente`, `fecha_entrada`, `tiempo_estimado_meses`, `estado_cobro`, `id_cliente`, `id_vivienda`) VALUES
(1, 'ALQ-2025-001', '2025-01-15', 12, 'Pagado', 1, 1),
(2, 'ALQ-2025-002', '2025-03-01', 6, 'Pendiente', 1, 1),
(3, 'ALQ-2025-010', '2025-01-20', 12, 'Pendiente', 2, 2),
(4, 'ALQ-2025-015', '2025-01-25', 24, 'Pagado', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `datos_facturacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `dni`, `nombre_completo`, `email`, `telefono`, `datos_facturacion`) VALUES
(1, 'Y1234567Z', 'Ana García López', 'ana.garcia@email.com', '600111222', 'ES80 0000 0000 00 0000000000'),
(2, '11223344B', 'Carlos Ruiz Gomez', 'carlos.ruiz@mail.com', '666777888', 'ES90 0000...'),
(3, '55667788C', 'Marta Valls Duran', 'marta.valls@mail.com', '600999000', 'ES21 0000...');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viviendas`
--

CREATE TABLE `viviendas` (
  `id_vivienda` int(11) NOT NULL,
  `ref_catastral` varchar(50) NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  `metros_cuadrados` int(11) DEFAULT NULL,
  `habitaciones` int(11) DEFAULT NULL,
  `banos` int(11) DEFAULT NULL,
  `precio_alquiler_mes` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `viviendas`
--

INSERT INTO `viviendas` (`id_vivienda`, `ref_catastral`, `ubicacion`, `metros_cuadrados`, `habitaciones`, `banos`, `precio_alquiler_mes`) VALUES
(1, '123456ABC', 'C/ Aragón 123, Zaragoza', 80, 3, 2, 850.00),
(2, '222222BBB', 'Avda. Libertad 45, 2ºA', 65, 2, 1, 650.00),
(3, '333333CCC', 'Plaza Mayor 1, Ático', 120, 4, 3, 1200.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD PRIMARY KEY (`id_alquiler`),
  ADD UNIQUE KEY `num_expediente` (`num_expediente`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_vivienda` (`id_vivienda`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `viviendas`
--
ALTER TABLE `viviendas`
  ADD PRIMARY KEY (`id_vivienda`),
  ADD UNIQUE KEY `ref_catastral` (`ref_catastral`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alquileres`
--
ALTER TABLE `alquileres`
  MODIFY `id_alquiler` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `viviendas`
--
ALTER TABLE `viviendas`
  MODIFY `id_vivienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquileres`
--
ALTER TABLE `alquileres`
  ADD CONSTRAINT `alquileres_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `alquileres_ibfk_2` FOREIGN KEY (`id_vivienda`) REFERENCES `viviendas` (`id_vivienda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
