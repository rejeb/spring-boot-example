-- Export of keyspace person_ks
CREATE KEYSPACE person_ks
WITH durable_writes = true
     AND replication = {
'class' : 'SimpleStrategy',
'replication_factor' : 1
};

CREATE TABLE person_ks.person (
first_name ascii,
date_of_birth timestamp,
person_id uuid,
gender ascii,
last_name ascii,
PRIMARY KEY (first_name, date_of_birth, person_id)
) WITH CLUSTERING ORDER BY ( date_of_birth ASC, person_id ASC );
