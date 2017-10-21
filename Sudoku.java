
public class Sudoku {

	private int[][] board = new int[9][9];

	public Sudoku() {
		initBoard();
	}
	
	public Sudoku(String sudoku){
		createSudoku(sudoku);
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public int[][] getDeepCopyBoard(){
		int[][] copy = new int[9][9];
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}
	
	public void printBoard(){
		for(int i = 0; i<9; i++){
			System.out.println(board[i][0] + "  " + board[i][1] + "  " + board[i][2] + " | "
							 + board[i][3] + "  " + board[i][4] + "  " + board[i][5] + " | "
							 + board[i][6] + "  " + board[i][7] + "  " + board[i][8]);
			if((i+1)%3 == 0){
				if((i+1) != 9){
					System.out.println("___________________________ \n");
				}
			}
		}
		System.out.println();
	}
	
	public void createSudoku(String sudoku){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				board[i][j] = Integer.parseInt(sudoku.substring((i*9)+j,(i*9)+j+1));
			}
		}
	}
	
	public void initBoard(){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				board[i][j] = 0;
			}
		}
	}	
}
