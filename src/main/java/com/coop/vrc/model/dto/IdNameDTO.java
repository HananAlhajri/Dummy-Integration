package com.coop.vrc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IdNameDTO<T> {
    private T id;
    private LanguageResource name;
}
