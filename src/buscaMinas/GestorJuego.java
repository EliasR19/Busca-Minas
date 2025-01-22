package buscaMinas;

public class GestorJuego {
	public static String[][] tablero = new String[8][8];
	Mina[] minas = new Mina[5];
	
	//constructor
	public GestorJuego() {
		tablero = setUp();
		minas = setUpMinas(minas);
		cambiarMinasMismaPos();
	}
	
	
	//comportamiento
	
	//Minas
	private Mina minaFactory() {
		Mina mina = new Mina(0,8);
		return mina;
	}
	
	
	//no funciona del todo, porque cuando se generan nuevas posiciones puede ser que ya esten en otro.
	private void cambiarMinasMismaPos() {
		for(int x = 0; x < minas.length; x++) {
			if(hayMinaEnPos(minas[x].getPosTotal())){
				minas[x] = minaFactory();
			}
		}
		
		
	}


	private boolean hayMinaEnPos(String minaPos) {
		for(int x = 0; x < minas.length; x++) {
			if(minaPos.equals(minas[x].getPosTotal())) {
				return true;
			}
		}
		return false;
	}


	public String[] getMinasPos() {
		String[] minasPos = new String[minas.length];
		
		for(int x = 0; x < minasPos.length; x++) {
			minasPos[x] = minas[x].getPosTotal();
		}
		
		return minasPos;
	}
	
	public void showMinasPos() {
		for(String minaPos : getMinasPos()) {
			System.out.println(minaPos);
		}
	}


	private Mina[] setUpMinas( Mina[] minasList) {
		Mina[] minas = new Mina[minasList.length];
		
		for(int x = 0; x < minasList.length; x++ ) {
			minas[x] = minaFactory();
		}
		
		return minas;
	}

	

	//contar la cantidad de minas que hay al rededor de la posicion dada por el jugador.
	int minasCountIn(String userPos) {
		int countMinas = 0;
		
		
		
		return countMinas;
	}
	
	
	//Tablero
	
	//Crear Tablero
	private static String[][] setUp() {
		int size = tablero.length;
		tablero = new String[size][size];
		char[] pos = {'0','A', 'B', 'C','D','E','F','G', 'H', 'I'}; 
		
		for(int row = 0 ; row < size; row ++) {
			for(int col = 0 ; col < size; col++) {
				tablero[row][col] = " - ";
			}
		}
		
		for(int row = 0; row < size; row ++) {
			tablero[row][0] = " " + pos[row]+ " ";
		}
		for(int col = 0; col < size; col++) {
			tablero[0][col] = " " + pos[col] + " ";
		}
		
		
		return tablero;
		
	}
	
	
}
