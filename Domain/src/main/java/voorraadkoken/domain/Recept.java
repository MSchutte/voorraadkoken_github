package voorraadkoken.domain;

import java.util.HashMap;
import voorraadkoken.domain.Product;
import java.util.ArrayList;

public class Recept {
	ArrayList<Product> ingredienten = new ArrayList<Product>();
	HashMap<String, String> bereidingswijze = new HashMap<String, String>();

	
	public ArrayList<Product> getIngredienten() {
		return ingredienten;
	}
	
	public HashMap<String, String> getBereidingswijze() {
		return bereidingswijze;
	}
	
	public void toJSON() {
		
	}
}