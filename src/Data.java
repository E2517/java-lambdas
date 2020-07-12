
public class Data {
	
	private int elevator; 
	private int start;
	private int end;
	private double weight; 
	
	public Data (int numeroAscensor, int plantaInicio, int plantaDestino, double cargaAscensor) {
		
		this.elevator = numeroAscensor;
	    this.start = plantaInicio;
	    this.end = plantaDestino;
	    this.weight = cargaAscensor;
	}

	public int getNumberElevator() {
		return elevator;
	}

	public void setNumberElevator(int numberElevator) {
		this.elevator = numberElevator;
	}

	public int getStartFloor() {
		return start;
	}

	public void setStartFloor(int startFloor) {
		this.start = startFloor;
	}

	public int getEndFloor() {
		return end;
	}

	public void setEndFloor(int endFloor) {
		this.end = endFloor;
	}

	public double getWeightElevator() {
		return weight;
	}

	public void setWeightElevator(double weightElevator) {
		this.weight = weightElevator;
	}

	@Override
	public String toString() {
		return "Elevator [number=" + elevator + ", start floor=" + start + ", end floor="
				+ end + ", weight=" + weight + "]";
	}
	
	

}
