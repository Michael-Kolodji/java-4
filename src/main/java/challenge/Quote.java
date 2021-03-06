package challenge;

public class Quote {

	private String actor;
	private String quote;

	public Quote(String actor, String quote) {
		this.actor = actor;
		this.quote = quote;
	}
	
	public String getActor() {
		return this.actor;
	}

	public String getQuote() {
		return this.quote;
	}

	@Override
	public String toString() {
		return "Quote [actor=" + actor + ", quote=" + quote + "]";
	}

}
