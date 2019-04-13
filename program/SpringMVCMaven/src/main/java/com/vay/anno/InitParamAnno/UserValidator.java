package com.vay.anno.InitParamAnno;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        boolean a = User.class.equals(aClass);
        return a;
    }

    public void validate(Object o, Errors errors) {
        User user = (User)o;
        if(user.getUserName().length() < 8){
            errors.rejectValue("userName", "valid.userName", new Object[]{"minLenth", 8}, "用户名不得小于{1}位");
        }
    }
}
