package sPlanner;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * REST Web Service
 *
 * @author Kayode
 */
@Path("splanner")
public class SPlanner {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SPlanner
     */
    public SPlanner() {
    }
    
    @GET
    @Produces("text/html")
    public String getHtml() {

        return "This is happening]Yep I said that";

        //return "<html><body><h1>Hello, World!!</body></h1></html>";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public int getJSON(RequestBody requestBody) {

        int res = 0;

        Servers ab = new Servers();

        res = ab.calculate(requestBody.sType, requestBody.vMachines);

        return res;
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public int getText(InputStream incomingData) {

        String outP[] = null;
        int res = 0;

        Servers ab = new Servers();

        StringBuilder mess = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;

            while ((line = in.readLine()) != null) {

                mess.append(line);
            }
        } catch (Exception ex) {

            System.out.println("Error Parsing: - " + ex);
        }

        outP = ab.retrieve(mess.toString());

        res = ab.calculate(outP[0], outP[1]);

        return res;
    }
}
