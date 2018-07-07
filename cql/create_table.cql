-- Export of keyspace person_ks
CREATE KEYSPACE person_ks
WITH durable_writes = true
     AND replication = {
'class' : 'SimpleStrategy',
'replication_factor' : 1
};

CREATE TABLE person_ks.person (
firstName ascii,
dateOfBirth timestamp,
personId uuid,
gender ascii,
lastName ascii,
PRIMARY KEY (first_name, date_of_birth, person_id)
) WITH CLUSTERING ORDER BY ( date_of_birth ASC, person_id ASC );
