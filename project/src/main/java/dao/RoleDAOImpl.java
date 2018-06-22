package dao;

import model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoleDAOImpl implements RoleDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Role getRoleById(int id) {

        Role role = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            role = (Role)session.get(Role.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return role;
    }

    @Override
    public boolean addRole(Role role) {

        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateRole(Role role) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(role);
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
