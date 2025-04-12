package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
public class CardsDto
{
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^[0-9]{10}$)", message = "Mobile number should be 10 digits")
    @Schema(
            description = "Mobile number of the user",
            example = "1234567890"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be null or empty")
    @Pattern(regexp = "(^[0-9]{12}$)", message = "Card number should be 12 digits")
    @Schema(
            description = "Card number of the user",
            example = "123456789012"
    )
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be null or empty")
    @Schema(
            description = "Card type of the user",
            example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total limit should be a positive number")
    @Schema(
            description = "Total limit of the card",
            example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used of the card",
            example = "100"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount used should be equal or greater than zero")
    @Schema(
            description = "Total available amount of the card",
            example = "900"
    )
    private int availableAmount;
}
