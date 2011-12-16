package com.example.jsfdemo.domain.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="peselValidator")
public class PeselValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String pesel = (String)arg2;
		/*if(!email.contains("@")) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Email is not valid.");
            message.setDetail("Email is not valid.");
            context.addMessage("userForm:Email", message);
            throw new ValidatorException(message);
        }*/
		FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
		int psize = pesel.length();
        if (psize != 11) {
        	message.setSummary("Pesel must contain 11 characters.");
            message.setDetail("Pesel must contain 11 characters.");
            //arg0.addMessage("userForm:Email", message);
            throw new ValidatorException(message);
        }
        int[] weights = {1,3,7,9,1,3,7,9,1,3};
        int j = 0, sum = 0, control = 0;
        int csum = new Integer(pesel.substring(psize - 1)).intValue();
        for (int i = 0; i < psize - 1; i++) {
            char c = pesel.charAt(i);
            j = new Integer(String.valueOf(c)).intValue();
            sum += j * weights[i];
        }
        control = 10 - (sum % 10);
        if (control == 10) {
            control = 0;
        }
        if (control != csum)
        {
        	message.setSummary("Not a valid pesel.");
            message.setDetail("Not a valid pesel.");
            //arg0.addMessage("userForm:Email", message);
            throw new ValidatorException(message);
        }
	}

}
