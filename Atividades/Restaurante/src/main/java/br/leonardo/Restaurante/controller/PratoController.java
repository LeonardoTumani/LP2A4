package br.leonardo.Restaurante.controller;

import br.leonardo.Restaurante.dto.PratoRequestDTO;
import br.leonardo.Restaurante.dto.PratoResponseDTO;
import br.leonardo.Restaurante.model.Prato;
import br.leonardo.Restaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prato")
public class PratoController {
    @Autowired
    PratoRepository pratoRepository;

    @GetMapping
    public List<PratoResponseDTO> getAllPratos() {
        return pratoRepository.findAll().stream().map(PratoResponseDTO::new).toList();
    }

    @PostMapping
    public void postPrato(@RequestBody PratoRequestDTO data) {
        pratoRepository.save(new Prato(data));
    }

    @PutMapping("{id}")
    public void putPrato(@PathVariable Long id, @RequestBody PratoRequestDTO data) {
        Prato p = new Prato(data);
        p.setId(id);
        pratoRepository.save(p);
    }

    @DeleteMapping("{id}")
    public void deletePrato(@PathVariable Long id) {
        pratoRepository.deleteById(id);
    }
}
