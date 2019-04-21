package initialapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import initialapp.dao.InitialAppDAO;
import initialapp.model.Car;
@Service
public class InitialAppServiceImpl implements InitialAppService{
	@Autowired
	private InitialAppDAO appDao;
	
	@Override
	@Transactional
	public long addCar(Car car) {
		return appDao.addCar(car);
	}

	@Override
	@Transactional
	public Car getCar(long id) {
		// TODO Auto-generated method stub
		return appDao.getCar(id);
	}

	@Override
	@Transactional
	public List<Car> listfCars() {
		List<Car> lisfCars = appDao.listfCars();
		return lisfCars;
	}

	@Override
	@Transactional
	public void updateCarEntry(long id, Car car) {
		appDao.updateCarEntry(id, car);		
	}

	@Override
	@Transactional
	public void deleteCarEntry(long id) {
		appDao.deleteCarEntry(id);
	}

}
