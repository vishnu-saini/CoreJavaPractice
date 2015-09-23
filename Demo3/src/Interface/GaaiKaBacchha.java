package Interface;

/* File name : MammalInt.java */
public class GaaiKaBacchha implements Animal, Living {

	public void eat() {
		System.out.println("Mammal eats");
	}

	public void travel() {
		System.out.println("Mammal travels");
	}

	public int noOfLegs() {
		return 0;
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("bhai m living thing bhi hu");
	}

	public void meraFunction() {
		System.out.println("ye mera function  h");

	}
}