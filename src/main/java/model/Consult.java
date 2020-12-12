package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "petclinic", name = "consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String description;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "petId", foreignKey = @ForeignKey(name = "fk_pet_consult"))
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinarianId", foreignKey = @ForeignKey(name = "fk_veterinarian_consult"))
    private Veterinarian veterinarian;

    public Consult( String description,Date date) {
        this.description = description;
        this.date = date;
    }

    public Consult(String description, Date date, Pet pet, Veterinarian veterinarian) {
        this.description = description;
        this.date = date;

    }

    public Consult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Consult{" +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public void setVeterinarian(Veterinarian veterinarian) {
    }

    public void sePet(Pet pet) {
    }
}
