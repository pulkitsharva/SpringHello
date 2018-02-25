package com.shhh.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shhh.spring.dto.UserRegistrationDTO;

@Component
public class UserRegistrationValidator implements Validator {

  public boolean supports(Class<?> arg0) {
    return UserRegistrationDTO.class.equals(arg0);
  }

  public void validate(Object obj, Errors error) {
    ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "username", "Username can't be empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "email", "Email can't be empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "password", "Password can't be empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(error, "confirmPassword", "confirmPassword", "Confirm Password can't be empty");
    
    UserRegistrationDTO user=(UserRegistrationDTO)obj;
    if(user.getConfirmPassword()!=null && !user.getConfirmPassword().equals(user.getPassword())){
        error.reject("confirmPassword","password doesn't match");
    }
    
  }

}
