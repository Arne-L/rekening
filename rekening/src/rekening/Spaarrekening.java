package rekening;

public class Spaarrekening extends Rekening {
	
	/**
	 * @invar | balans >= 0
	 */
	private double balans;

	public double getBalans() {
		return balans;
	}
	
	public Spaarrekening() {}
	
	/**
	 * @throws IllegalArguementException | bedrag < 0
	 * 
	 * @post | getBalans() == old(getBalans()) + bedrag
	 */
	public void storten(double bedrag) {
		if (bedrag < 0)
			throw new IllegalArgumentException("Het bedrag is negatief");
		balans += bedrag;
	}
	
	/**
	 * @throws IllegalArgumentException | bedrag < 0
	 * 
	 * @post | result == 0
	 */
	public double afhalen(double bedrag) {
		if (bedrag < 0)
			throw new IllegalArgumentException("Het bedrag is negatief.");
		return 0;
		
	}
}
