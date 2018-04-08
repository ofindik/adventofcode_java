package day3;

public class SpiralMemory {

	private static final int MAX_GRID_SIZE = 1000;

	int gridSize;

	int centerX, centerY;

	int[][] grid;
	
	int gridLimitValue = 0;

	public int process (int squareId) {
		getGridSize (squareId);
		centerX = (gridSize / 2);
		centerY = (gridSize / 2);

		fillGridUpToGivenSquare (squareId);

		int x = 0, y = 0;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (grid[i][j] == squareId) {
					x = i + 1;
					y = j + 1;
					break;
				}
			}
		}

		return Math.abs ((centerX + 1) - x) + Math.abs ((centerY + 1) - y);
	}

	public int process2 (int limit) {
		gridSize = 11;
		centerX = (gridSize / 2);
		centerY = (gridSize / 2);

		initGrid ();
		fillGrid (limit);

		return gridLimitValue;
	}

	private void fillGridUpToGivenSquare (int squareId) {
		grid = new int[gridSize][gridSize];
		int x = centerX;
		int y = centerY;
		int id = 1;
		// first element
		Coordinate currentCoordinate = new Coordinate (x, y, id);
		grid[x][y] = 1;
		for (int size = 3; size <= gridSize; size += 2) {
			//System.out.println ("fillGridForNextSize currentCoordinate=" + currentCoordinate + " size=" + size);
			currentCoordinate = fillGridForNextSize (currentCoordinate, size);
		}
		//printGrid ();
	}

	private void initGrid () {
		grid = new int[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = 0;
			}
		}
	}

	private void fillGrid (int limit) {
		int x = centerX;
		int y = centerY;
		int id = 1;
		// first element
		Coordinate currentCoordinate = new Coordinate (x, y, id);
		grid[x][y] = 1;
		for (int size = 3; size <= gridSize - 2; size += 2) {
			//System.out.println ("fillGridForNextSize currentCoordinate=" + currentCoordinate + " size=" + size);
			currentCoordinate = fillGridForNextSize2 (currentCoordinate, size, limit);
		}
		//printGrid ();
	}
	
	private void printGrid () {
		System.out.println ("GRID:");
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				System.out.print (grid[j][i] + "\t");
			}
			System.out.println ("");
		}
	}

	private int getGridSize (int squareId) {
		//System.out.println ("squareId=" + squareId);
		gridSize = 1;
		for (int i = 1; i < MAX_GRID_SIZE; i += 2) {
			if (squareId <= (i * i)) {
				gridSize = i;
				break;
			}
		}
		//System.out.println ("gridSize=" + gridSize);

		return gridSize;
	}

	private Coordinate fillGridForNextSize (Coordinate currentCoordinate, int size) {
		// move right
		currentCoordinate.setX (currentCoordinate.getX () + 1);
		setGridValue (currentCoordinate);
		// move up (size - 2) times
		for (int i = 1; i <= (size - 2); i++) {
			currentCoordinate.setY (currentCoordinate.getY () - 1);
			setGridValue (currentCoordinate);
		}
		// move left (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setX (currentCoordinate.getX () - 1);
			setGridValue (currentCoordinate);
		}
		// move down (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setY (currentCoordinate.getY () + 1);
			setGridValue (currentCoordinate);
		}
		// move right (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setX (currentCoordinate.getX () + 1);
			setGridValue (currentCoordinate);
		}
		return new Coordinate (currentCoordinate.getX (), currentCoordinate.getY (), currentCoordinate.getValue ());
	}

	private void setGridValue (Coordinate coordinate) {
		coordinate.setValue (coordinate.getValue () + 1);
		//System.out.println (coordinate);
		grid[coordinate.getX ()][coordinate.getY ()] = coordinate.getValue ();
	}

	private Coordinate fillGridForNextSize2 (Coordinate currentCoordinate, int size, int limit) {
		// move right
		currentCoordinate.setX (currentCoordinate.getX () + 1);
		setGridValue2 (currentCoordinate, limit);
		// move up (size - 2) times
		for (int i = 1; i <= (size - 2); i++) {
			currentCoordinate.setY (currentCoordinate.getY () - 1);
			setGridValue2 (currentCoordinate, limit);
		}
		// move left (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setX (currentCoordinate.getX () - 1);
			setGridValue2 (currentCoordinate, limit);
		}
		// move down (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setY (currentCoordinate.getY () + 1);
			setGridValue2 (currentCoordinate, limit);
		}
		// move right (size - 1) times
		for (int i = 1; i <= (size - 1); i++) {
			currentCoordinate.setX (currentCoordinate.getX () + 1);
			setGridValue2 (currentCoordinate, limit);
		}
		return new Coordinate (currentCoordinate.getX (), currentCoordinate.getY (), currentCoordinate.getValue ());
	}

	private void setGridValue2 (Coordinate coordinate, int limit) {
		int value = getGridValue (coordinate);
		if (value > limit && gridLimitValue == 0) {
			gridLimitValue = value;
		}
		coordinate.setValue (value);
		//System.out.println (coordinate);
		grid[coordinate.getX ()][coordinate.getY ()] = coordinate.getValue ();
	}

	private int getGridValue (Coordinate currentCoordinate) {
		int x = currentCoordinate.getX ();
		int y = currentCoordinate.getY ();
		int topleft = grid[x-1][y+1];
		int top = grid[x][y+1];
		int topright = grid[x+1][y+1];
		int right = grid[x+1][y];
		int bottomright = grid[x+1][y-1];
		int bottom = grid[x][y-1];
		int bottomleft = grid[x-1][y-1];
		int left = grid[x-1][y];
		return topleft + top + topright + right + bottomright + bottom + bottomleft + left;
	}

	class Coordinate {
		int x;

		int y;

		int value;

		Coordinate (int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public int getX () {
			return x;
		}

		public void setX (int x) {
			this.x = x;
		}

		public int getY () {
			return y;
		}

		public void setY (int y) {
			this.y = y;
		}

		public int getValue () {
			return value;
		}

		public void setValue (int value) {
			this.value = value;
		}

		@Override
		public String toString () {
			StringBuffer sb = new StringBuffer ();
			sb.append ("x=").append (x);
			sb.append (" y=").append (y);
			sb.append (" valu=").append (value);
			return sb.toString ();
		}
	}
}
