package org.acumen.training.codes.services;

import java.util.Set;

public class BasketSets {
	private Set<String> baskets;

	public BasketSets(Set<String> baskets) {
		this.baskets = baskets;
	}

	public Set<String> getBaskets() {
		return baskets;
	}

	public void setBaskets(Set<String> baskets) {
		this.baskets = baskets;
	}

	@Override
	public String toString() {
		return "BasketSets [baskets=" + baskets + "]";
	}
	



}