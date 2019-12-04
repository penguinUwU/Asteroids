# Space Rocks
A recreation of the 1979 game Asteroids created using `Java` and `Javafx` for the CSC290 class.


## Navigation
<a name="top"></a>
1. [Game Description](#intro)
    - [Screenshots](#screen)
2. [Game Controls and Features](#feature)
3. [How to Install Flipsies](#install)
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

Model:

View:

Controller:


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
Abhay Kaushik
In this project, I worked on the model of this game. I specifically worked on the Player, GameObject and the Asteroid. The parent class (GameObject) stores all the general information for each object in the game. This includes information about the velocity of the object in relation to the x and y position of the object. Likewise, the body and center of the object is stored in the GameObject. Player and Asteroid update their positions in different ways. The movement of the asteroid is independent of the player and random. On the other hand, the movement of the player is dependent of the keys the player presses. To extend these classes, one feature that needs to be included is to have a 'buffer time' so that when the player spawns on the screen, they do not automatically get hit by the asteroid.  