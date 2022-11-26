package lecture01BWorkingWithAbstractionExercise.jediGalaxy;

public class Field {
    private int[][] starsField;

    public Field(int rows, int cols) {
        this.starsField = new int[rows][cols];
        fillInField(rows, cols, starsField);
    }

    private void fillInField(int rows, int cols, int[][] field) {
        int value = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                field[r][c] = value++;
            }
        }
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < starsField.length && col >= 0 && col < starsField[row].length;
    }

    public int getValue(int row, int col) {
        return this.starsField[row][col];
    }

    public void setValue(int row, int col, int newValue) {
        starsField[row][col] = newValue;
    }

    public int getColLength() {
        return starsField[0].length;
    }
}