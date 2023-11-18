package com.example.tarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.example.tarefas.DTO.CreateTarefaDTO;
import com.example.tarefas.DTO.DeleteTarefaDTO;
import com.example.tarefas.DTO.UpdateTarefaDTO;
import com.example.tarefas.services.TarefasService;

@RestController
@CrossOrigin
@RequestMapping("tarefa")
public class TarefasController {

    @Autowired
    private TarefasService tarefaService;

    @PostMapping("/create")
    public ResponseEntity criarTarefa(@RequestBody @Valid CreateTarefaDTO tarefa){
        
        return ResponseEntity.ok(tarefaService.adicionarTarerfa(tarefa));
    }

    @GetMapping("/readAll")
    public ResponseEntity findAll(){
        return  ResponseEntity.ok(tarefaService.getTarefa());
    }


    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody DeleteTarefaDTO id){
        return  ResponseEntity.ok(tarefaService.deleteTarefa(id));                                                                                                                                                                                       
    }


    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UpdateTarefaDTO tarefa){
        return  ResponseEntity.ok(tarefaService.UpdateTarefa(tarefa));
    }


}
