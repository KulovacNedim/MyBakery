package dao;

import model.Ingredient;
import model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class IngredientDAOImpl implements IngredientDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Ingredient getIngredientById(int id) {

        Ingredient ingredient = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            ingredient = (Ingredient)session.get(Ingredient.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ingredient;
    }

    @Override
    public Ingredient getIngredientByName(String name) {

        Ingredient ingredient = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            Criteria cr = session.createCriteria(Ingredient.class);
            cr.add(Restrictions.eq("name", name));
            ingredient = (Ingredient) cr.uniqueResult();
            if(transaction.getStatus().equals(TransactionStatus.ACTIVE))
                transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ingredient;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsOfProduct(Product product) {

        Session session = null;
        ArrayList<Ingredient> allIngredients = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from product_ingredient_x_ref where productId = :prID");
            query.setParameter("prID", product.getProductId());
            allIngredients = (ArrayList<Ingredient>) ((org.hibernate.query.Query) query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();;
            return allIngredients;
        } finally {
            session.close();
        }

        return allIngredients;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {

        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(ingredient);
            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteIngredient(Ingredient ingredient) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(ingredient);
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
    public boolean updateIngredient(Ingredient ingredient) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(ingredient);
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
