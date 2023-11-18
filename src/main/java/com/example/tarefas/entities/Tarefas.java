package com.example.tarefas.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.tarefas.DTO.CreateTarefaDTO;
import com.example.tarefas.DTO.UpdateTarefaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarefas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String tarefa;

    @CreationTimestamp
    private LocalDate dataCriacao;

    @CreationTimestamp
    private LocalTime horaCriacao;

    public Tarefas(CreateTarefaDTO tarefa){
        this.tarefa = tarefa.getTarefa();
    }

    public Tarefas(UpdateTarefaDTO tarefa){
        this.id = tarefa.getId();
    }


}
