
public class GradStudent extends Student {

	private String thesisTopic;
	
	private final static String UNDEFINED_TOPIC = "Thesis Topic Undefined";
	
	public GradStudent(String firstName, String lastName, int studentID, String thesisTopic) {
		// first set up the parent part of the object
		super(firstName, lastName, studentID);
		
		// then do any child-specific initialization
		this.thesisTopic = thesisTopic;
	}
	
	// overloaded constructor
	public GradStudent(String firstName, String lastName, int studentID) {
		this(firstName, lastName, studentID, UNDEFINED_TOPIC);
	}
	
	public String getThesisTopic() {
		return thesisTopic;
	}
	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += "\n\tThesis: " + thesisTopic;
		return s;
	}
	
	
	
	
	
	
}
