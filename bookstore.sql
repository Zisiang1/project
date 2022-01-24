-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2022 at 02:45 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(40) NOT NULL,
  `bookid` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `book` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `paid` tinyint(1) NOT NULL,
  `price` float NOT NULL,
  `quantity` int(255) NOT NULL,
  `totalcost` float NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `bookid`, `username`, `book`, `img`, `paid`, `price`, `quantity`, `totalcost`, `date`) VALUES
(1, 0, '[value-3]', '[value-4]', '[value-5]', 0, 0, 0, 0, '0000-00-00 00:00:00'),
(2, 0, '[value-3]', '[value-4]', '[value-5]', 0, 0, 0, 0, '0000-00-00 00:00:00'),
(3, 2, 'tayyuda', 'Animals', '', 0, 0, 1, 0, '0000-00-00 00:00:00'),
(4, 1, 'tayyuda', 'Book', 'image', 0, 0, 1, 0, '2022-01-24 08:47:20');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Date_Of_Birth` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Phone_Number` int(20) NOT NULL,
  `Address` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Address2` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `City` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `State` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Zip` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Name`, `Password`, `Date_Of_Birth`, `Email`, `Phone_Number`, `Address`, `Address2`, `City`, `State`, `Zip`) VALUES
('tayyuda', '123', '2022-01-21', 'tayyuda@gmail.com', 123123, '11 Pasir Ris Street 11 07-647, Singapore Singapore 510112, SGP', '312', 'Singapore', 'daasdd', 513123);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(20) NOT NULL,
  `title` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genre` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `title`, `author`, `description`, `genre`, `image`, `price`) VALUES
(1, 'Book', 'Author', 'Synopsis', 'genre', 'image', 0),
(2, 'Animals', 'Timothy', 'Book about animals', 'Kids', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
