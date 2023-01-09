package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTest2 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);
        try {
            session.beginTransaction();
            session.save(employee);
//            session.getTransaction().commit();

            int myId = employee.getId();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee1);

            System.out.println("Done");

        }
        finally {
            factory.close();
        }
    }

}
