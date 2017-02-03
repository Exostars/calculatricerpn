I. Calculatrice en notation polonaise inversée
Présentation générale
Une calculatrice en RPN (Reverse Polish Notation, ou Notation polonaise inversée) est une calculatrice qui
fonctionne en suivant le principe de la notation postfixe. Autrement dit, on rentre d'abord les opérandes avant de
saisir l'opérateur. Les opérandes sont ainsi empilés (dans une pile !) et lorsqu'on rentre un opérateur, le nombre
d'opérandes requis est dépilé, le calcul est effectué, puis le résultat du calcul est de nouveau empilé.

II Travail demandé
Vous devez écrire un programme offrant les méthodes nécessaires pour effectuer des calculs exprimés en RPN
sur des nombres réels. Cela devra être disponible de 2 façons différentes :
- au moyen d'une méthode entree, pouvant prendre en paramètre aussi bien un nombre qu'un
opérateur, et effectuant la tâche adéquate ;
- au moyen d'une méthode evaluer, prenant en paramètre une chaîne de caractères correspondant au
calcul à effectuer, où les espaces sont utilisés comme séparateurs. Ainsi, le calcul précédent pourrait être
préciser par la chaîne suivante : '' 3 4 racine plus 10 3 - * ''.
Il devra toujours être possible que connaître :
- la valeur située en sommet de pile (par l'intermédiaire d'une méthode sommet());
- l'état complet de la pile (par l'intermédiaire de la méthode toString()).
Les opérateurs à implanter sont les suivants (les symboles devant être reconnus pour chacune de ces opérations
sont donnés entre parenthèses et sur fond jaune après chaque opération)
- les « 4 opérations » : addition(+), soustraction(-), multiplication(*), division(/) ;
- racine carré (sqrt) et carré (carré) ;
- fonctions trigonométriques : sinus (sin), cosinus (cos), tangente (tan) ;
- inverse (inv) et opposé (opp) ;
- puissance n-ième (puiss) ;
- la fonction factorielle généralisée aux réels positifs en utilisant la fonction Gamma d'Euler1
 (!)
Votre programme doit pouvoir être utilisé en mode texte de 2 façons différentes :
- si une chaîne lui est passé en paramètre, alors la fonction evaluer() est appelée sur la chaîne en
question, puis l'état final de la pile est affiché, et le programme se termine ;
- si aucun paramètre n'est passé au programme, le programme est lancé en mode interactif : l'utilisateur
rentre les nombres et opérateurs en passant à la ligne entre chacun. Outre les nombres et opérateurs précisés
plus haut, l'utilisateur peut également saisir les commandes suivantes :
- pile : affiche l'état de la pile ;
- stop : arrête le programme ;
- trace : passe en mode « trace » ;
- notrace : quitte le mode « trace ».
En mode « trace », l'état de la pile est affiché systématiquement après chaque saisie de nombre ou
d'opérateur.

III. Modalités de mise en œuvre
1. Votre projet doit être un projet maven (condition indispensable pour avoir une note non nulle)
2. Vous devez utiliser git et archiver vos différentes versions sur github
4 . Vous devez avoir utilisé Junit pour tester vos différentes fonctionnalités
5. Votre travail doit être individuel et personnel
IV. Modalité de rendu
Votre travail doit m'être communiqué par un mail ayant pour sujet [POO-DASI]. Concernant le contenu de ce
mail, 2 cas sont possibles :
- vous avez utilisé github : vous me communiquez l'URL de votre projet ;
- vous n'avez pas utilisé github : vous joignez à votre mail une archive tar gzippée du répertoire de tout
votre projet (avec fichier pom.xml et répertoire .git).
