-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2025 at 02:19 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebs`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `meter number` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Unit Consumed` varchar(20) NOT NULL,
  `Month` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`meter number`, `Name`, `Address`, `Unit Consumed`, `Month`) VALUES
('1', 'alisha', 'pkr', '546', 'January'),
('123', '', '', '', 'November'),
('2', 'al', 'pkr', '77', 'January'),
('234', 'sdds', 'd', '3', 'March'),
('456', 'Nil', 'Syangja', '10', 'January'),
('468', 'aakey', 'lakeside ', '55', 'May');

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `meter number` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Month` varchar(20) NOT NULL,
  `Unit Consumed` varchar(20) NOT NULL,
  `Total_bill` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `newcustomer`
--

CREATE TABLE `newcustomer` (
  `meter number` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `newcustomer`
--

INSERT INTO `newcustomer` (`meter number`, `name`, `address`, `branch`, `email`, `phone`) VALUES
(1, 'alisha', 'pkr', 'pumdi', 'jalsjlkdj', '98473287'),
(2, 'al', 'pkr', 'p', 's@gmail.com', '8765'),
(6, 'dfj', 'dnfj', 'bfj', 'sdhf', '45'),
(12, 'sn', 'sd', 'df', 'a@gmail.com', '12'),
(123, 'Sheeksha', 'Chhorepatan', 'Cp', 'skb', '9819160250'),
(234, 'Alisha', 'Pumdi', 'Pumdi', 'alc@gmail.com', '9806755432'),
(345, 'Anuja', 'Lekhnath', 'Arghaun', 'Alc', '9837466735'),
(456, 'Nil', 'Syangja', 'Sataun', 'uefh', '9804155374'),
(467, 'adf', 'dfh', 'hf', 'j@gmail.com', '09876'),
(468, 'aakey', 'lakeside ', 'restro', 'aakey123@gmail.com', '9866');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `meter number` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`meter number`, `username`, `name`, `password`) VALUES
('1', 'ddds', 'a', 'sd'),
('123', 'skb', 'sheeksha', 'sheeksha'),
('234', 'alc', 'anuja', 'anuja123'),
('66', 'hh', 'fffff', 'ff'),
('999', 'anu', 'aaa', 'ababa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`meter number`);

--
-- Indexes for table `newcustomer`
--
ALTER TABLE `newcustomer`
  ADD PRIMARY KEY (`meter number`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`meter number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `newcustomer`
--
ALTER TABLE `newcustomer`
  MODIFY `meter number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=469;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
