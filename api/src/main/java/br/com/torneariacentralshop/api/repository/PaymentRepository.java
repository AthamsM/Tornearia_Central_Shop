package br.com.torneariacentralshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.torneariacentralshop.api.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{}
