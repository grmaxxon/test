package com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonTest {

    Person igor = new Person("Igor");
    Person anna = new Person("Anna");
    Person denis = new Person("Denis");
    Person peter = new Person("Peter");
    Person eugene = new Person("Eugene");
    Person victor = new Person("Victor");
    Person maria = new Person("Maria");
    Person ivan = new Person("Ivan");
    Person maxim = new Person("Maxim");
    Person zoya = new Person("Zoya");
    Person zigrfid = new Person("Zigrfid");
    Person sigmund = new Person("Sigmund");

    @Before
    public void linkConnections() {

        /*
            |------------------------|
            |                        |
            |                |--- Eugene
            |    |-- Anna ---|--- Victor
            |    |           |--- Maria
            |    |
            |    |           |--- Ivan
          Igor ----- Denis --|
            |    |           |--- Maxim
            |    |
            |    |           |--- Zoya
            |    |-- Peter --|--- Zigfrid
            |                |--- Sigmund
            |                        |
            |------------------------|
         */

        igor.addFriend(anna);
        igor.addFriend(denis);
        igor.addFriend(peter);
        anna.addFriend(eugene);
        anna.addFriend(victor);
        anna.addFriend(maria);
        denis.addFriend(ivan);
        denis.addFriend(maxim);
        peter.addFriend(zoya);
        peter.addFriend(zigrfid);
        peter.addFriend(sigmund);
        igor.addFriend(eugene);
        igor.addFriend(sigmund);
    }

    @Test
    public void testFriendsOfFriendsAllLayers() {
        Person rootPerson = igor;
        List<Person> friends = rootPerson.friendsOfFriends();

        Assert.assertEquals(anna.getLevel(), 2);
        Assert.assertEquals(denis.getLevel(), 2);
        Assert.assertEquals(peter.getLevel(), 2);
        Assert.assertEquals(eugene.getLevel(), 2);
        Assert.assertEquals(sigmund.getLevel(), 2);
        Assert.assertEquals(victor.getLevel(), 3);
        Assert.assertEquals(maria.getLevel(), 3);
        Assert.assertEquals(ivan.getLevel(), 3);
        Assert.assertEquals(maxim.getLevel(), 3);
        Assert.assertEquals(zoya.getLevel(), 3);
        Assert.assertEquals(zigrfid.getLevel(), 3);

        showData(rootPerson);

    }

    /*
    Testing only up to third level (friends of my friends)
     */
    @Test
    public void testFriendsOfFriendsOnly() {
        Person rootPerson = sigmund;
        rootPerson.setLevel(3);
        List<Person> friends = rootPerson.friendsOfFriends();

        Assert.assertEquals(peter.getLevel(), 2);
        Assert.assertEquals(igor.getLevel(), 2);
        Assert.assertEquals(zoya.getLevel(), 3);
        Assert.assertEquals(zigrfid.getLevel(), 3);
        Assert.assertEquals(anna.getLevel(), 3);
        Assert.assertEquals(denis.getLevel(), 3);
        Assert.assertEquals(eugene.getLevel(), 3);

        //The following connections shouldn't be shown
        Assert.assertEquals(ivan.getLevel(), 4);
        Assert.assertEquals(maxim.getLevel(), 4);
        Assert.assertEquals(victor.getLevel(), 4);
        Assert.assertEquals(maria.getLevel(), 4);


        showData(rootPerson);

    }

    public void showData(Person rootPerson) {
        System.out.println("Friends for " + rootPerson.getName() + ":");
        for (Person p : rootPerson.friendsOfFriends()) {
            if (p.getLevel() > 0) {
                for (int i = 0; i < p.getLevel(); i++) {
                    System.out.print("  ");
                }
                if (p.getLevel() == 1) System.out.println(p.getName() + " (himself)");
                else System.out.println(p.getName() + " (" + p.getLevel() + ")");

            }
        }
    }


}
