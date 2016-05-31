CREATE SEQUENCE usersequence   START 1;

--Adding candidate_id coloumn & adding the foreign key constraint
ALTER TABLE workhistory.request_queue 
add column candidate_id int;

ALTER TABLE workhistory.request_queue 
ADD CONSTRAINT fk_candidate_id 
FOREIGN KEY (candidate_id) 
REFERENCES workhistory.user 
ON DELETE CASCADE;





CREATE SEQUENCE usersequence   START 1;
ALTER TABLE workhistory.user ALTER COLUMN id SET DEFAULT nextval('usersequence');


CREATE SEQUENCE requestqueuesequence   START 1;
ALTER TABLE workhistory.request_queue ALTER COLUMN id SET DEFAULT nextval('requestqueuesequence');


CREATE SEQUENCE requestinitiatorsequence   START 1;
ALTER TABLE workhistory.request_initiator ALTER COLUMN id SET DEFAULT nextval('requestinitiatorsequence');


CREATE SEQUENCE companysequence   START 1;
ALTER TABLE workhistory.company ALTER COLUMN id SET DEFAULT nextval('companysequence');