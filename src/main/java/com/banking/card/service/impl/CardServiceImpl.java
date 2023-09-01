package com.banking.card.service.impl;

import com.banking.card.enitity.Card;
import com.banking.card.repo.CardRepo;
import com.banking.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepo cardRepository;

    @Override
    public List<Card> getCardDetailsByCustomerId(String correlationId, Long customerId) {
        log.debug("correlationId : {}", correlationId);
        log.debug("inside card-service : fetching loan details for customerId: {}", customerId);
        try {
            Thread.sleep(3000);
            return cardRepository.findByCustomerId(customerId);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return cardRepository.findByCustomerId(customerId);
    }
}
