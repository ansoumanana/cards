package com.banksystem.cards.controller;

import com.banksystem.cards.model.Cards;
import com.banksystem.cards.model.Customer;
import com.banksystem.cards.repository.CardsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "cards")
public class CardsController {

    private  final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping(value = "/card")
    public Optional<List<Cards>> findCustomerById(@RequestBody Customer customer){

        return cardsRepository.findByCustomerId(customer.customerId());
    }


    @PostMapping("/myCards")
    public Optional<List<Cards>>getCardDetails(@RequestBody Customer customer) {
        return cardsRepository.findByCustomerId(customer.customerId());


    }
}
