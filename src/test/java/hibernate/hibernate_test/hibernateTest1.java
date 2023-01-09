package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTest1 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        Employee employee = new Employee("Oleg", "Sidorov", "HR", 750);

        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("Done");
            System.out.println(employee);
        }
        finally {
            factory.close();
        }
    }

}
