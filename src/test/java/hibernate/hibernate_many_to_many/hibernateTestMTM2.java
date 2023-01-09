package hibernate.hibernate_many_to_many;

import hibernate.hibernate_many_to_many.entity.Child;
import hibernate.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class hibernateTestMTM2 {

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

            Section section1 = new Section("Football");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");
            Child child1 = new Child("Igor", 10);

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();

            session.save(child1);

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
