import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

//uniwersalna klasa do wczytywania z pliku .life dla GOL oraz WW, potencjalnie rozszerzalna dla innej gry
public class LoadBoardFromFile {
	private int rows;
	private int cols;
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Board loadBoardFromFile(String fileName) throws FileNotFoundException {
		try {
			String buffer;
			Scanner s = new Scanner(new File("C:/Users/Kuba/eclipse-workspace/TreningJavy/src/" + fileName)); //TU MUSISZ MIEC INNA SCIEZKE DOSTEPU
			s.next();
			rows = s.nextInt();
			//System.out.println(rows);
			s.next();
			cols = s.nextInt();
			//System.out.println(cols);
			Board board = new Board(rows, cols);
			s.nextLine();
			s.nextLine();
			
			for(int i=0; i<rows; i++)
			{
				buffer = s.nextLine().trim();
				for(int j=0; j<cols; j++)
				{
					if(buffer.charAt(j)-'0' == (int)C.OFF)
						board.getCell(i, j).setState(C.OFF);
					else if(buffer.charAt(j)-'0' == (int)C.ON)
						board.getCell(i, j).setState(C.ON);
					else if(buffer.charAt(j)-'0' == (int)C.PADD)
						board.getCell(i, j).setState(C.PADD);
					else if(buffer.charAt(j)-'0' == (int)C.HEAD)
						board.getCell(i, j).setState(C.HEAD);
					else if(buffer.charAt(j)-'0' == (int)C.TAIL)
						board.getCell(i, j).setState(C.TAIL);
					//System.out.print(buffer.charAt(j));
				}
				//System.out.println("");
			}
			s.close();
			return board;
		}
		catch(FileNotFoundException ex) {
			return null;
		}
		
	}
}