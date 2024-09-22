package com.example.apibimo.services;

import com.example.apibimo.models.ItemPedido;
import com.example.apibimo.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemPedidoRepository;

    public ItemService(ItemRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    // Método para buscar todos os itens de pedido
    public List<ItemPedido> buscarTodosItensPedido() {
        return itemPedidoRepository.findAll();
    }

    // Método para buscar item de pedido por ID
    public ItemPedido buscarItemPedidoPorID(int id) {
        return itemPedidoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Item de pedido não encontrado"));
    }

    // Método para inserir novo item de pedido
    public ResponseEntity<String> inserirItemPedido(@RequestBody ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
        return ResponseEntity.ok("Item de pedido inserido com sucesso");
    }

    // Método para deletar itens de pedido por ID (array de IDs)
    public ResponseEntity<String> deletarItensPedido(@PathVariable int[] ids) {
        for (int id : ids) {
            itemPedidoRepository.deleteById(id);
        }
        return ResponseEntity.ok("Item(ns) de pedido deletado(s) com sucesso");
    }

    // Método para atualizar um item de pedido
    public ResponseEntity<String> atualizarItemPedido(@PathVariable Integer id, @RequestBody ItemPedido itemPedidoAtualizado) {
        Optional<ItemPedido> itemPedidoExistente = itemPedidoRepository.findById(id);
        if (itemPedidoExistente.isPresent()) {
            ItemPedido itemPedido = itemPedidoExistente.get();
            itemPedido.setiQuantidade(itemPedidoAtualizado.getiQuantidade());
            itemPedido.setfValor(itemPedidoAtualizado.getfValor());
            itemPedido.setIdPedido(itemPedidoAtualizado.getIdPedido());
            itemPedido.setIdProduto(itemPedidoAtualizado.getIdProduto());
            itemPedido.setTransactionMade(itemPedidoAtualizado.isTransactionMade());
            itemPedidoRepository.save(itemPedido);
            return ResponseEntity.ok("Item de pedido atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
