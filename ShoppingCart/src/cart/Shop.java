package cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	
	Map<String, Double> itemCostMap = new HashMap<String, Double>();

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

	public Double findTotalCost(List<String> cart) {
		Double cost=0.0;
		for(String item:cart) {
			cost += itemCostMap.get(item);
		}
		return cost;	
	}	
}
