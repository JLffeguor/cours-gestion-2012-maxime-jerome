# Introduction #

_eclipse configuration_project configuration
_project development_DB configuration


# Details #

## eclipse ##
**assuming you are using juno**
### set eclipse in unicode ###
get into the menu in _**Window => Preferences => General => Content Types**_
set **all types (eclipse doesn't override always subtypes)** int UTF-8 in _Default Encoding_ box in the bottom **and click update**
**OR**
modify _org.eclipse.core.runtime.prefs_ file(if exists) in _.metadata/.plugins/org.eclipse.core.runtime/.settings in your workspace and replace all charset to UTF-8_

## project configuration ##

## project development ##

## DB configuration ##
### mysql ###
install mysql-server on your computer (yum/apt-get/etc... install mysql-server for example)
connect as root

_mysql --user root_

and execute following commands :

_CREATE DATABASE winecave;_

_CREATE USER "winecave"@"localhost" IDENTIFIED BY "winecave" ;_

_GRANT ALL ON winecave.`*` TO "winecave"@"localhost";_