# ActivityRecognition-V1
Pour que le projet marche il faut en premier temps Installer le server #Xamp car j'ai utiliser MySql pour la gestion de base de donnnes 
deuxiemment dans le repertoire xampp/htdocs/ creer un dossier loginRegister comme suit :
![image](https://user-images.githubusercontent.com/98331671/175425410-2b3c97cd-234c-4ab3-8e29-9ec1c1ab10fb.png)
 et mettez y les fichier php suit : DataBase.php , DataBaseConfig.php, login.php et signup.php que vous trouverez sur le projet 
 
 Creer une base de donnes sur mysqlAdmin toute en respectant les noms et tous pour ne pas avoir des erreur :
 ![image](https://user-images.githubusercontent.com/98331671/175426791-156ba085-f81b-49cc-9a63-feae109ac0ae.png)

 
 Juste une petite precision : pour la reconnaissance d'activité le resulat s'affiche dnas la console d'androide studio. De base je voulais l'afficher dans l'interface activity_map mais j'ai pas pu, vu que la logique est a été faite dans une classe service qui tourne en Background et donc j'ai pas pu trouver une methode pour l'afficher dans l'interface.
 
 Dans Login.java et SignUp.java : il faut changer l'adresse IP
