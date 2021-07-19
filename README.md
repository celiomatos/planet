# planet
Catalogação de planetas descobertos 
docker run -d -p 1521:1521 oracleinanutshell/oracle-xe-11g
hostname: localhost
port: 1521
sid: xe
username: system
password: oracle


CREATE TABLE PLANETS
(
PLANET_ID NUMBER(10) PRIMARY KEY,
NAME varchar2(50) NOT NULL UNIQUE
);

CREATE SEQUENCE planet_seq START WITH 1;

CREATE OR REPLACE TRIGGER PLANET_BIR
BEFORE INSERT ON PLANETS
FOR EACH ROW
BEGIN
:new.PLANET_ID := planet_seq.nextval;
END;    
