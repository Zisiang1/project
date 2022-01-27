-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 27, 2022 at 03:37 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

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
(6, 1, 'tayyuda', 'Book', 'image', 0, 0, 1, 0, '2022-01-26 09:58:11'),
(7, 1, 'tayyuda', 'Book', 'image', 0, 0, 1, 0, '2022-01-26 11:04:37'),
(8, 1, 'test', 'Book', 'image', 0, 0, 1, 0, '2022-01-26 13:02:11'),
(9, 1, 'test', 'Book', 'image', 0, 0, 1, 0, '2022-01-26 15:00:30'),
(10, 1, 'test', 'Book', 'image', 0, 0, 1, 0, '2022-01-27 13:35:19');

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
('tayyuda', '123', '2022-01-21', 'tayyuda@gmail.com', 123123, '11 Pasir Ris Street 11 07-647, Singapore Singapore 510112, SGP', '312', 'Singapore', 'daasdd', 513123),
('test', '123', '2022-02-04', 'test1@gmail.com', 123213, 'test', 'test', 'test', 'test', 12);

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

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(255) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `reviews` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ratings` int(255) NOT NULL,
  `book` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bookid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `username`, `reviews`, `ratings`, `book`, `bookid`) VALUES
(1, 'tayyuda', 'great book', 3, 'book', 1),
(2, 'test', 'Great read had a blast', 3, 'Book', 1),
(3, 'tayyuda', 'Aight', 2, 'Animals', 2),
(4, 'test', 'Great book!!', 4, 'Animals', 2);

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
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
