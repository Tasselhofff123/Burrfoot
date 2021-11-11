package ru.tasselhoff.burrfoot.dao;

import org.springframework.stereotype.Component;
import ru.tasselhoff.burrfoot.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Sergey"));
        people.add(new Person(++PEOPLE_COUNT, "Nikolay"));
        people.add(new Person(++PEOPLE_COUNT, "Alexey"));
        people.add(new Person(++PEOPLE_COUNT, "Julia"));
    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        //return people.get(1);
        for (int i = 0; i<people.size();i++){
            if(id == people.get(i).getId()){
                System.out.println("alright");
                return people.get(i);
            }
        }
        System.out.println("Bad");
        return people.get(0);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
