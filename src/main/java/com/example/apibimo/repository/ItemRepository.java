package com.example.apibimo.repository;
import com.example.apibimo.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemPedido, Integer> {
}
