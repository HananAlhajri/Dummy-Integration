package com.coop.vrc.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

import static com.coop.vrc.model.constant.Constant.LookupValues.PLATE_LETTERS_MAP;
import static com.coop.vrc.model.constant.Constant.LookupValues.REGISTRATION_TYPES_MAP;


@RequiredArgsConstructor
@Service
public class LookupService {

    public LinkedHashMap<Integer, String> getRegistrationTypes() {
        return REGISTRATION_TYPES_MAP;
    }

    public LinkedHashMap<String, String> getPlateLetters() {
        return PLATE_LETTERS_MAP;
    }
}
