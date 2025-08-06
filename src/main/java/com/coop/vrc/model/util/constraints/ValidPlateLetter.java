package com.coop.vrc.model.util.constraints;

import com.coop.vrc.model.constant.Message;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.coop.vrc.model.constant.Constant.LookupValues.PLATE_LETTERS_MAP;


@Constraint(validatedBy = ValidPlateLetter.PlateLetterValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPlateLetter {

    String message() default Message.INVALID_PLATE_LETTER_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class PlateLetterValidator implements ConstraintValidator<ValidPlateLetter, String> {
        @Override
        public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
            return input == null || PLATE_LETTERS_MAP.containsKey(input);
        }
    }
}