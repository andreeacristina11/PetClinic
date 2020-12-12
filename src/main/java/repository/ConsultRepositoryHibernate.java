package repository;

import connection.HibernateUtils;
import model.Consult;
import model.Pet;
import model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Enum.PetRace;

import java.util.Date;
import java.util.List;

public class ConsultRepositoryHibernate {

    public void save(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(consult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void update(Consult consult) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            consult.setDescription("it looks ok");
            session.update(consult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Consult> getAllConsults() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Consult> consultList = session.createQuery("from Consult", Consult.class).list();
        return consultList;
    }
}
