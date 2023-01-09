package hibernate.hibernate_one_to_one;

import hibernate.hibernate_one_to_one.entity.Detail;
import hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class hibernateTestOTO4 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

//        try {
//            session = factory.getCurrentSession();
//
//            Employee employee = new Employee("Misha", "Sidorov", "IT", 500);
//            Detail detail = new Detail("London", "+375296697887", "MishaSidorov@gmail.com");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            System.out.println("Done");
//
//        } finally {
//            factory.close();
//            assert session != null;
//            session.close();
//        }

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            factory.close();
            assert session != null;
            session.close();
        }

    }

}
