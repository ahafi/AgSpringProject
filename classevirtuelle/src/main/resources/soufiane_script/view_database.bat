REM lancer si besoin le service mysql (net start mysql)
set MYSQL_HOME=C:\Prog\DB\MySql5
cd /d %~dp0
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql"   -u root -p  <view_classevirtuelle_db.sql
pause