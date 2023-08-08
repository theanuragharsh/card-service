package com.banking.card.controller;

import com.banking.card.config.CardServiceConfig;
import com.banking.card.enitity.Card;
import com.banking.card.enitity.Customer;
import com.banking.card.enitity.Properties;
import com.banking.card.repo.CardRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Anurag Harsh
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/card-service")
public class CardController {

    private final CardRepo cardsRepository;
    private final CardServiceConfig cardServiceConfig;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        List<Card> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            log.info(String.format("Inside Card-Service : %s", cards.toString()));
            return cards;
        } else {
            return null;
        }

    }

    @GetMapping("/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardServiceConfig.getMsg(), cardServiceConfig.getBuildVersion(), cardServiceConfig.getMailDetails(), cardServiceConfig.getActiveBranches());
        String jsonProperties = objectWriter.writeValueAsString(properties);
        return jsonProperties;
    }
}
