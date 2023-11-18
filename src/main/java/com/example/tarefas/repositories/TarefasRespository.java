package com.example.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarefas.entities.Tarefas;

public interface TarefasRespository extends JpaRepository<Tarefas, String>{
    
}
