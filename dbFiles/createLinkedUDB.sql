drop table linkedu.AppUser;
drop table linkedu.Student;
drop table linkedu.University;
drop table linkedu.Recruiter;
drop table linkedu.Appointment;
drop table linkedu.Multimedia;
--drop table AppUser;
--drop table Student;
--drop table University;
--drop table Recruiter;
--drop table Appointment;
--drop table Multimedia;

create table linkedu.AppUser(
	username		varchar(25) not null,
	password		varchar(25) not null,
	primary key(username, password)
);

create table linkedu.Student(
	studentUsername 	varchar(25) not null,
	password 		varchar(25) not null,
	--studentID 		int not null generated always as identity(start with 1, increment by 1),
	email			varchar(25),
	firstName		varchar(25),
	lastName		varchar(25),
        highSchool              varchar(25),
	actScore		varchar(2),
	satScore		varchar(4),
	essay			varchar(256),
	universities	varchar(256),
	majors			varchar(256),
	isPaidService	boolean,
	--foreign key(username) references User(username),
	--foreign key(password) references User(password),
	primary key(studentUsername)		
);

create table linkedu.University(
	universityUsername 		varchar(25) not null,
	password 		varchar(25) not null,
	--universityID	int not null generated always as identity(start with 1, increment by 1),
	officialName	varchar(25) not null,
	availability	varchar(25),
	address			varchar(25),
	city			varchar(25),
	state			varchar(2),
	zip				varchar(5),
	email			varchar(25),
	--foreign key(username) references User(username),
	--foreign key(password) references User(password),
	primary key(universityUsername)
);	

create table linkedu.Recruiter(
	recruiterUsername		varchar(25) not null,
	password 		varchar(25) not null,
	universityID            varchar(25),
	firstName 		varchar(25),
	lastName 		varchar(25),
	email 			varchar(25),
	isPaidService	boolean,
	primary key(recruiterUsername)
);

create table linkedu.Appointment(
	universityID 	varchar(25) not null,
	studentID 		varchar(25) not null,
	visitDate		date,
	--foreign key(universityID) references linkedu.University(universityID),
	--foreign key(studentID) references linkedu.Student(studentID),
	primary key(universityID, studentID, visitDate)
);

create table linkedu.Multimedia(
	mixtapeID		int not null generated always as identity(start with 1, increment by 1),
	--studentID		not null foreign key references linkedu.Student(studentID),
	mmBlob			blob(16M),
        rating                  
	primary key(mixtapeID)
);