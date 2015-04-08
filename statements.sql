DROP TABLE ProjectPartner;
DROP TABLE Partner;
DROP TABLE Project;



CREATE TABLE Project
(
ProjectID int,
ActivityDescription varchar(255),
Comments varchar(255),
Cost float,
MDFBudget char(9),
ExecutionQuarter varchar(255),
StartDate date,
EndDate date,
ObjAndResult varchar(255),
RequiredPOE varchar(255),
PRIMARY KEY (ProjectID)
);

CREATE TABLE Partner
(
PartnerID int,
PartnerName varchar(255),
Country varchar(255),
PRIMARY KEY (PartnerID)
);

CREATE TABLE ProjectPartner
(
ProjectID int,
PartnerID int,
FOREIGN KEY (ProjectID)REFERENCES Project(ProjectID),
FOREIGN KEY (PartnerID)REFERENCES Partner(PartnerID)
);


