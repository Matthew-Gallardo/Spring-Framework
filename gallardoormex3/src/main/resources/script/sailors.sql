drop database IF EXISTS sailor;
create database sailor;
\c sailor

DROP TABLE IF EXISTS reservation;

DROP TABLE IF EXISTS sailor;

DROP TABLE IF EXISTS boat;


CREATE TABLE sailor 
    (id      INTEGER,
     name    VARCHAR(20) NOT NULL,
     rating  INTEGER NOT NULL,
     age     INTEGER NOT NULL,
     PRIMARY KEY (id));


CREATE TABLE boat
    (id      INTEGER,
     name    VARCHAR(20) NOT NULL,
     colour  VARCHAR(10) NOT NULL,
     PRIMARY KEY (id));


CREATE TABLE reservation
    (rid  INTEGER,
     sid     INTEGER,
     bid     INTEGER,
     day     DATE,
     PRIMARY KEY (rid, sid, bid, day),
     FOREIGN KEY (sid) 
         REFERENCES sailor(id),
     FOREIGN KEY (bid) 
         REFERENCES boat(id));

GRANT ALL ON sailor TO PUBLIC;
GRANT ALL ON boat TO PUBLIC;
GRANT ALL ON reservation TO PUBLIC;

INSERT INTO sailor VALUES (22 , 'Dustin' ,  7 , 45.0 );
INSERT INTO sailor VALUES (31 , 'Lubber' ,  8 , 65.5 );
INSERT INTO sailor VALUES (58 , 'Rusty'  , 10 , 35.0 );
INSERT INTO sailor VALUES (59 , 'Smith'  ,  9 , 41.0 );


INSERT INTO boat VALUES (101 , 'Interlake' , 'blue'  );
INSERT INTO boat VALUES (102 , 'Interlake' , 'red'   );
INSERT INTO boat VALUES (103 , 'Clipper'   , 'green' );
INSERT INTO boat VALUES (104 , 'Marine'    , 'red'   );


INSERT INTO reservation VALUES (1, 22 ,  101 , '2006-10-10');
INSERT INTO reservation VALUES (2, 58 ,  103 , '2006-12-11');
INSERT INTO reservation VALUES (3, 31 ,  104 , '2007-02-04');
INSERT INTO reservation VALUES (4, 31 ,  103 , '2007-02-05');
INSERT INTO reservation VALUES (5, 58 ,  103 , '2007-02-06');
INSERT INTO reservation VALUES (6, 31 ,  102 , '2007-02-15');
INSERT INTO reservation VALUES (7, 59 ,  102 , '2008-01-05');
INSERT INTO reservation VALUES (8, 31 ,  101 , '2008-01-05');




 




