# Sudoku (Pygame)

## Allgemeine Information
**Hinweise**
- Bei "Hard" kann die Generierung durch die Eindeutigkeitsprüfung länger dauern.
- Letzte Bearbeitung 14.03.2024

Dieses Projekt ist ein Sudoku-Spiel mit grafischer Oberfläche, umgesetzt in Python mit der Bibliothek [pygame]. Das Programm generiert automatisch ein lösbares Sudoku mit eindeutiger Lösung (per Backtracking) und lässt Spielerinnen und Spieler es über Maus und Tastatur ausfüllen. Es stehen drei Schwierigkeitsgrade zur Verfügung: Easy, Medium und Hard.

## Bedienungsanleitung

### Voraussetzungen
Installieren Sie [Python 3.x].
Installieren Sie die Bibliothek pygame über die Konsole mit dem Befehl `pip install pygame`.

### Starten des Spiels
1. Öffnen Sie eine Konsole im Projektordner.
2. Starten Sie das Spiel mit dem Befehl `python sudoku.py`.
3. Es öffnet sich ein Fenster mit einem leeren Raster und drei Buttons: **easy**, **medium**, **hard**.

### Schwierigkeitsgrad wählen
Klicken Sie auf einen der drei Buttons, um ein neues Sudoku mit entsprechender Anzahl an leeren Feldern zu generieren:
- **Easy**: 30 leere Felder
- **Medium**: 40 leere Felder
- **Hard**: 51 leere Felder

### Zahlen eintragen
1. Klicken Sie mit der Maus auf eine leere Zelle im Raster.
2. Geben Sie über die Tastatur eine Zahl zwischen 1 und 9 ein, um sie in die Zelle einzutragen.
3. Mit der Taste `0` können Sie den Inhalt einer Zelle wieder löschen.

### Lösung überprüfen
Klicken Sie auf den Button **check** am unteren Rand des Fensters.
- Ist die aktuelle Eingabe regelkonform, erscheint der Hinweis **correct** in grüner Schrift.
- Andernfalls erscheint der Hinweis **incorrect** in roter Schrift.

### Beenden
Schließen Sie einfach das Fenster, um das Programm zu beenden.




