package br.com.cds.connecta.framework.core.security;

public interface IAuthService {

    boolean validateToken(String token);
    boolean validatePublicKey(String publicKey, String viewerId);
    boolean validatePublicKeyDash(String publicKey, String dashId);

}
