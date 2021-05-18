import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList alphabet = new ArrayList();
		char[] keyValue = { 'k', 'e', 'y' };
		String plaintext = "";
		String newPlaintext = "";
		String oldKey = "";
		String newKey = "";
		String encrypted = "";
		String decrypted = "";

		// adding alphabet
		for (int i = 97; i <= 122; i++) {
			// change int to ascii
			alphabet.add((char) i);
		}

		// get plaintext
		System.out.print("Enter Plaintext: ");
		plaintext = scn.next().toLowerCase();

		// create oldKey
		for (int i = 0; i < plaintext.length(); i++) {
			oldKey += keyValue[i % 3];
		}

		// create newKey
		for (int i = 0; i < oldKey.length(); i++) {
			int keyIndex = alphabet.indexOf(oldKey.charAt(i)); // find index
			keyIndex = (keyIndex + 3) % 26; // 3 right shift and mode26
			newKey += alphabet.get(keyIndex);
		}
		
		// encryption operation
		for (int i = 0; i < plaintext.length(); i++) {
			int keyIndex = alphabet.indexOf(newKey.charAt(i));
			int plainIndex = alphabet.indexOf(plaintext.charAt(i));
			plainIndex = ((plainIndex - 3)+26) % 26; // plaintext 3 left shift and mode26
			newPlaintext += alphabet.get(plainIndex);
			int newIndex = (keyIndex + plainIndex) % 26;
			encrypted += alphabet.get(newIndex);
		}
		

		// decryption operation
		for (int i = 0; i < encrypted.length(); i++) {
			int keyIndex = alphabet.indexOf(newKey.charAt(i));
			int plainIndex = alphabet.indexOf(encrypted.charAt(i));
			int newIndex = ((plainIndex - keyIndex)+26) % 26;
			newIndex = (newIndex + 3) % 26;
			decrypted += alphabet.get(newIndex);
		}
		System.out.println("***********************************");
		System.out.println("Old Key: " + oldKey);
		System.out.println("New Key(old key 3 shifted to the right): " + newKey);
		System.out.println("Plaintext: " + plaintext);
		System.out.println("New Plaintext(plaintext 3 shifted to the left): " + newPlaintext);
		System.out.println("---> Encrypted(new plaintext + new key): " + encrypted);
		System.out.println("---> Decrypted((encrypted - new key) then 3 shifted right): " + decrypted);
	}
}
