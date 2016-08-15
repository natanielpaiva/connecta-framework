package br.com.cds.connecta.framework.core.security;

public interface IAuthService {

    boolean validateToken(String token);

}
