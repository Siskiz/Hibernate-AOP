package hibernate.hibernate_one_to_many_uni;

import hibernate.hibernate_one_to_many_uni.entity.Department;
import hibernate.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTestOTMUni3 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 3);

            System.out.println(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }

}
