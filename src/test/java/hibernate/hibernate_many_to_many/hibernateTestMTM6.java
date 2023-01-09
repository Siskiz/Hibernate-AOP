package hibernate.hibernate_many_to_many;

import hibernate.hibernate_many_to_many.entity.Child;
import hibernate.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestMTM6 {

    @Test
    public void test() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            Section section = session.get(Section.class, 5);
            session.delete(section);

            session.getTransaction().commit();
            System.out.println("_________________________________________");
            System.out.println("Done!!!");
        } finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }

}
