public class Card {
	private char symbol;
	private int number;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(char symbol, int number) {
		this.symbol=symbol;
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}
