# amis-escalade
# Titre du projet

Avec lâ€™objectif de fÃ©dÃ©rer les licenciÃ©s, lâ€™association â€œâ€‹Les amis de lâ€™escaladeâ€
souhaite dÃ©velopper sa prÃ©sence en ligne. Ã€ ce titre, plusieurs axes dâ€™amÃ©lioration
ont Ã©tÃ© identifiÃ©s dont la crÃ©ation dâ€™un site communautaire.
Ce site aura pour but la mise en relation et le partage dâ€™informations. Il permettra
de donner de la visibilitÃ© Ã  lâ€™association afin dâ€™encourager des grimpeurs
indÃ©pendants Ã  y adhÃ©rer.

## Pour commencer

Entrez ici les instructions pour bien dÃ©buter avec votre projet...

### PrÃ©-requis

Ce qu'il est requis pour commencer avec votre projet...

- Java
- Spring Boot
- Base de donnÃ©e MySQL
- JSP

### Installation

1 - Creation d'une bdd et d'un utilisateur propriÃ©taire de la bdd psql -U MySQL -a -f donnÃ©es.sql.

Renseigner le mot de passe de l'utilisateur postgres (dans mon cas, c'est admin).

Ensuite Installer le serveur TomCat, un tutoriel est disponible : http://objis.com/tutoriel-tomcat-n1-installation-tomcat-8/

Configuration : Se rendre dans le fichier conf/tomcat-users.xml, ajouter 

  <role rolename="manager-gui"/>
  <role rolename="admin"/>
  <user username="admin" password="admin" roles="manager-gui,admin"/>
  Pour creer un role et pouvoir acceder Ã  l'interface manager.
  
DÃ©ployer le fichier war

Se rendre sur l'URL : http://localhost:8080/manager
Il suffit de spÃ©cifier lâ€™emplacement de votre fichier war de maniÃ¨re Ã  lâ€™uploader sur votre serveur tomcat qui le dÃ©ploiera automatiquement. Depuis le manager tomcat, dans la zone de dÃ©ploiement Â« WAR file to deploy Â» comme ci-dessous :

tomcat-manager2

â€“ dans la zone Â«Select WAR file to uploadÂ» cliquer sur le bouton Â«ParcourirÂ»;
â€“ une fenÃªtre de sÃ©lection de fichier sâ€™ouvre;
â€“ sÃ©lectionner le fichier war Ã  dÃ©ployer;
â€“ valider;
â€“ enfin cliquer sur le bouton Â« DeployÂ» dans la page du manager.

Dans la zone Â« MessageÂ» du manager, il est indiquÃ© la rÃ©ussite ou lâ€™Ã©chec du dÃ©ploiement. Ceci est la maniÃ¨re la plus simple pour dÃ©ployer un war sous tomcat.

Une autre maniÃ¨re de faire est de dÃ©poser le fichier war directement dans le dossier webapps du dossier dâ€™installation de Tomcat. Tomcat dÃ©ploiera automatiquement lâ€™application issue du fichier war.

## DÃ©marrage

Allez sur l'URL : http://localhost:8080/amis-escalade-0.0.1-SNAPSHOT/

## FabriquÃ© avec

- Java
- Spring Boot
- Base de donnÃ©e PostgresSql
- JSP
- IntelliJ

## Auteurs

Listez le(s) auteur(s) du projet ici !
* **Yann CABERAS** _alias_ [yanncb](https://github.com/yanncb)
