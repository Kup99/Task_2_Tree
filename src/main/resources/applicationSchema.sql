create table folder (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   parent_id BIGINT,
   PRIMARY KEY (id)
);

