package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import gui.FormEvent;
import model.FuelCategory;
import model.Database;
import model.FirstRegistrationCategory;
import model.NewUsed;
import model.Car;

public class Controller {
	Database db = new Database();

	// gui comunica cu dataModel prin acest Controller
	//trimit aceasta lista de masini catre tablemodel din TablePanel
	public List<Car> getCars() {
		return db.getCars();
	}
	public void removeCar(int index) {
		//ii comunic db sa stearga randul
		db.removeCar(index);
	}

	public void addCar(FormEvent ev) {
		String mark = ev.getMark();
		String model = ev.getModel();
		String mileage = ev.getMileage();
		String price = ev.getPrice();
		String transmission = ev.getTransmission();
		int fuelCatId = ev.getFuelCategory();
		String empCat = ev.getFirstRegistrationCategory();
		String newUsed = ev.getNewUsed();

		FuelCategory fuelCategory = null;

		switch (fuelCatId) {
		case 0:
			fuelCategory = FuelCategory.Diesel;
			break;
		case 1:
			fuelCategory = FuelCategory.Petrol;
			break;
		case 2:
			fuelCategory = FuelCategory.Electric;
			break;
		}
		FirstRegistrationCategory empCategory;
		if (empCat.equals("One year")) {
			empCategory = FirstRegistrationCategory.oneYear;

		} else if (empCat.equals("Five years")) {
			empCategory = FirstRegistrationCategory.fiveYears;

		} else if (empCat.equals("Ten years")) {
			empCategory = FirstRegistrationCategory.tenYears;

		} else {
			empCategory = FirstRegistrationCategory.fifteenYears;
			
		}

		NewUsed newUsedCat;
		if (newUsed.equals("Used")) {
			newUsedCat = NewUsed.Used;
		} else {
			newUsedCat = NewUsed.New;
		}
		Car car = new Car(mark, model, mileage, price, transmission, fuelCategory, empCategory,  newUsedCat);

		db.addCar(car);

	}

	public void saveToFile(File file) throws IOException {
		db.saveToFile(file);

	}

	public void loadFromFile(File file) throws IOException {
		db.loadFromFile(file);
	}

}
