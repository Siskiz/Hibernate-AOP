package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTest5 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 10);
//            session.delete(employee);

            session.createQuery("DELETE Employee WHERE name = 'Oleg'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
