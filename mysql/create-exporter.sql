CREATE USER 'exporter'@'%' IDENTIFIED BY 'prometheus';
GRANT PROCESS, REPLICATION CLIENT ON *.* TO 'exporter'@'%';
GRANT SELECT ON performance_schema.* TO 'exporter'@'%';
