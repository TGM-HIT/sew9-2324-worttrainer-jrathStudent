# sew9-2324-worttrainer-jrathStudent

Dieses Programm soll eine Lernhilfe für junge Schüler sein, in welchem man ein Bild gezeigt bekommt und das passende Tier danach aufschreibt.
Nach jedem Bild bekommt man ein Feedback, ob der Input richtig war.
Durch die Veranschaulichung einer Statistik erhält man anschließend ein Gesamtergebnis.

HINWEIS!  Zuerst bekommt man eine Ansicht des Bildes, dann auf "ok" drücken und im folgenden Textfeld die Antwort eintragen. 
          Zum Beenden des Programmes muss dieses Textfeld leer bleiben. Erneut auf "ok" drücken und anschließend wird die Erfolgsquote angezeigt.

Verwendete Technologien:
* Zum Check der URL wurde die Klasse URL von Java benutzt.
* Ebenfalls wurden einige Methoden mittels Verwendung von Arrays durchgeführt, um zB die Worteinträge zu managen.
* Durch BufferedWriter wurde die speichern-Methode realisiert. Ebenso wurden BufferedReader, FileReader und Scanner für die laden-Methoden benutzt.
  Beide Methoden wurden überladen und der Aufruf geschieht durch das dazugehörige Interface.
* Für Text- und Bildausgaben bzw. Eingaben wird JOptionPane benutz.
* Um die Bilder zu den URLs auch printen zu können wurde ImageIcon benutzt.
* Durch die Verwendung von IOException und MalformedURLException werden mögliche Errors vorgebeugt.
