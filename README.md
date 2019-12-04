# Space Rocks
A recreation of the 1979 game Asteroids created using `Java` and `Javafx` for the CSC290 class.


## Navigation
<a name="top"></a>
1. [Game Description](#intro)
    - [Screenshots](#screen)
2. [Game Controls and Features](#feature)
3. [How to Install Space Rocks](#install)
4. [Documentation](#documen)
5. [Authors](#Authors)
6. [License Information](#license)
7. [Individual Contribution](#contrib)

## <a name="intro"></a>Game Description



[Back to top](#top)

## <a name="screen"></a>Screenshots

![Imgur](https://i.imgur.com/QGqK6Pi.png)
![Imgur](https://i.imgur.com/yGEULqA.png)


[Back to top](#top)

## <a name="feature"></a>Game Controls and Features


[Back to top](#top)

## <a name="install"></a>How to Install Space Rocks


[Back to top](#top)

## <a name="documen"></a>Documentation and Directory Structure

**Model:**

**View:**

The view package has one class, called the GameView. The purpose of the GameView is to create and design the different elements that make up the game window, as well as update them during gameplay. This includes the game bar displayed at the top of the window, as well as the actual gameplay screen. There are two methods in GameView, the getRoot method and the update method. 

The getRoot method returns a Parent object that is used by the controller to initialize the screen. To modify the UI/background elements, this is the method to use. 

The update method is meant to be run while the game is in progress, and it updates the various UI elements (everything on the game bar), as well as which asteroids are active. It does this by calling methods from the model package to check the state of the game. The update method is called in the main game loop, located in the controller. If anyone wants to change how a UI element is updated, this is the method to modify.


**Controller:**


[Back to top](#top)

## <a name="Authors"></a>Authors

- Abhay Kaushik
- Michael Shearer
- Yichen Cui
- Mathieu Seah Labbe
- Fiona Vong

[Back to top](#top)

## <a name="license"></a>License Information

The MIT License (MIT)

Copyright © 2019 Zeros_Matter

You can find a copy of the License at https://mit-license.org/

License for them is in `Public Domain`


[Back to top](#top)

## <a name="contrib"></a>Individual Contribution
**Abhay Kaushik**

In this project, I worked on the model of this game. I specifically worked on the Player, GameObject and the Asteroid. The parent class (GameObject) stores all the general information for each object in the game. This includes information about the velocity of the object in relation to the x and y position of the object. Likewise, the body and center of the object is stored in the GameObject. Player and Asteroid update their positions in different ways. The movement of the asteroid is independent of the player and random. On the other hand, the movement of the player is dependent of the keys the player presses. To extend these classes, one feature that needs to be included is to have a 'buffer time' so that when the player spawns on the screen, they do not automatically get hit by the asteroid. 


**Michael Shearer**

I worked mainly on the view package for this project. In the view, I was mainly responsible for the functionality and design of the game bar and the main gameplay screen. This included designing the game bar layout, setting the screen bounds/background and modifying the reset function in the controller package to work with the reset button on the game bar. I also collaborated with Fiona on a number of parts, such as the update method and the creation of the images used for the game bar. Specifically with the update function, I determined how each of the game bar elements would be checked/updated with the model, as well as how the screen would display/remove active or inactive asteroids respectively.
For this Readme, I was responsible for adding screenshots and detailing the View portion of the Documentation and Directory Structure.

