DROP SEQUENCE ProID;
CREATE SEQUENCE ProiD
START WITH 1000;

DROP SEQUENCE PaiD;
CREATE SEQUENCE PaiD
START WITH 1000;

DROP TABLE COMMENTS;
DROP TABLE POETABLE;
DROP TABLE PROJECT;
DROP TABLE PARTNEREMPLOYEE;
DROP TABLE USERTABLE;






CREATE TABLE Partner
(
PartnerID int,
PartnerName_ varchar(255),
Country varchar(255),
PRIMARY KEY (PartnerID)
);


CREATE TABLE Usertable
(
Username varchar(255),
Usertype varchar(255),
Password varchar(255),
PRIMARY KEY (Username)
);

CREATE TABLE Partneremployee
(
Username varchar(255),
PartnerID int,
foreign key (Username) references usertable(Username),
foreign key (PartnerID) references Partner(PartnerID),
primary key(Username)
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

CREATE TABLE Poetable
(
ProjectID int,
Type_ varchar(255),
POE blob,
primary key (projectID)
);

CREATE TABLE Comments
(
ProjectID int,
Comments varchar(500),
primary key (projectID)
);





