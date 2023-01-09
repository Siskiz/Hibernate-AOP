package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_introduction.Dog;

public class ScopeTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = context.getBean("dogBean", Dog.class);
        Dog yourDog = context.getBean("dogBean", Dog.class);

        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog==yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);
    }

}
