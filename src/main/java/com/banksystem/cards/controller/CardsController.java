package com.banksystem.cards.controller;

import com.banksystem.cards.model.Cards;
import com.banksystem.cards.model.Customer;
import com.banksystem.cards.repository.CardsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "cards")
public class CardsController {

    private  final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping
    public Optional<List<Cards>> findByCustomerId(@RequestBody Customer customer){

        return cardsRepository.findByCustomerId(customer.customerId());
    }
}
