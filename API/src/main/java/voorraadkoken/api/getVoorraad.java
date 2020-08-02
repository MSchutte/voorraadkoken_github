package voorraadkoken.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBList;

import voorraadkoken.persistance.DBConnect;

@Path("/voorraad")

public class getVoorraad {
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getVorraad(
		@Context HttpServletRequest request) {
		
		DBConnect connection = new DBConnect();
		BasicDBList test = connection.selectAlleVoorraad();
		
		return Response.status(200).
			    header("Access-Control-Allow-Origin", "*").
				entity(test).build();
	}
 }