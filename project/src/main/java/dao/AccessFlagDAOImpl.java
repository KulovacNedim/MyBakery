package dao;

import dto.AccessFlag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccessFlagDAOImpl implements AccessFlagDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public AccessFlag getAccessFlagById(int id) {

        AccessFlag accessFlag = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            accessFlag = (AccessFlag)session.get(AccessFlag.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return accessFlag;
    }

    @Override
    public boolean addAccessFlag(AccessFlag accessFlag) {

        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.save(accessFlag);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAccessFlag(AccessFlag accessFlag) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(accessFlag);
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
