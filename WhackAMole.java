import java.util.Scanner;

public class WhackAMole {
    int score;
    int molesLeft;
    int attemptsLeft;
    char[][] moleGrid;
    
    WhackAMole(int numAttempts, int gridDimension){
	attemptsLeft = numAttempts;
	moleGrid = new char[gridDimension][gridDimension];
	//create grid
	for(int i = 0; i < gridDimension; i++) {
	    for(int j = 0; j < gridDimension; j++) {
		moleGrid[i][j] = '*';
	    }
	}
	    
    }
    
    boolean place(int x, int y) {
	if (moleGrid[x][y] == '*') {
	    moleGrid[x][y] = 'M';
	    molesLeft++;
	    return true;
	}else {
	    return false;
	}
    }
    
    void whack(int x, int y) {
	if (x == -1 && y == -1) {
	    attemptsLeft = 0;
	    printGrid();
	}else if(moleGrid[x][y] == 'M') {
	    moleGrid[x][y] = 'W';
	    score++;
	    attemptsLeft--;
	    molesLeft--;
	    printGridToUser();
	}else {
	    attemptsLeft--;
	    printGridToUser();
	}
    }
    
    void printGridToUser() {
	for(int i = 0; i < moleGrid.length; i++) {
	    for(int j = 0; j < moleGrid.length; j++) {
		if(moleGrid[i][i] == 'W') {
		    System.out.print("W");
		} else {
		    System.out.print("*");
		}
		    
	    }
	    System.out.print("\n");
	}
    }
    
    void printGrid() {
	for(int i = 0; i < moleGrid.length; i++) {
	    for(int j = 0; j < moleGrid.length; j++) {
		System.out.print(moleGrid[i][j] + "");		    
	    }
	    System.out.println("");
	}
    }
    
    public String toString(){
        String update = "";
        update += "Score: " + score;
        update += "\n";
        update += "Moles Left: " + molesLeft;
        update += "\n";
        update += "Attempts Left:" + attemptsLeft;
        return update;
    }
    
    public static void main(String[] args) {
	WhackAMole game = new WhackAMole(50,10);
	//place ten moles
	int placedMoles = 0;
	while (placedMoles < 10) {
	    int randomX = (int)(Math.random()*10);
	    int randomY = (int)(Math.random()*10);
	    	if(game.place(randomX, randomY) == true) {
	    	    placedMoles++;
	    	}
	}
	
	while(game.attemptsLeft > 0 && game.molesLeft > 0) {
	    Scanner kb = new Scanner(System.in);
	    System.out.println("Enter the x and y coordinates of where you would like to take a whack." + "\n" + "You have a maximum of 50 attempts to get all the moles.");
	    System.out.println("");
	    System.out.print("Enter the x coordinate: ");
	    int playerX = kb.nextInt();
	    System.out.println("");
	    System.out.print("Enter the y coordinate: ");
	    int playerY = kb.nextInt();
	    game.whack(playerX, playerY);
	}
    }
}
