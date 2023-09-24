package br.leonardo.Restaurante.controller;

import br.leonardo.Restaurante.dto.EnderecoRequestDTO;
import br.leonardo.Restaurante.dto.EnderecoResponseDTO;
import br.leonardo.Restaurante.model.Endereco;
import br.leonardo.Restaurante.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public List<EnderecoResponseDTO> getAllEnderecos() {
        return enderecoRepository.findAll().stream().map(EnderecoResponseDTO::new).toList();
    }

    @PostMapping
    public void postEndereco(@RequestBody EnderecoRequestDTO data) {
        enderecoRepository.save(new Endereco(data));
    }

    @PutMapping("{id}")
    public void putEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO data) {
        Endereco e = new Endereco(data);
        e.setId(id);
        enderecoRepository.save(e);
    }

    @DeleteMapping("{id}")
    public void deleteEndereco(@PathVariable Long id) {
        enderecoRepository.deleteById(id);
    }
}

