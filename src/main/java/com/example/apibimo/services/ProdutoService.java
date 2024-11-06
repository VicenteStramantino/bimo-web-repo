package com.example.apibimo.services;

import com.example.apibimo.models.Produto;
import com.example.apibimo.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorID(int id) {
        return produtoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto nao encontrado"));
    }

    public ResponseEntity<String> inserirProdutos(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto inserido com sucesso");
    }

    public ResponseEntity<String> deletar(@PathVariable int[] id) {
        for(int i = 0; i < id.length; i++) {
            produtoRepository.deleteById(id[i]);
        }
        return ResponseEntity.ok("Produto/s deletado com sucesso");
    }


    public ResponseEntity<String> atualiza(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setcNome(produtoAtualizado.getcNome());
            produto.setcDescricao(produtoAtualizado.getcDescricao());
            produto.setFvalor(produtoAtualizado.getFvalor());
            produto.setIdCategoria(produtoAtualizado.getIdCategoria());
            produto.setcEstado(produtoAtualizado.cEstado);
            produto.setCimgfirebase(produtoAtualizado.getCimgfirebase());
            produtoRepository.save(produto);
            return ResponseEntity.ok("Produto atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
