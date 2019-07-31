
create table employee(
	id serial primary key,
	Username varchar not null unique,
	Password varchar not null,
	Authority int not null,
	name varchar not null,
	email varchar not null,
	Phone varchar not null
	);
create table reimburstment(
	id serial primary key,
	reimburstmentname varchar not null references employee(Username),
	Amount integer, 
	reimburstmenttype varchar,
	status varchar
	);
	

drop table employee;
drop table reimburstment;
	
insert into employee(Username,Password,Authority,name,email,phone) values('john','123',1,'John Snow', 'john@snow.com','(956)254-1524');
insert into employee(Username,Password,Authority,name,email,phone) values('jim','123',1,'Jim slim', 'jim@slim.com','(956)158-5487');
insert into employee(Username,Password,Authority,name,email,phone) values('Ben','456',2,'Benjamin Garcia', 'Benjamin@Garcia.com','(956)154-4875');

insert into reimburstment(reimburstmentname,Amount,reimburstmenttype,status) values('john',250,'gas','pending');
insert into reimburstment(reimburstmentname,Amount,reimburstmenttype,status) values('jim',30,'food','pending');

select * from employee
select * from reimburstment
select * from reimburstment where reimburstmentname = 'john'
select * from reimburstment where reimburstmentname = 'john'
select * from employee where username = 'Ben'
select * from employee where username = 'Ben' and password ='456'

update reimburstment set status = 'Accepted' where id = 2 

create table Person(
	id serial primary key,
	Username varchar not null,
	Password varchar not null,
	Authority integer not null,
	Accountnum integer not null,
	verified boolean not null
	);

create table Account(
	id serial primary key,
	balance int not null,
	accountnumber int not null references Person(id)
	);
	
insert into Person(Username,Password,Authority,Accountnum,verified) values('emp',123,2,0,true);
insert into Person(Username,Password,Authority,Accountnum,verified) values('adm',123,3,0,true);

select * from person