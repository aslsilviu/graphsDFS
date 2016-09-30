package com.company;


import java.util.ArrayList;
import java.util.List;

public class OneToOneRepresentation {

    private class Person{
        String name;
        List<Person> friends = new ArrayList<>();

        public Person(String[] frArray){
            name = frArray[0]; //first name from list is the main node, the rest are its friends
            for (int i = 1; i < frArray.length; i++) {
                Person fr = new Person()

            }
        }

        addFriend(Person friend){
            friends.add(friend);
        }
    }

    public OneToOneRepresentation(String[] friends){
        for (int i = 0; i < friends.length; i++) {
            String line = friends[i];
            String[] arr = line.split(" ");

            Person obj = new Person(arr);
        }
//cica trebuie sa fac 2 parcurgeri, in prima creez nodurile si apoi fac legaturile

    }
}
