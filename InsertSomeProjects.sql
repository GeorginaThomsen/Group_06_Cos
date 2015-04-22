INSERT INTO Project (
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
PartnerID )VALUES
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
PartnerID)VALUES
(ProID.nextval ,'End Customer Event', '2 End customer events (cooperation with MS) on Win 10 Mobility', 5000, 'FY15Q3MDF', 'FY16Q1', 'Q2', 'Q2', 'Lead Generation, 30 Participants, 10 Leads', 'Picture of event, list of attendees, list of lead for upload to cmap','Approved',1000);


INSERT INTO Project (
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
PartnerID )VALUES
(ProID.nextval ,'Sales Competition', 'Incentive to drive Dell enterprise sales and lead/pipeline generation(Juha to scope', 10000, 'FY15Q3MDF', 'FY16Q1', 'feb', 'june', 'Revenue, leads/dealregs,TBD', 'Incentive launch comm, achieved revenue, list of leads in CMAP','Pending',1000);

INSERT INTO Project (
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
PartnerID )VALUES
(ProID.nextval ,'End Customer Event', '3 End customer events (cooperation with MS) on Win 10 Mobility', 5000, 'FY15Q3MDF', 'FY16Q1', 'Q1', 'Q1', 'Lead Generation, 30 Participants, 10 Leads', 'Picture of event, list of attendees, list of lead for upload to cmap','Approved',1000);

INSERT INTO Project (
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
PartnerID )VALUES
(ProID.nextval ,'End Customer Event', '3 End customer events (cooperation with MS) on Win 10 Mobility', 5000, 'FY15Q3MDF', 'FY16Q1', 'Q1', 'Q1', 'Lead Generation, 30 Participants, 10 Leads', 'Picture of event, list of attendees, list of lead for upload to cmap','Approved',1000);

INSERT INTO Project (
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
PartnerID )VALUES
(ProID.nextval ,'Online presence and communication package Q1(Patrick/Jesse to define)', 'Package of banners, microsite,e-mails/newsletters to ensure visibility of Dell messages and promotions', 10000, 'FY15Q4MDF', 'FY16Q2', 'may', 'july', 'Awareness,sales,250K,EUR Revenue', 'Screen dumps,e-mails,click stats,sales revenue','Pending',1000);

INSERT INTO Partner
(
PartnerID ,
PartnerName ,
Country )VALUES
(1000,'ben','england');

insert into Projectpartner
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

select * from project where partnerID = 1000;

select * from projectpartner;

select * from project;


update project

set Status = 'Pending';

where projectID = 1002;

select projectID from project;

select * from project 

where status = 'Pending';


update project set Status = 'Pending' where ProjectID = 1007;

