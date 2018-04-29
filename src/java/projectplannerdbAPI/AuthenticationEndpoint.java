/*
 * Inspiration found from the response to a post on stack overflow.
 *https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
 */
package projectplannerdbAPI;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.soap.Brugeradmin;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Service;
import projectplannerdbAPI.Tasks;

@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        Users user = new Users(username);
        if(username == user.getUserID() && password == user.getPassword()){
            
        }
        else{
         Brugeradmin ba;

            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
		Service service = Service.create(url, qname);
		ba = service.getPort(Brugeradmin.class);
            Bruger bruger = ba.hentBruger(username, password);
            Users users = new Users(username);
            users.setEmail(bruger.email);
            users.setFirstName(bruger.fornavn);
            users.setSurName(bruger.efternavn);
            users.setPassword(bruger.adgangskode);
            users.setUserID(username);
        }
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        
        
        // TODO: Return statement
        return null;
    }
}