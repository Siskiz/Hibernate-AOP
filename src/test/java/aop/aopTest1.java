package aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aopTest1 {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        Book book = context.getBean("book", Book.class);

        universityLibrary.getBook();
//         universityLibrary.returnBook();
        universityLibrary.getMagazine();
        universityLibrary.addBook("Alexey", book);
        universityLibrary.addMagazine();
//        universityLibrary.returnMagazine();

        context.close();
    }

}
