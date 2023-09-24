package br.leonardo.Restaurante.controller;

import br.leonardo.Restaurante.dto.FuncionarioRequestDTO;
import br.leonardo.Restaurante.dto.FuncionarioResponseDTO;
import br.leonardo.Restaurante.model.Funcionario;
import br.leonardo.Restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<FuncionarioResponseDTO> getAllFuncionarios() {
        return funcionarioRepository.findAll().stream().map(FuncionarioResponseDTO::new).toList();
    }

    @PostMapping
    public void postFuncionario(@RequestBody FuncionarioRequestDTO data) {
        funcionarioRepository.save(new Funcionario(data));
    }

    @PutMapping("{id}")
    public void putFuncionario(@PathVariable Long id, @RequestBody FuncionarioRequestDTO data) {
        Funcionario f = new Funcionario(data);
        f.setId(id);
        funcionarioRepository.save(f);
    }

    @DeleteMapping("{id}")
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}
