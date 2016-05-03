package eu.baldarn.classifica.services.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

import eu.baldarn.classifica.services.RecaptchaService;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RecaptchaFormValidator implements Validator {

    private static final String ERROR_RECAPTCHA_INVALID = "recaptcha.error.invalid";
    private static final String ERROR_RECAPTCHA_UNAVAILABLE = "recaptcha.error.unavailable";
    private final HttpServletRequest httpServletRequest;
    private final RecaptchaService recaptchaService;

    @Autowired
    public RecaptchaFormValidator(HttpServletRequest httpServletRequest, RecaptchaService recaptchaService) {
        this.httpServletRequest = httpServletRequest;
        this.recaptchaService = recaptchaService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RecaptchaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RecaptchaForm form = (RecaptchaForm) target;
        try {
            if (form.getRecaptcha() != null
                    && !form.getRecaptcha().isEmpty()
                    && !recaptchaService.isResponseValid(httpServletRequest.getRemoteAddr(), form.getRecaptcha())) {
                errors.reject(ERROR_RECAPTCHA_INVALID);
                errors.rejectValue("recaptchaResponse", ERROR_RECAPTCHA_INVALID);
            }
        } catch (RecaptchaServiceException e) {
            errors.reject(ERROR_RECAPTCHA_UNAVAILABLE);
        }
    }    
}