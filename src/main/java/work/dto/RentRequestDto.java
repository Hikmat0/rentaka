package work.dto;

import jakarta.validation.constraints.NotNull;

public class RentRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long itemId;
    @NotNull
    private Integer room;
    // getters / setters
}
