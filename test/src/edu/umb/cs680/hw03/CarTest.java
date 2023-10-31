package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CarTest{
	private String[] carToStringArray(Car car){
		String[] carString = {car.getMake(), car.getModel(), String.valueOf(car.getYear())};
		return carString;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 1, 2018, 1000000000);
		assertArrayEquals(expected, carToStringArray(actual));
	}
}