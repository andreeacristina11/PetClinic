package repository;

import connection.DataBaseUtils;
import connection.HibernateUtils;
import model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VeterinarianRepositoryHibernate {


    public void save(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(veterinarian);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(veterinarian);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Veterinarian veterinarian) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            veterinarian.setSpeciality("internal doctor and anesthetist");
            session.update(veterinarian);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Veterinarian> getAllVeterinarians() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Veterinarian> veterinarianList = session.createQuery("from Veterinarian", Veterinarian.class).list();
        return veterinarianList;
    }
}
