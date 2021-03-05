# amis-escalade

# Contexte
Avec l’objectif de fédérer les licenciés, l’association "Les amis de l’escalade” souhaite développer sa présence en ligne.
À ce titre, plusieurs axes d’amélioration ont été identifiés dont la création d’un site communautaire. Ce site aura pour but la mise en relation et le partage d’informations.
Il permettra de donner de la visibilité à l’association afin d’encourager des grimpeurs indépendants à y adhérer.

# Pré-requis
Ce qu'il est requis pour commencer avec votre projet...

* Java 11
* Spring Boot 2.4.0
* Spring MVC 2.4.0
* Spring security 2.4.0
* Spring Data JPA 2.4.0
* MySQL 8
* JSP + Bootstrap + JSTL

# Installation

1 - Creation d'une bdd et d'un utilisateur propriétaire de la bdd mysql -U MYSQL -a -f données.sql.

Renseigner le mot de passe de l'utilisateur mysql(dans mon cas, c'est admin).

Ensuite Installer le serveur TomCat, un tutoriel est disponible : http://objis.com/tutoriel-tomcat-n1-installation-tomcat-8/

Configuration : Se rendre dans le fichier conf/tomcat-users.xml, ajouter un utilisateur ```manager``` et un utilisateur ```admin```
```
<role rolename="manager-gui"/>
<role rolename="admin"/>
<user username="manager" password="manager" roles="manager-gui"/>
<user username="admin" password="admin" roles="admin,manager-gui"/>
```

Déployer le fichier war

Se rendre sur l'URL : http://localhost:8080/manager Il suffit de spécifier l’emplacement de votre fichier war de manière à l’uploader sur votre serveur tomcat qui le déploiera automatiquement. Depuis le manager tomcat, dans la zone de déploiement « WAR file to deploy » comme ci-dessous :

– dans la zone «Select WAR file to upload» cliquer sur le bouton «Parcourir»; – une fenêtre de sélection de fichier s’ouvre; – sélectionner le fichier war à déployer; – valider; – enfin cliquer sur le bouton « Deploy» dans la page du manager.

Dans la zone « Message» du manager, il est indiqué la réussite ou l’échec du déploiement. Ceci est la manière la plus simple pour déployer un war sous tomcat.

Une autre manière de faire est de déposer le fichier war directement dans le dossier webapps du dossier d’installation de Tomcat. Tomcat déploiera automatiquement l’application issue du fichier war.

# Démarrage

Allez sur l'URL : http://localhost:8080/amis-escalade/

# Auteurs
Listez le(s) auteur(s) du projet ici !

Freddy Marchandise