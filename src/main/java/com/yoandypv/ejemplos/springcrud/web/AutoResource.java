package com.yoandypv.ejemplos.springcrud.web;

import com.yoandypv.ejemplos.springcrud.entities.Auto;
import com.yoandypv.ejemplos.springcrud.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AutoResource {

    @Autowired
    private IAutoService autoService;

    @PostMapping("autos")
    public ResponseEntity<Auto> crearAuto(@RequestBody Auto auto) {
        return new ResponseEntity(this.autoService.crear(auto), HttpStatus.CREATED);
    }

    @GetMapping("/autos/{id}")
    public ResponseEntity<Auto> obtenerAuto(@PathVariable("id") Long id) {
        Optional<Auto> optionalAuto = this.autoService.obtenerPorId(id);
        if (optionalAuto.isPresent())
            return new ResponseEntity(optionalAuto.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/autos/{id}/nuevoprecio/{precio}")
    public ResponseEntity<Auto> actualizarAuto(@PathVariable("id") Long id, @PathVariable("precio") double precio) {
        Auto autoActualizado = this.autoService.actualizar(id, precio);
        if (autoActualizado != null) {
            return new ResponseEntity(autoActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/autos/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable("id") Long id) {
        this.autoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
