INSERT INTO project (
ProjectID,
ActivityDescription,
Comments,
Cost,
MDFBudget ,
ExecutionQuarter,
StartDate ,
EndDate ,
ObjAndResult,
RequiredPOE,
Status,
Paid )VALUES
(ProID.nextval ,'End Customer Event', '3 End customer events (cooperation with MS) on Win 10 Mobility', 5000, 'FY15Q3MDF', 'FY16Q1', 'Q1', 'Q1', 'Lead Generation, 30 Participants, 10 Leads', 'Picture of event, list of attendees, list of lead for upload to cmap','Approved',1000);

INSERT INTO project (
ProjectID,
ActivityDescription,
Comments,
Cost,
MDFBudget ,
ExecutionQuarter,
StartDate ,
EndDate ,
ObjAndResult,
RequiredPOE ,
Status,
PaID)VALUES
(ProID.nextval ,'End Customer Event', '2 End customer events (cooperation with MS) on Win 10 Mobility', 5000, 'FY15Q3MDF', 'FY16Q1', 'Q2', 'Q2', 'Lead Generation, 30 Participants, 10 Leads', 'Picture of event, list of attendees, list of lead for upload to cmap','Approved',1000);

INSERT INTO Partner
(
PartnerID ,
PartnerName ,
Country )VALUES
(1000,'ben','england');

insert into projectpartner
(
ProjectID,
PartnerID)values
(1003,1000);

insert into projectpartner
(
ProjectID,
PartnerID)values
(1004,1000);

select * from project;

select * from partner;

select * from projectpartner;

select * from project

where Paid = 1000;
