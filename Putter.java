import java.util.Random;

public class Putter {
	private int mean;
	private int dev;

	public int shoot(int power) {
		mean = this.calcMean(power);
		dev = this.calcDev(power);
		Random r = new Random();
		int distance;
		double aMean = mean * power / 10.0;
		double aDev = dev * power / 10.0;
		distance = (int) Math.abs(r.nextGaussian() * aDev + aMean);
		return distance;
	}

	private int calcMean(int power) {
		if (power == 10)
			return 40;
		else if (power == 9)
			return 30;
		else if (power == 8)
			return 25;
		else if (power == 7)
			return 20;
		else if (power == 6)
			return 16;
		else if (power == 5)
			return 12;
		else if (power == 4)
			return 8;
		else if (power == 3)
			return 4;
		else if (power == 2)
			return 2;
		return 1;

	}

	private int calcDev(int power) {
		if (power == 10)
			return 5;
		else if (power == 9)
			return 5;
		else if (power == 8)
			return 4;
		else if (power == 7)
			return 4;
		else if (power == 6)
			return 3;
		else if (power == 5)
			return 3;
		else if (power == 4)
			return 2;
		else if (power == 3)
			return 2;
		else if (power == 2)
			return 1;
		return 1;
	}

}
