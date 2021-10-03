package com.example.demo.services;
import com.example.demo.entities.Type;
import com.example.demo.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service(value = "typeService")
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public void addNewType(Type type) {
        Optional<Type> typeOptional = typeRepository.findTypeByCode(type.getCode());
        if (typeOptional.isPresent()){
            throw new IllegalStateException("Type already exists");
        }
        typeRepository.save(type);
    }


    public void deleteType(Long typeId) {
        typeRepository.findById(typeId);
        boolean exists= typeRepository.existsById(typeId);
        if(!exists){
            throw new IllegalStateException("Type indicateur avec type " + typeId + " n existe pas.");
        }
        typeRepository.deleteById(typeId);
    }

    @Transactional
    public void updateType(Long typeId, Type typeUpdate) {
        Type type = typeRepository.findById(typeId).orElseThrow(()-> new IllegalStateException(
                "type with id " + typeId + " does not exist"));

        if (typeUpdate.getDesignation()!=null &&
                typeUpdate.getDesignation().toString().length() > 0 &&
                !Objects.equals(type.getDesignation(), typeUpdate.getDesignation())){
            type.setDesignation(typeUpdate.getDesignation());
        }
    }

}
