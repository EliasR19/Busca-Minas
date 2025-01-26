package buscaMinas;

public class Mina {
	private char pos1;
	private char pos2;
	char[] pos = {'A', 'B', 'C','D','E','F','G', 'H', 'I'}; 
	
	public Mina(int max){
		pos1 = pos[randomNumEntre(max)];
		pos2 = pos[randomNumEntre(max)];
	}
	
	
public char getPos1() {
	return pos1;
}

public char getPos2() {
	return pos2;
}

public String getPosTotal() {
	return String.valueOf(pos1) + String.valueOf(pos2);
}

	
int randomNumEntre(int max) {
	int ranNum = (int)Math.round(Math.random()*10);
	while(ranNum >= max) {
		ranNum = (int)Math.round(Math.random()*10);
	}
	return ranNum;
}

//Test
public void setPosTotal(char pos1, char pos2) {
	this.pos1 = pos1;
	this.pos2 = pos2;
	}


}
