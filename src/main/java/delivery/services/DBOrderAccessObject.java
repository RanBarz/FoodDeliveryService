package delivery.services;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import delivery.entities.Order;

@Component
public class DBOrderAccessObject implements DataAccessObject {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void createSession() {
        this.sessionFactory = new Configuration().configure().addAnnotatedClass(Order.class).buildSessionFactory();
    }

    @Override
    public int createOrder(Order order) throws IOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            int id = (int) session.save(order);
            transaction.commit();
            return id;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new IOException("Error creating order", e);
        }
    }

    @Override
    public boolean deleteOrder(int id) throws IOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                session.delete(order);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new IOException("Error deleting order", e);
        }
    }

    @Override
    public boolean updateOrder(int id, String address) throws IOException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                order.setAddress(address);
                session.update(order);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new IOException("Error updating order", e);
        }
    }

    @Override
    public Order readOrder(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Order", Order.class).getResultList();
        }
    }
}
