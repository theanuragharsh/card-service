package com.banking.card.controller;

import java.util.List;

import com.banking.card.enitity.Card;
import com.banking.card.enitity.Customer;
import com.banking.card.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Anurag Harsh
 */

@RestController
public class CardController {

    @Autowired
    private CardRepo cardsRepository;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        List<Card> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }

    }

}
