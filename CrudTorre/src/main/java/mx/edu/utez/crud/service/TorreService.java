package mx.edu.utez.crud.service;

import mx.edu.utez.crud.entity.Torre;
import mx.edu.utez.crud.repository.TorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorreService {

    @Autowired
    TorreRepository torreRepository;

    public List<Torre> listaTorre(){
        return  torreRepository.findAll();
    }

    public Optional<Torre> getTorre(int idTorre){
        return torreRepository.findById(idTorre);
    }

    public Optional<Torre> getByNombreTorre(String nombre){
        return torreRepository.findByNombreTorre(nombre);
    }

    public  void save(Torre torre){
        torreRepository.save(torre);
    }

    public void deleteTorre(int idTorre){
        torreRepository.deleteById(idTorre);
    }

    public boolean existsByIdTorre(int idTorre){
        return torreRepository.existsById(idTorre);
    }

    public boolean existsByNombreTorre(String nombreTorre){
        return torreRepository.existsByNombreTorre(nombreTorre);
    }
}
