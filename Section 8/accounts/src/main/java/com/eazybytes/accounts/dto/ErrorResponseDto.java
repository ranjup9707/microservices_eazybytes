package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "Error Response",
        description = "Schema to hold Error Response"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(
            description = "API Path invoked by client"
    )
    private String apiPath;
    @Schema(
            description = "Error code representing the status of the error"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error message representing the error happened"
    )
    private String errorMessage;
    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime errorTime;
}
