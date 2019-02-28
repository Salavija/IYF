package it.docSys.services;

import it.docSys.entities.DocUser;

public interface UserServiceInt {
    void save(DocUser user);

    DocUser findByUserName(String username);
}