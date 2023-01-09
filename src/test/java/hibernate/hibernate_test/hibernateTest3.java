package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class hibernateTest3 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("FROM Employee").getResultList();
            List<Employee> employees = session.createQuery("FROM Employee WHERE name = 'Oleg' AND salary > 700").getResultList();
            for (Employee e : employees) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
