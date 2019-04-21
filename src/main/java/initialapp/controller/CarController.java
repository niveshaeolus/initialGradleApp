package initialapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import initialapp.model.Car;
import initialapp.service.InitialAppService;

@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired
	private InitialAppService appService;
	
	//methodtogetallcars
	@GetMapping(value = {"/cars"})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Car>> listOfCars(){
		List<Car> listFCars= appService.listfCars();
		return ResponseEntity.ok().body(listFCars);
	}
	
	//saveCarPrice
	@PostMapping("/addcar")
	@ResponseStatus(HttpStatus.CREATED)
	public  String addCar(@RequestBody Car car){
		long id = appService.addCar(car);
		return "Car created with if: "+id;
				
	}
	
	@GetMapping("/cars/{id}")
	@ResponseStatus(HttpStatus.OK)
	public  Car getSingleCar(@PathVariable("id") long id){
		Car requestedCar=appService.getCar(id);
		return requestedCar;			
	}
	
	@PutMapping("/cars/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public  String updateSingleCar(@PathVariable("id") long id,@RequestBody Car car){
		appService.updateCarEntry(id,car);
		return "Car details Updated";			
	}
	
	@DeleteMapping("/cars/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  String deleteSingleCar(@PathVariable("id") long id){
		appService.deleteCarEntry(id);
		return "Car is Sold";		
	}
	
}
