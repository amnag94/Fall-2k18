from random import randint
import math
import turtle



'''
pre : (0,0), east, up
pre : (0,length), north, up
'''
def drawTunk(length):
    t.down()
    t.left(90)
    t.fd(length)
    t.up()


'''
pre : (0,0), 120, up
pre : (0,0), 120, up
'''
# todo: can be changed to draw polygon
def drawTriangle(pineLength):
    t.down()
    for _ in range(3):
        t.fd(pineLength)
        t.right(120)
    t.up()

'''
pre : (0,0), north, up
pre : (0,length), north, up
'''
def drawPineTreeTop():
    pineLength = 50
    t.left(90)
    t.fd(pineLength // 2)
    t.right(120)
    t.up()
    drawTriangle(pineLength)
    t.right(60)
    t.fd(pineLength // 2)
    t.left(90)

'''
pre : (0,length), north, up
pre : (0,length), north, up
'''
def drawMapleTreeTop():
    leafLength = 25
    t.down()
    t.right(90)
    t.circle(leafLength)
    t.left(90)
    t.up()




'''
pre : (0,length) , north, up

'''
def drawTreeTop(type,length):
    if type == 'pine':
        # pine tree always draws tree top of length 50 -25 on left and 25 on right
        drawPineTreeTop()
    elif type == 'maple':
        drawMapleTreeTop()



'''
pre : (0,0), east, up
pre : (0,0), east, up
'''
def drawTree(length,type):
    t.up()
    drawTunk(length)
    drawTreeTop(type,length)
    t.bk(length)
    t.right(90)
    t.up()
    return length


def drawBase():
    t.speed(0)
    t.up()
    t.setpos(-290,-290)
    t.fd(580)
    t.left(90)
    t.fd(580)
    t.left(90)
    t.fd(580)
    t.left(90)
    t.fd(580)
    t.left(90)
    t.speed(6)


def setCordinates():
    turtle.setup(width=1200, height=800, startx=0, starty=0)
    turtle.setworldcoordinates(-300,-300,300,300)


'''
pre pos are same
'''
def drawSquare(length):
    t.down()
    for _ in range(4):
        t.fd(length)
        t.left(90)
    t.fd(length)
    t.up()


def drawRoofTop(length):
    t.left(45)
    t.down()
    t.fd(length)
    t.left(90)
    t.fd(length)



def drawHouse(length):
    drawSquare(length)
    t.left(90)
    t.fd(length)
    drawRoofTop(length/math.sqrt(2))
    t.up()
    t.left(45)
    t.fd(length)
    t.left(90)
    t.fd(length)


def drawStar(height):
    starlength = 10
    t.left(90)
    t.fd(height)
    t.down()
    for _ in range(4):
        t.fd(starlength)
        t.bk(starlength)
        t.right(90)
        t.up()
        t.circle(starlength//2,45)
        t.down()
        t.left(90)
    t.up()
    t.fd(starlength)
    t.left(90)


if __name__ == '__main__':
    t = turtle.Turtle()
    t.up()
    setCordinates()
    drawBase()
    treeTypes = ['maple','pine']
    treeTypesLength = [150,200]
    maxTreeHeight = 200

    #noOfTrees = int(input("How many trees in your forest? "))
    noOfTrees = 5
    for _ in range(noOfTrees):
        tree_height  = drawTree(randint(50,treeTypesLength[_%2]),treeTypes[_%2])
        if(tree_height > maxTreeHeight):
            maxTreeHeight = tree_height
        t.fd(90)

    #house =  input("Is there a house in the forest (y/n)? ")
    house = 'y'
    if house == 'y':
        drawHouse(100)

    drawStar(maxTreeHeight + 80)
        
    turtle.done()