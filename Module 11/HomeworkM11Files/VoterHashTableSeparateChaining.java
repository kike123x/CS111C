import java.util.Objects;

public class VoterHashTableSeparateChaining {

	private Node<Voter>[] hashTable;
	private int tableSize;

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}

	public int getHashLocation(int voterID) {
		int hashLocation = voterID % tableSize;
		return hashLocation;
	}

	// completed extra credit
	public boolean addVoter(Voter voterToAdd) {
		int hashLocation = getHashLocation(voterToAdd.getId());
		if (hashTable[hashLocation] == null) {
			hashTable[hashLocation] = new Node(voterToAdd);
			return true;
		} else {
			Node currentNode = hashTable[hashLocation];
			while (currentNode != null) {
				if (voterToAdd.equals(currentNode.getData())) {
					return false;
				} else if (currentNode.getNextNode() != null) {
					currentNode = currentNode.getNextNode();
				} else {
					break;
				}
			}
			currentNode.setNextNode(new Node(voterToAdd));
			return true;
		}
	}

	public Voter getVoter(int voterID) {
		int hashLocation = getHashLocation(voterID);
		if (hashTable[hashLocation] != null) {
			Node currentNode = hashTable[hashLocation];
			while(currentNode != null) {
				Voter person = (Voter) currentNode.getData();
				if (person.getId() == voterID) {
					return person;
				} else {
					currentNode = currentNode.getNextNode();
				}
			}
		}
		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print(i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
