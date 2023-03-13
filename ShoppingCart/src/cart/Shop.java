package cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

	Map<String, Double> itemCostMap = new HashMap<String, Double>();
	Map<String, Integer> itemCount = new HashMap<String, Integer>();
	Boolean buyOneGetOneOnApple = false;
	Boolean buyThreeAtTwoOnOrange = false;

	public Boolean getBuyOneGetOneOnApple() {
		return buyOneGetOneOnApple;
	}

	public void setBuyOneGetOneOnApple(Boolean buyOneGetOneOnApple) {
		this.buyOneGetOneOnApple = buyOneGetOneOnApple;
	}

	public Boolean getBuyThreeAtTwoOnOrange() {
		return buyThreeAtTwoOnOrange;
	}

	public void setBuyThreeAtTwoOnOrange(Boolean buyThreeAtTwoOnOrange) {
		this.buyThreeAtTwoOnOrange = buyThreeAtTwoOnOrange;
	}

	public Map<String, Double> getItemCostMap() {
		return itemCostMap;
	}

	public void setItemCostMap(Map<String, Double> itemCostMap) {
		this.itemCostMap = itemCostMap;
	}

	@Override
	public String toString() {
		return "Shop [itemCostMap=" + itemCostMap + "]";
	}

	public Double findTotalCost() {
		Double cost = 0.0;
		for (String k : itemCount.keySet()) {
			cost += itemCostMap.get(k) * itemCount.get(k);
		}
		return cost;
	}

	public Map<String, Integer> updateCart(List<String> cart) {
		for (String s : cart) {
			if (!itemCount.containsKey(s)) {
				itemCount.put(s, 1);
			} else {
				itemCount.put(s, itemCount.get(s) + 1);
			}
		}

		if (buyOneGetOneOnApple)
			itemCount.put("apple", updateApple(itemCount.get("apple")));
		if (buyThreeAtTwoOnOrange)
			itemCount.put("orange", updateOrange(itemCount.get("orange")));

		return itemCount;
	}

	public Map<String, Integer> getItemCount() {
		return itemCount;
	}

	public void setItemCount(Map<String, Integer> itemCount) {
		this.itemCount = itemCount;
	}

	private Integer updateOrange(Integer count) {
		if (count % 3 == 0)
			return count / 3 * 2;
		else
			return count / 3 * 2 + count % 3;
	}

	private Integer updateApple(Integer count) {
		if (count % 2 == 0)
			return count / 2;
		else
			return count / 2 + 1;
	}

}
