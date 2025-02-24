import java.util.List;
import java.util.Stack;

public class HomeworkM12FolderDriver {

	public static void main(String[] args) {
    	Folder folder1 = new Folder("Folder1");
    	Folder folder2 = new Folder("Folder2");
    	Folder folder3 = new Folder("Folder3");
    	Folder folder4 = new Folder("Folder4");
    	Folder folder1a = new Folder("Folder1a");
    	Folder folder1b = new Folder("Folder1b");
    	Folder folder2a = new Folder("Folder2a");
    	Folder folder2b = new Folder("Folder2b");
    	Folder folder2c = new Folder("Folder2c");
    	Folder folder4a = new Folder("Folder4a");
    	Folder folder4b = new Folder("Folder4b");
    	folder1.addFolder(folder1a);
    	folder1.addFile(new File("File1-1"));
    	folder1.addFile(new File("File1-2"));
    	folder1.addFolder(folder1b);
    	folder2.addFolder(folder2a);
    	folder2.addFolder(folder2b);
    	folder2.addFolder(folder2c);
    	folder3.addFile(new File("File3-1"));
    	folder4.addFolder(folder4a);
    	folder4.addFile(new File("File4-1"));
    	folder4.addFile(new File("File4-2"));
    	folder4.addFolder(folder4b);

    	folder1a.addFile(new File("File1a-1"));
    	folder1a.addFile(new File("File1a-2"));
    	folder1b.addFile(new File("File1b-1"));
    	folder2a.addFile(new File("File2a-1"));
    	folder2a.addFile(new File("File2a-2"));
    	folder2a.addFile(new File("File2a-3"));
    	folder2c.addFile(new File("File2c-1"));
    	folder4b.addFile(new File("File4b-1"));
    	folder4b.addFile(new File("File4b-2"));
    	folder4b.addFile(new File("File4b-3"));

    	Folder topFolder = new Folder("TopFolder");
    	topFolder.addFolder(folder1);
    	topFolder.addFolder(folder2);
    	topFolder.addFolder(folder3);
			topFolder.addFolder(folder4);

			printFolderContentsRecursive(topFolder);
			printFolderContentsWithStack(topFolder);

			// Folder newFolder = new Folder("newFolder");
			// newFolder.addFolder(topFolder);
			// Folder sampleFolder = new Folder("Hi");
			// newFolder.addFile(new File("Hello"));
			// newFolder.addFolder(sampleFolder);
			// sampleFolder.addFolder(topFolder);
			// newFolder.addFolder(topFolder);

    	// printFolderContentsRecursive(newFolder);
    	// printFolderContentsWithStack(newFolder);

	}

	public static void printFolderContentsRecursive(Folder topFolder) {
		printFolderContentsHelper(topFolder, 0);
	}
	private static void printFolderContentsHelper(Folder topFolder, int indentationIndex) {
		for(int i=0; i<indentationIndex; i++) {
			System.out.print("   ");
		}
		System.out.println(topFolder);
		if(!topFolder.getFileList().isEmpty()) {
			for(int i=0; i<indentationIndex+1; i++) {
				System.out.print("   ");
			}
			System.out.println(topFolder.getFileList()); // small part solving now- print the files in the current folder
		}

		List<Folder> subfolderList = topFolder.getFolderList();
		for(Folder subfolder : subfolderList) {
			printFolderContentsHelper(subfolder, indentationIndex+1); // recursive call
		}


		// implicit base case- happens when a folder has no more subfolders- the recursion will end

	}

	public static void printFolderContentsWithStack(Folder topFolder) {
		Stack<Folder> folderStack = new Stack<Folder>();
		folderStack.push(topFolder);
		// keeps track of how many folders at each level/branch
		Stack<Integer> levels = new Stack<Integer>();
		levels.push(1); // 1 topFolder at level 1

		while (!folderStack.isEmpty()) {
			// if no more folders at current level, proceeds to its parent folder's sibling
			if (levels.peek().equals(0)){
				levels.pop();
			} else {
				// prints current folder name
				Folder current = folderStack.pop();
				for (int count = 1; count < levels.size(); count++) {
					System.out.print("   ");
				}
				System.out.println(current);

				// prints files in current folder
				List<File> fileList = current.getFileList();
				if (!fileList.isEmpty()) {
					for (int count = 1; count < levels.size() + 1; count++) {
						System.out.print("   ");
					}
					System.out.println(fileList);
				}

				// decreases count of remaining folders to print at this level
				Integer remainCount = levels.pop();
				remainCount--;
				levels.push(remainCount);

				// handles subfolders of the current folder
				List<Folder> folderList = current.getFolderList();
				if (!folderList.isEmpty()) {
					for (int index = folderList.size() - 1; index >= 0; index--) {
						Folder subFolder = folderList.get(index);
						folderStack.push(subFolder);
					}
					// adds a new level of subfolders
					levels.push(folderList.size());
				}
			}
		}
	}


}
