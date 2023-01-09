package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Dog;

public class PetTest5 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();

        context.close();
    }

}
