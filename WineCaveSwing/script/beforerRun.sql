--reate database winecave

CREATE DATABASE winecave;
--create user winecave
CREATE USER "winecave"@"localhost";
--lui donner le password winecave
SET password FOR "winecave"@"localhost" = password('winecave');
--OR
CREATE USER "winecave"@"localhost" IDENTIFIED BY "winecave";
--donner tous les privilèges au user sur la db créée (pas top pour le moment mais va changer)

GRANT ALL ON winecave.* TO "winecave"@"localhost"; 