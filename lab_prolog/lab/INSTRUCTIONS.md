# Bounty Hunter


You are a bounty hunter that is drifting in your ship. You must find the objects
needed to get to and capture your target.

This is a locked door type of game.


## Instructions
Enter commands using standard Prolog syntax.
Available commands are:
* start.             -- to start the game.
* n.  s.  e.  w.     -- to go in that direction.
* take(Object).      -- to pick up an object.
* look.              -- to look around you again.
* instructions.      -- to see this message again.
* halt.              -- to end the game and quit.


# Walkthrough
?- start.

Enter commands using standard Prolog syntax.
Available commands are:
start.             -- to start the game.
n.  s.  e.  w.     -- to go in that direction.
take(Object).      -- to pick up an object.
look.              -- to look around you again.
instructions.      -- to see this message again.
halt.              -- to end the game and quit.

You are drifting in a small single
person spaceship.  You are a bounty hunter trying
to find your target on the planet Tatooine on the other side of deep space.
Deep space is to the north. you have an astroid field to the east.
There is a small planet to the west. You must return your bounty to the
space station to the south.


true.

?- e.
Go into an astroid field without a shield on your ship?  Are you crazy?
You can't go that way.
true.

?- n.
It would take years to cross deep space without a working hyperdrive.
You need to find a crystal to power your hyperdrive.
You can't go that way.
true.

?- s.
You need to go find the bounty and return it to this station.
You can't go that way.
true.

?- w.
There is a small planet that has a populated city.
There is a platform where you land. You are now on the planet.


true.

?- n.
There is a ship parts shop.

There is a shield here.

true.

?- take(shield).
OK.
true.

?- s.
You are drifting in a small single
person spaceship.  You are a bounty hunter trying
to find your target on the planet Tatooine on the other side of deep space.
Deep space is to the north. you have an astroid field to the east.
There is a small planet to the west. You must return your bounty to the
space station to the south.


true.

?- e.
You enter an astroid field. there is a shiny rock
formation on one of the larger astroids.

There is a crystal here.

true.

?- take(crystal).
OK.
true.

?- w.
You are drifting in a small single
person spaceship.  You are a bounty hunter trying
to find your target on the planet Tatooine on the other side of deep space.
Deep space is to the north. you have an astroid field to the east.
There is a small planet to the west. You must return your bounty to the
space station to the south.


true.

?- n.
The crystals you got worked in your hyperdrive and in a short few minutes the sight of the planet Tatooine is to the north.


true.

?- n.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- w.
You can't go that way.
true.

?- e.
You walk into Watto's Shop.
There is a new blatster to replace your broken one.
There is also a light saber, but you're no jedi.
Choose one.

There is a blaster here.
There is a lightsaber here.

true.

?- w.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- n.
The bounty notices you and pulls his blaster.
you pull out yours but it malfunctions.
should have gotten a new weapon. he shoots you and you die.

The game is over. Please enter the "halt." command.
You can't go that way.
true.

?- s.
The crystals you got worked in your hyperdrive and in a short few minutes the sight of the planet Tatooine is to the north.


true.

?- n.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- e.
You walk into Watto's Shop.
There is a new blatster to replace your broken one.
There is also a light saber, but you're no jedi.
Choose one.

There is a blaster here.
There is a lightsaber here.

true.

## Lighsaber Ending

?- take(lightsaber).
OK.
true.

?- w.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- n.
You walk into the Mos Eisley Cantina.
Your target is sitting in the back booth.
He pulls his blaster and you ignite your saber.
You dflect one blast but you're not a jedi.
He shoots you faster than you can block and you die.

The game is over. Please enter the "halt." command.
false.

## Blaster Ending

?- take(blaster)
|    .
OK.
true.

?- w.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- n.
You walk into the Mos Eisley Cantina.
Your target is sitting in the back booth.
He pulls his blaster and you shoot it from his hand.
you walk up and put bindings on him.

There is a bounty here.

true.

?- take(bounty).
OK.
true.

?- s.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- s.
The crystals you got worked in your hyperdrive and in a short few minutes the sight of the planet Tatooine is to the north.


true.

?- s.
You are drifting in a small single
person spaceship.  You are a bounty hunter trying
to find your target on the planet Tatooine on the other side of deep space.
Deep space is to the north. you have an astroid field to the east.
There is a small planet to the west. You must return your bounty to the
space station to the south.


true.

?- s.
Awesome! You brought back the bounty alive.
You won the game!

The game is over. Please enter the "halt." command.


true.

## No Weapon Ending

?- n.
You land at the space port that your target is supposed to be.
Mos Eisley Cantina is to the north. Watto's shop is to the east.


true.

?- n.
The bounty notices you and pulls his blaster.
you pull out yours but it malfunctions.
should have gotten a new weapon. he shoots you and you die.

The game is over. Please enter the "halt." command.
You can't go that way.
true.