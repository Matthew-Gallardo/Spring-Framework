package org.acumen.training.codes.model.form;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpendingForm {
    private Double food;
    private Double clothing;
    private Double entertainment;
    private Double rent;

    private Double foodPercentage;
    private Double clothingPercentage;
    private Double entertainmentPercentage;
    private Double rentPercentage;

    public void calculatePercentages() {
        double total = food + clothing + entertainment + rent;

        foodPercentage = roundToTwoDecimalPlaces((food / total) * 100);
        clothingPercentage = roundToTwoDecimalPlaces((clothing / total) * 100);
        entertainmentPercentage = roundToTwoDecimalPlaces((entertainment / total) * 100);
        rentPercentage = roundToTwoDecimalPlaces((rent / total) * 100);
    }

    private Double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

	public Double getFood() {
		return food;
	}

	public void setFood(Double food) {
		this.food = food;
	}

	public Double getClothing() {
		return clothing;
	}

	public void setClothing(Double clothing) {
		this.clothing = clothing;
	}

	public Double getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(Double entertainment) {
		this.entertainment = entertainment;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getFoodPercentage() {
		return foodPercentage;
	}

	public void setFoodPercentage(Double foodPercentage) {
		this.foodPercentage = foodPercentage;
	}

	public Double getClothingPercentage() {
		return clothingPercentage;
	}

	public void setClothingPercentage(Double clothingPercentage) {
		this.clothingPercentage = clothingPercentage;
	}

	public Double getEntertainmentPercentage() {
		return entertainmentPercentage;
	}

	public void setEntertainmentPercentage(Double entertainmentPercentage) {
		this.entertainmentPercentage = entertainmentPercentage;
	}

	public Double getRentPercentage() {
		return rentPercentage;
	}

	public void setRentPercentage(Double rentPercentage) {
		this.rentPercentage = rentPercentage;
	}

    
    
    
}
