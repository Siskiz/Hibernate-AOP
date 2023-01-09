package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Person;

public class ConfigWithAnnotation1 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }

}
