package rekening;

public class Zichtrekening extends Rekening {
	
	/**
	 * @invar | balans >= 0
	 * @invar | kredietlimiet >= 0
	 */
	private double balans;
	private double kredietlimiet;
	
	public double getBalans() {
		return balans;
	}
	
	public double getKredietlimiet() {
		return kredietlimiet;
	}
	
	/**
	 * @throws IllegalArgumentException | kredietlimiet < 0
	 * 
	 * @post | kredietlimiet == getKredietlimiet()
	 */
	public Zichtrekening(double kredietlimiet) {
		if (kredietlimiet < 0)
			throw new IllegalArgumentException("De kredietlimiet is negatief.");
		this.kredietlimiet = kredietlimiet;
	}
	
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
	 * @post | ((result == bedrag) || (result == old(getBalans()) + getKredietlimiet()))
	 */
	public double afhalen(double bedrag) {
		if (bedrag < 0)
			throw new IllegalArgumentException("Het bedrag is negatief.");
		if (balans - bedrag < -kredietlimiet) {
			double resultaat = balans + kredietlimiet;
			balans = kredietlimiet;
			return resultaat;
		}
		else {
			balans -= bedrag;
			return bedrag;
		}
	}
	
	@Override 
	public String toString() {
		return super.toString() + ", kredietlimiet: " + kredietlimiet;
	}
	
	/**
	 * @throws IllegalArgumentException | other == null
	 * 
	 * @post | result == ((this.getClass() == other.getClass()) && (getBalans() == ((Rekening)other).getBalans()) && (getKredietlimiet() == ((Zichtrekening)other).getKredietlimiet()))
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			throw new IllegalArgumentException("'other' is null");
		return super.equals(other) && 
				kredietlimiet == ((Zichtrekening)other).kredietlimiet;
	}

}
