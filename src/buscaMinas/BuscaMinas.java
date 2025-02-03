package buscaMinas;
import java.util.Scanner;

public class BuscaMinas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[][] tablero = new String[8][8];
		//String[] minasPos = new String[10];
		
		GestorJuego gestor = new GestorJuego();
		//Mina mina1 = new Mina(6);
		
		gestor.getMinasPos();
		//gestor.showMinasPos();

		
		//tablero = setUp(tablero.length, tablero);
		//ponerMinas(tablero, minasPos);
		showTablero();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter new position to play: ");
		String userPos = scanner.nextLine().toUpperCase();
		
		while(gestor.perdio(userPos)) {
			gestor.jugar(userPos);
			showTablero();
			userPos = scanner.nextLine().toUpperCase();
		}
		
		showTablero();
	}

	

	
	
	public static void showTablero() {
		for(String[] b : GestorJuego.tablero) {
			for(String n : b) {
				System.out.print(n);
			}
			System.out.println();
		}
		
		
	}





	private static String[][] play(String[][] tablero, int pos1, int pos2, String[] minasPos) {
		
		int count = 0;
		
		count = searchMinas(tablero , pos1,pos2);
		
		if(tablero[pos1+1][pos2+1].equals(" X ")) {
			count++;
		}
		
		tablero[pos1][pos2] = " " + String.valueOf(count) + " ";
		
		return tablero;
	}

	//no tengo la mina a la vista. Buscar en la lista,
	private static int searchMinas(String[][] tablero, int pos1, int pos2) {
		
		int countMinas = 0;
		if(tablero[pos1][pos2+1].equals(" X ") || tablero[pos1-1][pos2-1].equals(" X ")) {
			countMinas++;
		}
		
		return countMinas;
	}


	//Encuentra la posicion en el tablero
	private static int foundPos(char[] pos, char letterPos) {
		
		for(int i = 1; i < pos.length ; i++) {
			if(pos[i] == letterPos) {
				return i;
			}
		}
		return -1;

	}


	private static String[] ponerMinas(String[][] tablero, String[] minasPos) {
		char[] pos = {'0','A', 'B', 'C','D','E','F','G', 'H', 'I'}; 
		
		int minaPos1 = 1; //random position
		int minaPos2 = 5;
		
		tablero[minaPos1][minaPos2] = " X ";
		minasPos[0] = String.valueOf(pos[minaPos1]) + String.valueOf(pos[minaPos2]);
		
		
		return minasPos;
	}


	//Crear Tablero
	private static String[][] setUp(int i, String[][] tablero) {
		int size = i+1;
		tablero = new String[size][size];
		char[] pos = {'0','A', 'B', 'C','D','E','F','G', 'H', 'I'}; 
		
		for(int row = 0 ; row < size; row ++) {
			for(int col = 0 ; col < size; col++) {
				tablero[row][col] = " - ";
			}
		}
		
		for(int row = 0; row < size; row ++) {
			tablero[row][0] = " " + pos[row] + " ";
		}
		for(int col = 0; col < size; col++) {
			tablero[0][col] = " " + pos[col] + " ";
		}
		
		
		return tablero;
		
	}

}


