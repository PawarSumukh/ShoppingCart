package cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

	public static void main(String[] args) {

		List<String> ip = Arrays.asList("Apple", "Orange", "orange", "orangE", "Apple", "Apple", "Apple", "Orange",
				"orange", "orangE", "Orange"); // add further items in cart for checkout

		Boolean offerOnApple = false;
		Boolean offerOnOrange = true;

		Map<String, Double> itemCost = new HashMap<String, Double>();
		itemCost.put("apple", 0.60);
		itemCost.put("orange", 0.25);
//		itemCost.put("item3",priceForItem3);	// add further items and prices here

		Double totalCost = 0.0;
		Shop s = new Shop();
		s.setItemCostMap(itemCost);
		s.setBuyOneGetOneOnApple(offerOnApple);
		s.setBuyThreeAtTwoOnOrange(offerOnOrange);

		List<String> cart = new ArrayList<String>();
		for (String str : ip) {
			cart.add(str.toLowerCase());
		}

		try {
			for (String item : cart)
				if (!itemCost.containsKey(item.toLowerCase()))
					throw new Exception("Invalid Item in cart");

			s.updateCart(cart);
			totalCost = s.findTotalCost();

			System.out.println("items brought: " + s.getItemCount());
			System.out.println("Total cost: " + totalCost);
		} catch (Exception e) {
			System.out.println("Could not checkout Cart due to the below reason");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Thanks for shopping with us... Visit Again!!!");
		}
	}
}
