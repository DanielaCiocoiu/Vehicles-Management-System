package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<Car> cars;

	public Database() {
		//folosesc un linkedList pt ca este mai optimizat pt adaugare si stergere de elmente din mijlocul unei liste
		cars = new LinkedList<Car>();

	}

	public void addCar(Car car) {
		cars.add(car);
	}
    //ca sa stearga randul informez tablePanel
	public void removeCar(int index) {
		cars.remove(index);
	}

	public List<Car> getCars() {
		//previne modificarile efectuate de alte clase
		return Collections.unmodifiableList(cars);
	}

	// salvare lista masini
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//convertesc arrayList la array pt a evita delete-ul
		Car[] cars1 = cars.toArray(new Car[cars.size()]);

		oos.writeObject(cars1);

		oos.close();
	}

	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Car[] cars1 = (Car[]) ois.readObject();
			cars.clear();
			//Notifies all listeners that all cell values in the table'srows may have changed.
			cars.addAll(Arrays.asList(cars1));

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		ois.close();
	}
}
