package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Schema(
        name = "Accounts",
        description = "Schema to hold account information"
)
@Data
/* @Data is combination of all these annotations -  Getter, Setter, ToString, RequiredArgsConstructor, ToString
*  EqualsAndHashCode, Value */
public class AccountsDto {
    @Schema(
            description = "Account number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "(^$[0-9]{10})", message = "Account number should be 10 digits")
    private Long accountNumber;
    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;
    @Schema(
            description = "Branch address of the customer",
            example = "Sangvi"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;
}
