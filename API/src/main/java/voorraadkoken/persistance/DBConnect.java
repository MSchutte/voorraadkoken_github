package voorraadkoken.persistance;

import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.exists;

import com.mongodb.BasicDBList;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class DBConnect {
	
	
	private static void connection() {
		
		try {
		MongoClient mongoClient = MongoClients.create();

		System.out.println("Database connected. dbvoorraad & dbrecepten accessible");
			
		mongoClient.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BasicDBList selectAlleVoorraad() 
	{
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("voorraadKoken");

		MongoCollection<Document> dbvoorraad = database.getCollection("voorraad");  
		MongoCursor<Document> cursor = dbvoorraad.find().iterator();
	    
		BasicDBList list = new BasicDBList();
		
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	list.add(doc);
		    }
		} finally {
		    cursor.close();
		}

		mongoClient.close();
	    return list;
	}
	
	public BasicDBList getRecipebyIngredient(String ingredient)
	{
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase database = mongoClient.getDatabase("voorraadKoken");

		MongoCollection<Document> dbrecepten = database.getCollection("recepten");

		String query = "ingredienten." + ingredient;
		Bson filter = exists(query, true);
		
		MongoCursor<Document> cursor = dbrecepten.find(filter).iterator();
		
		BasicDBList list = new BasicDBList();

		if (!cursor.hasNext()) {
			System.out.println("No recipes found");
		}
		
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	list.add(doc);
		    }
		} finally {
		    cursor.close();
		}
		
		mongoClient.close();
		return list;
	}
	
}
	

