
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        
        int col = size / 2;
        int row = 0;
        square.placeValue(col, row, 1);
        //int rowLimit = 0;
        //int colLimit = size - 1;
        
        for(int value = 2; value <= size * size; value++) {
            
            int oldRow = row;
            int oldCol = col;
            
            row = row - 1;
            col = col + 1;
            
            if(row < 0) {
                row = row + size;
            }
            
            if(col > size - 1) {
                col = col - size;
            }
            
            if(square.readValue(col, row) != 0) {
                row = oldRow;
                col = oldCol;
                row = row + 1;
            }
            
            if(square.readValue(col, row) == 0) {
                square.placeValue(col, row, value);
            }
            
        }
        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }

}
