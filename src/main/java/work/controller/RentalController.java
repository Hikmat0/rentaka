package work.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import work.dto.RentRequestDto;
import work.dto.RentalDto;
import work.service.RentalService;
import work.entity.Rental;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) { this.rentalService = rentalService; }

    @PostMapping
    public ResponseEntity<RentalDto> create(@Valid @RequestBody RentRequestDto req) {
        Rental r = rentalService.rentItem(req.getUserId(), req.getItemId(), req.getRoom());
        return ResponseEntity.status(HttpStatus.CREATED).body(RentalDto.fromEntity(r));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<RentalDto> doReturn(@PathVariable Long id) {
        Rental r = rentalService.returnItem(id);
        return ResponseEntity.ok(RentalDto.fromEntity(r));
    }

    // GET /api/rentals with filters (implement with repository + specs / query)
}
