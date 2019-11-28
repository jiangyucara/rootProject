package rootProject;

public class Driver {
	public String name;
	public double totalDistance;
	public double totalDuration;
	public double averageSpeed;	
	
	public Driver(String name) {
		this.name = name;
	}
	
	public Driver(String name, double distance, double duration){
		this.name = name;
		this.totalDistance = distance;
		this.totalDuration = duration;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Driver) {
			Driver toCompare = (Driver) o;
			return this.name.equals(toCompare.name);
		}
		return false;
	}
	
	
}
