import java.util.Scanner;


public class Main {
	public static void main(String [] args) {
		Scanner read = new Scanner(System.in);
		char repeat;
		
		do {
			run();
			repeat = read.next().charAt(0);
		} while (repeat == 'y');
		
	}
	
	public static void run() {
		Scanner read = new Scanner(System.in);
		String line;
		int whitespaceCounter = 0;
		char [] array;
		
		System.out.print("Enter a statement: ");
		line = read.nextLine();
		
		array = line.toCharArray();
		
		for (int i = 0; i < line.length(); ++i) {
			if (Character.isWhitespace(array[i]) != true) {
				whitespaceCounter++;
			}
		}
		
		String [] token = line.split(" ", (whitespaceCounter + 1));
		
		
		System.out.println("There are " + token.length + " tokens");
		
		for (int i = 0; i < token.length; i++) {
			if (isReservedWord(token[i]) == true) {
				System.out.println(token[i] + "\t" + "reserved word");
			}
			else if (isSpecialChar(token[i]) == true) {
				System.out.println(token[i] + "\t" + "special character");
			}
			else if (isIdentifier(token[i]) == true) {
				System.out.println(token[i] + "\t" + "identifier");
			}
			else if (isNumeric(token[i]) == true) {
				System.out.println(token[i] + "\t" + "number");
			}
			else {
				System.out.println(token[i] + "\t" + "nothing");
			}
		}	
	}
	
	public static boolean isReservedWord(String word) {
		
		String [] reservedWords = {"bool", "int", "char", "double", "float", "if", "else", "else if", "while", "do", "for", "cout<<", "cin>>" };
		for (int i = 0; i < reservedWords.length; i++) {
			if (reservedWords[i].equals(word)) {
				return true;
			} 
		}
		return false;
	}
	
	public static boolean isSpecialChar(String character) {
		String [] specialChar = {"&&", "+", "=", ";", "/", "%", "*", "-", "==", "{", "}", "(", ")", "<=", ">=", "++", "--"};
		for (int i = 0; i < specialChar.length; ++i) {
			if (specialChar[i].equals(character)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isIdentifier(String word) {
		char [] arr = word.toCharArray();
		if (Character.isDigit(arr[0]) == true) {
			return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}	
}

/*output:
 * Enter a statement: for ( int tom_jones = 22 ; tom_jones <= 100 ; tom_jones = tom + 1 ) cout<< 2tom ;
There are 20 tokens
for	reserved word
(	special character
int	reserved word
tom_jones	identifier
=	special character
22	number
;	special character
tom_jones	identifier
<=	special character
100	number
;	special character
tom_jones	identifier
=	special character
tom	identifier
+	special character
1	number
)	special character
cout<<	reserved word
2tom	nothing
;	special character
*/
