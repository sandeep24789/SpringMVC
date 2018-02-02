package com.accenture.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.accenture.domain.User;

 

public class UsrerValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmpty(errors, "address.street", "address.street.required");
		ValidationUtils.rejectIfEmpty(errors, "address.city", "address.city.required");
		ValidationUtils.rejectIfEmpty(errors, "address.postalCode", "address.postalCode.required");
	}

}
