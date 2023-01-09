package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* aop.UniversityLibrary.*(..))")
//    private void allMethodsFromUniversityLibrary() {}
//
//    @Pointcut("execution(public void aop.UniversityLibrary.returnMagazine())")
//    private void returnMagazineFromUniversityLibrary() {}
//
//    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineFromUniversityLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniversityLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromUniversityLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log#10");
//    }
//

//    @Pointcut("execution(* aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniversityLibrary() {}
//
//    @Pointcut("execution(* aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniversityLibrary() {}
//
//    @Pointcut("allGetMethodsFromUniversityLibrary() || allReturnMethodsFromUniversityLibrary()")
//    private void allGetAndReturnMethodsFromUniversityLibrary() {}
//
//
//
//    @Before("allGetMethodsFromUniversityLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniversityLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniversityLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log#3");
//    }

//    @Before("execution(* get*())")
//    public void beforeAll() {
//        System.out.println();
//    }
//

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: " +
                            "Название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearsOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет - " + obj);
                }
            }
        }


        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("____________________________________");
    }

//    @Before("execution(* returnBook())")
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
//    }

}
