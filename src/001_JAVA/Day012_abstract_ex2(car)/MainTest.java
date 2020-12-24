package com.lec.ex07car;

import com.lec.cons.CarSpecs;

public class MainTest {
public static void main(String[] args) {
	
	Car lowCar = new LowGradeCar(CarSpecs.GRAY_COLOR, CarSpecs.TIRE_NORMAL, 
												     CarSpecs.DISPLACEMENT_1000, CarSpecs.HANDLE_POWER);
	
	
	Car highCar = new HighGradeCar(CarSpecs.BLUE_COLOR, CarSpecs.TIRE_NORMAL, 
												     CarSpecs.DISPLACEMENT_1000, CarSpecs.HANDLE_POWER);

	
	
			lowCar.getSpec();
			highCar.getSpec();
	
}
}
