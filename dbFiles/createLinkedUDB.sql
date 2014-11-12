drop table linkedu.AppUser;
drop table linkedu.Student;
drop table linkedu.University;
drop table linkedu.Recruiter;
drop table linkedu.Appointment;
drop table linkedu.Multimedia;

create table linkedu.AppUser(
	username		varchar(25) not null,
	password		varchar(25) not null,
	primary key(username)
);

create table linkedu.Student(
	username		varchar(25) not null,
	password		varchar(25) not null,
        studentID               INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 1),
        email                   varchar(25),
        firstName               varchar(25),
        lastName               varchar(25),
        highSchool               varchar(25),
        gpa                     decimal(3,2),
        actScore                integer,
        atScore                 integer,
        psatScore               integer,
        nmsqtScore              integer,
        apCourse                varchar(256),
	essay			varchar(256),
	universities            varchar(256),
	majors			varchar(256),
	isPaidService           boolean,
	primary key(username)
);

create table linkedu.University(
	username 		varchar(25) not null,
	password 		varchar(25) not null,
	universityID	INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 1),
	officialName	varchar(25) not null,
	availability	varchar(25),
	address			varchar(25),
	city			varchar(25),
	stAbbr			varchar(2),
	zip			varchar(5),
	email			varchar(25),
        isFeatured              boolean,
	primary key(username)
);	

create table linkedu.Recruiter(
	username		varchar(25) not null,
	password 		varchar(25) not null,
        recruiterID             INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 1),
	universityID            integer,
	firstName 		varchar(25),
	lastName 		varchar(25),
	email 			varchar(25),
	isPaidService           boolean,
	primary key(username)
);

create table linkedu.Appointment(
	universityID            integer,
	studentID 		integer,
	visitDate		date,
	primary key(universityID, studentID, visitDate)
);

create table linkedu.Multimedia(
	mixtapeID		integer not null generated always as identity(start with 100, increment by 1),
	studentID		integer,
	mmBlob			blob(16M),
        rating                  decimal(2,1),
	primary key(mixtapeID)
);