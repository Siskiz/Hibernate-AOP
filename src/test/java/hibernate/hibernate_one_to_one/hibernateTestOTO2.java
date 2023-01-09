package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTestOTO2 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmpDetail());


            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}
