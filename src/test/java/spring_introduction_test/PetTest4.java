package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Dog;

public class PetTest4 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("Belka");
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("Strelka");

        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog == yourDog));
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());

        context.close();
    }

}
