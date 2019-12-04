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

## <a name="intro"></a>Game Description

Do you find checkers boring? Do you find chess time-consuming? Then Flipsies is the perfect game for you!

Flipsies is a Python implementation of the famous strategy board game "Othello". With a minimalistic blue-and-black theme, an intuitive interface, and easy installation, Flipsies can be enjoyed by all ages.

Flipsies uses an 8-by-8 board and requires 2 players. Player 1 can only place white stones, and Player 2 can only place black
stones. Initially, the board has two black stones and two white stones arranged in the centre of the board, and gameplay
branches out from the centre. The objective is to have all the stones on the board displaying  your colour by the end of the
game.

The rules of Flipsies are very straightforward. During their turn, each player can place a stone in the same diagonal, column,
or row of another stone of their colour. If any opponent's pieces lie in the middle, they are "flipped": white pieces
become black and black pieces become white. Gameplay ends either when there are no remaining spots on the board to place
stones, or when all the stones on the board display the same colour.

[Back to top](#top)

## <a name="screen"></a>Screenshots

![Imgur](https://i.imgur.com/hTIDj54.png)
![Imgur](https://i.imgur.com/3TKCKOu.png)
![Imgur](https://i.imgur.com/raEKjA5.png)


[Back to top](#top)

## <a name="feature"></a>Game Controls and Features

All gameplay is controlled by mouse input, and there are no keyboard commands.

The title screen contains a "Play" button and an "Instructions" button.
- Click on the "Play" button to advance to the game screen.
- Click on the "Instructions" button to read the game rules. Click on the "Back" button to return to the title screen.

The game screen contains an 8 by 8 board.
- Click on the squares on the board to places stones.
- **Important**: A stone will only be placed on the board if the move is valid according to the rules of Flipsies.

The game will automatically proceed to the winning screen once the game detects that a player has won.

[Back to top](#top)

## <a name="install"></a>How to Install Flipsies

### For `Windows`

 First, download `Pygame` [here.](https://www.pygame.org/download.shtml)

- :arrow_down: [Download Flipsies' zip file here.](https://github.com/kwpark23/Zeros_Matter/zipball/master)
- Unzip and run the executable named `main` inside the extracted file with IDE of your choice.


[Back to top](#top)

## <a name="documen"></a>Documentation and Directory Structure

The documentation and directory structure of our project is located in the Wiki page of our repository.
Check it out by clicking [here](https://github.com/kwpark23/Zeros_Matter/wiki)

[Back to top](#top)

## <a name="Authors"></a>Authors

Zeros_Matter is a group of 1st and 2nd year computer science students at the University of Toronto Mississauga.
This project was done for credit in the course CSC290: Communication Skills for Computer Scientists. Group members
are listed below:

-	Maha Kesibi
-	Adiba Ahmed
-	Damian Koscielniak
-	Jin  Park
-	Nivy Kani

[Back to top](#top)

## <a name="license"></a>License Information

The MIT License (MIT)

Copyright © 2019 Zeros_Matter

You can find a copy of the License at https://mit-license.org/

License for them is in `Public Domain`


[Back to top](#top)
