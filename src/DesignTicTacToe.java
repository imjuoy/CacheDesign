
public class DesignTicTacToe {

	int[] rows;
	int[] columns;
	int diagonal;
	int antiDiagonal;

	public DesignTicTacToe(int size) {
		rows = new int[size];
		columns = new int[size];
	}

	// There could only be two players 1 or 2.
	// For simplicity we will consider that if 1 plays he marks 1
	// If 2 plays he marks -1

	public int moves(int row, int column, int Player) {
		int val = Player == 1 ? 1 : -1;
		rows[row] += val;
		columns[column] += val;

		if (row == column)
			diagonal += val;
		if (column == (columns.length - row - 1))
			antiDiagonal += val;

		int size = rows.length;

		if (Math.abs(rows[row]) == size || Math.abs(columns[column]) == size || Math.abs(diagonal) == size
				|| Math.abs(antiDiagonal) == size)
			return Player;

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
