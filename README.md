# TowerOfDoom
Based on an "ancient legend", if monks in a temple in India/China/Nepal successfully solve the famous Tower of Hanoi problem with 64 discs, the world will end. 

The puzzle was actually invented in 1883 by French mathematician Édouard Lucas, but nonetheless, this Java program visualizes a recursive solution to the problem, attempting to end the world along the way. 

But because the 64-disc solution requires no less than a whopping 2^64-1 moves, the world will not be ending any time soon. :)

# How to run:

To visualize the legend, for example, use: 

    javac Hanoi
    
and then:

    java Hanoi 64 1
    
where the first command-line argument is the number of discs to display, and the second is long (in ms) it takes to move each disc (minimum value of 1). 

# Sources

This code is adapted from Sedgewick and Wayne's *Computer Science: An Interdisciplinary Approach*, and uses the StdOut and StdDraw libraries developed by Princeton University.


