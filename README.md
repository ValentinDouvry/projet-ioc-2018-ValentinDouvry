# Projet IOC

Logiciel récupérant des objets spatiaux  (actuellement des météorites et bientôt d'autres objets spatiaux comme des satellites etc) tombées sur Terre, depuis des xml de la NASA pour les afficher sur une carte.
Il est possible d'ajouter un objet spatial ou d'un modifier un déjà existant. (La suppression n'est pas encore implémentée).

Design pattern: 
* Singleton sur le contoleur afin de n'avoir qu'une seule instance de celui-ci
* Factory implémentée afin de créer plusieurs types d'objets spatiaux (Météore, Satellites, Comètes...) possédant des caractéristiques communs.