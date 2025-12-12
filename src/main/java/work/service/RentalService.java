package work.service;


import work.entity.*;
import  work.repository.*;
import work.exception.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class RentalService {
    private final RentalRepository rentalRepo;
    private final InventoryRepository inventoryRepo;
    private final UserRepository userRepo;

    public RentalService(RentalRepository rentalRepo, InventoryRepository inventoryRepo, UserRepository userRepo) {
        this.rentalRepo = rentalRepo;
        this.inventoryRepo = inventoryRepo;
        this.userRepo = userRepo;
    }

    @Transactional
    public Rental rentItem(Long userId, Long itemId, Integer room) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ApiException("User not found"));
        Inventory item = inventoryRepo.findById(itemId).orElseThrow(() -> new ApiException("Item not found"));

        if (!user.getIsValid()) throw new ApiException("User is not valid");
        if (item.getQuantity() <= 0) throw new ApiException("Item not available");

        // decrease quantity
        item.setQuantity(item.getQuantity() - 1);
        inventoryRepo.save(item);

        Rental r = new Rental();
        r.setUser(user);
        r.setItem(item);
        r.setRoom(room);
        r.setRentDate(LocalDateTime.now());
        rentalRepo.save(r);

        return r;
    }

    @Transactional
    public Rental returnItem(Long rentalId) {
        Rental r = rentalRepo.findById(rentalId).orElseThrow(() -> new ApiException("Rental not found"));
        if (r.getReturnDate() != null) throw new ApiException("Rental already returned");

        r.setReturnDate(LocalDateTime.now());
        rentalRepo.save(r);

        Inventory item = r.getItem();
        item.setQuantity(item.getQuantity() + 1);
        inventoryRepo.save(item);
        return r;
    }
}

