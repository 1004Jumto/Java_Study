package ch13.sec02.exam2;

public class GenericEx {

	public static void main(String[] args) {
		HomeAgency agency = new HomeAgency();
		Home home = agency.rent();
		home.turnOnLight();

		CarAgency cagency = new CarAgency();
		Car car = cagency.rent();
		car.run(); 
	} 
}
