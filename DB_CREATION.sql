CREATE DATABASE SDMHT_DB;
USE SDMHT_DB;
CREATE TABLE `sdmht_doctor_details` (
  `DOCTOR_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `SPECIALIZATION` varchar(100) DEFAULT NULL,
  `USER_LOGIN_ID` int DEFAULT NULL,
  PRIMARY KEY (`DOCTOR_ID`),
  KEY `USER_LOGIN_ID` (`USER_LOGIN_ID`),
  CONSTRAINT `sdmht_doctor_details_ibfk_1` FOREIGN KEY (`USER_LOGIN_ID`) REFERENCES `sdmht_user_login_details` (`USER_LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_hospital_details` (
  `HOSPITAL_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `CONTACT_INFO` varchar(100) DEFAULT NULL,
  `USER_LOGIN_ID` int DEFAULT NULL,
  PRIMARY KEY (`HOSPITAL_ID`),
  KEY `USER_LOGIN_ID` (`USER_LOGIN_ID`),
  CONSTRAINT `sdmht_hospital_details_ibfk_1` FOREIGN KEY (`USER_LOGIN_ID`) REFERENCES `sdmht_user_login_details` (`USER_LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_lab_details` (
  `LAB_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(200) DEFAULT NULL,
  `CONTACT_INFO` varchar(100) DEFAULT NULL,
  `USER_LOGIN_ID` int DEFAULT NULL,
  PRIMARY KEY (`LAB_ID`),
  KEY `USER_LOGIN_ID` (`USER_LOGIN_ID`),
  CONSTRAINT `sdmht_lab_details_ibfk_1` FOREIGN KEY (`USER_LOGIN_ID`) REFERENCES `sdmht_user_login_details` (`USER_LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_patient_details` (
  `PATIENT_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `CONTACT_NO` varchar(20) DEFAULT NULL,
  `MAIL_ID` varchar(100) DEFAULT NULL,
  `USER_LOGIN_ID` int DEFAULT NULL,
  PRIMARY KEY (`PATIENT_ID`),
  KEY `USER_LOGIN_ID` (`USER_LOGIN_ID`),
  CONSTRAINT `sdmht_patient_details_ibfk_1` FOREIGN KEY (`USER_LOGIN_ID`) REFERENCES `sdmht_user_login_details` (`USER_LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_patient_medical_testresults` (
  `TESTRESULT_ID` int NOT NULL AUTO_INCREMENT,
  `VISIT_ID` int DEFAULT NULL,
  `LAB_ID` int DEFAULT NULL,
  `TEST_DATE` date DEFAULT NULL,
  `REPORT_ID` varchar(50) DEFAULT NULL,
  `RESULT` varchar(200) DEFAULT NULL,
  `PATIENT_ID` int DEFAULT NULL,
  `TEST_STATUS` varchar(30) DEFAULT NULL,
  `TEST_NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TESTRESULT_ID`),
  KEY `VISIT_ID` (`VISIT_ID`),
  KEY `LAB_ID` (`LAB_ID`),
  KEY `patient_id_mapping` (`PATIENT_ID`),
  CONSTRAINT `patient_id_mapping` FOREIGN KEY (`PATIENT_ID`) REFERENCES `sdmht_patient_details` (`PATIENT_ID`),
  CONSTRAINT `sdmht_patient_medical_testresults_ibfk_1` FOREIGN KEY (`VISIT_ID`) REFERENCES `sdmht_patientvisit_details` (`VISIT_ID`),
  CONSTRAINT `sdmht_patient_medical_testresults_ibfk_3` FOREIGN KEY (`LAB_ID`) REFERENCES `sdmht_lab_details` (`LAB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_patientvisit_details` (
  `VISIT_ID` int NOT NULL AUTO_INCREMENT,
  `PATIENT_ID` int DEFAULT NULL,
  `HOSPITAL_ID` int DEFAULT NULL,
  `DOCTOR_ID` int DEFAULT NULL,
  `VISIT_DATE` date DEFAULT NULL,
  `ISSUE` varchar(200) DEFAULT NULL,
  `DIAGNOSIS` varchar(200) DEFAULT NULL,
  `DOCTOR_NAME` varchar(50) DEFAULT NULL,
  `suggested_tests` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`VISIT_ID`),
  KEY `PATIENT_ID` (`PATIENT_ID`),
  KEY `HOSPITAL_ID` (`HOSPITAL_ID`),
  KEY `DOCTOR_ID` (`DOCTOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sdmht_user_login_details` (
  `USER_LOGIN_ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(100) DEFAULT NULL,
  `ENCRYPTED_PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `ROLE` enum('hospital_staff','doctor','normal_person','lab_technician') DEFAULT NULL,
  PRIMARY KEY (`USER_LOGIN_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`),
  UNIQUE KEY `unique_username` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
