package spring.com.test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import spring.com.util.HibernateConfig;

public class TestHibernate {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        if(sessionFactory != null){
            System.out.println("SessionFactory is configured correctly.");
        } else {
            System.out.println("SessionFactory not found.");
        }

        HibernateTransactionManager transactionManager = context.getBean(HibernateTransactionManager.class);

        if(transactionManager != null){
            System.out.println("TransactionManager is configured correctly.");
        } else {
            System.out.println("TransactionManager not found.");
        }
    }
}
