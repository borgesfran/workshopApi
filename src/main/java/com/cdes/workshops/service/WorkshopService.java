package com.cdes.workshops.service;

import com.cdes.workshops.exception.ServiceException;
import com.cdes.workshops.model.Workshop;
import com.cdes.workshops.repository.WorkshopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkshopService {

    private final WorkshopRepository workshopRepository;

    public Workshop salvar(Workshop workshop){
        verificaWorkshop(workshop.getNome());
        return workshopRepository.save(workshop);
    }

    public Workshop alterar(Workshop workshop){
        if(workshop.getId()==null){
            throw new ServiceException("Id do Workshop não informado");
        }
        return workshopRepository.findById(workshop.getId()).map(wkSalvo->{
            if(!workshop.getNome().equals(wkSalvo.getNome())) verificaWorkshop(workshop.getNome());

            return workshopRepository.save(workshop);
        }).orElseThrow(()->new ServiceException("Workshop com o id "+workshop.getId()+" inexistente"));
    }

    public Workshop buscarPorId(Long id){
        return workshopRepository.findById(id).orElseThrow(()->new ServiceException("Workshop com o id "+id+" inexistente"));
    }

    public  Workshop buscaPorNome(String nome){
        return workshopRepository.findByNome(nome).orElseThrow(()->new ServiceException("Workshop com o nome "+nome+" inexistente"));
    }

    private void verificaWorkshop(String wkNome){
        if (workshopRepository.findByNome(wkNome).isPresent()) {

            throw new ServiceException("Workshop já cadastrado");
        }
    }
}
