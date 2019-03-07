package it.docSys.configs;


import it.docSys.entities.DocUser;
import it.docSys.entities.Role;
import it.docSys.enums.Roles;
import it.docSys.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDBLoader {

    // REPOSITORIES
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void load2UsersToDB(int docUsers, int roles) {
        final int numOfUsers = docUsers;
        final int numOfRoles = roles;



        createRoles(numOfRoles);

        addUsers(numOfUsers);

    }

    @Transactional
    public void createRoles(int numOfRoles) {
        roleRepository.save(new Role(Roles.ROLE_ADMIN.name()));
        roleRepository.save(new Role(Roles.ROLE_USER.name()));
    }


    @Transactional
    public void addUsers(int numOfUsers) {
        List<DocUser> users = new ArrayList<>();
        String adminRole = roleRepository.findByName(Roles.ROLE_ADMIN.name()).orElseThrow(
                () -> new NullPointerException("We do not have any Admins yet")
        );
        String userRole = roleRepository.findByName(Roles.ROLE_USER.name()).orElseThrow(
                () -> new NullPointerException("We do not have any Users")
        );


//        userRepository.saveAll(users);

        // Add simpleUser

        for (int i = 1; i <= numOfUsers; i++ ) {
            DocUser user = new DocUser();
            user.setUserName("user");
            user.setPassword(bCryptPasswordEncoder.encode("password"));
            user.setFirstName("ufirstname");
            user.setLastName("ulastname");
            user.setRoles(Roles.ROLE_USER.name());
            users.add(user);
            userRepository.save(user);
//        userRepository.saveAll(users);
        }

        // Add admin


        DocUser user = new DocUser();
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("apassword"));
        user.setFirstName("afirstname");
        user.setLastName("alastname");
        user.setRoles(Roles.ROLE_ADMIN.name());
        users.add(user);
        userRepository.save(user);
    }
    }



