-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for interview_adinata
CREATE DATABASE IF NOT EXISTS `interview_adinata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `interview_adinata`;

-- Dumping structure for table interview_adinata.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `id` varchar(255) NOT NULL,
  `faculty_name` varchar(255) DEFAULT NULL,
  `major_list` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.faculty: ~4 rows (approximately)
INSERT INTO `faculty` (`id`, `faculty_name`, `major_list`) VALUES
	('BS', 'Business School', NULL),
	('FS', 'Desain', NULL),
	('SA', 'Sastra', NULL),
	('TK', 'Fakultas Teknik', NULL);

-- Dumping structure for table interview_adinata.lecturer
CREATE TABLE IF NOT EXISTS `lecturer` (
  `nip` varchar(255) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `major_idmajor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nip`),
  KEY `FKbsoer7vcaujwg641bh18q6tr0` (`major_idmajor`),
  CONSTRAINT `FKbsoer7vcaujwg641bh18q6tr0` FOREIGN KEY (`major_idmajor`) REFERENCES `major` (`idmajor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.lecturer: ~2 rows (approximately)
INSERT INTO `lecturer` (`nip`, `adress`, `city`, `name`, `telephone`, `major_idmajor`) VALUES
	('1120002', 'JL Cikapayang', 'BDG', 'Ken Ratri', '0878990175223', 'IF'),
	('1120007', 'JL Cikapayang', 'BDG', 'Irfin Afifudin', '0878990175223', 'IF');

-- Dumping structure for table interview_adinata.major
CREATE TABLE IF NOT EXISTS `major` (
  `idmajor` varchar(255) NOT NULL,
  `akreditasi` varchar(255) DEFAULT NULL,
  `faculty` varbinary(255) DEFAULT NULL,
  `majorname` varchar(255) DEFAULT NULL,
  `tahunsk` varchar(255) DEFAULT NULL,
  `faculty_id` varchar(255) DEFAULT NULL,
  `facultyid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idmajor`),
  KEY `FKrbpflj1p41y81s9d2jf5ix2jv` (`faculty_id`),
  KEY `FK6am1xy0osw4yhj8wtgokcfl29` (`facultyid`),
  CONSTRAINT `FK6am1xy0osw4yhj8wtgokcfl29` FOREIGN KEY (`facultyid`) REFERENCES `faculty` (`id`),
  CONSTRAINT `FKrbpflj1p41y81s9d2jf5ix2jv` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.major: ~7 rows (approximately)
INSERT INTO `major` (`idmajor`, `akreditasi`, `faculty`, `majorname`, `tahunsk`, `faculty_id`, `facultyid`) VALUES
	('AK', 'Sangat Baik', _binary 0x4253, 'Akuntansi update', '2023/SK/07', 'BS', 'BS'),
	('DKV', 'Baik', _binary 0x4653, 'Design Komunikasi Visual', '2023/SK/05', 'FS', NULL),
	('IF', 'Sangat Baik', _binary 0x544b, 'Informatika', '2023/SK/11', 'TK', NULL),
	('MG', 'Baik', _binary 0x4253, 'Management', '2023/SK/05', 'BS', NULL),
	('SI', 'Sangat Baik', _binary 0x4653, 'Sastra Inggirs', '2023/SK/07', 'SA', 'FS'),
	('SJ', 'Sangat Baik', _binary 0x5341, 'Sastra Jepang', '2023/SK/11', 'SA', NULL),
	('SS', 'Sangat Baik', _binary 0x5341, 'Sastra Sunda', '2023/SK/11', 'SA', NULL);

-- Dumping structure for table interview_adinata.students
CREATE TABLE IF NOT EXISTS `students` (
  `nim` varchar(255) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `major_idmajor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nim`),
  KEY `FKmf3xxqk0o43yty0xtn92901av` (`major_idmajor`),
  CONSTRAINT `FKmf3xxqk0o43yty0xtn92901av` FOREIGN KEY (`major_idmajor`) REFERENCES `major` (`idmajor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.students: ~2 rows (approximately)
INSERT INTO `students` (`nim`, `adress`, `city`, `name`, `telephone`, `major_idmajor`) VALUES
	('1119004', 'JL Pagarsih', 'BDG', 'Calvin J', '087880575491', 'IF'),
	('1119028', 'JL Ir H Djuanda 294 B', 'BDG', 'Aji Parama', '087880575491', 'IF');

-- Dumping structure for table interview_adinata.students_course
CREATE TABLE IF NOT EXISTS `students_course` (
  `students_id` varchar(255) NOT NULL,
  `subjects_id` varchar(255) NOT NULL,
  KEY `FKt7icb5dlyl1iq842m1sagqqwh` (`subjects_id`),
  KEY `FKqx6ds2magrwt230uvhcbur7yg` (`students_id`),
  CONSTRAINT `FKqx6ds2magrwt230uvhcbur7yg` FOREIGN KEY (`students_id`) REFERENCES `students` (`nim`),
  CONSTRAINT `FKt7icb5dlyl1iq842m1sagqqwh` FOREIGN KEY (`subjects_id`) REFERENCES `subjects` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.students_course: ~0 rows (approximately)

-- Dumping structure for table interview_adinata.subjects
CREATE TABLE IF NOT EXISTS `subjects` (
  `code` varchar(255) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `semester` int(11) NOT NULL,
  `sks` int(11) NOT NULL,
  `lecturer_nip` varchar(255) DEFAULT NULL,
  `major_idmajor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKsucdjw3nry5lr80v2k4o8tn3y` (`lecturer_nip`),
  KEY `FKproa0anvv4v87a58lpwo2040b` (`major_idmajor`),
  CONSTRAINT `FKproa0anvv4v87a58lpwo2040b` FOREIGN KEY (`major_idmajor`) REFERENCES `major` (`idmajor`),
  CONSTRAINT `FKsucdjw3nry5lr80v2k4o8tn3y` FOREIGN KEY (`lecturer_nip`) REFERENCES `lecturer` (`nip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table interview_adinata.subjects: ~1 rows (approximately)
INSERT INTO `subjects` (`code`, `nama`, `semester`, `sks`, `lecturer_nip`, `major_idmajor`) VALUES
	('IF-101', 'Algoritma Pemrograman Dasar', 1, 4, '1120002', 'IF');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
