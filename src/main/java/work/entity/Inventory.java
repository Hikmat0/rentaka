package work.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="item_name", nullable=false)
    private String itemName;

    @Column(name="quantity", nullable=false)
    private Integer quantity = 0;

    @Column(name="description")
    private String description;

    // getters / setters
}
