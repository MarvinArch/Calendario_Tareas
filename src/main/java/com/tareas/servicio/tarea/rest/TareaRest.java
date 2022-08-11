package com.tareas.servicio.tarea.rest;

import com.tareas.servicio.tarea.model.Tarea;
import com.tareas.servicio.tarea.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tarea/")
public class TareaRest {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping
    private ResponseEntity<List<Tarea>> getAllTarea(){
        return ResponseEntity.ok(tareaRepository.findAll());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    private Tarea create(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping("{id}")
    private Tarea update(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaFromUpdate = tareaRepository.findById(id).orElseThrow(RuntimeException::new);
        tareaFromUpdate.setName(tarea.getName());
        tareaFromUpdate.setComplete(tarea.isComplete());
        tareaFromUpdate.setDateDelivery(tarea.getDateDelivery());
        return tareaRepository.save(tareaFromUpdate);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        Tarea tareaDelete = tareaRepository.findById(id).orElseThrow(RuntimeException::new);
        tareaRepository.delete(tareaDelete);
    }

}
