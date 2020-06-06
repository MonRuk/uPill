package pl.coderslab.upill.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @Column(unique = true, length = 50)
    private String username;

    @NotBlank
    @NotEmpty
    @Length(message = "Hasło powinno mieć przynajmniej 6 znaków", min = 6)
    private String password;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;
    private boolean enabled;

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /*@Min(1910)
    private int yearOfBirth;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_medicines", joinColumns = {@JoinColumn(name = "medicine_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<Medicine> meds = new HashSet<>();

    public boolean isEnabled() {
        return enabled;
    }


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Medicine> getMeds() {
        return meds;
    }

    public void setMeds(Set<Medicine> meds) {
        this.meds = meds;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
