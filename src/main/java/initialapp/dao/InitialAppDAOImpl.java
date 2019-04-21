package initialapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import initialapp.model.Car;
@Repository
public class InitialAppDAOImpl implements InitialAppDAO{
	@Autowired
	private SessionFactory sessFctry;
	
	@Override
	public long addCar(Car car) {
		sessFctry.getCurrentSession().save(car);
		return car.getId();
	}

	@Override
	public Car getCar(long id) {
		return sessFctry.getCurrentSession().get(Car.class,id);
	}

	@Override
	public List<Car> listfCars() {
		List<Car> listfCars= sessFctry.getCurrentSession().createQuery("from Car").list();
		return listfCars;
	}

	@Override
	public void updateCarEntry(long id, Car car) {
		Session session = sessFctry.getCurrentSession();
		Car oldCar = session.byId(Car.class).load(id); 
		oldCar.setBrand(car.getBrand());
		oldCar.setType(car.getType());
		oldCar.setPrice(car.getPrice());
		oldCar.setAvailability(car.getAvailability());
		session.flush();
	}

	@Override
	public void deleteCarEntry(long id) {
		Session session = sessFctry.getCurrentSession();
		Car car = session.byId(Car.class).load(id);
		//session.remove(car);
		session.delete(car);
	}

}
