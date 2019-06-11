package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Car;

public class CarTableModel extends AbstractTableModel {

	private List<Car> db;
	//header columns
	private String[] colNames = { "ID", "Mark", "Model", "Mileage", "Price", "Transmission", "Fuel", "First registration","New/Used" };

	public CarTableModel() {
	}

	public String getColumnName(int column) {
		
		return colNames[column];
	}
	
	// pasez referinta bazei de date in table model, care actioneaza ca un wrapper pt date
	public void setData(List<Car> db) {
		this.db = db;
		
	}

	public int getColumnCount() {

		return 9;
	}

	@Override
	public int getRowCount() {
      //nr de ob masini din lista
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		// returnez datele din aceste randuri si coloane
		Car car = db.get(row);
		switch (col) {
		case 0:
			return car.getId();
		case 1:
			return car. getMark();
		case 2:
			return car.getModel();
		case 3:
			return car.getMileage();
		case 4:
			return car.getPrice();
		case 5:
			return car.getTransmission();
		case 6:
			return car.getFuelCategory();
		case 7:
			return car.getEmpCat();
		case 8:
			return car.getNewUsed();
		}
		return null;
	}

}
