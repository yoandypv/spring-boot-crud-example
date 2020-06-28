package com.yoandypv.ejemplos.springcrud.service;

import com.yoandypv.ejemplos.springcrud.entities.Auto;

import java.util.Optional;

public interface IAutoService {
     Auto crear(Auto auto);
     Optional<Auto> obtenerPorId(Long id);
     Auto actualizar(Long id, double nuevoPrecio);
     boolean eliminar(Long id);
}
