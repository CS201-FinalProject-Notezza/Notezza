
DROP DATABASE IF EXISTS Notezza;
CREATE DATABASE Notezza;
USE Notezza;

CREATE TABLE UserTable
(
	userID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	fname VARCHAR(32) NOT NULL,
	lname VARCHAR(32) NOT NULL,
	username VARCHAR(32) NOT NULL,
	email VARCHAR(32) NOT NULL,
	pword VARCHAR(32) NOT NULL,
	isInstructor CHAR(5) NOT NULL,
	isVisible CHAR(5) NOT NULL,
	UNIQUE (username)
);

CREATE TABLE Course
(
	courseID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	courseName VARCHAR(20) NOT NULL,
	instructorID INT NOT NULL,
	FOREIGN KEY (instructorID) REFERENCES UserTable(userID),
	UNIQUE (courseName)
);

CREATE TABLE UserCourse
(
	userID INT NOT NULL,
	courseID INT NOT NULL,
	FOREIGN KEY (userID) REFERENCES UserTable(userID),
	FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

CREATE TABLE PresentationLink
(
	link VARCHAR(128) NOT NULL,
	courseID INT NOT NULL,
	FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

CREATE TABLE PresentationQuestion
(
	questionID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	content VARCHAR(128) NOT NULL,
	courseID INT NOT NULL,
	FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

CREATE TABLE QuestionChoice
(
	content VARCHAR(64) NOT NULL,
	correctBool VARCHAR(5) NOT NULL,
	questionID INT NOT NULL,
	FOREIGN KEY (questionID) REFERENCES PresentationQuestion(questionID)
);

CREATE TABLE Note
(
	noteID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	content VARCHAR(8000) NOT NULL,
	postedDate VARCHAR(32) NOT NULL,
	courseID INT NOT NULL,
	userID INT NOT NULL,
	FOREIGN KEY (courseID) REFERENCES Course(courseID),
	FOREIGN KEY (userID) REFERENCES UserTable(userID)
);

CREATE TABLE Tag
(
	tag VARCHAR(16) NOT NULL,
	noteID INT NOT NULL,
	FOREIGN KEY (noteID) REFERENCES Note(noteID)
);

CREATE TABLE NoteVote
(
	likeBool VARCHAR(5) NOT NULL,
    userID INT NOT NULL,
	noteID INT NOT NULL,
	FOREIGN KEY (noteID) REFERENCES Note(noteID),
	FOREIGN KEY (userID) REFERENCES UserTable(userID)
);

CREATE TABLE NoteComment
(
	commentID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	content VARCHAR(8000) NOT NULL,
	postedDate VARCHAR(32) NOT NULL,
	noteID INT NOT NULL,
	userID INT NOT NULL,
	FOREIGN KEY (noteID) REFERENCES Note(noteID),
	FOREIGN KEY (userID) REFERENCES UserTable(userID)
);

CREATE TABLE CommentVote
(
	likeBool VARCHAR(5) NOT NULL,
	userID INT NOT NULL,
	commentID INT NOT NULL,
	FOREIGN KEY (userID) REFERENCES UserTable(userID),
	FOREIGN KEY (commentID) REFERENCES NoteComment(commentID)
);

INSERT INTO UserTable (fname, lname, username, email, pword, isInstructor, isVisible)
		VALUES 	("Jeffrey", "Miller", "miller", "jeffrey.miller@usc.edu", "MillerhashedPWORD", "true", "true"),
						("Joey", "Blundell", "blundell", "blundell@usc.edu", "JoeyhashedPWORD", "false", "true"),
						("Willie", "Shen", "shen", "williesh@usc.edu", "WilliehashedPWORD", "false", "true"),
                        ("Tim", "Hu", "hu", "tianyuh@usc.edu", "TimhashedPWORD", "false", "true"),
                        ("Stan", "Shi", "shi", "zifanshi@usc.edu", "StanhashedPWORD", "false", "true");
                        
INSERT INTO Course (courseName, instructorID)
		VALUES 	("CSCI 201", 1);
        
INSERT INTO UserCourse (userID, courseID)
		VALUES 	(1, 1),
						(2, 1),
                        (3, 1),
                        (4, 1),
                        (5, 1);
        
INSERT INTO PresentationLink (link, courseID)
		VALUES 	("http://www-scf.usc.edu/~csci201/lectures/Lecture1/Introduction.pdf", 1);
        
INSERT INTO PresentationQuestion (content, courseID)
		VALUES 	("What is the professor's first name?", 1);

INSERT INTO QuestionChoice (content, correctBool, questionID)
		VALUES 	("Geoffrey", "false", 1),
						("Geoffery", "false", 1),
                        ("Jeffrey", "true", 1),
                        ("Jeffery", "false", 1);
                        
INSERT INTO Note (content, postedDate, courseID, userID)
		VALUES 	("Welcome to the CS201 Notezza page.\nPlease use this as a place to help out your classmates by posting notes as well as viewing our lectures and testing your knowledge!\nLooking forward to a great semester", 
								"08/20/17 14:00", 1, 1),
						("Classes vs Objects\n\tFor objects, the code knows what each method will do, but doesn’t need to know how it does it\n\tAn object is a high-level term for the idea behind a class, the implementation of the object is a class, and an instance of the class in code is typically referred to as an object\n\tNo functions in Java, called methods instead\n\tAccess modifiers for variables and methods:\n\t\tpublic\n\t\tprivate (only the class in which variable or method is declared can access it)\n\t\tprotected (any class in same package or who inherits from the class can access)\n\t\t<package> (any class in same package can access it)\n\tA class is considered encapsulated if all of the data is declared private\n\tA class is considered fully encapsulated if all the data is declared private and you provide a getter and setter for each piece of data\n", 
								"08/24/17 10:00", 1, 2);
                                
INSERT INTO Tag (tag, noteID)
		VALUES 	("Lecture1", 1),
						("Classes", 1),
						("Objects", 1);
                        
INSERT INTO NoteVote (likeBool, userID, noteID)
		VALUES 	("true", 3, 1),
						("true", 4, 1),
                        ("false", 5, 1);
                        
INSERT INTO NoteComment (content, postedDate, noteID, userID)
		VALUES 	("Nice", "8/24/17 10:50", 1, 3);
        
INSERT INTO CommentVote (likeBool, userID, commentID)
		VALUES 	("true", 2, 1);
