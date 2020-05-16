import java.io.FileNotFoundException;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException{
		MainWindow window = new MainWindow(); //stworzenie obiektu ktory jest oknem, mozna stworzyc 2 niezalezne identyczne okna
		
		LoadBoardFromFile lbff = new LoadBoardFromFile();
		Board board = lbff.loadBoardFromFile("example.life"); //tworzy now¹ planszê z pliku .life
		if(board==null) return;
		
		
	}
}
