package ua.omenyuk.spring.dao;

import org.springframework.stereotype.Component;
import ua.omenyuk.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonList {
    private static final PersonList PERSON_LIST = new PersonList();
    private List<Person> people;

    public static PersonList getPersonList() {
        return PERSON_LIST;
    }

    private PersonList(){
        people = new ArrayList<>();
        people.add(new Person("Vasyl","Vasya", "1111"));
        people.add(new Person("Pavlo2002", "Pasha","214125fgs5"));
        people.add(new Person("Karolina", "Kara","fdsg2gwe"));
        people.add(new Person("Mareri70s", "Valya","sfaf2g2as"));
    }

    public List<Person> getPeople(){
        return people;
    }

    public Person show(String password){
        return people.stream().filter(person -> person.getPassword() == password).findAny().orElse(null);
    }
}
