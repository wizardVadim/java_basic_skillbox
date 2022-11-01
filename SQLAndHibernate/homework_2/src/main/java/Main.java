import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {

        String hql;
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        hql = "INSERT IGNORE INTO linkedpurchaselist (studentId, courseId) " +
                "(SELECT s.id, c.id " +
                "FROM purchaselist p " +
                "LEFT JOIN students s ON (s.name = p.student_name) " +
                "LEFT JOIN courses c ON (c.name = p.course_name))";

        Transaction transaction = session.beginTransaction();
        session.createSQLQuery(hql).executeUpdate();
        transaction.commit();

        sessionFactory.close();
    }
}
