package com.pluralsight.streams;

import com.pluralsight.streams.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Person> people = getPeople();

        System.out.print("Enter last name you want to search: ");
        String lastName = input.nextLine().toLowerCase();
        findMatchingName(people, lastName);

        getAge(people);

    }

    private static void getAge(List<Person> people) {
        double averageAge = people.stream().mapToDouble(person-> person.getAge()).average().orElse(0);
        int maxAge = people.stream().map(person -> person.getAge()).reduce(Integer::max).orElse(0);
        int minAge = people.stream().map(person -> person.getAge()).reduce(Integer::min).orElse(0);

        System.out.printf("Average age is: %.2f", averageAge);

        System.out.println("Oldest age is: "+ maxAge);
        System.out.println("Youngest age is: "+minAge);
    }


    private static void findMatchingName(List<Person> people, String lastName) {
        List<Person> matchingPeople = people.stream().filter(person -> person.getLastName().contains(lastName))
                .toList();
        System.out.println(matchingPeople);
    }

    private static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Stephen", "Curry", 36));
        people.add(new Person("Kevin", "Durant", 35));
        people.add(new Person("Giannis", "Antetokounmpo", 29));
        people.add(new Person("Joel", "Embiid", 30));
        people.add(new Person("Luka", "Doncic", 25));
        people.add(new Person("Jayson", "Tatum", 26));
        people.add(new Person("Nikola", "Jokic", 29));
        people.add(new Person("Anthony", "Davis", 31));
        people.add(new Person("Jimmy", "Butler", 34));
        people.add(new Person("Kawhi", "Leonard", 32));
        people.add(new Person("Devin", "Booker", 27));

        // Duplicate last names
        people.add(new Person("Jalen", "Williams", 23));
        people.add(new Person("Grant", "Williams", 25));
        people.add(new Person("Jaden", "Ivey", 22));
        people.add(new Person("Keyontae", "Johnson", 24));
        people.add(new Person("Keldon", "Johnson", 24));
        people.add(new Person("Draymond", "Green", 34));
        people.add(new Person("Josh", "Green", 23));
        people.add(new Person("Trey", "Murphy", 24));
        return people;
    }
}
