create database Hospital 
use Hospital


create table Patients
(ssn int primary key , name nvarchar  (max) not null ,medical_insurance nvarchar (max),
 date_admitted date not null , date_checkedout date not null )
 
create table Medical_Doctor
(dssn int primary key , name nvarchar (max) not null ,specialization nvarchar (max) not null )
 
create table Tests
(test_id int primary key , test_name nvarchar (max) not null , test_date date , test_time time , result nvarchar (max ))

create table patients_Doctors
(fssn int foreign key references Patients (ssn) , fdssn int foreign key references Medical_Doctor(dssn))

create table patients_Tests
(fssn int foreign key references Patients (ssn) , fid int foreign key references Tests(test_id))

create table Doctors_Tests
( fid int foreign key references Tests(test_id), fdssn int foreign key references Medical_Doctor(dssn))




alter table Patients alter column  date_admitted nvarchar (max)
alter table Patients alter column  date_checkedout nvarchar (max)

alter table Tests alter column  test_date nvarchar (max)
alter table Tests alter column  test_time nvarchar (max)

select* from Medical_Doctor
select* from Patients
select* from Tests