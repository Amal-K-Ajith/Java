
/** 
 * ----------------------------------------
 * SET sum INT 0
 * SET A INT 10
 * SET B INT 20
 * ADD sum A B
 * PRINT sum
 * ----------------------------------------
 * 
 * The above given content is a txt file giving Commands sorta like a interperter 
 * where SET is like initialising a varible and with value, in this case sum (variable) of int(Type) and value 0
 * Then adding A & B and saving sum to SUM
 * Print prints the sum
 * 
 * 
 * 
 * 
 * **/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandSen {

	ArrayList<Variable> ls = new ArrayList<Variable>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file to be executed :- ");
		String path = sc.nextLine();
		CommandSen cm = new CommandSen();
		File f = new File(path);
		cm.read(f);

		cm.display();
		sc.close();
	}

	public void read(File path) throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String cmd = br.readLine();

		while (cmd != null) {
			// System.out.println(cmd);
			String[] scmd = cmd.split(" ");

			if (scmd[0].equalsIgnoreCase("SET")) {
				if (scmd[2].equalsIgnoreCase("int")) {
					ls.add(new Variable(scmd[1], scmd[2], Integer.parseInt(scmd[3])));
				}
			}

			if (scmd[0].equalsIgnoreCase("ADD")) {
				for (Variable v : ls) {
					if (v.name.equalsIgnoreCase(scmd[1])) {
						int a = 0, b = 0;
						for (Variable v1 : ls) {
							if (v1.name.equalsIgnoreCase(scmd[2])) {
								a = (int) v1.value;
								break;
							}
						}
						for (Variable v1 : ls) {
							if (v1.name.equalsIgnoreCase(scmd[3])) {
								b = (int) v1.value;
								break;
							}
						}
						v.value = a + b;

						break;
					}
				}
			}

			if (scmd[0].equalsIgnoreCase("print")) {
				for (Variable v : ls) {
					if (v.name.equalsIgnoreCase(scmd[1])) {
						System.out.println(v.value);
						break;
					}
				}
			}
			cmd = br.readLine();
		}
		br.close();
	}

	public void display() {
		System.out.println("Values in memory\n----------");
		System.out.println("Var_Name\tVar_type\tValue");
		System.out.println("----------------------------------");

		for (Variable v : ls) {
			System.out.println(v.name + "\t\t" + v.varType + "\t\t" + v.value);
		}
	}

	private class Variable {
		String name, varType;
		Object value;

		Variable(String n, String t, Object v) {
			name = n;
			varType = t;
			value = v;
		}
	}
}
