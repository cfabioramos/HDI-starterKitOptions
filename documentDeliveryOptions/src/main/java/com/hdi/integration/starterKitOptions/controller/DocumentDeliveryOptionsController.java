package com.hdi.integration.starterKitOptions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdi.integration.starterKitOptions.controller.common.ApiErrorResponse;
import com.hdi.integration.starterKitOptions.controller.common.EnumExceptionCode;
import com.hdi.integration.starterKitOptions.service.DocumentDeliveryOptionsService;
import com.progress.open4gl.Open4GLException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "/insurancepolicy/{idInsurancePolicy}")
@Api("InsurancePolicy Document Delivery Options")
public class DocumentDeliveryOptionsController {

//    private static final Logger log = LoggerFactory.getLogger(DocumentDeliveryOptionsController.class);

    private DocumentDeliveryOptionsService service;

    private final HttpServletRequest request;

    private final ObjectMapper objectMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public DocumentDeliveryOptionsController(
            ObjectMapper objectMapper, HttpServletRequest request, DocumentDeliveryOptionsService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    @ApiOperation(value = "Send Start Kit Options")
    @GetMapping(value = "/documentDeliveryOptions", produces = {"application/json"})
    public ResponseEntity<?> getStarterKitOptions(
            @ApiParam(value = "Company ID", required = true) @RequestHeader(value = "X-Company-Id", required = true) String xCompanyId,
            @ApiParam(value = "Application ID", required = true) @RequestHeader(value = "X-Application-Id", required = true) String xApplicationId,
            @ApiParam(value = "User ID", required = true) @RequestHeader(value = "X-User-Id", required = true) String xUserId,
            @ApiParam(value = "Insurance policy ID", required = true) @PathVariable("idInsurancePolicy") Long idInsurancePolicy)
            throws Open4GLException, IOException {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(this.service.findOptionsByDocument(idInsurancePolicy), HttpStatus.OK);
        }

        return new ResponseEntity<>(
                new ApiErrorResponse(EnumExceptionCode.DATA_INVALID, "You must accept \"application/json\"", null),
                HttpStatus.BAD_REQUEST);
    }
}
