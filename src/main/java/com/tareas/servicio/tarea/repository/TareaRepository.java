package com.tareas.servicio.tarea.repository;

import com.tareas.servicio.tarea.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
