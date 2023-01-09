package hibernate.hibernate_one_to_many_bi;

import hibernate.hibernate_one_to_many_bi.entity.Department;
import hibernate.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTestOTM2 {

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

            System.out.println("Get department");
            Department department = session.get(Department.class, 3);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }

}
