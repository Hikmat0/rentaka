package work.dto;


import jakarta.validation.constraints.NotNull;

public class RentalDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long itemId;
    @NotNull
    private Integer room;
    // getters / setters
}
