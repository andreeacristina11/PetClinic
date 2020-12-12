package repository;

import connection.HibernateUtils;
import model.Pet;
import model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PetRepositoryHibernate {

    public void save(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Pet pet) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            pet.setIsVaccinated("no");
            session.update(pet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Pet> getAllPets() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Pet> petList = session.createQuery("from Pet", Pet.class).list();
        return petList;
    }
}
