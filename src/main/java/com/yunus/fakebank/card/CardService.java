package com.yunus.fakebank.card;

import com.sun.nio.sctp.IllegalReceiveException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    CardRepository cardRepository;

    public CardService(CardRepository cardRepository){
        this.cardRepository=cardRepository;
    }

    List<Card> getCards(){
        return cardRepository.findAll();
    }

    void deleteCard(Long cardNumber){
        cardRepository.deleteById(cardNumber);
    }

    void addCard(Card card){
        if (cardRepository.existsById(card.getAccountId())){
            throw new IllegalStateException("ERROR: Card already exist");
        }else {
            cardRepository.save(card);
        }
    }

    void updateCard(Long id, String password){
        Card cardUpdate = cardRepository.findById(id).orElseThrow(() -> new IllegalStateException("Card Not found on update"));
        cardUpdate.setPassword(password);
        cardRepository.save(cardUpdate);
    }
}
