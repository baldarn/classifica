package eu.baldarn.classifica.services.utils;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class RecaptchaForm {

	@NotEmpty
	private String recaptcha;

	public String getRecaptcha() {
		return recaptcha;
	}

	public void setRecaptcha(String recaptcha) {
		this.recaptcha = recaptcha;
	}
}