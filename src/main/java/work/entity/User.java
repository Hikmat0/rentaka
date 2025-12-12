package work.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="is_valid")
    private Boolean isValid = true;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

    // getters / setters
}
