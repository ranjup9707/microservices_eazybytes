package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer, Accounts, Cards and Loans information"
)
public class CustomerDetailsDto
{
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "Name should between 5 and 30 characters")
    @Schema(
            description = "Name of the customer",
            example = "Ranju Pillai"
    )
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "ranju.pillai@gmail.com"
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "0987654321"
    )
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^[0-9]{10}$)", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Accounts detail of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Cards detail of the customer"
    )
    private CardsDto cardsDto;

    @Schema(
            description = "Loans detail of the customer"
    )
    private LoansDto loansDto;
}
