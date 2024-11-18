/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class PersonDirectory {
    
    private ArrayList<Person> personDirectory;
    
    public PersonDirectory()
    {
        personDirectory = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Person addPerson()
    {
        Person person = new Person();
        personDirectory.add(person);
        return person;
    }
    
    public void deletePerson(int personId)
    {
        personDirectory.remove(personId);
    }
    public Person getPersonById(int id) {
        Person result = new Person();
        for(Person k : personDirectory){
            if(k.getPersonId()==id)
                result = k;
        }
        return result;
    }
}
