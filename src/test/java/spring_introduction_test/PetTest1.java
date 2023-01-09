package spring_introduction_test;

import org.junit.Test;
import spring_introduction.Cat;
import spring_introduction.Dog;
import spring_introduction.Pet;

public class PetTest1 {

    @Test
    public void test() {
        Pet dog = new Dog();
        Pet cat = new Cat();

        dog.say();
        cat.say();
    }

}
