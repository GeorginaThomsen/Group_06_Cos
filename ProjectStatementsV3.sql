DROP SEQUENCE ProiD;
CREATE SEQUENCE ProiD
START WITH 1000;

DROP SEQUENCE DelliD;
CREATE SEQUENCE DelliD
START WITH 1000;

DROP SEQUENCE PartneriD;
CREATE SEQUENCE PartneriD
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

CREATE TABLE Poe
(
ProjectID int,
Poe varchar(255),
PRIMARY KEY (ProjectID)
);

CREATE TABLE Dell
(
DellID int,
Name_ varchar(255),
Dept varchar(255),
PRIMARY KEY (DellID)
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

CREATE TABLE ProjectManager
(
ProjectID int,
DellID int,
PRIMARY KEY (ProjectID,DellID),
FOREIGN KEY (ProjectID) REFERENCES  Poe(ProjectID),
FOREIGN KEY (DellID) REFERENCES Dell(DellID)
);



