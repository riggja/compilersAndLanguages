/* Bounty Hunter, by Jason Riggs. */

:- dynamic i_am_at/1, at/2, holding/1, alive/1, inventory/1.
:- retractall(at(_, _)), retractall(i_am_at(_)), retractall(alive(_)).

/* current location  */
i_am_at(space).

/* These are how the places are connected*/
path(space, n, deepSpace) :- holding(crystal).
path(space, n, deepSpace) :-
        write('It would take years to cross deep space without a working hyperdrive.'), nl,
        write('You need to find a crystal to power your hyperdrive.'), nl,
        !, fail.
path(deepSpace, n, tatooine).
path(tatooine, n, cantina) :- holding(blaster).
path(tatooine, n, cantina) :- holding(lightsaber).
path(tatooine, n, cantina) :-
        write('The bounty notices you and pulls his blaster.'), nl,
        write('you pull out yours but it malfunctions.'), nl,
        write('should have gotten a new weapon. he shoots you and you die.'), nl, die, !, fail.
path(cantina, s, tatooine).
path(tatooine, e, watto).
path(watto, w, tatooine).
path(tatooine, s, deepSpace).
path(deepSpace, s, space).

path(space, w, planet).

path(space, s, station) :- holding(bounty).
path(space, s, station) :-
            write('You need to go find the bounty and return it to this station.'), nl, !,fail.

path(planet, n, shop).
path(shop, s, space).

path(space, e, astroid) :- holding(shield).
path(space, e, astroid) :-
        write('Go into an astroid field without a shield on your ship?  Are you crazy?'), nl,
        !, fail.
path(astroid, w, space).

/* Objects location */
at(shield, shop).
at(crystal, astroid).
at(blaster, watto).
at(lightsaber, watto).
at(bounty, cantina).

/* This tells you if the bounty is alive or dead */

alive(bounty).

/* These rules describe how to pick up an object. */

take(X) :-
        holding(X),
        write('You''re already holding it!'),
        !, nl.

take(X) :-
        i_am_at(Place),
        at(X, Place),
        retract(at(X, Place)),
        assert(holding(X)),
        write('OK.'),
        !, nl.

take(_) :-
        write('I don''t see it here.'),
        nl.


/* These rules describe how to put down an object. */

drop(X) :-
        holding(X),
        i_am_at(Place),
        retract(holding(X)),
        assert(at(X, Place)),
        write('OK.'),
        !, nl.

drop(_) :-
        write('You aren''t holding it!'),
        nl.

/* These rules define the direction letters as calls to go/1. */

n :- go(n).

s :- go(s).

e :- go(e).

w :- go(w).


/* This rule tells how to move in a given direction. */

go(Direction) :-
        i_am_at(Here),
        path(Here, Direction, There),
        retract(i_am_at(Here)),
        assert(i_am_at(There)),
        !, look.

go(_) :-
        write('You can''t go that way.').


/* This rule tells how to look about you. */

look :-
        i_am_at(Place),
        describe(Place),
        nl,
        notice_objects_at(Place),
        nl.


/* These rules set up a loop to mention all the objects
   in your vicinity. */

notice_objects_at(Place) :-
        at(X, Place),
        write('There is a '), write(X), write(' here.'), nl,
        fail.

notice_objects_at(_).

/* This rule tells how to die. */

die :-
        finish.


/* Under UNIX, the "halt." command quits Prolog but does not
   remove the output window. On a PC, however, the window
   disappears before the final output can be seen. Hence this
   routine requests the user to perform the final "halt." */

finish :-
        nl,
        write('The game is over. Please enter the "halt." command.'),
        nl.


/* This rule just writes out game instructions. */

instructions :-
        nl,
        write('Enter commands using standard Prolog syntax.'), nl,
        write('Available commands are:'), nl,
        write('start.             -- to start the game.'), nl,
        write('n.  s.  e.  w.     -- to go in that direction.'), nl,
        write('take(Object).      -- to pick up an object.'), nl,
        write('look.              -- to look around you again.'), nl,
        write('instructions.      -- to see this message again.'), nl,
        write('halt.              -- to end the game and quit.'), nl,
        nl.


/* This rule prints out instructions and tells where you are. */

start :-
        instructions,
        look.


/* These rules describe the various rooms.  Depending on
   circumstances, a room may have more than one description. */

describe(space) :-
        write('You are drifting in a small single'), nl,
        write('person spaceship.  You are a bounty hunter trying'), nl,
        write('to find your target on the planet Tatooine on the other side of deep space.'), nl,
        write('Deep space is to the north. you have an astroid field to the east.'), nl,
        write('There is a small planet to the west. You must return your bounty to the'), nl,
        write('space station to the south.'), nl.


describe(astroid) :-
        write('You enter an astroid field. there is a shiny rock'), nl,
        write('formation on one of the larger astroids.'), nl.

describe(planet) :-
        write('There is a small planet that has a populated city.'), nl,
        write('There is a platform where you land. You are now on the planet.'), nl.

describe(shop) :-
        write('There is a ship parts shop.'), nl.

describe(deepSpace) :-
        write('The crystals you got worked in your hyperdrive and in a short few minutes the sight of the planet Tatooine is to the north.'), nl.

describe(tatooine) :-
        write('You land at the space port that your target is supposed to be.'), nl,
        write('Mos Eisley Cantina is to the north. Watto''s shop is to the east.'), nl.

describe(cantina) :-
        holding(lightsaber),
        write('You walk into the Mos Eisley Cantina.'), nl,
        write('Your target is sitting in the back booth.'), nl,
        write('He pulls his blaster and you ignite your saber.'), nl,
        write('You dflect one blast but you''re not a jedi.'), nl,
        write('He shoots you faster than you can block and you die.'), nl, die, !, fail.
describe(cantina) :-
        write('You walk into the Mos Eisley Cantina.'), nl,
        write('Your target is sitting in the back booth.'), nl,
        write('He pulls his blaster and you shoot it from his hand.'), nl,
        write('you walk up and put bindings on him.'), nl.

describe(watto) :-
        write('You walk into Watto''s Shop.'), nl,
        write('There is a new blatster to replace your broken one.'), nl,
        write('There is also a light saber, but you''re no jedi.'), nl,
        write('Choose one.'), nl.

describe(station) :-
        alive(bounty),
        write('Awesome! You brought back the bounty alive.'), nl,
        write('You won the game!'), nl,
        finish, !.

describe(station) :-
        write('Dang the bounty is dead. only half points.'), nl,
        write('You won the game, kinda.'), nl,
        finish, !.
