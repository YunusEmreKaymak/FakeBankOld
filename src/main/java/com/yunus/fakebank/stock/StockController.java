package com.yunus.fakebank.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;
    @GetMapping
    public List<Stock> getStocks(){
        return stockService.getStocks();
    }
    @PostMapping
    public void addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
    }
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable("id") Long id){
        stockService.deleteStock(id);
    }
    @PutMapping("/{id}/{value}")
    public void updateStock(@PathVariable("id") Long id, @PathVariable("value") int value){
        stockService.updateStock(id, value);
    }

}
