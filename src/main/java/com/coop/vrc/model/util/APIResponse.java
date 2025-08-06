package com.coop.vrc.model.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> implements Serializable {

    T data;
    List<String> errors;

    public static <T> ResponseEntity<Object> success(T data) {
        return getResponse(HttpStatus.OK, data, null);
    }

    public static ResponseEntity<Object> fail(HttpStatus httpStatus, List<String> errors) {
        return getResponse(httpStatus, null, errors);
    }

    private static <T> ResponseEntity<Object> getResponse(HttpStatus httpStatus, T data, List<String> errors) {
        APIResponse<T> response = new APIResponse<>();
        response.setData(data);
        response.setErrors(errors);
        return new ResponseEntity<>(response, httpStatus);
    }

}
