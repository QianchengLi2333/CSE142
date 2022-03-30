//<Qiancheng Li>
//<10/9/2020>
//CSE142 Section <A>
//<TA: Emily Whelan>
//<Take-home Assessment #2>
//
//<This program will produce the ASCII art 
//of Space Needle in Seattle>

public class SpaceNeedle {
	//Set the value of class constant SIZE
	public static final int SIZE = 4;

    //Draw the needle-like top part of Space Needle
	public static void needle() {
		for (int line = 0; line < SIZE; line++) {
			for (int space = 0; space < 3 * SIZE; space++) {
				System.out.print(" ");
			}
			System.out.println("||");
		}
	}

    //Draw the base of Space Needle
	public static void base() {
		for (int line = 0; line < SIZE; line++) {
			for (int space = 0; space < 3 * (SIZE - line - 1); space++) {
				System.out.print(" ");
			}
			System.out.print("__/");
			for (int colon = 0; colon < 3 * line; colon++) {
				System.out.print(":");
			}
			System.out.print("||");
			for (int colon = 0; colon < 3 * line; colon++) {
				System.out.print(":");
			}
			System.out.println("\\__");
		}
		System.out.print("|");
		for (int quotation = 0; quotation < 3 * SIZE; quotation++) {
			System.out.print("\"\"");
		}
		System.out.println("|");
	}

    //Draw the lower half of Space Needle's "bump"
	public static void bottomHalf() {
		for (int line = 0; line < SIZE; line++) {
			for (int space = 0; space < 2 * line; space++) {
				System.out.print(" ");
			}
			System.out.print("\\_/");
		    for (int spike = 0; spike < -2 * line + (3 * SIZE - 2); spike++) {
				System.out.print("\\/");
			}
			System.out.println("\\_/");
		}
	}

    //Draw the long body of Space Needle
	public static void body() {
		for (int line = 0; line < SIZE * SIZE; line++) {
			for (int space = 0; space < 2 * SIZE + 1; space++) {
				System.out.print(" ");
			}
			System.out.print("|");
			for (int mod = 0; mod < SIZE -2; mod++) {
				System.out.print("%");
			}
			System.out.print("||");
			for (int mod = 0; mod < SIZE -2; mod++) {
				System.out.print("%");
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		needle();
		base();
		bottomHalf();
		needle();
		body();
		base();
	} 
}
