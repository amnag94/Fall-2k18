import random
import math
import turtle

left_point = -400
right_point = 400

pine_leaf_length = 50
maple_leaf_length = 25

tree_types = ['maple', 'pine']
tre_types_length = [150, 200]
max_tree_height = 200

available_wood = 0

'''
pre : (0,0), east, up
pre : (0,length), north, up
'''


def draw_trunk(trunk_length):
    t.down()
    t.left(90)
    t.fd(trunk_length)
    t.up()


'''
pre : (0,0), 120, up
pre : (0,0), 120, up
'''
# todo: can be changed to draw polygon


def draw_triangle(side_length):
    t.down()
    for _ in range(3):
        t.fd(side_length)
        t.right(120)
    t.up()

'''
pre : (0,0), north, up
pre : (0,length), north, up
'''


def draw_pine_tree_top():


    t.left(90)
    t.fd(pine_leaf_length // 2)
    t.right(120)
    t.up()
    draw_triangle(pine_leaf_length)
    t.right(60)
    t.fd(pine_leaf_length // 2)
    t.left(90)

'''
pre : (0,length), north, up
pre : (0,length), north, up
'''


def draw_maple_tree_top():

    t.down()
    t.right(90)
    t.circle(maple_leaf_length)
    t.left(90)
    t.up()

'''
pre : (0,length) , north, up

'''


def draw_tree_top(tree_type):
    if tree_type == 'pine':
        draw_pine_tree_top()
    elif tree_type == 'maple':
        draw_maple_tree_top()



'''
pre : (0,0), east, up
pre : (0,0), east, up
'''


def draw_tree(length, tree_type):
    t.up()
    draw_trunk(length)
    draw_tree_top(tree_type)
    t.bk(length)
    t.right(90)
    t.up()
    return length


def draw_picture_base():
    t.up()
    t.speed(0)
    t.setpos(left_point + 10,left_point + 50)
    t.down()
    t.fd(right_point - left_point - 20)
    t.bk(right_point - left_point - 50)
    #t.speed(6)
    t.up()


def initialise_screen():
    turtle.setup(width=1200, height=800, startx=0, starty=0)
    turtle.setworldcoordinates(left_point,left_point,right_point,right_point)



'''
pre pos are same
'''


def draw_square(length):
    t.down()
    for _ in range(4):
        if _ == 2:
            t.up()
        else:
            t.down()
        t.fd(length)
        t.left(90)
    t.fd(length)
    t.up()


def draw_roof_top(length):
    t.left(45)
    t.down()
    t.fd(length)
    t.left(90)
    t.fd(length)


def draw_house(wall_height):
    draw_square(wall_height)
    t.left(90)
    t.fd(wall_height)
    draw_roof_top(wall_height / math.sqrt(2))
    t.up()
    t.left(45)
    t.fd(wall_height)
    t.left(90)
    t.fd(wall_height)


def draw_star(sky_height):
    star_size = 20
    t.left(90)
    t.fd(sky_height)
    t.down()
    for _ in range(4):
        t.fd(star_size)
        t.bk(star_size)
        t.right(90)
        t.up()
        t.circle(star_size//2, 45)
        t.down()
        t.left(90)
    t.up()
    t.fd(star_size)
    t.left(90)


def get_drawing_sequence(noOfTrees, house):
    if house == 'n':
        return ['tree'] * noOfTrees
    draw_sequence = ['tree'] * (noOfTrees-2)
    draw_sequence.append('house')
    random.shuffle(draw_sequence)
    return ['tree']+ draw_sequence + ['tree']


def calculate_wall_height(available_wood):
    pass



if __name__ == '__main__':
    t = turtle.Turtle()
    t.up()
    initialise_screen()
    draw_picture_base()

    #noOfTrees = int(input("How many trees in your forest? "))
    noOfTrees = 5
    #house =  input("Is there a house in the forest (y/n)? ")
    house = 'y'
    draw_sequence = get_drawing_sequence(noOfTrees,house)

    for _ in draw_sequence:
        if _ == 'tree':
            tree_height  = draw_tree(random.randint(50, tre_types_length[random.randint(0, 1)]), tree_types[random.randint(0, 1)])
            available_wood = available_wood + tree_height
            if tree_height > max_tree_height:
                max_tree_height = tree_height
        else:
            draw_house(100)
        t.fd(100)
    t.bk(100)
    draw_star(max_tree_height + 80)
    print("Night is done, press enter for the day")
    print("We have {0} units of lumber for building".format(available_wood))
    calculate_wall_height(available_wood)
        
    turtle.done()