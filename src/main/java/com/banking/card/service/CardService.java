package com.banking.card.service;

import com.banking.card.enitity.Card;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface CardService {
     List<Card> getCardDetailsByCustomerId(@RequestHeader("correlation-id") String correlationId, @PathVariable Long customerId);
}
