package work.repository;
import work.entity.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    Long countByItemIdAndReturnDateIsNull(Long itemId);

}