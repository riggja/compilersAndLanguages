# Prolog Programming Assignment

Adapted from David Matuszek Prolog Assignment: https://www.cis.upenn.edu/~matuszek/cis554-2015/Assignments/prolog-02-adventure-game.html

## Text Adventure

Purposes of this assignment

* To get give you more practice in Prolog.
* To introduce the idea of nonmonotonic logic.

##General idea

Your assignment is to write an adventure game in SWI-Prolog. Pick any theme you like for your adventure game: rescue, survival, treasure hunt, "a day in the life," or whatever else appeals to you.

Use the file adventure.pl and as a starting point. This is an absolutely boring game consisting of one room, one object, and one direction you can go (but going in that direction takes you back to the same room). Add to this code to create your own game; if it doesn't do what you want, fix it so that it does. This is free code, to use or modify any way you like. If you don't want to use it, that's OK too.

You can get additional ideas and sample code from previous [students games](http://www.cis.upenn.edu/~matuszek/cis554-2014/Pages/adventure-games.html). However, please don't copy one of these games and change the words around; write your own game!


> Special note: I would like to publish your game on my website, so that your classmates (and anyone else) can play your game. If you would prefer that I not do this, please say so clearly in your INSTRUCTIONS.md file.


## Details

Your program should contain one (or more, if you like) of each of the following:

- [ ] **Locked door** In its most boring form, you must find a key and use it to unlock a door, thus giving you access to one or more additional rooms. With a little more imagination: You aren't admitted without a badge. You need to buy a ticket. You must give the troll a gold piece before you can cross the bridge. Waving the magic wand causes the rainbow bridge to appear. Et cetera. Any sort of locked door puzzle will do.
- [ ] **Hidden object** Boring form: You open a box and find something inside. More interesting: You break open a treasure chest. You use the combination to a safe. You peer into the crystal ball. You buy the candy bar from the vending machine. You disassemble the robot to get some part out of it.
- [ ] **Incomplete object** Your flashlight needs batteries. Your gun needs bullets. Your car needs gas. Your bicycle has a flat tire. You need a computer to get at the information on a floppy disk. You are a zombie and need a brain.
- [ ] **Limited resouces** You have a limited amount of time (to find the bomb before it goes off) or money (to buy the things you need), or food, drink, or sleep (so you don't collapse), or some other resource. Maybe you can find more resources in the game, maybe you can't. Depending on just what you decide to do, you may want to figure out how to do arithmetic in Prolog.

You should have a `start/0` predicate (similar to the one provided) that my TA and I can use to start your game and find out what commands you have added. Don't make us look at the code to figure out how to run your program!

Also include an **inventory** command (abbreviation: `i`) to tell what the player is currently holding.

Play the game by running Prolog and typing queries into it. Prolog can easily read Prolog terms, but reading anything else is awkward, and not worth learning how to do. (However, if you want to ask the user for a number, you can use the read(X) predicate; a number is a term. Just remember to type a period after the number.)

## Grading

Your program should work, should satisfy the above requirements, and should be reasonably formatted.

We reserve the right for some subjective judgment. If we like your game, we may give you bonus points for it. If your game seems to lack creativity and interest, you may lose points.

## Due date

Wednesday, December 4, before 11:59pm. 

- [ ] **Code** Gitlab has your updated `adventure.pl` file.
- [ ] **Instructions** The instruction should be saved in an `INSTRUCTIONS.md` file. Please give your game a name and include a one-sentence description of your game. Try to choose an interesting name. Include a transcript of a sample run of your program. A "transcript" is a walkthrough of the game, showing the commands entered and the computer's response to each command. You can get this by playing the game and copy/pasting the results.
- [ ] **Requirements** As part of the instuctions indicate of how you have satisfied the requirements for a locked door, hidden object, incomplete object, and limited resource.
- [ ] **Post?** The name of the game and the one-sentence description are for posting purposes. The transcript and the descriptions of the locked door, etc., are to make it possible for my TAs to grade your program without extensive effort.

