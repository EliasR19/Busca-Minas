package buscaMinas;
import java.util.*;
public class BuscaMinas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tablero = new String[8][8];
		tablero = setUp(tablero.length, tablero);
		ponerMinas(10);
		
		for(String[] b : tablero) {
			for(String n : b) {
				System.out.print(n);
			}
			System.out.println();
		}
	}

	
	private static void ponerMinas(int i) {
		
		
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


