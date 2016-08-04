--Adding candidate_id coloumn & adding the foreign key constraint
CREATE SEQUENCE workhistory.usersequence   START 3;
ALTER TABLE workhistory.user ALTER COLUMN id SET DEFAULT nextval('workhistory.usersequence');


CREATE SEQUENCE workhistory.requestqueuesequence   START 1;
ALTER TABLE workhistory.request_queue ALTER COLUMN id SET DEFAULT nextval('workhistory.requestqueuesequence');


CREATE SEQUENCE workhistory.requestinitiatorsequence   START 1;
ALTER TABLE workhistory.request_initiator ALTER COLUMN id SET DEFAULT nextval('workhistory.requestinitiatorsequence');


CREATE SEQUENCE workhistory.companysequence   START 1;
ALTER TABLE workhistory.company ALTER COLUMN id SET DEFAULT nextval('workhistory.companysequence');

CREATE SEQUENCE workhistory.workhistorytransaction   START 1;
ALTER TABLE workhistory.work_history_transaction ALTER COLUMN id SET DEFAULT nextval('workhistory.workhistorytransaction');
ALTER TABLE workhistory.work_history_transaction ADD CONSTRAINT uniqueRequestQueue UNIQUE (request_queue_id);


insert into workhistory.company values 
(54, 'alias',null, 'Crizal Technologie', 454, null);

insert into workhistory.company values 
(56, 'alias',null, 'Fransico Partners', 455, null);

insert into workhistory.user values 
(1,null, 'vikramk.cs@gmail.com','vikram','kolla','admin123',4354354353,null,'HR', 54);

insert into workhistory.user values 
(2,null, 'mathrupradeep@gmail.com','pradeep','mathru','admin123',984934,null,'HR', 56);

