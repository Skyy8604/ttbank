package ch.bbcag.jakarta.ttbank;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class TTBankApplication extends ResourceConfig {

    public TTBankApplication() {
        packages("ch.bbcag.jakarta.ttbank").register(MultiPartFeature.class);
    }
}
