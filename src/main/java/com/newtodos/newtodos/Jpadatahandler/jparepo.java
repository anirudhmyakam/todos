package com.newtodos.newtodos.Jpadatahandler;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.newtodos.newtodos.Todos.Todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class jparepo {
    // we could even use autowired but this is more specific to our use
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Todo todo){
        entityManager.merge(todo);
    }

    public Todo findbyId(long id){
        return entityManager.find(Todo.class, id);
    }

    public void delete(long id){
        Todo deltodo = entityManager.find(Todo.class, id);
        entityManager.remove(deltodo);
    }

    public List<Todo> findall(){
        TypedQuery<Todo> query = entityManager.createQuery("SELECT e FROM Todo e", Todo.class);
        return query.getResultList();
    }
}