package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {//toate ev deriva din EventObject
//stochez informatia temporar pe care o transmit catre mainFrame

	private String mark;
	private String model;
	private String mileage;
	private String price;
	private String transmission;
	private int fuelCategory;
	private String empCat;
	private String newUsed;

	public FormEvent(Object source) {//ctor care accepta ca arg sursa este in FormPanel ok btn
		super(source);

	}
	
	public FormEvent(Object source, String mark, String model,  String mileage, String price, String transmission, 
			int fuelCat, String empCat,  String newUsed) {
		
		super(source);

		this.mark = mark;
		this.model = model;
		this.mileage = mileage;
		this.price = price;
		this.transmission = transmission;
		this.fuelCategory = fuelCat;
		this.empCat = empCat;
		this.newUsed = newUsed;

	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getFuelCategory() {
		return fuelCategory;
	}

	public String getFirstRegistrationCategory() {
		return empCat;
	}
	public String getNewUsed() {
		return newUsed;
	}

	public void setNewUsed(String newUsed) {
		this.newUsed = newUsed;
	}
}
