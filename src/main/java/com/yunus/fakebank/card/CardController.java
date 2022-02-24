package com.yunus.fakebank.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @GetMapping
    public List<Card> getCards(){
        return cardService.getCards();
    }
    @PostMapping
    public void addCard(@RequestBody Card card){
        cardService.addCard(card);
    }
    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable("id") Long id){
        cardService.deleteCard(id);
    }
    @PutMapping("/{id}/{password}")
    public void updateCard(@PathVariable("id") Long id, @PathVariable("password") String password){
        cardService.updateCard(id, password);
    }
}
