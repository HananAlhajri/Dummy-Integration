package com.coop.vrc.controller;


import com.coop.vrc.model.util.APIResponse;
import com.coop.vrc.service.LookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.coop.vrc.model.constant.APIUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(API_LOOKUPS_PREFIX)
public class LookupController {

    private final LookupService lookupService;

    @GetMapping(REGISTRATION_TYPES)
    public ResponseEntity<?> registrationTypes() {
        return APIResponse.success(lookupService.getRegistrationTypes());
    }

    @GetMapping(PLATE_LETTERS)
    public ResponseEntity<?> plateLetters() {
        return APIResponse.success(lookupService.getPlateLetters());
    }
}
