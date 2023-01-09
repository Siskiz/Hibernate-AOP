package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("We took book from UniversityLibrary");
        System.out.println("____________________________________");
    }

    public void getMagazine() {
        System.out.println("We took magazine from UniversityLibrary");
        System.out.println("____________________________________");
    }

    public String returnBook() {
        int a = 10 / 0;
        System.out.println("We return book in UniversityLibrary");
        return "Война и мир";
    }

    public void returnMagazine() {
        System.out.println("We return magazine in UniversityLibrary");
        System.out.println("____________________________________");
    }

    public void addBook(String personName, Book book) {
        System.out.println("We add book in UniversityLibrary");
        System.out.println("____________________________________");
    }

    public void addMagazine() {
        System.out.println("We add magazine in UniversityLibrary");
        System.out.println("____________________________________");
    }

}
