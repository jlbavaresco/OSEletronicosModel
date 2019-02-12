@echo off                                            
echo Efetuando backup completo do banco de dados PostgreSQL 10.5
SET PGUSER=postgres
SET PGPASSWORD=postgres
C:\PostgreSQL\pg11\bin\pg_dump.exe --host localhost --port 5432 --username "postgres" --clean --format c --verbose --file backup_completo.backup "oseletronicos"


