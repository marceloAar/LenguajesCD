package cl.mar.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.lenguajes.models.Lenguaje;
import cl.mar.lenguajes.repositories.LenguajeRepository;

@Service
public class LenguajeService {
	
    @Autowired
    LenguajeRepository lenguajeRepo;
    
    //busca todos los lenguajes
    public List<Lenguaje> todosLenguajes() {
        return (List<Lenguaje>) lenguajeRepo.findAll();
    }
    
    //crea un lenguaje
    public Lenguaje crearLenguaje(Lenguaje len) {
        return lenguajeRepo.save(len);
    }
    
    //busca un lenguaje por su id
    public Lenguaje buscaUnLenguaje(Long id) {
        Optional<Lenguaje> optionalLen = lenguajeRepo.findById(id);
        
        if(optionalLen.isPresent()) {
            return optionalLen.get();
        } else {
            return null;
        }
    }	
       
    //borra un lenguaje por su id    
    public void borraLenguaje(Long id) {
    	lenguajeRepo.deleteById(id);
    }
}