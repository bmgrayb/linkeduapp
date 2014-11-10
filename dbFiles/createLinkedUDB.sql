create table linkedu.User(
	username		varchar(25) not null,
	password		varchar(25) not null,
	primary key(username, password)
);

create table linkedu.Student(
	username 		varchar(25) not null,
	password 		varchar(25) not null,
	studentID 		int not null generated always as identity(start with 1, increment by 1),
	email			varchar(25),
	firstName		varchar(25),
	lastName		varchar(25),
	actScore		varchar(2),
	satScore		varchar(4),
	essay			varchar(256),
	universities	varchar(256),
	majors			varchar(256),
	isPaidService	boolean,
	foreign key(username) references User(username),
	foreign key(password) references User(password),
	primary key(username)		
);

create table linkedu.University(
	username 		varchar(25) not null,
	password 		varchar(25) not null,
	universityID	int not null generated always as identity(start with 1, increment by 1),
	officialName	varchar(25) not null,
	availability	varchar(25),
	address			varchar(25),
	city			varchar(25),
	state			varchar(2),
	zip				varchar(5),
	email			varchar(25),
	foreign key(username) references User(username),
	foreign key(password) references User(password),
	primary key(username)
);	

create table linkedu.Recruiter(
	username		varchar(25) not null,
	password 		varchar(25) not null,
	universityID	varchar(25),
	firstName 		varchar(25),
	lastName 		varchar(25),
	email 			varchar(25),
	isPaidService	boolean,
	primary key(username)
);

create table linkedu.Appointment(
	universityID 	varchar(25) not null,
	studentID 		varchar(25) not null,
	visitDate		date,
	foreign key(universityID) references University(universityID),
	foreign key(studentID) references Student(studentID),
	primary key(universityID, studentID, visitDate)
);

create table linkedu.Multimedia(
	mixtapeID		int not null generated always as identity(start with 1, increment by 1),
	studentID		not null foreign key references Student(studentID),
	mmBlob			blob(16M),
	primary key(mixtapeID)
);