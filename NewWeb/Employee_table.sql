CREATE TABLE test.LOGIN (U_ID INT primary key,user_name varchar(20),PW varchar(50),acc_type INT);
-- INSERT INTO test.LOGIN VALUE(1,"ADMIN","hashed",0);

CREATE TABLE test.EMP (Emp_ID INT primary key,Emp_name varchar(20),Position_name varchar(20),Salary INT,Dep_ID INT, Foreign Key (Dep_ID) REFERENCES test.DEP(Dep_ID) );
CREATE TABLE test.DEP (Dep_ID INT primary key,Dep_name varchar(20));


SELECT * FROM test.LOGIN;
SELECT * FROM test.EMP;
SELECT * FROM test.DEP;




