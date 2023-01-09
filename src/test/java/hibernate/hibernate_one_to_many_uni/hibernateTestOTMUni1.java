package hibernate.hibernate_one_to_many_uni;

import hibernate.hibernate_one_to_many_uni.entity.Department;
import hibernate.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestOTMUni1 {

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
            Department dep = new Department("HR", 1500, 500);
            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.beginTransaction();

            session.save(dep);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }

}
