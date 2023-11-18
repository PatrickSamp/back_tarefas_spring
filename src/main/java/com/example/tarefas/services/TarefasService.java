package com.example.tarefas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.tarefas.DTO.CreateTarefaDTO;
import com.example.tarefas.DTO.DeleteTarefaDTO;
import com.example.tarefas.DTO.UpdateTarefaDTO;
import com.example.tarefas.entities.Tarefas;
import com.example.tarefas.repositories.TarefasRespository;


@Service
public class TarefasService {
    

    @Autowired
    TarefasRespository tarefasRespository;


    public Tarefas adicionarTarerfa(CreateTarefaDTO tarefa){
        Tarefas newTarefa = new Tarefas(tarefa);
        return tarefasRespository.save(newTarefa);
    }

    public Iterable<Tarefas> getTarefa(){
        return tarefasRespository.findAll();
    }

    public Tarefas deleteTarefa(DeleteTarefaDTO id){
        Tarefas tarefa = tarefasRespository.findById(id.getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não Encontrado!"));
        tarefasRespository.deleteById(id.getId());
        return tarefa;
    }

    public Tarefas UpdateTarefa(UpdateTarefaDTO tarefas){
        Tarefas tarefa = tarefasRespository.findById(tarefas.getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não Encontrado!"));

       tarefa.setTarefa(tarefas.getTarefa());

       return tarefasRespository.save(tarefa);
    }
}
