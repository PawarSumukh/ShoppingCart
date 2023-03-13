package cart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

	public static void main(String[] args) {
		
		List<String> cart = Arrays.asList("Apple","Orange","Apple","Apple","xyz");	// add further items in cart for checkout
		
		Map<String, Double> itemCost = new HashMap<String, Double>();
		itemCost.put("Apple", 0.60);
		itemCost.put("Orange", 0.25);		
//		itemCost.put("item3",priceForItem3);	// add further items and prices here
		
		Double totalCost = 0.0;
		Shop s = new Shop();
		s.setItemCostMap(itemCost);
		
		
		
		try {
			for(String item:cart) 
				if (!itemCost.containsKey(item))
					throw new Exception("Invalid Item in cart");
			totalCost  = s.findTotalCost(cart);
			System.out.println("items brought: "+cart);
			System.out.println("Total cost: "+totalCost);
			
		}catch(Exception e){
			System.out.println("Could not checkout Cart due to the below reason");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Thanks for shopping with us... Visit Again!!!");
		}
	}
}
