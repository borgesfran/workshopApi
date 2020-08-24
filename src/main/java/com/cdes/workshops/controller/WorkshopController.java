package com.cdes.workshops.controller;

import com.cdes.workshops.model.Workshop;
import com.cdes.workshops.repository.WorkshopRepository;
import com.cdes.workshops.service.WorkshopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import static org.springframework.http.ResponseEntity.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
@Api(value="Workshops")
@CrossOrigin(origins = "*")
public class WorkshopController {

    private final WorkshopService workshopService;
    private  final WorkshopRepository workshopRepository;

    @GetMapping("/workshops")
    @ApiOperation(value = "Retorna os workshops cadastrados")
    public ResponseEntity<List<Workshop>> buscarTodos(){
        List<Workshop>workshopsCadastrados = workshopRepository.findAll();

        if(workshopsCadastrados.isEmpty()){
            return noContent().build();
        }else {
            return ok(workshopsCadastrados);
        }

    }

    @GetMapping("/workshopId/{id}")
    @ApiOperation(value = "Busca workshop por id")
    public ResponseEntity<Workshop> buscaPorId(@PathVariable Long id){return ok(workshopService.buscarPorId(id));}

    @GetMapping("/workshopNome/{nome}")
    @ApiOperation(value = "Busca workshop por nome")
    public ResponseEntity<Workshop>buscaPorNome(@PathVariable String nome){return  ok(workshopService.buscaPorNome(nome));}

    @PostMapping("/workshop")
    @ApiOperation(value = "Cadastra um novo workshop")
    public ResponseEntity<Workshop>cadastrar(@Valid @RequestBody Workshop workshop){
        Workshop novo = workshopService.salvar(workshop);
        return new ResponseEntity<>(novo,HttpStatus.CREATED);
    }

    @PutMapping("/workshopUp/{id}")
    @ApiOperation(value = "Atualiza um workshop")
    public ResponseEntity<Workshop>atualizar(@Valid @RequestBody Workshop workshop){
        Workshop wkAtulaizado = workshopService.alterar(workshop);
        return new ResponseEntity<>(wkAtulaizado,HttpStatus.CREATED);
    }

    @DeleteMapping("/workshop/{id}")
    @ApiOperation(value = "Deleta um workshop cadastrado")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        workshopRepository.delete(workshopService.buscarPorId(id));
        return noContent().build();
    }
}
