import java.util.Scanner;

public class Golf_TTY {

	public void start(Golf_TTY golf, String win) {
		Scanner sc = new Scanner(System.in);
		// printing club names for user's convenience
		System.out.println(
				"Club names, increasing in strength: Wedge, 9-iron, 8-iron, 7-iron, 6-iron, 5-iron, 4-iron, 3-iron, 3-wood, Driver");

		// main loop
		while (!win.equals("N")) {

			// selection of course
			int g = golf.courseSelect(), i = 0;
			Course course = new Course(g);
			if (g == 1) {
				System.out.println("You are playing Genesee Park North Course.\n");
			} else {
				System.out.println("You are playing The Old Course at St. Andrews.\n");
			}

			// initializing variables to count overall par
			int sum_par = 0, pl_par = 0;
			// secondary loop for the course
			for (int j = 0; j < 2; j++) {
				// first shot is different from the others
				System.out.println("You are at the tee #" + (j + 1) + ". " + course.getYrd(j) + " Yards, par "
						+ course.getPar(j) + ".");
				System.out.print("Choose your club: ");
				Club club = new Club(sc.next());
				System.out.print("How hard to hit?[1-10]: ");
				// getting shot info, also distance and initialing shotNum - number of shots on
				// one hole
				int shot = club.shoot(sc.nextInt()), distance = course.getYrd(j) - shot, shotNum = 2,
						par = course.getPar(j);
				System.out.println("You hit the ball " + shot + " Yards. Nice!\n");

				while (distance > 20) {
					// all the next shots
					System.out.println("Shot #" + shotNum + ". " + distance + " yards to the hole.");
					System.out.print("Choose your club: ");
					club = new Club(sc.next());
					System.out.print("How hard to hit?[1-10]: ");
					shot = club.shoot(sc.nextInt());
					// cutting distance to the hole
					distance -= shot;
					// if we hit the hole shotNum should not go up
					if (distance != 0) {
						shotNum++;
					}
					System.out.println("You hit the ball " + shot + " Yards.\n");

					// cool feature: if you overshoot the green, you start to "shoot back" -
					// absolute value of distance is taken
					if (distance < -20) {
						System.out.println("You shot the ball over the green and now have to shoot back!");
						distance = Math.abs(distance);
					}
				}

				// converting distance from yards to feet
				distance = Math.abs(distance) * 3;
				int putt;

				System.out.println("You are on the green");
				while (distance > 0) {
					// shots on the green
					System.out.println("Shot #" + shotNum + ". " + distance + " feet to the hole.");
					Putter putter = new Putter();
					System.out.print("Putt power[1-10]: ");
					putt = putter.shoot(sc.nextInt());
					System.out.println();
					// cutting distance to the hole
					distance -= putt;
					// if we hit the hole shotNum should not go up
					if (distance > 0) {
						shotNum++;
					}
				}
				
				// prompting user with info about his par this round (3 cases)
				if (par == shotNum)
					System.out.println("You made par on this hole.\n");
				else if (par > shotNum)
					System.out.println("You shot a " + getTerm(par, shotNum) + " on this hole.\n");
				else
					System.out.println("You shot a " + getTerm(par, shotNum) + " on this hole.\n");

				// increasing the overall par values
				sum_par += par;
				pl_par += shotNum;
				// prompting user with info about his overall par after hole #(j + 1) (3 cases)
				if (sum_par == pl_par)
					System.out.println("Your score after hole #" + (j + 1) + " is: par.\n");
				else if (sum_par > pl_par)
					System.out
							.println("Your score after hole #" + (j + 1) + " is: " + (sum_par - pl_par) + " under.\n");
				else
					System.out.println("Your score after hole #" + (j + 1) + " is: " + (pl_par - sum_par) + " over.\n");
			}

			// prompting user with info about his overall par on the course (3 cases)
			System.out.println("_____________________________");
			if (sum_par == pl_par)
				System.out.println("Your final score for the round is: par. Not bad!\n");
			else if (sum_par > pl_par)
				System.out.println("Your final score for the round is: " + (sum_par - pl_par) + " under. Good job!\n");
			else
				System.out.println("Your final score for the round is: " + (pl_par - sum_par) + " over. Too bad!\n");

			win = golf.endGame();
		}

	}
	
	public void start2(Golf_TTY golf, String win) {
		String p1,p2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player one's name: ");
		p1 = sc.nextLine();
		System.out.print("\nEnter player two's name: ");
		p2 = sc.nextLine();
		// printing club names for user's convenience
		System.out.println(
				"Club names, increasing in strength: Wedge, 9-iron, 8-iron, 7-iron, 6-iron, 5-iron, 4-iron, 3-iron, 3-wood, Driver");
		
		// main loop
		while (!win.equals("N")) {

			// selection of course
			int g = golf.courseSelect(), i = 0;
			System.out.println(p1 + " select course");
			Course course = new Course(g);
			if (g == 1) {
				System.out.println("You are playing Genesee Park North Course.\n");
			} else {
				System.out.println("You are playing The Old Course at St. Andrews.\n");
			}

			// initializing variables to count overall par
			int sum_par = 0, pl_par = 0, sum_par2 = 0, pl_par2 = 0;
			// secondary loop for the course
			for (int j = 0; j < 2; j++) {
				// first shot is different from the others
				System.out.println(p1 + ", you are at the tee #" + (j + 1) + ". " + course.getYrd(j) + " Yards, par "
						+ course.getPar(j) + ".");
				System.out.print("Choose your club: ");
				Club club = new Club(sc.next());
				System.out.print("How hard to hit?[1-10]: ");
				// getting shot info, also distance and initialing shotNum - number of shots on
				// one hole
				int shot = club.shoot(sc.nextInt()), distance = course.getYrd(j) - shot, shotNum = 2,
						par = course.getPar(j);
				System.out.println(p1 + ", you hit the ball " + shot + " Yards. Nice!\n");
				
				//player two's turn
				System.out.println(p2 + ", you are at the tee #" + (j + 1) + ". " + course.getYrd(j) + " Yards, par "
						+ course.getPar(j) + ".");
				System.out.print("Choose your club: ");
				Club club2 = new Club(sc.next());
				System.out.print("How hard to hit?[1-10]: ");
				// getting shot info, also distance and initialing shotNum - number of shots on
				// one hole
				int shot2 = club2.shoot(sc.nextInt()), distance2 = course.getYrd(j) - shot, shotNum2 = 2,
						par2 = course.getPar(j);
				System.out.println( p2 + ", you hit the ball " + shot2 + " Yards. Nice!\n");

				while (distance > 20) {
					// all the next shots
					System.out.println(p1 + ", shot #" + shotNum + ". " + distance + " yards to the hole.");
					System.out.print("Choose your club: ");
					club = new Club(sc.next());
					System.out.print("How hard to hit?[1-10]: ");
					shot = club.shoot(sc.nextInt());
					// cutting distance to the hole
					distance -= shot;
					// if we hit the hole shotNum should not go up
					if (distance != 0) {
						shotNum++;
					}
					System.out.println("You hit the ball " + shot + " Yards.\n");

					// cool feature: if you overshoot the green, you start to "shoot back" -
					// absolute value of distance is taken
					if (distance < -20) {
						System.out.println("You shot the ball over the green and now have to shoot back!");
						distance = Math.abs(distance);
					}
				}
				System.out.println(p1 + ", you are on the green!");
				while (distance2 > 20) {
					// all the next shots
					System.out.println(p2 + ", shot #" + shotNum2 + ". " + distance2 + " yards to the hole.");
					System.out.print("Choose your club: ");
					club2 = new Club(sc.next());
					System.out.print("How hard to hit?[1-10]: ");
					shot2 = club2.shoot(sc.nextInt());
					// cutting distance to the hole
					distance2 -= shot2;
					// if we hit the hole shotNum should not go up
					if (distance2 != 0) {
						shotNum2++;
					}
					System.out.println(p2 + ", you hit the ball " + shot + " Yards.\n");

					// cool feature: if you overshoot the green, you start to "shoot back" -
					// absolute value of distance is taken
					if (distance2 < -20) {
						System.out.println(p2 + ", you shot the ball over the green and now have to shoot back!");
						distance2 = Math.abs(distance2);
					}
				}
				System.out.println(p2 + ", you are on the green!");
				// converting distance from yards to feet
				distance = Math.abs(distance) * 3;
				int putt;

				System.out.println("You are on the green");
				while (distance > 0) {
					// shots on the green
					System.out.println("Shot #" + shotNum + ". " + distance + " feet to the hole.");
					Putter putter = new Putter();
					System.out.print("Putt power[1-10]: ");
					putt = putter.shoot(sc.nextInt());
					System.out.println();
					// cutting distance to the hole
					distance -= putt;
					// if we hit the hole shotNum should not go up
					if (distance > 0) {
						shotNum++;
					}
				}
				
				// converting distance from yards to feet
				distance2 = Math.abs(distance2) * 3;
				int putt2;

				System.out.println("You are on the green");
				while (distance2 > 0) {
					// shots on the green
					System.out.println("Shot #" + shotNum2 + ". " + distance2 + " feet to the hole.");
					Putter putter2 = new Putter();
					System.out.print("Putt power[1-10]: ");
					putt2 = putter2.shoot(sc.nextInt());
					System.out.println();
					// cutting distance to the hole
					distance2 -= putt2;
					// if we hit the hole shotNum should not go up
					if (distance2 > 0) {
						shotNum2++;
					}
				}
				
				// prompting user with info about his par this round (3 cases)
				if (par == shotNum)
					System.out.println(p1 + ", you made par on this hole.\n");
				else if (par > shotNum)
					System.out.println(p1 + ", you shot a " + getTerm(par, shotNum) + " on this hole.\n");
				else
					System.out.println(p1 + ", you shot a " + getTerm(par, shotNum) + " on this hole.\n");

				// increasing the overall par values
				sum_par += par;
				pl_par += shotNum;
				// prompting user with info about his overall par after hole #(j + 1) (3 cases)
				if (sum_par == pl_par)
					System.out.println(p1 + ", your score after hole #" + (j + 1) + " is: par.\n");
				else if (sum_par > pl_par)
					System.out
							.println(p1 + ", your score after hole #" + (j + 1) + " is: " + (sum_par - pl_par) + " under.\n");
				else
					System.out.println(p1 + ", your score after hole #" + (j + 1) + " is: " + (pl_par - sum_par) + " over.\n");
				
				// prompting user2 with info about his par this round (3 cases)
				if (par2 == shotNum2)
					System.out.println(p2 + ", you made par on this hole.\n");
				else if (par2 > shotNum2)
					System.out.println(p2 + ", you shot a " + getTerm(par2, shotNum2) + " on this hole.\n");
				else
					System.out.println(p2 + ", you shot a " + getTerm(par2, shotNum2) + " on this hole.\n");

				// increasing the overall par values
				sum_par2 += par2;
				pl_par2 += shotNum2;
				// prompting user with info about his overall par after hole #(j + 1) (3 cases)
				if (sum_par2 == pl_par2)
					System.out.println(p2 + ", your score after hole #" + (j + 1) + " is: par.\n");
				else if (sum_par2 > pl_par2)
					System.out
							.println(p2 + ", your score after hole #" + (j + 1) + " is: " + (sum_par2 - pl_par2) + " under.\n");
				else
					System.out.println(p2 + ", your score after hole #" + (j + 1) + " is: " + (pl_par2 - sum_par2) + " over.\n");
			}

			// prompting user with info about his overall par on the course (3 cases)
			System.out.println("_____________________________");
			if (sum_par == pl_par)
				System.out.println(p1 + ", your final score for the round is: par. Not bad!\n");
			else if (sum_par > pl_par)
				System.out.println(p1 + ", your final score for the round is: " + (sum_par - pl_par) + " under. Good job!\n");
			else
				System.out.println(p1 + ", your final score for the round is: " + (pl_par - sum_par) + " over. Too bad!\n");

		
			
			// prompting user with info about his overall par on the course (3 cases)
			System.out.println("_____________________________");
			if (sum_par2 == pl_par2)
				System.out.println(p2 + ", your final score for the round is: par. Not bad!\n");
			else if (sum_par2 > pl_par2)
				System.out.println(p2 + ", your final score for the round is: " + (sum_par2 - pl_par2) + " under. Good job!\n");
			else
				System.out.println(p2 + ", your final score for the round is: " + (pl_par2 - sum_par2) + " over. Too bad!\n");

			win = golf.endGame();
		}

	}

	public int courseSelect() {
		// method for selecting of the course
		Scanner sc = new Scanner(System.in);

		System.out.print("What course would you like to play?\n" + "1. Genesee Valley Park North Course\n"
				+ "2. The Old Course at St. Andrews\n" + "Your choise[1-2]:");

		return sc.nextInt();
	}

	public String endGame() {
		// method for end of the game stuff
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to play another round? [Y/N]: ");
		String win = sc.next();
		return win;
	}

	public static void main(String[] args) {
		
		String win = "Y";
		Golf_TTY golf = new Golf_TTY();
		Scanner sc = new Scanner(System.in);
		System.out.print("One or two players? [1 or 2] ");
		int choice = sc.nextInt();
		if(choice == 1) 
			golf.start(golf, win);
		else
			golf.start2(golf, win);
	}
	public String getTerm(int par, int shotNum) {
		//golf terminology 
		String term = "";
		if(par-shotNum == 1)
			term = "Birdie";
		else if(par-shotNum == 2)
			term = "Eagle";
		else if(par-shotNum == 3)
			term = "Albatross";
		else if(shotNum-par == 1)
			term = "Bogey";
		else if(shotNum-par == 2)
			term = "Double Bogey";
		else if(shotNum-par == 3)
			term = "Tripe Bogey";
		else if(shotNum-par == 4)
			term = "+4";
		else if(shotNum-par == 5)
			term = "+5";
		else if(shotNum-par == 6)
			term = "+6";
		else if(shotNum-par == 7)
			term = "+7";
		else if(shotNum-par == 8)
			term = "+8";
		else if(shotNum-par == 9)
			term = "+9";
		else 
			term = "+10";
		return term;
			
		}
	}

