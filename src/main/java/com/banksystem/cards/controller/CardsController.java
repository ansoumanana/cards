package com.banksystem.cards.controller;

import com.banksystem.cards.model.Cards;
import com.banksystem.cards.model.Customer;
import com.banksystem.cards.repository.CardsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "cards")
public class CardsController {
    private static final Logger logger = LoggerFactory.getLogger(CardsController.class);
    private  final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping(value = "/card")
    public Optional<List<Cards>> findCustomerById(@RequestHeader("banksystem-correlation-id") String correlationId,@RequestBody Customer customer){

        return cardsRepository.findByCustomerId(customer.customerId());
    }


    @PostMapping("/myCards")
    public Optional<List<Cards>> getCardDetails(@RequestHeader("banksystem-correlation-id") String correlationId,@RequestBody Customer customer) {
        logger.info("Invoking getCardDetails method started");
        return cardsRepository.findByCustomerId( customer.customerId());


    }
}
