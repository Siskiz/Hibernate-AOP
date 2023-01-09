package spring_introduction_test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.MyConfig;
import spring_introduction.Person;

public class ConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }

}
