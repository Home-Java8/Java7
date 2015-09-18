package test.java.com;

import main.java.com.Person;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Javin Paul
 * {@link http://java67.blogspot.com/2013/04/example-of-overriding-equals-hashcode-compareTo-java-method.html}
 * **********************************************************************
 * Simple example of using equals and hashCode method
 */
public class PersonTest {

    @Test
    public void testEquals(){
        Person   james = new Person("James", 21, new Date(1980,12, 1));
        Person    same = new Person("James", 21, new Date(1980,12, 1));
        Person similar = new Person("Harry", 21, new Date(1981,12,1));

        assertTrue( james.equals(same) );
        assertTrue( james.hashCode() == same.hashCode() );

        assertFalse( james.equals(null) );
        assertFalse( james.equals(similar) );
        assertTrue( james.hashCode() != similar.hashCode() );
    }

}