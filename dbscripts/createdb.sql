create table student (id INT NOT NULL auto_increment primary key, student_id INT, firstName varchar(255), lastName varchar(255),
rollNumber INT, address varchar(500), courses varchar(125), );
create table studentBookMapping (id INT NOT NULL auto_increment primary key, student_id INT, book_id INT, issue_date DATE, due_date DATE);
create table book (id INT NOT NULL auto_increment primary key, title varchar(1000), author varchar(255));