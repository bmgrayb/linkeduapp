
--insert AppUser table
insert into linkedu.appuser values('univ1','univ1', 'university');
insert into linkedu.appuser values('univ2','univ2','university');
insert into linkedu.appuser values('univ3','univ3','university');
insert into linkedu.appuser values('stu1','stu1', 'student');
insert into linkedu.appuser values('stu2','stu2','student');
insert into linkedu.appuser values('stu3','stu3','student');
insert into linkedu.appuser values('rec1','rec1', 'recruiter');
insert into linkedu.appuser values('rec2','rec2', 'recruiter');
insert into linkedu.appuser values('rec3','rec3', 'recruiter');

--insert into student table
insert into linkedu.STUDENT values ('stu1', 'stu1', default, 'stu1@school.edu', 'Student', 'One',1, 'Normal Community', 4.0, 36, null, null, null, 'Calc;Computer Science', 'I am awesome.', 'MIT', 'Computer Engineering', true, null);
insert into linkedu.STUDENT values ('stu2', 'stu2', default, 'stu2@school.edu', 'Student', 'Two',3, 'Normal West', 3.8, 32, 1200, null, null, 'Calc;Computer Science;English', 'I am better than everyone else.', 'Illinois State University', 'Computer Science', false, null);
insert into linkedu.STUDENT values ('stu3', 'stu3', default, 'stu3@school.edu', 'Student', 'Three',4, 'UHigh', 2.5, 27, null, null, 1200, null, 'you should accept me.', 'University of Illinois', 'Network Security', true, null);

--insert into university table
insert into linkedu.UNIVERSITY values('univ1', 'univ1', default, 'MIT', 11301, 'M;W;F', '77 Massachussetts Ave', 'Cambridge', 'MA', '02139', 'school@mit.edu', true);
insert into linkedu.UNIVERSITY values('univ2', 'univ2', default, 'Illinois State University', 18714,'M;T;W;F', '100 N University Ave', 'Normal', 'IL', '61761', 'school@ilstu.edu', true);
insert into linkedu.UNIVERSITY values('univ3', 'univ3', default, 'University of Illinois', 44520, 'M;T;W;Th;F', '506 S Wright St', 'Urbana', 'IL', '61801', 'school@uiuc.edu', false);

-- insert into recruiter table
insert into linkedu.RECRUITER values ('rec1', 'rec1', default, 100, 'Recruiter', 'One', 'rec@mit.com', false);
insert into linkedu.RECRUITER values ('rec2', 'rec2', default, 101, 'Recruiter', 'Two', 'rec@ilstu.com', true);
insert into linkedu.RECRUITER values ('rec3', 'rec3', default, 102, 'Recruiter', 'Three', 'rec@uiuc.com', true);

--insert into appointment table
insert into linkedu.APPOINTMENT values(102, 100, '2014-1-1');
insert into linkedu.APPOINTMENT values(100, 101, '2014-5-5');
insert into linkedu.APPOINTMENT values(101, 102, '2014-7-6');

--insert into multimedia table
insert into linkedu.MULTIMEDIA values(default, 100, null, 4.0);
insert into linkedu.MULTIMEDIA values(default, 101, null, 3.2);
insert into linkedu.MULTIMEDIA values(default, 102, null, 5.0);

