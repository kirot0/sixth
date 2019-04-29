package ac.scggi.app.inheritance;

public class GroundVehicle extends Vehicle {
	public boolean hasSunRoof;
	public GroundVehicle(String whereUsing, int speed, boolean hasSunRoof) {
		super(whereUsing, speed);
		this.hasSunRoof = hasSunRoof;
	}
	@Override
	public void startEngine() {
		super.startEngine();
		System.out.println("GroundVehicle's startEngine");
	}
}
