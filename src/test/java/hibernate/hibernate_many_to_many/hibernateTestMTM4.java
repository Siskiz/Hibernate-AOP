package hibernate.hibernate_many_to_many;

import hibernate.hibernate_many_to_many.entity.Child;
import hibernate.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestMTM4 {

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

            Child child = session.get(Child.class, 4);

            System.out.println(child);
            System.out.println(child.getSections());

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
