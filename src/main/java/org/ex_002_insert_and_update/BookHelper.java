package org.ex_002_insert_and_update;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.ex_002_insert_and_update.entity.Author2;
import org.ex_002_insert_and_update.entity.Book2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.awt.print.Book;
import java.util.List;

public class BookHelper {
    private SessionFactory factory;
    public BookHelper(){
        factory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList(){
        try(Session session = factory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = criteriaQuery.from(Book.class);
            criteriaQuery.select(root);
            Query<Book> query = session.createQuery(criteriaQuery);

            return query.list();
        }
    }

    public Book getBookById(long id){
        try(Session session = factory.openSession()){
            Book book = session.get(Book.class, id);
            return book;
        }
    }

    public Book2 addBook(Book2 book){
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(book);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public void changeNameById(int id, String newName){
        try (Session session = factory.openSession()){
            Book2 book2 = session.get(Book2.class, id);
            book2.setName(newName);
            session.beginTransaction();
            session.persist(book2);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void bookInfo(int id){
        try (Session session = factory.openSession()){
            Book2 book2 = session.get(Book2.class, id);
            Author2 author2 = session.get(Author2.class, book2.getAuthorId());
            System.out.println("Book name: " + book2.getName() + "\nAuthor name: " + author2.getName() + " " + author2.getLastName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
