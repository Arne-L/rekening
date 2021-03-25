package rekening;

public abstract class Rekening {
	
	public abstract double getBalans();
	
	/**
	 * @pre | bedrag < 0
	 * 
	 * @post | getBalans() == old(getBalans()) + bedrag
	 */
	public abstract void storten(double bedrag);
	
	/**
	 * @pre | bedrag >= 0
	 * 
	 * @post | getBalans() >= old(getBalans()) - bedrag
	 * @post | 0 <= result && result <= bedrag
	 */
	public abstract double afhalen(double bedrag);
	
	/**
	 * @pre | other != null
	 * 
	 * @post | result == (this.getClass() == other.getClass() && getBalans() == ((Rekening)other).getBalans())
	 */
	@Override
	public boolean equals(Object other) {
		return this.getClass() == other.getClass() && getBalans() == ((Rekening)other).getBalans();
	}
	
	
	@Override 
	public String toString() {
		return "balans: " + getBalans();
	}
}
