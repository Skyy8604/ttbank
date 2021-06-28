package ch.bbcag.jakarta.ttbank.controller;

import ch.bbcag.jakarta.ttbank.service.JwtService;
import ch.bbcag.jakarta.ttbank.service.MarketService;
import ch.bbcag.jakarta.ttbank.service.UserService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("marketcontroller")
public class MarketEndpoint {

    @GET
    @Path("getTest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<String> response() throws UnirestException {
        HttpResponse<String> resp = Unirest.get("https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete?q=tesla&region=US")
                .header("x-rapidapi-key", "02bcf9c92fmsh5ebf1aa04101497p139d34jsn34bf265fcc44")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .asString();

        return resp;
    }
}
