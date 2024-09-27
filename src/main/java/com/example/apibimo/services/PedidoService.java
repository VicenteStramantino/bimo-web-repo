package com.example.apibimo.services;

import com.example.apibimo.models.Pedido;
import com.example.apibimo.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Método para buscar todos os pedidos
    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    // Método para buscar pedido por ID
    public Pedido buscarPedidoPorID(int id) {
        return pedidoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pedido não encontrado"));
    }

    // Método para inserir novo pedido
    public ResponseEntity<String> inserirPedido(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
        return ResponseEntity.ok("Pedido inserido com sucesso");
    }

    // Método para deletar pedidos por ID (array de IDs)
    public ResponseEntity<String> deletarPedidos(@PathVariable int[] ids) {
        for (int id : ids) {
            pedidoRepository.deleteById(id);
        }
        return ResponseEntity.ok("Pedido(s) deletado(s) com sucesso");
    }

    // Método para atualizar um pedido
    public ResponseEntity<String> atualizarPedido(@PathVariable Integer id, @RequestBody Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setfValorTotal(pedidoAtualizado.getfValorTotal());
            pedido.setdData(pedidoAtualizado.getdData());
            pedido.setcStatus(pedidoAtualizado.getcStatus());
            pedido.setcTipoPagamento(pedidoAtualizado.getcTipoPagamento());
            pedidoRepository.save(pedido);
            return ResponseEntity.ok("Pedido atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
