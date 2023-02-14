package mx.edu.utez.shop.services;


import mx.edu.utez.shop.model.Product;
import mx.edu.utez.shop.model.Transaction;
import mx.edu.utez.shop.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> listTransaction(){
        return  transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(int idTransaction){
        return transactionRepository.findById(idTransaction);
    }

    public  void save(Transaction torre){
        transactionRepository.save(torre);
    }

    public void deleteTransaction(int idTransaction){
        transactionRepository.deleteById(idTransaction);
    }

    public boolean existsByIdTransaction(int idTransaction){
        return transactionRepository.existsById(idTransaction);
    }

}
