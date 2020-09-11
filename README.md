//COPYRIGHT STEFAN CRISTIAN POPA 321CA 2020//

1st Stage of the Project

Most of the game logic is being implemented in the gameMap file. After we
read the initial data (each type of terrain and the type of champions and their
first positions, which we create with the help of a factory) when we
instantiate the map, we proceed to play each round.

During a round, we move champions across the map and put them to fight if
that spot is already occupied. Since they attack each other at the same time,
we need to first see the after effects of their battle and then apply the
damage and other stats (like root timers and DoT number and duration).

We use the Double Dispatch Pattern to do this. ChampA.fight(ChampB) calls
in fact ChampB.getEffects(ChampA), which has a particular implementation
considering what type of champions ChampA and ChampB are and their specific
bonuses and interactions.

Now the only thing left to do is to deal the respective effects to the
champions and check whether one of them died so the other one can gain the exp.

2nd Stage of the Project

In addition to the first stage of the project I have implemented:

	1) Angels
Angels are some pretty simple classes, they only give their respective
buffs to champions. They do this using the Visitor pattern, each one can bless
a champion which in turn calls a method of the champion called getBlessed.
Depending on what kind of angel and champion we're talking about, these methods
have their own implementation in the Knight, Rogue, Wizard and Pyromancer
classes. Every time we need an angel, we first create it using the factory.

	2) Strategies
To implement the Strategy pattern we gave each champion a strategy field, 
where strategy is an interface with 8 classes which implement it: 2 for every
type of hero, one for when he's low on hp and on for when he has medium hp.
Depending on the state that a certain champion is in, strategy gets initialized
to one of this 8 classes and applies its effects on the champion.

	3) Observer
The greatMag is the observer of the gameMap, the place where every fight
and encounter takes place. Every time something of notice happens, we call the
appropiate update method of the observer. I opted to not use a list and an add
to the list method for the gameMap observers seeing as we only have 1 which
receives all the messages.
