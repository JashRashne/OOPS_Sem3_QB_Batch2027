import java.util.*;
class Student {

    private String name;
    private int id;
    private String branch;
    
    static String collegeName = "Thadomal Shahani Engineering College";

    static int itCount = 0;
    static int computersCount = 0;

    public Student(String name, int id, String branch) throws InvalidBranchException {
        this.name = name;
        this.id = id;
        setBranch(branch);
    }

    private void setBranch(String branch) throws InvalidBranchException {
        if (branch.equalsIgnoreCase("IT")) {
            itCount++;
            this.branch = "IT";
        } else if (branch.equalsIgnoreCase("Computers")) {
            computersCount++;
            this.branch = "Computers";
        } else {
            throw new InvalidBranchException("Invalid branch! Allowed branches are IT and Computers.");
        }
    }

    public String getBranch() {
        return branch;
    }

    public static void displayCounts() {
        System.out.println("Number of students in IT branch: " + itCount);
        System.out.println("Number of students in Computers branch: " + computersCount);
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Branch: " + branch);
        System.out.println("College: " + collegeName);
        System.out.println();
    }
}

class InvalidBranchException extends Exception {
    public InvalidBranchException(String message) {
        super(message);
    }
}

public class UserDefinedExceptions {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        while(true){
		System.out.print("1.Enter Student Details\n2.Display Student Count\n");
		int op = sc.nextInt();
		sc.nextLine();
		switch(op){
			case 1 -> {
				System.out.print("Enter Student Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Student ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Branch: ");
				String branch = sc.nextLine();
				try {
					Student s1 = new Student(name , id , branch);
					s1.displayStudentInfo();
				}catch(InvalidBranchException e){
					System.out.println(e.getMessage());
				}
			}
			case 2 -> {
				Student.displayCounts();
			}
		}
		System.out.print("Do you to continue(y/n): ");
		String ch = sc.nextLine();
		if(ch.equals("n")) System.exit(1);
		else continue;
	}
    }
}
