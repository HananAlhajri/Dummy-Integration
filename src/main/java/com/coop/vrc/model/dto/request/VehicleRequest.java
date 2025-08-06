package com.coop.vrc.model.dto.request;

import com.coop.vrc.model.util.constraints.ValidPlateLetter;
import com.coop.vrc.model.util.constraints.ValidRegistrationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import static com.coop.vrc.model.constant.Constant.Regex.PLATE_NUMBER_REGEX;
import static com.coop.vrc.model.constant.Message.INVALID_PLATE_NUMBER_MESSAGE;
import static com.coop.vrc.model.constant.Message.NOT_BLANK_MESSAGE;

@Data
public class VehicleRequest {

    @NotBlank(message = "plate letter" + NOT_BLANK_MESSAGE)
    @ValidPlateLetter
    private String plateLetter1; // First from Left

    @ValidPlateLetter
    private String plateLetter2, plateLetter3; // Optional

    @NotBlank(message = "plate number" + NOT_BLANK_MESSAGE)
    @Pattern(regexp = PLATE_NUMBER_REGEX, message = INVALID_PLATE_NUMBER_MESSAGE)
    private String plateNumber;

    @NotBlank(message = "registration type" + NOT_BLANK_MESSAGE)
    @ValidRegistrationType
    private String registrationType;

}