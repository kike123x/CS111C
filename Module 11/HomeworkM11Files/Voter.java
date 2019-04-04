public class Voter {

	private int id;
	private String name;

	public Voter(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " (" + id + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Voter) {
			Voter otherVoter = (Voter) obj;
			return id == otherVoter.id && name.equals(otherVoter.name);
		} else {
			return false;
		}
	}


}
