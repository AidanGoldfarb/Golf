import java.util.Random;
public class Club {
	private String name;
	private int mean;
	private int dev;
	
	public Club(String a) {
		name = a;
		mean = this.calcMean(a);
		dev = this.calcDev(a);
	}
	
	public String toString() {
		return name;
	}
	
	public int shoot(int power) {
		Random r = new Random();
		int distance;
		double aMean = mean*power/10.0;
		double aDev = dev*power/10.0;
		distance = (int) Math.abs(r.nextGaussian() * aDev + aMean);
		return distance;
	}
	
	private int calcMean(String a) {
		if(a.equalsIgnoreCase("Driver"))
			return 230;
		else if(a.equalsIgnoreCase("3-wood"))
			return 215;
		else if(a.equalsIgnoreCase("3-iron"))
			return 180;
		else if(a.equalsIgnoreCase("4-iron"))
			return 170;
		else if(a.equalsIgnoreCase("5-iron"))
			return 155;
		else if(a.equalsIgnoreCase("6-iron"))
			return 145;
		else if(a.equalsIgnoreCase("7-iron"))
			return 135;
		else if(a.equalsIgnoreCase("8-iron"))
			return 125;
		else if(a.equalsIgnoreCase("9-iron"))
			return 110;
		return 50;
	}
	
	private int calcDev(String a) {
		if(a.equalsIgnoreCase("Driver"))
			return 30;
		else if(a.equalsIgnoreCase("3-wood"))
			return 20;
		else if(a.equalsIgnoreCase("3-iron"))
			return 20;
		else if(a.equalsIgnoreCase("4-iron"))
			return 17;
		else if(a.equalsIgnoreCase("5-iron"))
			return 15;
		else if(a.equalsIgnoreCase("6-iron"))
			return 15;
		else if(a.equalsIgnoreCase("7-iron"))
			return 15;
		else if(a.equalsIgnoreCase("8-iron"))
			return 15;
		else if(a.equalsIgnoreCase("9-iron"))
			return 10;
		return 10;
	}
}
