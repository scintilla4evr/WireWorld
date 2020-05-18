import java.io.FileNotFoundException;

public class MainClass {
	public static void main(String[] args){
		MainWindow window = new MainWindow(); //stworzenie obiektu ktory jest oknem, mozna stworzyc 2 niezalezne identyczne okna

		LoadBoardFromFile lbff = new LoadBoardFromFile();
		try {
			System.out.print(lbff.loadBoardFromFile("example.life") == null);
		}
		catch(FileNotFoundException ex) {
			;
		}
	}
}
