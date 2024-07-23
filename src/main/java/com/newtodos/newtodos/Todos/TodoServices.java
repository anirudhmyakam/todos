package com.newtodos.newtodos.Todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newtodos.newtodos.Jpadatahandler.jparepo;

@Component
public class TodoServices {

    @Autowired
    private jparepo jpadata;

    static Long idcounter=4l;

    public Todo savetodo(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idcounter);
            jpadata.insert(todo);
        }
        else{
            jpadata.delete(todo.getId());
            jpadata.insert(todo);
        }
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = jpadata.findbyId(id);
        if(todo==null){
            return null;
        }
        jpadata.delete(id);
        return todo;
    }

    public Todo findById(long id){
        return jpadata.findbyId(id);
    }

    public List<Todo> findall(){
        return jpadata.findall();
    }
    
}
