package aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class aopTest2 {

    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);

        university.addStudent();
        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch (Exception e) {
            System.out.println("Было поймано исключение - " + e);
        }


        context.close();

    }

}
