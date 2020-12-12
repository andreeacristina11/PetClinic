package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import Enum.PetRace;

@Entity
@Table(schema = "petclinic", name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column
    private PetRace race;

    @Column
    private Date birthDate;

    @Column
    private String isVaccinated;

    @Column
    private String ownerName;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consultList;

    public Pet( PetRace race, Date birthDate, String isVaccinated, String ownerName) {
        this.race = race;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.ownerName = ownerName;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetRace getRace() {
        return race;
    }

    public void setRace(PetRace race) {
        this.race = race;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIsVaccinated() {
        return isVaccinated;
    }

    public void setIsVaccinated(String isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", race='" + race + '\'' +
                ", birthDate=" + birthDate +
                ", isVaccinated='" + isVaccinated + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", consultList=" + consultList +
                '}';
    }
}
