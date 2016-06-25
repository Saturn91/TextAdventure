addCreature: Player 10 Room1;
addCreature: Watchman 15 Room2;
addCreature: Lady 5 Room1;

addThing: Dagger;
addThing: Key;
addThing: Sword;
addThing: Ring;

addRoom: Room1 ./res/Rooms/room1;
addRoom: Room2 ./res/Rooms/room2;

setStartRoom: Room1;

addEvent: InInventory E1 Player Dagger;
addEvent: InInventory E2 Player Key;
addEvent: DeathOf E3 Watchman;
addEvent: Read E5 T4 Lady;

addAction: Give Player Sword E3;
addAction: Give Player Ring E5;

addEventBefore: E1 [START];
addEventBefore: E2 [START];
addEventBefore: E3 E1;

addDialog: Lady ./res/Dialogs/lady;