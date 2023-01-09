package hibernate.hibernate_many_to_many;

import hibernate.hibernate_many_to_many.entity.Child;
import hibernate.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestMTM5 {

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

            Section section1 = new Section("Dance");
            Child child1 = new Child("Olya", 12);
            Child child2 = new Child("Sasha", 9);
            Child child3 = new Child("Bogdan", 11);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1);

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
