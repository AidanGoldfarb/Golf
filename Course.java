
public class Course {

	private int course;
	// initializing arrays of constants for each course(yards and pars on every
	// hole)
	private static int[] GEN_YRD = { 530, 305, };
	private static int[] GEN_PAR = { 5, 4, };
	private static int[] AND_YRD = { 530, 305 };
	private static int[] AND_PAR = { 5, 4 };

	Course(int course) {
		this.course = course;
	}

	public int getYrd(int i) {
		// method to get yard number on specific hole
		if (course == 1) {
			return GEN_YRD[i];
		} else {
			return AND_YRD[i];
		}

	}

	public int getPar(int j) {
		// method to get par number on specific hole
		if (course == 1) {
			return GEN_PAR[j];
		} else {
			return AND_PAR[j];
		}

	}

}
