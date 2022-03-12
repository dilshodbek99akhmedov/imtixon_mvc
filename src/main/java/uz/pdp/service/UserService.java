package uz.pdp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import uz.pdp.dto.UserDto;
import uz.pdp.entity.Book;
import uz.pdp.entity.Role;
import uz.pdp.entity.User;
import uz.pdp.utils.HibernateUtils;

import java.util.List;

@Service
public class UserService {

    public boolean login(UserDto dto) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        String qryString = "from users u where u.username =:uName";
        Query query = session.createQuery(qryString);
        query.setParameter("uName", dto.getUsername());
        List<User> patients = query.list();
        transaction.commit();
        return patients.get(0).getPassword().equals(dto.getPassword());
    }

    public void create(UserDto dto) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        User user = new User(dto.getUsername(), dto.getPassword(), dto.getPhoneNumber(), new Role(2L, "User", "USER"));
        session.save(user);
        transaction.commit();
    }

}
