import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

public class SearchTest {
    SocialNetWork<Person> test;
    Person p1 = new Person("Kevin",LocalDate.of(1988, Month.AUGUST,1), Person.Sex.MALE,"myEmail@gmail.com");
    Person p2 = new Person("Han",LocalDate.of(1999, Month.JANUARY,1), Person.Sex.FEMALE,"someEmail@hotmail.com");
    Person p3 = new Person("Voung",LocalDate.of(2002, Month.SEPTEMBER,1), Person.Sex.FEMALE,"otherEmail@yahoo.com");
    Person p4 = new Person("Moe",LocalDate.of(1964, Month.AUGUST,1), Person.Sex.MALE,"nextEmail@gmail.com");
    //31 21 17 55

    @Before
    public void setUp(){
        test = new SocialNetWork<>();
        test.addPerson(p1);
        test.addPerson(p2);
        test.addPerson(p3);
        test.addPerson(p4);
    }

    @Test
    public void checkBirthDate(){
        int expected = 31;
        int actual = test.roster.get(0).getAge();
        assertEquals(expected,actual);
    }

    @Test
    public void personsOlderThanTest(){
        Search.printPersonsOlderThan(test,22);
    }

    @Test
    public void printWithinRangeTest(){
        Search.printPersonsWithinAgeRange(test,22,45);
    }

    @Test
    public void printPersonsTestLocal(){
        CheckPerson tester = new Person(){};
        Search.printPersons(test, tester);
    }

    @Test
    public void printPersonsTestAnonymous(){
        CheckPerson tester = new Person(){
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.FEMALE;
            }
        };
        Search.printPersons(test, tester);
    }

    @Test
    public void printPersonsTestLambda(){
        CheckPerson tester = p -> p.getAge() > 30;
        Search.printPersons(test, tester);
    }

}
