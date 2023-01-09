package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestOTO1 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
            Detail detail = new Detail("Brest", "+375296429856", "OlegSmirnov@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}
