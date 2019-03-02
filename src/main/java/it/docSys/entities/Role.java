package it.docSys.entities;

import it.docSys.configs.Roles;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Roles name;

    @ManyToMany(mappedBy = "roles")
    private Set<DocUser> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }

    public Set<DocUser> getUsers() {
        return users;
    }

    public void setUsers(Set<DocUser> users) {
        this.users = users;
    }
}