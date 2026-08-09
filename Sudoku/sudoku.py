# Libraries

import pygame
import random

# Initialize pygame

pygame.init()

# Keeps the program/pygame running

run = True

# Colors

RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
BLUE = (0, 0, 128)
GREY = (192, 192, 192)

# Used to center the numbers inside the cells / Offset

extra = 5

# Window settings

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


# Function that searches for an empty cell in the Sudoku
# grid: Sudoku grid in which the search is performed

def findEmpty(grid):
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            if grid[row][col] == 0:
                return row, col
            
    return None



# Function that prints a Sudoku to the terminal
# grid: Sudoku grid that should be printed

def printGrid(grid):
    for i in range(len(grid)):
        # Separates the blocks
        if i % 3 == 0 and i != 0:
            print("                      ")
        for j in range(len(grid[0])):
            # Separates the blocks
            if j % 3 == 0 and j != 0:
                print("   ", end="")
            # Checks whether the end of a row has been reached
            if j == 8:
                print(grid[i][j])
            else:
                print(str(grid[i][j]) + " ", end="")



# Function that counts all possible solutions using backtracking
# grid: Sudoku grid that is being examined

def countSolutions(grid):
    # Try to find an empty cell
    cell = findEmpty(grid)
    if not cell:
        # Complete solution found
        return 1

    row, col = cell
    count = 0

    # Try numbers from 1 to 9
    for i in range(1, 10):
        # Check whether the number is valid
        if validNumber(grid, i, (row, col)):
            grid[row][col] = i

            # Recursively continue solving and count all solutions
            count += countSolutions(grid)

            # Reset the cell if this path leads to a dead end
            grid[row][col] = 0
            
    return count





# Function that checks whether a given number is valid
# grid: Sudoku grid in which the number is checked
# number: number that is being checked
# position: position of the number in the Sudoku grid

def validNumber(grid, number, position):
    # Check whether the value is valid
    if 0 < number < 10:
        
        # Check the column
        for y in range(len(grid)):
            if number == grid[y][position[1]] and position[0] != y:
                return False

        # Check the row
        for x in range(len(grid[0])):
            if number == grid[position[0]][x] and position[1] != x:
                return False

        # Check the 3x3 blocks
        xblock = position[1] // 3
        yblock = position[0] // 3

        for y in range(yblock * 3, yblock * 3 + 3):
            for x in range(xblock * 3, xblock * 3 + 3):
                if number == grid[y][x] and (y, x) != position:
                    return False
                
        return True
    
    return False



# Function that fills a given Sudoku with numbers
# grid: Sudoku grid

def completeGrid(grid):
    # Try to find an empty cell
    cell = findEmpty(grid)
    if cell is None: 
        # Sudoku completely filled
        return True
    else:
        row, col = cell
        
    # Generate a random number and, if it is valid, move on to the next cell
    # If it is not valid, generate a new number and try again
    # => Backtracking
    for number in range(1, 10):
        randomNumber = random.randint(1, 9)
        if validNumber(grid, randomNumber, (row, col)):
            grid[row][col] = randomNumber
            if completeGrid(grid):
                return True
            grid[row][col] = 0
    return False



# Function that registers and inserts numbers entered by the player
# window: window/view that is being modified
# position: position of the cell where the number should be inserted

def insertNumber(window, position):
    i, j = position[1], position[0]
    
    # Program for player interaction after clicking on the Sudoku field
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return
            
            # Register a key press
            if event.type == pygame.KEYDOWN:
                # Check whether the cell was originally empty,
                # meaning that it was already filled and cannot be changed
                if (original_grid[i-1][j-1] != 0):
                    return
                
                # Check whether the 0 key was pressed
                if (event.key == 48):
                    # Set the position in the 9x9 matrix to 0
                    # and create a rectangle that covers/deletes the previous number
                    grid[i-1][j-1] = event.key - 48
                    pygame.draw.rect(window, WHITE, (position[0]*50 + extra, position[1]*50 + extra, 50 - 2*extra, 50 - 2*extra))
                    pygame.display.update()
                    return
                
                # Check whether the key was between 1 and 9
                if (0 < event.key - 48 < 10): 
                    # Cover the previous number with a rectangle,
                    # write the new number on top and update the 9x9 matrix
                    pygame.draw.rect(window, WHITE, (position[0]*50 + extra, position[1]*50 + extra, 50 - 2*extra, 50 - 2*extra))
                    value = font.render(str(event.key-48), True, BLUE)
                    window.blit(value, (position[0]*50 + 15, position[1]*50))
                    grid[i-1][j-1] = event.key - 48
                    pygame.display.update()
                    return
                
                return



# Function that checks the player's result
# grid: Sudoku grid that should be checked

def checkResult(grid):
    for row in range(len(grid)):
        for col in range(len(grid[0])):
            num = grid[row][col]
            if not validNumber(grid, num, (row, col)):
                return False
    return True



# Function that draws the Sudoku grid

def drawGrid():
    for i in range(0, 10):
        # If the line is an outer border or separates a 3x3 block,
        # it is drawn thicker
        if (i % 3 == 0):
            pygame.draw.line(window, BLACK, (50 + 50*i, 50), (50 + 50*i, 500), 4)
            pygame.draw.line(window, BLACK, (50, 50 + 50*i), (500, 50 + 50*i), 4)
        pygame.draw.line(window, BLACK, (50 + 50*i, 50), (50 + 50*i, 500), 2)
        pygame.draw.line(window, BLACK, (50, 50 + 50*i), (500, 50 + 50*i), 2)
    pygame.display.update()
    return



# Function that draws the Sudoku grid and adds the given numbers
# grid: Sudoku grid that should be displayed

def updateGrid(grid):
    drawGrid()
    for i in range(0, len(grid[0])):
        for j in range(0, len(grid[0])):
            if (0 < grid[i][j] < 10):
                value = font.render(str(grid[i][j]), True, BLACK)
                window.blit(value, ((j+1)*50 + 15, (i+1)*50))
    pygame.display.update()
    return



# Function that handles player interaction
# Main program after selecting the difficulty
# window: window in which the player interacts

def playSudoku(window):
    # Draw the check button and the Sudoku grid
    window.fill(WHITE)
    check_button = pygame.Surface((140, 40))
    check_text = font.render("check", True, BLACK)
    check_button.fill(GREY)
    check_button.blit(check_text, (20, -7))
    window.blit(check_button, (55, 530))
    updateGrid(original_grid)
    
    # Player interaction
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return
            
            # Register mouse click
            if event.type == pygame.MOUSEBUTTONUP and event.button == 1:
                pos = pygame.mouse.get_pos()
                
                # If the check button was clicked,
                # check the player's solution and display an appropriate message
                if (55 <= pos[0] <= 195 and 530 <= pos[1] <= 570):
                    if checkResult(grid):
                        # print("correct")
                        pygame.draw.rect(window, WHITE, (300, 530, 200, 50))
                        correct_text = font.render("correct", True, GREEN)
                        window.blit(correct_text, (300, 520))
                        pygame.display.update()
                    else:
                        # print("incorrect")
                        pygame.draw.rect(window, WHITE, (300, 530, 200, 50))
                        correct_text = font.render("incorrect", True, RED)
                        window.blit(correct_text, (300, 520))
                        pygame.display.update()
                # If the Sudoku grid was clicked, execute insertNumber()
                if (50 <= pos[0] <= 500 and 50 <= pos[1] <= 500):
                    insertNumber(window, (pos[0]//50, pos[1]//50))
    #return



# Function that removes numbers from the Sudoku grid
# grid: given Sudoku grid
# num_to_remove: number of numbers that should be removed

def deleteNumbers(grid, num_to_remove):
    while num_to_remove > 0:
        # Choose a random cell
        row, col = random.randint(0, 8), random.randint(0, 8)
        
        # If the cell is not empty, save the original value for later
        # in case there are multiple solutions, and remove the number
        if grid[row][col] != 0:
            original_value = grid[row][col]
            grid[row][col] = 0

            # Check whether the Sudoku still has exactly one solution
            if countSolutions(grid) != 1:
                # Restore the original cell if there is no unique solution
                grid[row][col] = original_value
            else:
                num_to_remove -= 1
    return



# Function that generates a Sudoku with a given difficulty level
# grid: Sudoku grid
# num_to_remove: number of empty cells

def generateSudoku(grid, num_to_remove):
    # First create a complete Sudoku and then remove numbers
    completeGrid(grid)
    # printGrid(grid)
    deleteNumbers(grid, num_to_remove)
    # printGrid(grid)
    return grid




# Main menu
# Draw the Sudoku grid for the main menu

drawGrid()

# Buttons for difficulty levels

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

# Update the window

pygame.display.update()


# Main program

while run:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        if event.type == pygame.MOUSEBUTTONUP:
            pos = pygame.mouse.get_pos()
            
            # If the Easy button is clicked, generate a corresponding
            # Sudoku, save the original grid and execute playSudoku() to play
            if (55 <= pos[0] <= 195 and 530 <= pos[1] <= 570):
                newgrid = generateSudoku(grid, 30)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)
                
            # If the Medium button is clicked, generate a corresponding
            # Sudoku, save the original grid and execute playSudoku() to play
            if (205 <= pos[0] <= 345 and 530 <= pos[1] <= 570):
                # print("Medium level")
                newgrid = generateSudoku(grid, 40)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)
                
            # If the Hard button is clicked, generate a corresponding
            # Sudoku, save the original grid and execute playSudoku() to play
            if (355 <= pos[0] <= 495 and 530 <= pos[1] <= 570):
                newgrid = generateSudoku(grid, 51)
                original_grid = [[newgrid[x][y] for y in range(len(newgrid[0]))] for x in range(len(newgrid))]
                playSudoku(window)

pygame.quit()
