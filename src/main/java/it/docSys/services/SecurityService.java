package it.docSys.services;

public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String username, String password);
}

