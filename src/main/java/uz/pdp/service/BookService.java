package uz.pdp.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookUpdateDto;
import uz.pdp.entity.Book;
import uz.pdp.mapper.Mapper;
import uz.pdp.utils.HibernateUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final Mapper mapper;

    public void create(BookCreateDto dto) {
        Book book = mapper.toEntity(dto);
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(book);
        transaction.commit();

    }

    public List<Book> bookList() {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        String query = "from books where deleted=false";
        Query result = session.createQuery(query);
        List<Book> books = result.list();
        transaction.commit();
        return books;
    }

    public void delete(Long id) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        String qryString3 = "update books s set s.deleted=true where s.id=:sId";
        Query query3 = session.createQuery(qryString3);
        query3.setParameter("sId", id);
        query3.executeUpdate();
        transaction.commit();
    }

    public Book get(Long id) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        String query = "from books b where b.id =:book_id";
        Query result = session.createQuery(query);
        result.setParameter("book_id", id);
        List list = result.list();
        transaction.commit();
        return (Book) list.get(0);
    }

    public void update(BookUpdateDto dto) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        String qryString3 = "update books s set s.name=:dName, s.author=:dAuthor, s.page=:dPage where s.id=:sId";
        Query query3 = session.createQuery(qryString3);
        query3.setParameter("dName", dto.getName());
        query3.setParameter("dAuthor", dto.getAuthor());
        query3.setParameter("dPage", dto.getPage());
        query3.setParameter("sId", dto.getId());
        query3.executeUpdate();
        transaction.commit();
    }
}
