DROP SEQUENCE ProiD;
CREATE SEQUENCE ProiD
START WITH 1000;


DROP SEQUENCE PaiD;
CREATE SEQUENCE PaiD
START WITH 1000;

DROP TABLE Project;
DROP TABLE Partner;
DROP TABLE ProjectManager;
DROP TABLE Dell;
DROP TABLE Poe;


CREATE TABLE Partner
(
PartnerID int,
PartnerName varchar(255),
Country varchar(255),
PRIMARY KEY (PartnerID)
);


create table partneremployee
(
Username varchar(255),
PartnerID int,
foreign key (Username) references usertable(Username),
foreign key (PartnerID) references Partner(PartnerID),
primary key(Username)
);

create table usertable
(
Username varchar(255),
Password varchar(255),
Usertype varchar(255),
primary key (Username)
);


CREATE TABLE Project
(
ProjectID int,
ActivityDescription varchar(255),
Comments varchar(255),
Cost float,
MDFBudget char(9),
ExecutionQuarter varchar(255),
StartDate varchar(255),
EndDate varchar(255),
ObjAndResult varchar(255),
RequiredPOE varchar(255),
Status varchar(255),
PartnerID int,
FOREIGN KEY (PartnerID) REFERENCES Partner(PartnerID),
PRIMARY KEY (ProjectID)
);

create table poetable
(
ProjectID int,
Type_ varchar(255),
POE blob,
primary key (projectID)
);



