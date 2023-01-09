package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: В библиотеку пытаются вернуть книгу");
        Object targetMethodResult = null;

        try {
            Long begin = System.currentTimeMillis();
            targetMethodResult = proceedingJoinPoint.proceed();
            Long end = System.currentTimeMillis();
            System.out.println("aroundReturnBookLoggingAdvice: метод returnBook выполнил работу за - " + (end - begin) + " Millis");
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: Было поймано исключение - " + e);
//            targetMethodResult = "\"Неизвестное название книги\"";
                throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: В библиотеку успешно вернули книгу");
        return targetMethodResult;
    }

}
