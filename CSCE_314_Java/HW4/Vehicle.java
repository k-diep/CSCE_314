class Vehicle {
	private int speed;
	private int direction;
	private String owner;
	private int ID;
	public static int nextID = 0;
	public final static String TURN_LEFT = "TURN_LEFT";
	public final static String TURN_RIGHT = "TURN_RIGHT";
	
	// Constructors
	public Vehicle (){
		speed = 0;
		direction = 0;
		owner = "Anon";
		ID = nextID++;
	}
	
	public Vehicle (String name){
		speed = 0;
		direction = 0;
		owner = name;
		ID = nextID++;
	}
	// Getters
	public int getSpeed(){
		return speed;
	}
	public int getDirection(){
		return direction;
	}
	public String getOwner(){
		return owner;
	}
	public int getID(){
		return ID;
	}
	
	// Setters
	public void setSpeed(int s){
		this.speed = s;
	}
	
	public void setDirection(int d){
		int angle = d % 360;
		if (angle < 0){
			angle += 360;
		}
		this.direction = angle;
	}
	
	public void setOwner(String s){
		this.owner = s;
	}
	
	//Should not be used, but needed for VehicleTestP5
	public void setID(int i){
		this.ID = i;
	}
	
	//The fields that needs setter methods are Speed, Direction, Owner, and ID. NextID does not need one, since it is static public.
	
	public static int getHighestID () {
		return nextID - 1;
	}
	
	public String toString() {
		String desc = speed + " " + direction + " " + owner + " " + ID;
		return desc;
	}
	
	public void changeSpeed(int s){ //another setter
		this.speed = s;
	}
	
	public void stop(){
		this.speed = 0;
	}
	
	public void turn(int d){
		int angle = (d + direction) % 360;
		if (angle < 0){
			angle += 360;
		}
		this.direction = angle;
	}
	
	public void turn(String d){
		int angle = direction; 
		if (d == TURN_LEFT){
			angle = (angle - 90) % 360;
		}
		if (d == TURN_RIGHT){
			angle = (angle + 90) % 360;
		}
		if (angle < 0){
			angle += 360;
		}
		this.direction = angle;
	}
}

class VehicleTest{
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		System.out.println("V1 ------------------------");
		
		v1.setSpeed(10);
		v1.setDirection(359);
		// we will use default user
		
		System.out.println(v1.getSpeed());
		System.out.println(v1.getDirection());
		System.out.println(v1.getOwner());
		System.out.println(v1.getID());
		System.out.println(v1.toString());
		System.out.println();
		
		Vehicle v2 = new Vehicle("Khoa");
		v2.setSpeed(20);
		v2.setDirection(-270);
		System.out.println("V2 ------------------------");
		System.out.println(v2.getSpeed());
		System.out.println(v2.getDirection());
		System.out.println(v2.getOwner());
		System.out.println(v2.getID());
		System.out.println(v2.toString());
		System.out.println();
		
		Vehicle v3 = new Vehicle("Sonic");
		v3.setSpeed(8000);
		v3.setDirection(0);
	
		System.out.println("V3 ------------------------");
		System.out.println(v3.getSpeed());
		System.out.println(v3.getDirection());
		System.out.println(v3.getOwner());
		System.out.println(v3.getID());
		System.out.println(v3.toString());
		System.out.println();
		
		Vehicle v4 = new Vehicle("Turtle");
		v4.setSpeed(10);
		v4.setDirection(50);
		System.out.println("V4 ------------------------");
		System.out.println(v4.getSpeed());
		System.out.println(v4.getDirection());
		System.out.println(v4.getOwner());
		System.out.println(v4.getID());
		System.out.println(v4.toString());
		System.out.println();
		
		Vehicle v5 = new Vehicle("John Doe");
		v5.setSpeed(20);
		v5.setDirection(100);
		System.out.println("V5 ------------------------");
		System.out.println(v5.getSpeed());
		System.out.println(v5.getDirection());
		System.out.println(v5.getOwner());
		System.out.println(v5.getID());
		System.out.println(v5.toString());
		System.out.println();
		
		System.out.println("Highest ID so far is: " + Vehicle.getHighestID());
		System.out.println();
		
		System.out.println("Testing changeSpeed() and stop() ------------------------");
		System.out.println("Speed before changeSpeed(1000): " + v5.getSpeed());
		v5.changeSpeed(1000);
		System.out.println("Speed after changeSpeed(1000): " + v5.getSpeed());
		v5.stop();
		System.out.println("Speed after stop(): " + v5.getSpeed());
		System.out.println();
		
		System.out.println("Testing turn() ------------------------");
		System.out.println("Direction before turn(-180): " + v5.getDirection());
		v5.turn(-180);
		System.out.println("Direction after turn(-180): " + v5.getDirection());
		v5.turn(-90);
		System.out.println("Direction after turn(-90): " + v5.getDirection());
		v5.turn(45);
		System.out.println("Direction after turn(45): " + v5.getDirection());
		v5.turn(Vehicle.TURN_LEFT);
		System.out.println("Direction after turn(Vehicle.TURN_LEFT): " + v5.getDirection());
		v5.turn(Vehicle.TURN_LEFT);
		System.out.println("Direction after turn(Vehicle.TURN_LEFT): " + v5.getDirection());
		v5.turn(Vehicle.TURN_RIGHT);
		System.out.println("Direction after turn(Vehicle.TURN_RIGHT): " + v5.getDirection());
		v5.turn(Vehicle.TURN_RIGHT);
		System.out.println("Direction after turn(Vehicle.TURN_RIGHT): " + v5.getDirection());
	}
}

class VehicleTestP5{
	public static void main(String[] args) {
		//Vehicle 1
		Vehicle v1 = new Vehicle();
		v1.setSpeed(10);
		v1.setDirection(359);
		v1.setOwner("Khoa");
		v1.setID(0);
		
		System.out.println("V1 ------------------------");
		System.out.println(v1.getSpeed());
		System.out.println(v1.getDirection());
		System.out.println(v1.getOwner());
		System.out.println(v1.getID());
		System.out.println();
		
		//Vehicle 2
		Vehicle v2 = new Vehicle();
		v2.setSpeed(20);
		v2.setDirection(0);
		v2.setOwner("Bob");
		v2.setID(1);
		
		System.out.println("V2 ------------------------");
		System.out.println(v2.getSpeed());
		System.out.println(v2.getDirection());
		System.out.println(v2.getOwner());
		System.out.println(v2.getID());
		System.out.println();
		
		//Vehicle 3
		Vehicle v3 = new Vehicle();
		v3.setSpeed(80);
		v3.setDirection(0);
		v3.setOwner("Highwayman");
		v3.setID(2);
		
		System.out.println("V3 ------------------------");
		System.out.println(v3.getSpeed());
		System.out.println(v3.getDirection());
		System.out.println(v3.getOwner());
		System.out.println(v3.getID());
		System.out.println();
		
		//Vehicle 4
		Vehicle v4 = new Vehicle();
		v4.setSpeed(200000000);
		v4.setDirection(100);
		v4.setOwner("Sonic");
		v4.setID(3);
		
		System.out.println("V4 ------------------------");
		System.out.println(v4.getSpeed());
		System.out.println(v4.getDirection());
		System.out.println(v4.getOwner());
		System.out.println(v4.getID());
		System.out.println();
		
		//Vehicle 5
		Vehicle v5 = new Vehicle();
		v5.setSpeed(10);
		v5.setDirection(50);
		v5.setOwner("Turtle");
		v5.setID(4);
		
		System.out.println("V5 ------------------------");
		System.out.println(v5.getSpeed());
		System.out.println(v5.getDirection());
		System.out.println(v5.getOwner());
		System.out.println(v5.getID());
		}
}