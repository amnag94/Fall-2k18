
# each character cannot be more than 50 characters long 
# space is of 10 units
def drawA():
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    noteStartPosition()
    my_turtle.down()
    my_turtle.left(90)
    my_turtle.fd(Height)
    my_turtle.right(90)
    my_turtle.fd(Width)
    my_turtle.right(90)
    drawLine(my_turtle,Height)
    my_turtle.down()
    my_turtle.fd(Height/2)
    my_turtle.right(90)
    my_turtle.fd(Width)
    my_turtle.up()
    goToStartPosition()

def drawE():
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    noteStartPosition()
    drawLine(my_turtle,Width)
    my_turtle.left(90)
    drawLine(my_turtle,Height)
    my_turtle.fd(Height/2)
    my_turtle.right(90)
    drawLine(my_turtle,Width)
    my_turtle.left(90)
    my_turtle.fd(Height/2)
    my_turtle.right(90)
    drawLine(my_turtle,Width)
    my_turtle.up()
    goToStartPosition()

    
def drawT():
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    noteStartPosition()
    my_turtle.left(90)
    my_turtle.fd(Height)
    my_turtle.right(90)
    drawLine(my_turtle,Width)
    my_turtle.fd(Width/2)
    my_turtle.right(90)
    my_turtle.down()
    my_turtle.fd(Height)
    my_turtle.up()
    goToStartPosition()

def drawK():
    #
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    noteStartPosition()
    half_of_height = Height/2
    my_turtle.left(90)
    drawLine(my_turtle,Height)
    my_turtle.fd(half_of_height)
    my_turtle.right(45)
    drawLine(my_turtle,half_of_height*math.sqrt(2))
    my_turtle.right(90)
    drawLine(my_turtle,half_of_height*math.sqrt(2))
    my_turtle.up()
    goToStartPosition()


def space():
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    my_turtle.fd(60)

def drawLine(my_turtle,len):
    #Pre: Pos (0,0), Heading Unknown, UP
    #Post: Pos (0,0),Same Heading as Pre , UP
    my_turtle.down()
    my_turtle.fd(len)
    my_turtle.bk(len)
    my_turtle.up()


def drawN():
    #Pre: Pos (0,0), Head East, UP
    #Post: Pos (0,0), Head East, UP
    noteStartPosition()
    my_turtle.down()
    my_turtle.left(90)
    my_turtle.fd(Height)
    pos = my_turtle.position()
    my_turtle.right(90)
    my_turtle.up()
    my_turtle.fd(Width)
    my_turtle.down()
    my_turtle.right(90)
    my_turtle.fd(Height)
    my_turtle.right(150)
    my_turtle.goto(pos)
    my_turtle.up()
    goToStartPosition()

def drawO():
    #pre
    #pos
    noteStartPosition()
    my_turtle.down()
    my_turtle.fd(Width)
    my_turtle.left(90)
    my_turtle.fd(Height)
    my_turtle.left(90)
    my_turtle.fd(Width)
    my_turtle.left(90)
    my_turtle.fd(Height)
    goToStartPosition()


def goToStartPosition():
    my_turtle.up()
    my_turtle.goto(start_pos)
    my_turtle.setheading(0)


def noteStartPosition():
    global start_pos 
    start_pos = my_turtle.position()



import turtle
import math

start_pos = (0,0)

my_turtle = turtle.Turtle()
my_turtle.up()
my_turtle.setposition(-300,100)
Height = 100
Width = 50


drawK()
space()
drawE()
space()
drawT()
space()
drawA()
space()
drawN()

my_turtle.setposition(-300,-100)

drawK()
space()
drawO()
space()
drawK()
space()
drawA()
space()
drawN()
space()
drawE()
space()

turtle.done()




