package com.coop.vrc.model.constant;

public interface Message {
    String INVALID_PLATE_NUMBER_MESSAGE = "plate number must be a numeric value consisting of 1-4 digits",
            INVALID_PLATE_LETTER_MESSAGE = "plate letter must be valid single Arabic alphabet character",
            INVALID_REGISTRATION_TYPE_MESSAGE = "registration type must be within allowed values",
            INVALID_REGISTRATION_TYPE_WITH_PLACE_HOLDER_MESSAGE = INVALID_REGISTRATION_TYPE_MESSAGE + ": [{}]",
            NOT_BLANK_MESSAGE = " must not be blank";
}
