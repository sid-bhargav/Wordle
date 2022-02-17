# Wordle

This is a Wordle clone made by me for an infinite number of games (really just 5757).

The game is played in the terminal and follows all the rules Wordle does. Some of the words are unfortunately a little bit obscure, but I plan to change the list I'm using soon. 

The words are currently from a [list provided by Stanford](https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt)

## Game play

```
[c(Y), r(*), a(*), n(*), e(*)]
[s(*), t(Y), i(G), c(G), k(G)]
[t(G), h(G), i(G), c(G), k(G)]
[#(*), #(*), #(*), #(*), #(*)]
[#(*), #(*), #(*), #(*), #(*)]
[#(*), #(*), #(*), #(*), #(*)]

You won! it took you 3 turns to get the answer: thick
```

In the game, you are presented with a 5x6 grid that shows how many guesses you have left. Each hashed-out line is a line that is still available. When you make a guess, the "color" is indicated by the letter in the parenthesis. 

Y = Yellow, which means this letter in your guess is in the final word by not in the right place.

G = Green, which means this letter in your guess is in the right place. 

## Future plans

Currently, the game can only be played in the terminal. As is probably clear by the fact I'm still keeping track of color, I'm hoping to create a GUI soon