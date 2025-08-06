package com.coop.vrc.controller;

import com.coop.vrc.model.dto.request.VehicleRequest;
import com.coop.vrc.service.MainService;
import com.coop.vrc.model.util.APIResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static com.coop.vrc.model.constant.APIUrls.API_V1_PREFIX;
import static com.coop.vrc.model.constant.APIUrls.VEHICLE_INFO;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_PREFIX)
public class MainController {

    private final MainService mainService;

    @PostMapping(VEHICLE_INFO)
    public ResponseEntity<?> vehicleInfo(@Valid @RequestBody VehicleRequest request) {
        log.info("MainController -> vehicleInfo() -> request:[{}]", request);

        if (request.getPlateLetter1().equals("أ")) {
            throw new NoSuchElementException();
        }

        return APIResponse.success(mainService.getRandomVehicle(request));
    }
}
