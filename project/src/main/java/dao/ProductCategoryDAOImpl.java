package dao;

import model.ProductCategory;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class ProductCategoryDAOImpl implements ProductCategoryDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public ProductCategory getProductCategoryById(int id) {

        ProductCategory productCategory = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            productCategory = (ProductCategory)session.get(ProductCategory.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return productCategory;
    }

    @Override
    public ProductCategory getProductCategoryByCategoryName(String category) {

        ProductCategory prCategory = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            Criteria cr = session.createCriteria(ProductCategory.class);
            cr.add(Restrictions.eq("category", category));
            prCategory = (ProductCategory) cr.uniqueResult();
            if(transaction.getStatus().equals(TransactionStatus.ACTIVE))
                transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return prCategory;
    }

    @Override
    public ArrayList<ProductCategory> getAllProductCategories() {

       return null;
    }

    @Override
    public boolean addProductCategory(ProductCategory productCategory) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(productCategory);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProductCategory(ProductCategory productCategory) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(productCategory);
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
    public boolean updateProductCategory(ProductCategory productCategory) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(productCategory);
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
