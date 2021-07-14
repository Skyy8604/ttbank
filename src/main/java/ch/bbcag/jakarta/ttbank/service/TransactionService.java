package ch.bbcag.jakarta.ttbank.service;

import ch.bbcag.jakarta.ttbank.model.MoneyAccount;
import ch.bbcag.jakarta.ttbank.model.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;

@Stateless
public class TransactionService {

    @PersistenceContext
    private EntityManager em;

    public Transaction createTransaction(
            String trxID,
            MoneyAccount sender_account_id,
            MoneyAccount receiver_account_id,
            Timestamp datetime,
            Float amount
            ) {
        Transaction newTransaction = new Transaction();

        newTransaction.setId(trxID);
        newTransaction.setSenderAccountId(sender_account_id);
        newTransaction.setReceiverAccountId(receiver_account_id);
        newTransaction.setAmount(amount);
        newTransaction.setDateTime(datetime);

        em.persist(newTransaction);

        MoneyAccountService.updateCapitalAfterTransaction(sender_account_id, receiver_account_id, amount);

        return newTransaction;
    }

    public List<Transaction> getTransactionListByUID(String receiver_UID) {
        return em.createQuery("select * from Transaction transaction where transaction.receiver_account_id or" +
                "transaction.sender_account_id =" + receiver_UID, Transaction.class).getResultList();
    }
}
