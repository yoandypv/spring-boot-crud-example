package com.yoandypv.ejemplos.springcrud.service;

import com.yoandypv.ejemplos.springcrud.entities.Auto;
import com.yoandypv.ejemplos.springcrud.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IAutoServiceImpl implements IAutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public Auto crear(Auto auto) {
        return this.autoRepository.save(auto);
    }

    @Override
    public Optional<Auto> obtenerPorId(Long id) {
        return this.autoRepository.findById(id);
    }

    @Override
    public Auto actualizar(Long id, double nuevoPrecio) {
        Optional<Auto> auto = this.autoRepository.findById(id);
        if (auto.isPresent()) {
           Auto tmp = auto.get();
           tmp.setPrecio(nuevoPrecio);
           return crear(tmp);
        }
        return null;
    }

    @Override
    public boolean eliminar(Long id) {
        this.autoRepository.deleteById(id);
        return true;
    }
}
