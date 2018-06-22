package dao;

import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class UserDAOImpl implements UserDAO {

   private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User getUserById(int id) {

        User user = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            user = (User)session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {

        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("email", email));
            user = (User) cr.uniqueResult();
            if(transaction.getStatus().equals(TransactionStatus.ACTIVE))
                transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {

        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("phoneNumber", phoneNumber));
            user = (User) cr.uniqueResult();
            if(transaction.getStatus().equals(TransactionStatus.ACTIVE))
                transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public boolean addUser(User user) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
           e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(User user) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updateUser(User user) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
