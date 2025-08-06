package com.coop.vrc.model.util.constraints;

import com.coop.vrc.model.constant.Message;
import com.coop.vrc.model.util.MessageUtil;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.coop.vrc.model.constant.Constant.LookupValues.REGISTRATION_TYPES_MAP;
import static com.coop.vrc.model.constant.Message.INVALID_REGISTRATION_TYPE_WITH_PLACE_HOLDER_MESSAGE;

@Constraint(validatedBy = ValidRegistrationType.RegistrationTypeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRegistrationType {

    String message() default Message.INVALID_REGISTRATION_TYPE_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @RequiredArgsConstructor
    class RegistrationTypeValidator implements ConstraintValidator<ValidRegistrationType, String> {

        private final MessageUtil messageUtil;
        String regex;

        @Override
        public void initialize(ValidRegistrationType constraintAnnotation) {
            regex = REGISTRATION_TYPES_MAP.keySet().stream().map(String::valueOf).collect(Collectors.joining("|"));
        }

        @Override
        public boolean isValid(String registrationType, ConstraintValidatorContext context) {
            if (registrationType == null) {
                return true;
            }

            boolean isValidRegistrationType = Pattern.matches(regex, registrationType);
            if (!isValidRegistrationType) {
                context.disableDefaultConstraintViolation();
                context
                        .buildConstraintViolationWithTemplate(
                                messageUtil.replacePlaceholders(INVALID_REGISTRATION_TYPE_WITH_PLACE_HOLDER_MESSAGE, regex)
                        )
                        .addConstraintViolation();
            }
            return isValidRegistrationType;
        }
    }
}