package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(
        name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
public class LoansDto {
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp = "(^[0-9]{10}$)", message = "Mobile number should be 10 digits")
    @Schema(
            description = "Mobile number of the user",
            example = "1234567890"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp = "(^[0-9]{12}$)", message = "Loan number should be 12 digits")
    @Schema(
            description = "Loan number of the user",
            example = "123456789012"
    )
    private String loanNumber;

    @NotEmpty(message = "Loan Type can not be a null or empty")
    @Schema(
            description = "Loan type of the user",
            example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount of the user",
            example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Amount paid by the user",
            example = "50000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Outstanding amount of the user",
            example = "50000"
    )
    private int outstandingAmount;
}
