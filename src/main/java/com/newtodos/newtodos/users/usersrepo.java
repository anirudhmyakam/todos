package com.newtodos.newtodos.users;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class usersrepo {
    @PersistenceContext
    private EntityManager entitymanager;

    public void newuser(users user){
        entitymanager.merge(user);
    }
    
    public users findbyId(long userid){
        return entitymanager.find(users.class, userid);
    }

    public users findByUsername(String username){
        return entitymanager.find(users.class,username);
    }

    public void delete(long userid){
        users delusr = entitymanager.find(users.class, userid);
        entitymanager.remove(delusr);
    }
}
