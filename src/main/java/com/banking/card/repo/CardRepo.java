package com.banking.card.repo;

import com.banking.card.enitity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepo extends CrudRepository<Card, Long> {
    List<Card> findByCustomerId(int customerId);
}
