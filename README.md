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
The player's spaceship is controlled with the keyboard. The mouse is only used to click the "restart" button in the top left.

The game begins immediately after launching the application. The player’s spaceship starts at the center of the screen. The asteroids start along the edges of the screen. Each asteroid moves in a random direction. 

The player’s spaceship is controlled using the following keyboard keys: 
- Press and hold the “W” key to accelerate in the direction the spaceship is facing
- Press and hold the “A” key to rotate the spaceship counter clockwise
- Press and hold the “D” key to rotate the spaceship clockwise
- Press the “Space” key to shoot a bullet in the direction the spaceship is facing 

The player’s spaceship maintains its velocity while the “W” key is not held down. If the player’s spaceship, an asteroid, or a bullet leaves one side of the screen, it will reappear on the opposite side.

If the player’s spaceship collides with an asteroid, the player will lose a life and their spaceship will respawn at the center of the screen. Losing all three lives causes the game to reset. If a bullet collides with a medium or large asteroid, then the asteroid will split into two smaller asteroids. If a bullet collides with a small asteroid, then the asteroid will be destroyed. The player wins once all the asteroids have been destroyed. 


[Back to top](#top)

## <a name="install"></a>How to Install Space Rocks
### For Windows
- Download Space-Rocks-1.0-Installer.exe which can be found [here.](https://github.com/penguinUwU/Space-Rocks/releases)
- Run the executable.
- A prompt will appear to select the destination location. Select a folder and then click “Next >”.
- A folder named “Space-Rocks” will be created inside of the folder selected in the previous step. Inside of the "Space-Rocks" folder, run the application named “Space-Rocks” to play the game. 


[Back to top](#top)

## <a name="documen"></a>Documentation and Directory Structure
### Directory Structure
- controller package
	* GameController.java
    * ButtonPressEventHandler.java
- model package
    * Asteroid.java
    * Bullet.java
    * GameModel.java
    * GameObject.java
    * Player.java
- view package
    * GameView.java
    * oneLife.png 
    * threeLife.png
    * twoLife.png

**Model:**

**View:**

The view package has one class, called the GameView. The purpose of the GameView is to create and design the different elements that make up the game window, as well as update them during gameplay. This includes the game bar displayed at the top of the window, as well as the actual gameplay screen. There are two methods in GameView, the getRoot method and the update method. 

The getRoot method returns a Parent object that is used by the controller to initialize the screen. To modify the UI/background elements, this is the method to use. 

The update method is meant to be run while the game is in progress, and it updates the various UI elements (everything on the game bar), as well as which asteroids are active. It does this by calling methods from the model package to check the state of the game. The update method is called in the main game loop, located in the controller. If anyone wants to change how a UI element is updated, this is the method to modify.


**Controller:**

The controller package contains the classes that makes up the Controller component of the MVC design pattern.
The classes in the controller package must work together to execute the game loop, read user inputs, and update the Model and View components in real-time with information such as time and user inputs. There are two classes in the package: ButtonPressEventHandler and GameController.

The purpose of the ButtonPressEventHandler class is handle button presses from the restart game button. Once the user presses the restart button, the game will instantly reset all data, and restart the game loop.

The purpose of the GameController class is to be the entry point of the game for the users. It loads the game, starts the game loop, and updates the game with user inputs.

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

Copyright © 2019 Space-Rocks

You can find a copy of the License at https://mit-license.org/

License for them is in `Public Domain`


[Back to top](#top)

## <a name="contrib"></a>Individual Contribution
**Abhay Kaushik**

In this project, I worked on the model of this game. I specifically worked on the Player, GameObject and the Asteroid. The parent class (GameObject) stores all the general information for each object in the game. This includes information about the velocity of the object in relation to the x and y position of the object. Likewise, the body and center of the object is stored in the GameObject. Player and Asteroid update their positions in different ways. The movement of the asteroid is independent of the player and random. On the other hand, the movement of the player is dependent of the keys the player presses. To extend these classes, one feature that needs to be included is to have a 'buffer time' so that when the player spawns on the screen, they do not automatically get hit by the asteroid. 


**Michael Shearer**

I worked mainly on the view package for this project. In the view, I was mainly responsible for the functionality and design of the game bar and the main gameplay screen. This included designing the game bar layout, setting the screen bounds/background and modifying the reset function in the controller package to work with the reset button on the game bar. I also collaborated with Fiona on a number of parts, such as the update method and the creation of the images used for the game bar. Specifically with the update function, I determined how each of the game bar elements would be checked/updated with the model, as well as how the screen would display/remove active or inactive asteroids respectively.
For this Readme, I was responsible for adding screenshots and detailing the View portion of the Documentation and Directory Structure.

