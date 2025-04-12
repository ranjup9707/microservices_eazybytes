package com.eazybytes.cards.controller;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.dto.ErrorResponseDto;
import com.eazybytes.cards.dto.ResponseDto;
import com.eazybytes.cards.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "CRUD REST APIs for Cards in EazyBank",
    description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE card details"
)
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardsController
{
    private ICardsService iCardsService;

    @Operation(
            summary = "Create Card REST API",
            description = "REST API to create new Card inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam @Pattern(regexp = "(^[0-9]{10}$)",
            message = "Mobile number should be 10 digits") String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Fetch Card Details REST API",
            description = "REST API to fetch card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status INTERNAL SERVER ERROR",
                    content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCardsDetails(@Valid @RequestParam
                                                      @Pattern(regexp = "(^[0-9]{10}$)",
                                                              message = "Mobile number should be 10 digits")
                                                      String mobileNumber) {
        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @Operation(
            summary = "Delete Card Details REST API",
            description = "REST API to delete Card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Http Status EXPECTATION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@Valid @RequestParam
                                                             @Pattern(regexp = "(^[0-9]{10}$)",
                                                                     message = "Mobile number should be 10 digits")
                                                             String mobileNumber) {
        boolean isDeleted = iCardsService.deleteCard(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(
            summary = "Update Card Details REST API",
            description = "REST API to update Card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Http Status EXPECTATION FAILED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status INTERNAL SERVER ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCardDetails(@Valid @RequestBody CardsDto cardsDto) {
        boolean isUpdated = iCardsService.updateCard(cardsDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
        }
    }
}
