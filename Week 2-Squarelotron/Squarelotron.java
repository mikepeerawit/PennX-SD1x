import java.util.Arrays;

public class Squarelotron {
	public int[][] squarelotron;
	public int size;
	
	public Squarelotron(int n) {
		// Sets the size instance variable to be n.
		this.size = n;
		
		//Create a 2-dimensional array.
		this.squarelotron = new int[size][size];
		
		/* Fills the 2-dimensional array with 
		 * the numbers 1 to n squared, in order.
		 */
		for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                squarelotron[i][j] = i * size + j + 1;
            }
        }
	}
    
    public boolean isOnRing(int i, int j, int ring) {
        
        // a square has at least 1 side on the ring
		boolean isOn = (i == ring - 1 || j == ring - 1 || i == size - ring || j == size - ring); 
        
        // the square is outside the ring
		boolean isOut = (i <= ring - 2 || i >= size + 1 - ring || j <= ring - 2 || j >= size + 1 - ring);
        
		return isOn && !isOut;
	}
	
	public Squarelotron upsideDownFlip(int ring) {
		
		// Create the resulting 2-dimensional array
		Squarelotron result = new Squarelotron(size);
		for(int i = 0; i < this.size; i++) {
			for(int j = 0; j < this.size; j++) {
				
				/* Use condition to check if the position is 
				 * either outer ring or inner ring. If it is 
				 * in the outer ring it process into if condition,
				 * however if it is inner ring it goes into else condition.
				 */
				if (isOnRing(i, j, ring)) {
					
					/** Outer ring flip their value 
					 * upside down from the original matrix
					 */
					result.squarelotron[i][j] = this.squarelotron[this.size - i - 1][j];
				}
			}
		}
		return result;
	}
	
	public Squarelotron mainDiagonalFlip(int ring) {
		
		// Create the resulting 2-dimensional array
		Squarelotron result = new Squarelotron(this.size);
		for( int i = 0; i < this.size; i++) {
			for( int j = 0; j < this.size; j++) {
				
				/* Use condition to check if the position is 
				 * either outer ring or inner ring. If it is 
				 * in the outer ring it process into if condition,
				 * however if it is inner ring it goes into else condition.
				 */
				if (isOnRing(i, j, ring)) {
					
					/** Outer ring flip their value 
					 * through Main Diagonal from
					 * the original matrix
					 */
					result.squarelotron[i][j] = this.squarelotron[j][i];
				}	
			}
		}
		return result;
	}
	
	public void rotateRight(int numberOfTurns) {
        
        // take care of negative number of turns
		numberOfTurns = (numberOfTurns % 4 + 4) % 4; 
		for (int n = 0; n < numberOfTurns; n++) {
			Squarelotron newSquarelotron = new Squarelotron(size);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					newSquarelotron.squarelotron[j][size - 1 - i] = squarelotron[i][j]; 
				}
			}
			this.squarelotron = newSquarelotron.squarelotron;
		}
	}
    
}
