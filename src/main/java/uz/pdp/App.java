package uz.pdp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import uz.pdp.entity.Role;
import uz.pdp.utils.HibernateUtils;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory;
        sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
//        Book book = new Book("O'tgan kunlar", "Abdulla Qodriy", 5000);
//        session.save(book);
//        User user = new User("admin", "123", "+998887871764", );
//        session.save(user);
        Role role = new Role("Super Admin", "SUPER_ADMIN");
        session.save(role);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
