package ch.bbcag.jakarta.ttbank.controller;

import ch.bbcag.jakarta.ttbank.model.MoneyAccount;
import ch.bbcag.jakarta.ttbank.model.Transaction;
import ch.bbcag.jakarta.ttbank.service.TransactionService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Inherited;

@Path("transaction")
@Provider
@Priority(Priorities.AUTHENTICATION)
public class TransactionController {

    @Inject
    private TransactionService transactionService;

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(MoneyAccount user) {
        return Response.ok(this.transactionService.getTransactionListByUID(user.getId())).build();
    }

    @Path("create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(MoneyAccount user) {
        return Response
                .ok()
                .entity(this.transactionService.createTransaction(user.getId(), user.))
                .build();
    }
}
