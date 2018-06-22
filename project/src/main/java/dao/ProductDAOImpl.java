package dao;

import model.Product;
import model.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Product getProductById(int id) {

        Product product = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            product = (Product)session.get(Product.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() {

        //Open Session
        Session session = sessionFactory.openSession();

        /* //Deprecated Way
         * Criteria criteria = session.createCriteria(Contact.class);
         * List<Contacts> contacts = criteria.list(); */

        //Get Criteria Builder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> productRoot = criteria.from(Product.class);
        criteria.select(productRoot);

        //Use criteria to query with session to fetch all contacts
        ArrayList<Product> allProducts = (ArrayList<Product>) session.createQuery(criteria).getResultList();

        //Close session
        session.close();

        return allProducts;
    }

    @Override
    public ArrayList<Product> getAllProductsByCategory(ProductCategory productCategory) {

        Session session = null;
        ArrayList<Product> allProducts = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Product where productCategoryId = :prCategID");
            query.setParameter("prCategID", productCategory.getProductCategoryId());
            allProducts = (ArrayList<Product>) ((org.hibernate.query.Query) query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();;
            return allProducts;
        } finally {
            session.close();
        }

        return allProducts;
    }

    @Override
    public boolean addProduct(Product product) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(product);
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
    public boolean updateProduct(Product product) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(product);
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
