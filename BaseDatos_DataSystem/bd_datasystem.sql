-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2024 a las 23:29:45
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
-- Base de datos: `bd_datasystem`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `ID_cliente` int(11) NOT NULL,
  `nombre_cl` varchar(50) NOT NULL,
  `email_cl` varchar(50) NOT NULL,
  `telefono_cl` varchar(50) NOT NULL,
  `direccion_cl` varchar(50) NOT NULL,
  `ultima_modif` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`ID_cliente`, `nombre_cl`, `email_cl`, `telefono_cl`, `direccion_cl`, `ultima_modif`) VALUES
(1, 'cliente1', 'cliente1@gmail.com', '1123456789', 'p sherman calle wallaby 42 sidney', 'admin'),
(2, 'cliente2', 'cliente2@gmail.com', '1123456789', 'p sherman calle wallaby 42 sidney', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `ID_equipo` int(11) NOT NULL,
  `ID_cliente` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `num_serie` varchar(50) NOT NULL,
  `dia_ingreso` varchar(50) NOT NULL,
  `mes_ingreso` varchar(50) NOT NULL,
  `año_ingreso` varchar(50) NOT NULL,
  `observaciones` longtext NOT NULL,
  `status` varchar(50) NOT NULL,
  `ultima_mod` varchar(50) NOT NULL,
  `comentarios_tec` longtext NOT NULL,
  `revision_tecnica` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`ID_equipo`, `ID_cliente`, `tipo`, `marca`, `modelo`, `num_serie`, `dia_ingreso`, `mes_ingreso`, `año_ingreso`, `observaciones`, `status`, `ultima_mod`, `comentarios_tec`, `revision_tecnica`) VALUES
(1, 2, 'Celular', 'Motorola', 'G6 PLUS', '123548', '4', '2', '2024', 'Pantalla rota, prende pero no da imagen', 'Nuevo Ingreso', 'dai', '', ''),
(2, 2, 'PC', 'AMD', 'Ryzen7', '1156421', '4', '2', '2024', 'No enciende, tiro humo la fuente', 'Nuevo Ingreso', 'dai', '', ''),
(3, 1, 'Notebook', 'HP', 'Intel 9', '12548', '5', '2', '2024', 'la trajo sin cable', 'En Revision', 'dai', '', ''),
(4, 1, 'Celular', 'Samsung', 'E9', '2356421', '14', '2', '2024', 'Pantalla Rota', 'Nuevo Ingreso', 'dai', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_usuario` int(11) NOT NULL,
  `nombre_us` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `tipo_nivel` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `registrado_por` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_usuario`, `nombre_us`, `email`, `telefono`, `username`, `password`, `tipo_nivel`, `status`, `registrado_por`) VALUES
(1, 'admin', 'admin', '111111', 'admin', 'admin', 'Administrador', 'Activo', 'admin'),
(2, 'Tecnico', 'tecnico@gmail.com', '1123456789', 'Tecnico', 'admin', 'Tecnico', 'Activo', 'admin'),
(3, 'AtencionCliente', 'atencionCliente@gmail.com', '1123456789', 'atencionCliente', 'admin', 'Atencion al cliente', 'Activo', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ID_cliente`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`ID_equipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `ID_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `ID_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
