package com.lanzarotdev.app.rest.Controller;

import com.lanzarotdev.app.rest.Model.Task;
import com.lanzarotdev.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo(){
        return "Hola Mundo!!!";
    }

    // obtener tareas
    @GetMapping(value= "/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    // agregar y colocar una nueva task
    @PostMapping(value="/savetask")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "saved task";
    }

    // para editar y actualizar dependiendo del id que envie
    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask = todoRepository.findById(id).get(); // la variable updatedTask de tipo Task va a buscar en el almacenamiento y obtener el cuerpo por el id enviado
        updatedTask.setTitle(task.getTitle()); // seteo nuevo titulo
        updatedTask.setDescription(task.getDescription()); // seteo nueva descripción obteniendo primero la descripción que quiero editar
        todoRepository.save(updatedTask);
        return "Updated Task";
    }

    @DeleteMapping(value="delete/{id}")
    public String deleteTask(@PathVariable long id) {
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "Deleted Task";
    }

}
