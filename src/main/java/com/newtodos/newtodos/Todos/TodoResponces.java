package com.newtodos.newtodos.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
// import java.util.Date;
import java.util.List;

import com.newtodos.newtodos.users.userlogin;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResponces {
    @Autowired
    private TodoServices todoService;


    // for getting all the todos
    @GetMapping(path = "/user/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username){
        return todoService.findall();
    }

    
    @GetMapping(path="/hello-world")
    public String hellowrld(){
        return "hello world";
    }


    // for getting a singlge todo based on id
    @GetMapping(path = "/user/{username}/todos/{id}")
    public Todo getTodobyid(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);
    }

    // for deleting todo
    @DeleteMapping(path = "/user/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    // for updating todo
    @PutMapping(path = "/user/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo todoUpdated = todoService.savetodo(todo);
        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
    }

    // , @RequestBody Todo todo
    @PostMapping(path = "/user/{username}/todos")
    public ResponseEntity<Void> addTodo(@PathVariable String username , @RequestBody Todo todo){
        // Todo todocreated = todoService.savetodo(new Todo(-1, "anirudh", "added", new Date(), false));
        Todo todocreated = todoService.savetodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todocreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
