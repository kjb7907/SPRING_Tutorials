-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- injava 의 데이터베이스 구조 덤핑
DROP DATABASE IF EXISTS `injava`;
CREATE DATABASE IF NOT EXISTS `injava` /*!40100 DEFAULT CHARACTER SET euckr */;
USE `injava`;


-- 테이블 injava의 구조를 덤프합니다. board
DROP TABLE IF EXISTS `board`;
CREATE TABLE IF NOT EXISTS `board` (
  `board_no` int(10) NOT NULL AUTO_INCREMENT,
  `board_pw` varchar(50) DEFAULT NULL,
  `board_title` varchar(50) DEFAULT NULL,
  `board_content` varchar(50) DEFAULT NULL,
  `board_user` varchar(50) DEFAULT NULL,
  `board_date` date DEFAULT NULL,
  PRIMARY KEY (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=euckr;

-- Dumping data for table injava.board: ~1 rows (대략적)
DELETE FROM `board`;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`board_no`, `board_pw`, `board_title`, `board_content`, `board_user`, `board_date`) VALUES
	(1, '1234', 'asds', 'asd3', 'asd', '2017-01-04'),
	(2, '1234', '123', 'asd', 'asd', '2017-01-05'),
	(3, '1234', '123', 'asd', 'asd', '2017-01-05'),
	(4, '1234', 'sad', '1234', 'sad', '2017-01-05'),
	(5, '4342', '342', '34324', '', '2017-01-05'),
	(6, '123', '14', 'asd', 'asd', '2017-01-05'),
	(7, 'sd', 'sd', 'sasdsd', '1234', '2017-01-05'),
	(8, '543', '123', '143', '12344', '2017-01-05'),
	(9, 'adsddff', 'ff', 'ff', '1234', '2017-01-05'),
	(10, 'dsd', '123', 'asdd', '123', '2017-01-05'),
	(11, '1234', '13d', 'awed', '123', '2017-01-05'),
	(12, 'sdd', '13d', 'awed', '123', '2017-01-05');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
