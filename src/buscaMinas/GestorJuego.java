package buscaMinas;

public class GestorJuego {
	public static String[][] tablero = new String[8][8];
	Mina[] minas = new Mina[5];
	
	char[] pos = {'0', 'A', 'B', 'C','D','E','F','G', 'H', 'I'}; 
	
	//constructor
	public GestorJuego() {
		tablero = setUp();
		minas = setUpMinas(minas);
		//cambiarMinasMismaPos();
		//MinaTets
		minas[0].setPosTotal('A', 'C');
	}
	

	//comportamiento
	
	//jugada
	public void jugar(String posUser) {
		System.out.println("User play position: " + posUser);
		
		evaluarPierde(posUser);
		
		
	}
	
	//Evaluia si la posicion jugada es la misma posiicon de la mina
	private void evaluarPierde(String posUser) {
		for(int x=0; x < minas.length; x++) {
			if(posUser.equals(minas[x].getPosTotal())) { // si la es muestra todas las minas del tablero y pierde.
				//tablero[buscarPosEnTablero(posUser)[0]][buscarPosEnTablero(posUser)[1]] = " X ";
				showAllMines();
				System.out.println("YouLose!"); //End game
				
			}
		}
	}
	
	
	private void showAllMines() { // muestra todas las minas del tablero
		for(int x = 0; x < minas.length; x++) {
			tablero[pasarLetraANum(minas[x].getPosTotal(),0)][pasarLetraANum(minas[x].getPosTotal(),1)] = " X ";
		}
		
	}


	private int[] buscarPosEnTablero(String posUser) {
		int[] posUserNum = new int[2];
		posUserNum[0] = pasarLetraANum(posUser, 0);
		//System.out.println(String.valueOf(pos1));
		posUserNum[1] = pasarLetraANum(posUser, 1);
		//System.out.println(String.valueOf(pos2));
		return posUserNum;
			
	}

	
	private int pasarLetraANum(String posUser, int i) { // pasa el character i del string mandado por el usuario a int ( dependiendo la posicion de las posicion que hay char[] pos)
		for(int x = 1; x < pos.length; x++) {
			if(posUser.charAt(i) == pos[x]) {
				//System.out.println("aca : " + posUser.charAt(i) + " - " +  x );
				return x;
			}
		}
		
		return -1;
	}

	
	
	//Minas
	private Mina minaFactory() {
		Mina mina = new Mina(8);
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
