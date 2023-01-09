package spring_introduction_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                PetTest1.class,
                PetTest2.class,
                PetTest3.class,
                PetTest4.class,
                PetTest5.class,
                ConfigWithAnnotation1.class,
                ScopeTest.class
        }
)

public class AllPetTest {
}
