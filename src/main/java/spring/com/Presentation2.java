package spring.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.com.dao.IDao;
import spring.com.entities.Product;
import spring.com.util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        IDao<Product> productDao = context.getBean(IDao.class);

        Product p = new Product();
        p.setName("Product 1");
        p.setPrice(100.0);

        productDao.create(p);
        System.out.println("Product created successfully: " + p.getName());
    }
}
