# FreecellAI
Freecell project for Artificial Intelligence class

How to use main:

Passing into String args[], if you would like a randomly generated board state, simply input 0 on the command line

If you would like to load a gamestate from a file the command line parameters are 1 followed by the file name.

Example

1 small.txt will solve the game state stored in the small.txt file

Main will print to System.out the initial board state, then upon finding a solution, it will print out an ArrayList of actions that it took to get to the solution

In addition, it will print out the number of gamestates reached, number of moves in solution, the time elapsed in seconds (floor), and it will verify that the actions taken will reach the final solution.

I have been able to pass all test cases provided, with the Freecell deal #25 being completed in about 44 seconds in 103 moves on my 16GB RAM intel i7-4790 @3.60GHz

For example a sample output on a randomly generated game state may look like this

Initial Game State: 
0 0 0 0 
4 
QS TD 5C 9H KC 3S KD 
7D 4S 2D KH 9D 2S QH 
QD AS 4H QC 9C 8S 3H 
JD TC 7S JS 5H 7H 2H 
KS 4D 2C 4C JH TH 
8D 5D 3C 6D JC 3D 
AD 6C 5S 8H 9S 7C 
AH 6H 6S TS AC 8C 

[1KD0, 88C0, 77C0, 2QH0, 79S5, 78H5, 22S3, 42H1, 8AC9, b8C2, 8TS0, 47H2, 86S2, b7C5, 75S0, 45H7, 86H5, 8AH9, 12H9, bQH8, 56H0, 4JS8, d6H4, 57C0, 75H2, c5S4, 76C0, 7AD3, 58H7, c7C7, 59S0, 5TH8, d9S8, 77C0, 3AD9, 78H8, 5JH7, 54C2, 63D2, 52C9, 13S5, bTS7, 1KC0, 19H7, c7C8, 45S0, 46H8, 32S2, 33H9, 38S7, 86H4, d5S4, 53S0, 54D1, d3S1, 5KS0, aKD5, 39C0, 3QC5, 34H9, 3AS9, 6JC3, 66D8, 22S9, 13S9, 63C9, 14D4, 15C8, d9C1, 23D0, 24C9, 85C9, a6C9, 44D0, 25H9, 65D2, 68D1, 45S6, 46H9, 86D4, 87C9, 65S4, aKC6, 3JC0, 3QD6, c4D3, 25D0, cJC6, 34D0, 26S3, 27H9, c5D3, 78S0, 28C9, 88H9, 79H9, 29D7, c4D4, 2KH0, 22D9, b3D9, 24S9, 44D9, 35D9, 45S9, 36S9, 46D9, 27D9, 18D9, 19C9, 47S9, b8S9, 79D9, 89S9, 4TC9, 6JC9, 1TD9, 4JD9, 6QD9, 7TS9, 8TH9, 7JH9, 8JS9, 1QS9, aKS9, 5QC9, 5KD9, 6KC9, 8QH9, aKH9]
Game States/Nodes checked: 42853
Moves in Solution: 130
Time Elapsed: 83
Verifying Win
13 13 13 13 
4 
--
--
--
--
--
--
--
--