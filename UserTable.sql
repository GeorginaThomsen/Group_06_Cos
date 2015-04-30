
DROP TABLE UserTable;


CREATE TABLE UserTable(
UserID int,
UserName varchar(255),
UserType varchar(255),
Password varchar(255),
PRIMARY KEY(UserId)
)

insert into usertable
(UserID,UserName,UserType,Password)
values(1000,ben,partner,ben);

select * from usertable;

update usertable set usertype = 'partner';

select max(projectid) from project;
