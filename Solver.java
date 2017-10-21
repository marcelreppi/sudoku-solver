public class Solver {

	private Sudoku sudoku;
	private int cnt = 0;
	
	public Solver(Sudoku sudoku) {
		this.sudoku = sudoku;
	}
	
	
	public void solveRecStart(){
		System.out.println("Original board : \n");
		sudoku.printBoard();
		long a = System.currentTimeMillis();
		if(solveRec(0,0)){
			long b = System.currentTimeMillis();
			System.out.println("Solved board : \n");
			sudoku.printBoard();
			System.out.println("solveRec Method was called " + cnt + " times.");
			System.out.println("The Sudoku is solved! ;)");
			System.out.println("Total time : " + (b-a) + " milliseconds");
		}else{
			System.out.println("Bad Input!");
		}	
	}
	
	//solveRec can solve any (solvable) sudoku
	//created according to pseudocode
	private boolean solveRec(int row, int col){
		cnt++;
		if(row == 9){
			row = 0;
			col += 1;
			if(col == 9){
				return true;
			}
		}
		if(sudoku.getBoard()[row][col] != 0){
			return solveRec(row+1,col);
		}
		for(int num = 1; num<10; num++){
			if(isPossible(num, row, col)){
				sudoku.getBoard()[row][col] = num;
				
				if(solveRec(row+1,col)){
					return true;
				}
			}
		}
		sudoku.getBoard()[row][col] = 0;		
		return false;
	}
	
	//checks if num is possible at row/cal coordinates
	private boolean isPossible(int num, int row, int col){
		return !(checkBoxForNum(num,row,col)||checkRowForNum(num,row,col)||checkColForNum(num,row,col));
	}
	
	//checks if current number can be found in the column
	//if true, then num can NOT go here
	private boolean checkColForNum(int num, int row, int col) {
		for(int i = 0; i<9; i++){
			if(sudoku.getBoard()[i][col] == num){
				return true;
			}
		}
		return false;
	}

	//checks if current number can be found in the row
	//if true, then num can NOT go here
	private boolean checkRowForNum(int num, int row, int col) {
		for(int i = 0; i<9; i++){
			if(sudoku.getBoard()[row][i] == num){
				return true;
			}
		}
		return false;
	}

	//checks if current number can be found in the box
	//if true, then num can NOT go here
	private boolean checkBoxForNum(int num, int row, int col) {
		if(row <3){
			if(col<3){
				//top left
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else if(col>5){
				//top right
				for(int i = 0; i<3; i++){
					for(int j = 6; j<9; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else{
				//top middle
				for(int i = 0; i<3; i++){
					for(int j = 3; j<6; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}
		}else if(row >5){
			if(col<3){
				//bottom left
				for(int i = 6; i<9; i++){
					for(int j = 0; j<3; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else if(col>5){
				//bottom right
				for(int i = 6; i<9; i++){
					for(int j = 6; j<9; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else{
				//bottom middle
				for(int i = 6; i<9; i++){
					for(int j = 3; j<6; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}
		}else{
			if(col<3){
				//middle left
				for(int i = 3; i<6; i++){
					for(int j = 0; j<3; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else if(col>5){
				//middle right
				for(int i = 3; i<6; i++){
					for(int j = 6; j<9; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}else{
				//middle middle
				for(int i = 3; i<6; i++){
					for(int j = 3; j<6; j++){
						if(sudoku.getBoard()[i][j] == num){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
