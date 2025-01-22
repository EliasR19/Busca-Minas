package buscaMinas;

public class Mina {
	private int pos1;
	private int pos2;
	
	public Mina(int a, int b){
		pos1 = randomNumEntre(a, b);
		pos2 = randomNumEntre(a, b);
	}
	
	
public int getPos1() {
	return pos1;
}

public int getPos2() {
	return pos2;
}

public String getPosTotal() {
	return String.valueOf(pos1) + String.valueOf(pos2);
}

	
int randomNumEntre(int a, int b) {
	int ranNum = (int)Math.round(Math.random()*10);
	while(ranNum <= a || ranNum >= b) {
		ranNum = (int)Math.round(Math.random()*10);
	}
	return ranNum;
}
}
