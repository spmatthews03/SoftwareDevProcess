# Design Information

After reviewing the requirements for this project I designed the UML class diagram to where I believe would be a efficient design with the code taking care of quite a bit.


#### Requirement 1
My class, Game, had a minimal job that was simply to create a new player or to login. Both of these methods were created
#### Requirement 2
The Game Manager is where the beef of the program lies. It covers the 5 checks listed in this requirement as well as some additional methods
#### Requirement 3
The game stores all of its stats with lists of players, puzzles and a list of mapped information regarding all the stats
#### Requirement 4
I imagine in the code that there will be prompt on the screen for user information, that screen can be done within the create Player method and it will then pass all the information entered into a constructor for the new player
#### Requirement 5
Creating a puzzle is done from the GameManager by a Player. the play will pass the phrase into the method which will be passed during the call of the constructor of the Puzzle
#### Requirement 6
This was a bit trickier since I believe code will do a lot of this, but I created a Puzzle Screen that will update information including prize value, the solved parts of the phrase and the value of the next consonant
#### Requirement 7
The Game manager has an exit function in case the player wants to quit
#### Requirement 8
When deciding to solve a puzzle the Player is passed in and checked to see the owner of that puzzle
#### Requirement 9

#### Requirement 10
This is a dependency, that the player creates. A tournament is an aggregation of puzzles, and can consist of 1-5 puzzles
#### Requirement 11

#### Requirement 12
The Stats database holds a long list of Maps with the user and the information for puzzles, tournaments, $$ won etc.
#### Requirement 13
I did not consider this in my class diagram
#### Requirement 14
I did not consider this in my class diagram


