package work.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name="user_id")
    private User user;

    @ManyToOne @JoinColumn(name="item_id")
    private Inventory item;

    @Column(name="rent_date")
    private LocalDateTime rentDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Column(name="room")
    private Integer room;

    // getters / setters
}
