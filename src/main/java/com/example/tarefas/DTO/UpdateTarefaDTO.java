package com.example.tarefas.DTO;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTarefaDTO {
    private String id;

    private String tarefa;
}
