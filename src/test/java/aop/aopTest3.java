package aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopTest3 {

    @Test
    public void test() {
        System.out.println("Method start" + "\n" + "_____________________________________________");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary library = context.getBean("universityLibrary", UniversityLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу - " + bookName);

        context.close();
        System.out.println("Method end" + "\n" + "_____________________________________________");
    }

}
