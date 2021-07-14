package ch.bbcag.jakarta.ttbank.service;

import ch.bbcag.jakarta.ttbank.common.RandomStringGenerator;
import ch.bbcag.jakarta.ttbank.exception.EmailAlreadyExistsException;
import ch.bbcag.jakarta.ttbank.model.MoneyAccount;
import ch.bbcag.jakarta.ttbank.model.Transaction;
import ch.bbcag.jakarta.ttbank.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

public class MoneyAccountService {


    @PersistenceContext
    private static EntityManager em;

    public static MoneyAccount register(User user, String name, float zero, Set<Transaction> transactionsSend, Set<Transaction> transactionsReceive ){
        MoneyAccount moneyAccountSameEmail = em.find(MoneyAccount.class, user.getEmail());

        if(moneyAccountSameEmail != null){
            throw new EmailAlreadyExistsException();
        }

        MoneyAccount newMoneyAccount = new MoneyAccount();

        newMoneyAccount.setId(RandomStringGenerator.getRandomString(32));
        newMoneyAccount.setName(name);
        newMoneyAccount.setBalance(zero);
        newMoneyAccount.setTransactionsSend(transactionsSend);
        newMoneyAccount.setTransactionsReceive(transactionsReceive);

        em.persist(newMoneyAccount);

        return newMoneyAccount;
    }

    public static void updateCapitalAfterTransaction(MoneyAccount sender, MoneyAccount receiver, Float amount){
        debitTransaction(sender, amount);
        creditTransaction(receiver, amount);
    }

    private static void debitTransaction(MoneyAccount sender, float amount){
        float balanceCalculated = sender.getBalance() - amount;
        sender.setBalance(balanceCalculated);
    }

    private static void creditTransaction(MoneyAccount receiver, float amount){
        float balanceCalculated = receiver.getBalance() - amount;
        receiver.setBalance(balanceCalculated);
    }
}
