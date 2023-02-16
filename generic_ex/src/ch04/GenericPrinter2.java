package ch04;

public class GenericPrinter2<T extends Vehicle> {
	
	private T vehicle;

	public T getVehicle() {
		return vehicle;
	}

	public void setVehicle(T vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return vehicle.toString();
	}
	
	
}
