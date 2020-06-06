package pl.coderslab.upill.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "meds")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(name = "forPrescription")
    private boolean forPrescription;

    @NotEmpty
    @NotBlank
    @Column(name = "measureUnit")
    private String measureUnit;

    @NotNull
    @NumberFormat
    private Double dosage;

    //@NotNull
    @NumberFormat
    private Double stock;

    //@ManyToMany(mappedBy = "meds", fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "meds")
    private Set<User> users = new HashSet<>();


    public Medicine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isForPrescription() {
        return forPrescription;
    }

    public void setForPrescription(boolean forPrescription) {
        this.forPrescription = forPrescription;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
