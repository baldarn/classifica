package eu.baldarn.classifica.services;

import eu.baldarn.classifica.model.User;

public interface MailService {
	
	public void registra(User user);
    public void recuperaPassword(User user);
}
