# Name:             Hoang Long Nguyen
# Matrikelnummer:   808101

# Bibliotheken
import pygame
import random

# startet pygame
pygame.init()

# damit das Programm/pygame laeuft
run = True

# Farben
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
BLUE = (0, 0, 128)
GREY = (192, 192, 192)

# um die Zahlen mittig in den Feldern zu platzieren
extra = 5

# Fenstereinstellungen
window = pygame.display.set_mode((550, 600))
pygame.display.set_caption("Sudoku")
window.fill(WHITE)
font = pygame.font.SysFont('Comic Sans MS', 35)


grid = [
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0]
]

# gridtestresult = [
#     [6, 9, 7, 1, 2, 4, 5, 3, 8],
#     [1, 2, 5, 9, 8, 3, 7, 4, 6],
#     [3, 8, 4, 5, 6, 7, 1, 9, 2],
#     [2, 6, 3, 4, 9, 5, 8, 1, 7],
#     [5, 1, 9, 2, 7, 8, 4, 6, 3],
#     [4, 7, 8, 3, 1, 6, 2, 5, 9],
#     [8, 3, 6, 7, 5, 1, 9, 2, 4],
#     [7, 5, 2, 6, 4, 9, 3, 8, 1],
#     [9, 4, 1, 8, 3, 2, 6, 7, 5]
# ]

# gridtest = [
#     [6, 9, 7, 1, 0, 0, 5, 0, 8],
#     [1, 0, 0, 0, 8, 0, 7, 0, 0],
#     [0, 0, 4, 5, 0, 0, 1, 9, 2],
#     [0, 0, 3, 4, 0, 0, 0, 1, 0],
#     [0, 1, 0, 2, 0, 8, 0, 6, 0],
#     [0, 0, 8, 3, 1, 6, 2, 5, 9],
#     [0, 3, 0, 0, 5, 1, 0, 0, 4],
#     [7, 5, 2, 6, 0, 0, 0, 0, 1],
#     [0, 0, 1, 8, 3, 0, 0, 0, 5]
# ]


# Funktion sucht nach leeren Felder im Sudoku
# grid: Sudokufeld in dem gesucht werden soll
def findEmpty(grid):
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if grid[row][col] == 0:
                return row, col
            
    return None



# Funktion printet ein Sudoku ins Terminal
# grid: Sudokufeld das geprinted werden soll
def printGrid(grid):
    for i in range(len(grid)):
        # trennt Bloecke
        if i % 3 == 0 and i != 0:
            print("                      ")
        for j in range(len(grid[0])):
            # trennt Bloecke
            if j % 3 == 0 and j != 0:
                print("   ", end="")
            # ueberprueft, ob das Ende einer Reihe erreicht ist
            if j == 8:
                print(grid[i][j])
            else:
                print(str(grid[i][j]) + " ", end="")



# Funktion zaehlt mithilfe von Backtracking alle moegliche Loesungen
# grid: Sudokufeld das untersucht wird
def countSolutions(grid):
    # versucht eine leeres Feld zu finden
    cell = findEmpty(grid)
    if not cell:
        # vollstaendige Loesung gefunden 
        return 1

    row, col = cell
    count = 0

    # versucht Zahlen von 1 bis 9
    for i in range(1, 10):
        # ueberprueft, ob die Zahl gueltig ist
        if validNumber(grid, i, (row, col)):
            grid[row][col] = i

            # Rekursiv weiter loesen und alle Loesungen zählen
            count += countSolutions(grid)

            # Feld wird zuruekgesetzt falls Sackgasse
            grid[row][col] = 0
            
    return count





# Funktio ueberprueft, ob eine gegebene Zahl gueltig ist
# grid: Sudokufeld in der die Zahl geprueft wird
# number: die Zahl die geprueft wird
# postion: Postion der Zahl im Sudokufeld
def validNumber(grid, number, position):
    # ueberprueft, ob Wert gueltig ist
    if 0 < number < 10:
        
        # ueberprueft Spalte
        for y in range(len(grid)):
            if number == grid[y][position[1]] and position[0] != y:
                return False

        # ueberprueft Reihe
        for x in range(len(grid[0])):
            if number == grid[position[0]][x] and position[1] != x:
                return False

        # ueberprueft 3x3 Bloecke
        xblock = position[1] // 3
        yblock = position[0] // 3

        for y in range(yblock * 3, yblock * 3 + 3):
            for x in range(xblock * 3, xblock * 3 + 3):
                if number == grid[y][x] and (y, x) != position:
                    return False
                
        return True
    
    return False



# Funktion fuellt ein gegebenes Sudoku mit Zahlen
# grid: Sudoku
def completeGrid(grid):
    # versucht eine leeres Feld zu finden
    cell = findEmpty(grid)
    if cell is None: 
        # Sudoku vollstaendig gefuellt 
        return True
    else:
        row, col = cell
        
    # generiere eine zufaellige Zahl und falls sie gueltig ist, gehe zum naechsten Feld
    # falls sie nicht gueltig ist, generiere eine neue Zahl und probiere es nochmal
    # => Backtracking
    for number in range(1, 10):
        randomNumber = random.randint(1, 9)
        if validNumber(grid, randomNumber, (row, col)):
            grid[row][col] = randomNumber
            if completeGrid(grid):
                return True
            grid[row][col] = 0
    return False



# Funktion die die eingebenen Zahlen vom Spieler registriert und einfuegt
# window: Fenster/Ansicht die bearbeitet werden soll
# postion: Position des Feldes, wo die Zahl eingefuegt werden soll
def insertNumber(window, position):
    i, j = position[1], position[0]
    
    # Programm zum interagieren mit dem Spieler, falls er ins Sudokufeld klickt
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return
            
            # registriert einen Tastendruck
            if event.type == pygame.KEYDOWN:
                # ueberprueft, ob das Feld leer war, also ob das Feld zu Beginn schon belegt war und nicht veraendert werden kann
                if (original_grid[i-1][j-1] != 0):
                    return
                
                # ueberprueft, ob die 0-Taste gedrueckt wurde
                if (event.key == 48):
                    # setzt in der 9x9 Matrix die Stelle auf 0 und erzeugt ein Rechteck im Sudokufeld, dass die vorherige Zahl ueberdeckt/loescht
                    grid[i-1][j-1] = event.key - 48
                    pygame.draw.rect(window, WHITE, (position[0]*50 + extra, position[1]*50 + extra, 50 - 2*extra, 50 - 2*extra))
                    pygame.display.update()
                    return
                
                # ueberprueft, ob die Taste 1 bis 9 war
                if (0 < event.key - 48 < 10): 
                    # ueberdeckt die vorherige Zahl mit einem Rechteck und schreibt die neue Zahl darauf und setzt den Wert in der 9x9 Matrix
                    pygame.draw.rect(window, WHITE, (position[0]*50 + extra, position[1]*50 + extra, 50 - 2*extra, 50 - 2*extra))
                    value = font.render(str(event.key-48), True, BLUE)
                    window.blit(value, (position[0]*50 + 15, position[1]*50))
                    grid[i-1][j-1] = event.key - 48
                    pygame.display.update()
                    return
                
                return



# Funktion ueberprueft das Ergebnis vom Spieler
# grid: Sudokufeld, dass ueberprueft werden soll
def checkResult(grid):
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            num = grid[row][col]
            if not validNumber(grid, num, (row, col)):
                return False
    return True



# Funktion zeichnet das Sudokufeld
def drawGrid():
    for i in range(0, 10):
        # falls die Linie der Aussenrand oder eines 3x3 Blocks ist, wird sie dicker gezeichnet
        if (i % 3 == 0):
            pygame.draw.line(window, BLACK, (50 + 50*i, 50), (50 + 50*i, 500), 4)
            pygame.draw.line(window, BLACK, (50, 50 + 50*i), (500, 50 + 50*i), 4)
        pygame.draw.line(window, BLACK, (50 + 50*i, 50), (50 + 50*i, 500), 2)
        pygame.draw.line(window, BLACK, (50, 50 + 50*i), (500, 50 + 50*i), 2)
    pygame.display.update()
    return



# Funktion zeichnet das Sudokufeld und fuegt die vorgegebenen Zahlen ein
# grid: Sudokufeld das gezeichent werden soll
def updateGrid(grid):
    drawGrid()
    for i in range(0, len(grid[0])):
        for j in range(0, len(grid[0])):
            if (0 < grid[i][j] < 10):
                value = font.render(str(grid[i][j]), True, BLACK)
                window.blit(value, ((j+1)*50 + 15, (i+1)*50))
    pygame.display.update()
    return



# Funktion die zum interagieren mit dem Spieler dient(Hauptprogramm nach dem auswaehlen der Schwierigkeit)
# window: Fenster in der interagiert wird
def playSudoku(window):
    # zeichnet den check-Button und das Sudokufeld
    window.fill(WHITE)
    check_button = pygame.Surface((140, 40))
    check_text = font.render("check", True, BLACK)
    check_button.fill(GREY)
    check_button.blit(check_text, (20, -7))
    window.blit(check_button, (55, 530))
    updateGrid(original_grid)
    
    # Spielerintraktion
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return
            
            # registriert Mausklick
            if event.type == pygame.MOUSEBUTTONUP and event.button == 1:
                pos = pygame.mouse.get_pos()
                
                # falls auf check-Button, ueberpruefe die Loesung des Spielers und gebe eine passende Ausgabe aus
                if (55 <= pos[0] <= 195 and 530 <= pos[1] <= 570):
                    if checkResult(grid):
                        # print("korrekt")
                        pygame.draw.rect(window, WHITE, (300, 530, 200, 50))
                        correct_text = font.render("correct", True, GREEN)
                        window.blit(correct_text, (300, 520))
                        pygame.display.update()
                    else:
                        # print("nicht korrekt")
                        pygame.draw.rect(window, WHITE, (300, 530, 200, 50))
                        correct_text = font.render("incorrect", True, RED)
                        window.blit(correct_text, (300, 520))
                        pygame.display.update()
                # falls auf Sudokufeld, fuehre insertNumber() aus
                if (50 <= pos[0] <= 500 and 50 <= pos[1] <= 500):
                    insertNumber(window, (pos[0]//50, pos[1]//50))
    #return



# Funktion entfernt Zahlen aus dem Sudokufeld
# grid: gegebenes Sudokufeld
# num_to_remove: Anzahl der Zahlen die entfernt sollen
def deleteNumbers(grid, num_to_remove):
    while num_to_remove > 0:
        # waehle eine zufaelliges Feld aus
        row, col = random.randint(0, 8), random.randint(0, 8)
        
        # wenn das Feld nicht leer ist, speichere den original Wert fuer spaeter, falls mehrere Loesungen
        # loesche die Zahl
        if grid[row][col] != 0:
            original_value = grid[row][col]
            grid[row][col] = 0

            # ueberpruefe, ob das Sudoku immer noch genau eine Loesung hat
            if countSolutions(grid) != 1:
                # setze die ursprüngliche Zelle zurueck, falls keine eindeutige Liesung
                grid[row][col] = original_value
            else:
                num_to_remove -= 1
    return



# Funktion zum generieren eines Sudokus mit Schwierigkeitsstufe
# grid: Sudokufeld
# num_to_remove: Anzahl der leeren Felder
def generateSudoku(grid, num_to_remove):
    # erzeuge zuerst ein vollstaendiges Sudoku und entferne anschliessend Zahlen
    completeGrid(grid)
    # printGrid(grid)
    deleteNumbers(grid, num_to_remove)
    # printGrid(grid)
    return grid




# Hauptmenue
# Sudokufeld wird gezeichnet fuer das Hauptmenue
drawGrid()

# Buttons fuer Schwierigkeitsstufen
easy_button = pygame.Surface((140, 40))
easy_text = font.render("easy", True, BLACK)
easy_button.fill(GREY)
easy_button.blit(easy_text, (34, -7))
window.blit(easy_button, (55, 530))

medium_button = pygame.Surface((140, 40))
medium_text = font.render("medium", True, BLACK)
medium_button.fill(GREY)
medium_button.blit(medium_text, (9, -6))
window.blit(medium_button, (205, 530))

hard_button = pygame.Surface((140, 40))
hard_text = font.render("hard", True, BLACK)
hard_button.fill(GREY)
hard_button.blit(hard_text, (31, -5))
window.blit(hard_button, (355, 530))

# updatet das Fenster
pygame.display.update()


# Hauptprogramm
while run:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        if event.type == pygame.MOUSEBUTTONUP:
            pos = pygame.mouse.get_pos()
            
            # falls auf easy-Button, erzeuge ein entsprechendes Sudokufeld, speichere das Ursprungssudoku und fuehre play_sudoku() aus zum spielen
            if (55 <= pos[0] <= 195 and 530 <= pos[1] <= 570):
                newgrid = generateSudoku(grid, 30)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)
                
            # falls auf medium-Button, erzeuge ein entsprechendes Sudokufeld, speichere das Ursprungssudoku und fuehre play_sudoku() aus zum spielen                
            if (205 <= pos[0] <= 345 and 530 <= pos[1] <= 570):
                # print("Level medium")
                newgrid = generateSudoku(grid, 40)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)
                
            # falls auf hard-Button, erzeuge ein entsprechendes Sudokufeld, speichere das Ursprungssudoku und fuehre play_sudoku() aus zum spielen                            
            if (355 <= pos[0] <= 495 and 530 <= pos[1] <= 570):
                newgrid = generateSudoku(grid, 51)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)

pygame.quit()
