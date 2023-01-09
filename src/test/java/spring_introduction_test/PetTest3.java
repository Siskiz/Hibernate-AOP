package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Person;

public class PetTest3 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
