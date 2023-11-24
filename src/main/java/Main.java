import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        List<String> students = session.createQuery("SELECT name FROM Student", String.class).list();
        for (String student : students) {
            System.out.println("Имя студента: " + student);
        }

        List<String> courses = session.createQuery("SELECT name FROM Course", String.class).list();
        for (String course : courses) {
            System.out.println("Название курса: " + course);
        }

        List<String> Teachers = session.createQuery("SELECT name FROM Teacher", String.class).list();
        for (String teacher : Teachers) {
            System.out.println("Имя учителя: " + teacher);
        }

        List<Long> courses = session.createQuery("SELECT COUNT (id) FROM Student", Long.class).list();
        for (Long course : courses) {
            System.out.println("Общее количество студентов: " + course);
        }

        List<Double> students = session.createQuery("SELECT AVG(age) FROM Student", Double.class).list();
        for (Double student : students) {
            System.out.println("Средний возраст студентов: " + student);
        }

        sessionFactory.close();
    }
}