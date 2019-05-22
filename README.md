# Taller-1-Programacio-II
Primer taller de l'assignatura de Programació II de l'Universitat de les Illes Balears

Primer Taller Avaluable

Objectius

Programació orientada a objectes. Emmagatzemant dins memòria secundària. Accés aleatori.
Excepcions

Enunciat

Escriure un programa que permeti gestió d'una Pila d'articles. Per això és necessari implementar la
classe Article que es defineix com una cadena de caràcters que conté el nom de l'article i un enter amb
el seu codi. La Pila d'articles és una estructura de dades seqüencial que permet inserir articles a la Pila
(operació push) i extreure articles de la Pila (operació pop).
La inserció d'articles sempre es fa de forma seqüencial, és a dir, enregistrem el primer article després el
següent i així successivament. En aquest exercici tindrem en compte que no és possible inserir cap codi
repetit, si això passa s'activarà una excepció.

L'extracció d'articles es fa pel final, és a dir, el primer article que s'extreu és el darrer que s'ha inserit i
així successivament. Una vegada s'ha extret un article amb un codi, ja no hi ha cap problema per què es
pugui inserir un article nou que tingui el mateix codi anterior. Si la Pila està buida i s'intenta fer una
operació pop es generarà una excepció de pila buida.
A part d'aquestes dues operacions és necessari implementar una opció que permeti veure el contingut
de la Pila.

Totes aquestes tres opcions estaràn gestionades amb un menú simple a la finestra de text.
Indicacions

La classe per gestionar la Pila s'escriurà usant fitxers d'accés aleatori.
