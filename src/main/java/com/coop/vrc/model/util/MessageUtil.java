package com.coop.vrc.model.util;

import org.springframework.stereotype.Service;

import static com.coop.vrc.model.constant.Constant.PLACE_HOLDER;

@Service
public class MessageUtil {

    public String replacePlaceholders(String message, String value) {
        return message.replace(PLACE_HOLDER, value);
    }

}
