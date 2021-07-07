# Game Centre :video_game:

## Introduction

We have created an Android game suite with the following games: 
- Sliding Tiles :game_die:
- Card Matching :black_joker:
- Simon :eyes:

Our task was to add the following features to the initial framework: 
- **JUnit Testing**: Write tests that cover as much of the code as possible (Code Coverage). 
- **Remove Unsolvable Boards**: Amend "Sliding Tiles" to ensure that it will never generate an unsolvable board.
- **Additional Games**: Add 2 more games of roughly the same complexity as Sliding Tiles. Create a scoreboard that incorporates all games. 
At least 1 new game should auto-save points. At least 1 new game should be able to "undo" moves.
- **Design Patterns**: Find areas in the code which can use design patterns and implement them. 
- **Refactoring**: Remove code smells and refactor existing codes. 
- **Fix Style Issues**

## Game Descriptions

### Sliding Tiles :game_die:
- The game starts with a shuffled board of randomly-ordered tiles and one blank tile.
- All tiles around the blank tile can be moved and replaced with the blank tile.
- The game ends when the tiles are in ascending order, and the blank tile at the bottom right.
- The player can undo a move using the undo button on the game screen.
- The game can be saved with the save button on the game screen. 
- The game can be loaded from the save/load menu.
- There is a score that is calculated based on the number of moves.
The user who completes the game with the lowest number of moves gets the highest score.

### Matching Cards :black_joker:
- The game starts with all cards faced-down. 
- The player must flip over two cards in efforts to create a match. 
- The game will end when the player matches all cards and there are no cards left. 
- The game can be saved with the save button on the game screen. 
- The game can be loaded from the save/load menu. 

### The Simon Game :eyes:
- The game starts with a pattern that is shown to the player. 
- The player must replicate the same pattern to proceed to the next round where a new pattern will be shown.
- The game ends when the player does not correctly replicate the pattern. 
- The player can undo a move using the undo button on the game screen. 
- The game can be loaded from the save/load menu. 

## Classes and Functions
1. CreateAccountActivity: Handles create account activity 
2. LoginActivity: Handles logins 
3. GameActivity: Parent of SlidingTileActivity (an abstract class)
4. SlidingTilesStartingActivity: Handles main menu screen after login 
5. SlidingTileActivity: Handles the sliding tiles game board
6. SlidingTileEndActivity: Handles the sliding tiles end game screen
7. SlidingTileGameScoreboardActivity: Handles the general (game) scoreboard
8. SlidingTileUserScoreboardActivity: Handles the personalized (user) scoreboard
9. SavedGamesView: Handles the selectable saved games screen
10. SidingTilesSettingsActivity: Handles the settings screen
11. Score: Represents the score that a user earns for a game
12. Scoreboard: Represents a scoreboard full of game scores
13. UserAccount: Class for each user and its data
