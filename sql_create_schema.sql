CREATE USER 'rpsp'@'localhost'
  IDENTIFIED BY 'rpsp';
CREATE SCHEMA rpsp;
GRANT ALL PRIVILEGES ON rpsp.* TO 'croinc'@'localhost'
WITH GRANT OPTION;

CREATE SCHEMA rpspaudit;
GRANT ALL PRIVILEGES ON rpspaudit.* TO 'croinc'@'localhost'
WITH GRANT OPTION;
