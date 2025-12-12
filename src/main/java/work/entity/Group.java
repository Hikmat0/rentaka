package work.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="group_name", nullable=false)
    private String groupName;

    @Column(name="is_active")
    private Boolean isActive = true;

    // getters / setters
}
