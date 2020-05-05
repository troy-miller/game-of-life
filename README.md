# game-of-life

Implementation of John Horton Conway's 1970 "zero player game"

QUICK DISCLAIMER:
- This is my first project on the site and my first real "finished" project (albeit small and insignificant haha)
- This is really just meant to help me get a start on building a portfolio of projects to help me strengthen my resume!
- Of course, if you have any changes or comments, please send them in! I'm still a student and want as many chances to learn as possible

Conway designed the game as such:
- The board is a grid of squares called "cells"
- Each cell interacts with its 8 neighbors to determine if it will survive the next generation, die, or come to life
- The rules are as such:
  1. A living cell dies if it has more than 3 or fewer than 2 living neighbors
  2. A living cell survives if it has 2 or 3 living neighbors
  3. A dead cell comes to life if it has exactly 3 living neighbors
  
My implementation:
- Using Java's Swing GUI library, I initialize a JFrame of what can be a desired amount of cells
- Using a JMenuBar, options are given to either randomize the board and reset it. It also gives the functionality to either move to the     next generation, or start moving through generations at a fixed rate
- Living cells are represented by a black square, dead cells as white

Desired future additions:
- Slider to adjust board size from within GUI
- Slider to adjust speed at which the game moves through generations
