package initialapp.dao;

import java.util.List;

import initialapp.model.Car;

public interface InitialAppDAO {

	//2Save
	long addCar(Car car);
	
	//getsinglerecord
	Car getCar(long id);
	
	
	//listallcars
	List<Car> listfCars();
	
	//updateSingleRecord
	void updateCarEntry(long id,Car car);
	
	//deleteSingleRecord
	void deleteCarEntry(long id);
}
