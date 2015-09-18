package main.java.com;

import java.util.Date;

/**
 * @author Javin Paul
 * {@link http://java67.blogspot.com/2013/04/example-of-overriding-equals-hashcode-compareTo-java-method.html}
 * **********************************************************************
 * Simple Java Class to represent Person with name, id and date of birth.
 */
public class Person implements Comparable<Person>{

    public Person(String name, int id, Date dob) {
        this.name = name;
        this.id   = id;
        this.dob  = dob;
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;

        if(other == null || (this.getClass() != other.getClass())){
            return false;
        }

        Person guest = (Person) other;
        return (this.id == guest.id) &&
                (this.name != null && name.equals(guest.name)) &&
                (this.dob != null && dob.equals(guest.dob));
    }

    @Override
    public int hashCode(){
        int result = 0;
        result = 31*result + id;
        result = 31*result + (name !=null ? name.hashCode() : 0);
        result = 31*result + (dob  !=null ? dob.hashCode() : 0);

        return result;
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }

    private String name;
    private int      id;
    private Date    dob;
}