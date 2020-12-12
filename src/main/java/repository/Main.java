package repository;

import connection.HibernateUtils;
import model.Consult;
import model.Pet;
import Enum.PetRace;
import model.Veterinarian;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        if (session != null){
            System.out.println("we have a session");
        }else {
            System.out.println("something went wrong");
        }

        Veterinarian veterinarian1 = new Veterinarian("Max", "Verstappen", "Holand", "Intern");
        Veterinarian veterinarian2 = new Veterinarian("Alex","Albon", "Spain", "Surgeon");
        Veterinarian veterinarian3 = new Veterinarian("Lewis","Hamilton", "USA", "Surgeon");
        Veterinarian veterinarian4 = new Veterinarian("Sainz","Carlos", "Spain", "Intern");

        VeterinarianRepositoryHibernate veterinarianRepository = new VeterinarianRepositoryHibernate();

        veterinarianRepository.save(veterinarian1);
        veterinarianRepository.save(veterinarian2);
        veterinarianRepository.save(veterinarian3);
        veterinarianRepository.save(veterinarian4);

        veterinarianRepository.delete(veterinarian4);
        veterinarianRepository.update(veterinarian1);

        List<Veterinarian> veterinarianList = veterinarianRepository.getAllVeterinarians();
        for (Veterinarian p : veterinarianList){
            System.out.println(p.toString());
        }
//        HibernateUtils.shutdown();

        Pet pet1 = new Pet(PetRace.SHEPHERD, new Date(97,10, 15), "yes", "DenisRoadman");
        Pet pet2 = new Pet(PetRace.MALAMUT, new Date(99,11, 10), "yes", "LebronJames");
        Pet pet3 = new Pet(PetRace.BEAGLE, new Date(00,4, 25), "no", "KobeBryant");
        Pet pet4 = new Pet(PetRace.AKITA, new Date(98,3, 5), "yes", "MichaelJordan");

        PetRepositoryHibernate petRepositoryHibernate = new PetRepositoryHibernate();
        petRepositoryHibernate.save(pet1);
        petRepositoryHibernate.save(pet2);
        petRepositoryHibernate.save(pet3);
        petRepositoryHibernate.save(pet4);

        petRepositoryHibernate.delete(pet3);

        petRepositoryHibernate.update(pet4);

        List<Pet> petList = petRepositoryHibernate.getAllPets();
        for (Pet p: petList){
            System.out.println(p.toString());
        }
        HibernateUtils.shutdown();



        Consult consult1 = new Consult("not a good shape", new Date(2020, 12, 5));
        Consult consult2 = new Consult("looks very good", new Date(2020, 12, 5));
        Consult consult3 = new Consult("very well", new Date(2020, 12, 6));

        ConsultRepositoryHibernate consultRepositoryHibernate = new ConsultRepositoryHibernate();

        consult1.setVeterinarian(veterinarian1);
        consult1.sePet(pet1);
        consultRepositoryHibernate.save(consult1);

        consult2.setVeterinarian(veterinarian2);
        consult2.sePet(pet2);
        consultRepositoryHibernate.save(consult2);

        consult3.setVeterinarian(veterinarian3);
        consult3.sePet(pet3);
        consultRepositoryHibernate.save(consult3);

        consultRepositoryHibernate.update(consult1);
        consultRepositoryHibernate.delete(consult3);

        List<Consult> consultList = consultRepositoryHibernate.getAllConsults();
        for (Consult c: consultList){
            System.out.println(c.toString());
        }
        HibernateUtils.shutdown();

    }
}