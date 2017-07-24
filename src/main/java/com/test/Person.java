package com.test;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Person
{


    private int depth = 4; //max layer when searching with bfs
    private int level = 0; //layer of the current person
    private String name; //name of the current person

    List<Person> friends = null; //list of friends of the current person

    public Person(String name) {
        friends = new LinkedList<Person>();
        this.name = name;
    }

    /*
    This method adds person with the link of friendship
     */
    public void addFriend(Person person) {
        if (!friends.contains(person)) {
            friends.add(person);
            person.friends.add(this);
        }
    }

    /*
    This method returns friends of the current person using breadth-first search.
    It uses default value of the bottom layer 'depth'. You may set depth = -1 for searching through all layers
     */
    public List<Person> friendsOfFriends() {
        List<Person> visitedPersons = new LinkedList<Person>();
        Queue<Person> queue = new LinkedList<Person>();
        level = 1;
        queue.add(this);
        visitedPersons.add(this);

        while (!queue.isEmpty()) {
            Person currPerson = queue.remove();

            for (Person p : currPerson.friends) {
                if (!visitedPersons.contains(p)) {
                    p.level = currPerson.level+1;
                    if (p.level < depth || depth == 0) {
                        queue.add(p);
                        visitedPersons.add(p);
                    }
                }
            }

        }
        return visitedPersons;
    }



    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

}
