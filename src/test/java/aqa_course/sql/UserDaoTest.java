package aqa_course.sql;

import aqa_course.sql.hibernate_util.HibernateUtil;
import aqa_course.sql.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class UserDaoTest {

    @Test
    public void testFetchUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<User> users = session.createQuery("FROM User", User.class).list();

            assertFalse(users.isEmpty(), "Users list should not be empty");

            users.forEach(user -> System.out.println("User: " + user.getUsername()));

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
