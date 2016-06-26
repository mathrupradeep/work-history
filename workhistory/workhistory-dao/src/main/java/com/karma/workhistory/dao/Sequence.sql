--Adding candidate_id coloumn & adding the foreign key constraint
ALTER TABLE workhistory.request_queue 
add column candidate_id int;

ALTER TABLE workhistory.request_queue 
ADD CONSTRAINT fk_candidate_id 
FOREIGN KEY (candidate_id) 
REFERENCES workhistory.user 
ON DELETE CASCADE;





CREATE SEQUENCE usersequence   START 3;
ALTER TABLE workhistory.user ALTER COLUMN id SET DEFAULT nextval('usersequence');


CREATE SEQUENCE requestqueuesequence   START 1;
ALTER TABLE workhistory.request_queue ALTER COLUMN id SET DEFAULT nextval('requestqueuesequence');


CREATE SEQUENCE requestinitiatorsequence   START 1;
ALTER TABLE workhistory.request_initiator ALTER COLUMN id SET DEFAULT nextval('requestinitiatorsequence');


CREATE SEQUENCE companysequence   START 1;
ALTER TABLE workhistory.company ALTER COLUMN id SET DEFAULT nextval('companysequence');


insert into workhistory.company values 
(54, 'alias', 45, 'Cone Company', 454, null);

insert into workhistory.company values 
(56, 'alias', 45, 'Ctwo Company', 455, null);

insert into workhistory.user values 
(1,null, 'vikramk.cs@gmail.com','vikram','kolla','admin123',4354354353,null,'HR', 54);

insert into workhistory.user values 
(2,null, 'mathrupradeep@gmail.com','pradeep','mathru','admin123',984934,null,'HR', 56);

