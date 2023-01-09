package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Pet;

public class PetTest2 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();

        context.close();
    }

}
