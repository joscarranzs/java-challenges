### Problematic  
The challenge is to create a program that determines the winner in a **Rock-Paper-Scissors game**. The game must include a **scoring system** to track points for two players over multiple rounds. The ultimate goal is to decide the overall winner based on the number of rounds won.  

---

### Proposal  

#### Classes  
- **Main Class**: A class to encapsulate the game logic, player data, and scoring system.  

#### Variables  
- `playerOne` and `playerTwo`: Strings to store player names.  
- `pointsPlayerOne` and `pointsPlayerTwo`: Integers to track the points of each player.  
- `attempts`: An integer to limit the number of rounds.  
- `choices`: An array with options like `"rock"`, `"paper"`, and `"scissors"`.  

#### Methods  
- **`roll(String player)`**: Generates a random choice for a player.  
- **`addPoints(String player)`**: Updates the score for the winning player.  
- **`evaluate(int choicePlayerOne, int choicePlayerTwo)`**: Compares player choices and determines the winner for the round.  
- **`play()`**: Handles the game loop, allowing multiple rounds and tracking scores.  

---

### Suggestions  

#### Suggestion 1: Use a Rules Map  
To determine the winner efficiently, use a **Map** to store the rules:
- Each key represents a choice (e.g., "rock"), and the value represents the choice it defeats (e.g., "scissors").  
- Use the player's choice as a key to look up the opponent's choice and decide the outcome.

#### Suggestion 2: Random Choice for Players  
Use the `Random` class to randomly select a choice (rock, paper, or scissors) for each player.  
- Ensure the random index is between `0` and the length of the `choices` array minus 1.

#### Suggestion 3: Scoring System  
Implement a simple scoring system:
- Use two variables (`pointsPlayerOne` and `pointsPlayerTwo`) to track each player's score.  
- Increment the winner's score after each round.

#### Suggestion 4: Game Loop  
Use a **loop** to manage multiple rounds:
- Allow the game to run for a fixed number of attempts (e.g., 3 rounds).  
- Include an option for the user to exit the game early.

#### Suggestion 5: Tie Handling  
Ensure you handle ties properly:
- Check if both players choose the same option and display a tie message.  
- No points are awarded for a tie.

#### Suggestion 6: User-Friendly Output  
Make the game interactive and clear:
- Print player choices and round results.  
- At the end of the game, display the overall winner or indicate a tie if scores are equal.

---

### Results  

The program is expected to resolve the following scenarios:

#### Example 1: Player One Wins  
```
Player 1 rolls a rock  
Player 2 rolls scissors  
Player 1 has won this round!  
```

#### Example 2: Player Two Wins  
```
Player 1 rolls paper  
Player 2 rolls scissors  
Player 2 has won this round!  
```

#### Example 3: Tie Round  
```
Player 1 rolls paper  
Player 2 rolls paper  
It's a tie! No one won this round!  
```

---

### Expected Outcome  
By the end of the game:
- The program will determine the winner based on the scoring system.  
- If both players have the same score, the game will declare a tie.  
- The game can handle multiple rounds and provide a user-friendly experience with clear outputs.

---

Happy coding! Focus on breaking down the problem and building the solution step by step. 🚀  
