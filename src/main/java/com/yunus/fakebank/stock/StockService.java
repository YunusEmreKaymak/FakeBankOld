package com.yunus.fakebank.stock;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository=stockRepository;
    }

    List<Stock> getStocks(){
        return stockRepository.findAll();
    }

    void addStock(Stock stock){
        if (stockRepository.existsById(stock.getStockId())){
            throw new IllegalStateException("Stock already exist on add");
        }else {
            stockRepository.save(stock);
        }
    }

    void deleteStock(Long id){
        if (stockRepository.existsById(id)){
            stockRepository.deleteById(id);
        }else {
            throw new IllegalStateException("Id not found on deleteStock");
        }
    }

    void updateStock(Long id, int value){
        Stock stockUpdate = stockRepository.findById(id).orElseThrow(() -> new IllegalStateException("Id not found on updateStock"));
        stockUpdate.setValue(value);
        stockRepository.save(stockUpdate);
    }
}
