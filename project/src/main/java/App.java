import dao.*;
import dto.AccessFlag;
import model.Ingredient;
import model.Product;
import model.ProductCategory;
import org.hibernate.SessionFactory;

import javax.transaction.*;
import java.util.ArrayList;


public class App {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public static void main(String[] args) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {


        IngredientDAOImpl inDAO = new IngredientDAOImpl();
        ProductDAOImpl prDAO = new ProductDAOImpl();
        ProductCategoryDAOImpl pcDAO = new ProductCategoryDAOImpl();
        UserDAOImpl usDAO = new UserDAOImpl();
        RoleDAOImpl roDAO = new RoleDAOImpl();
        AccessFlagDAOImpl afDAO = new AccessFlagDAOImpl();

        Product product = prDAO.getProductById(1);



      ArrayList<Ingredient> prCat = inDAO.getIngredientsOfProduct(product);

        for(int i = 0; i < prCat.size(); i++) {
            System.out.println(prCat.get(i));
        }

    }
}
