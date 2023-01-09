package hibernate.hibernate_one_to_many_uni;

import hibernate.hibernate_one_to_many_uni.entity.Department;
import hibernate.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTestOTMUni4 {

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
            Department department = session.get(Department.class, 1);
            Department department2 = session.get(Department.class, 2);

            session.delete(department);
            session.delete(department2);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }

}
