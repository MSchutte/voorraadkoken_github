package voorraadkoken.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBList;

import voorraadkoken.persistance.DBConnect;

@Path("/ingredient")

public class getRecipesbyIngredient {
	@GET 
	@Produces(MediaType.APPLICATION_JSON)

	@Path("/{ingredient}")

	public Response getRecipe(
		@PathParam("ingredient") String ingredient,
		@Context HttpServletRequest request) {

		DBConnect connection = new DBConnect();
		BasicDBList output = connection.getRecipebyIngredient(ingredient);
		
		if (output.size() < 1) {
			String nooutput = "Geen recepten met " + ingredient + " gevonden.";
			return Response.status(200).entity(nooutput).build();
		} else {
			return Response.status(200).
				    header("Access-Control-Allow-Origin", "*").
					entity(output).build();
		}
	}
 }