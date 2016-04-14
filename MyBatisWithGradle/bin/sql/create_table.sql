--CREATE TABLE ADDRESSES
--(
--	ADDR_ID INT(11) NOT NULL AUTO_INCREMENT,
--	STREET VARCHAR(50) NOT NULL,
--	CITY VARCHAR(50) NOT NULL,
--	STATE VARCHAR(50) NOT NULL,
--	ZIP VARCHAR(10) DEFAULT NULL,
--	COUNTRY VARCHAR(50) NOT NULL,
--	PRIMARY KEY (ADDR_ID)
--);

CREATE TABLE STUDENTS
(
	STUD_ID INT(11) NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	EMAIL VARCHAR(50) NOT NULL,
	PHONE VARCHAR(15) DEFAULT NULL,
	DOB DATE DEFAULT NULL,
	BIO LONGTEXT DEFAULT NULL,
	PIC BLOB DEFAULT NULL,
	ADDR_ID INT(11) DEFAULT NULL);
--	PRIMARY KEY(STUD_ID),
--	CONSTRAINT FK_STUDENT_ADDR FOREIGN KEZ (ADDR_ID) REFERENCES ADDRESSES (ADDR_ID)
--);