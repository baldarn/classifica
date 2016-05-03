package eu.baldarn.classifica.services;

public interface RecaptchaService {

    boolean isResponseValid(String remoteIp, String response);
}
