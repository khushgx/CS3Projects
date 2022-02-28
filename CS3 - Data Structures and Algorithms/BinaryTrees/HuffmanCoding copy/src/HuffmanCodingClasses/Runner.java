package HuffmanCodingClasses;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		int[] count = new int[256];
		
		
		count[97] = 3;
		count[98] = 3;
		count[99] = 1;
		count[120] = 1;
		count[121] = 1;
		HuffmanTree x = new HuffmanTree(count);
		x.write("Output3");
		
		x.codes();
		

		HuffmanTree y = new HuffmanTree("Output3.");
		
		HuffmanCompressor t;
		
		HuffmanCompressor.compress("happy hip hop");
		
		
		
		
		
		
		
	}

}
