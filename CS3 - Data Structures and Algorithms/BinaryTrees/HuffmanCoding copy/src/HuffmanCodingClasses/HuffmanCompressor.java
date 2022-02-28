package HuffmanCodingClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HuffmanCompressor {
	
	
	public static void compress(String filename) throws IOException {	
		
	
		//get the character frequencies	
			FileReader input = new FileReader(filename);
			
			int n = input.read();
			int[] count = new int[256];
			while(n != -1) {
				
				
				count[n] ++;
				n = input.read();
				
			}
			
			HuffmanTree t = new HuffmanTree(count);
			
			
			t.write(filename);
			
			//create the short file
			FileReader input2 = new FileReader(filename);
			BitOutputStream out = new BitOutputStream(filename + ".short");
			
			String[] codes = t.codes();
			int n2 = input2.read();
			while(n2 != -1) {
				
				
				writetoBits(codes[n2], out);
				n2 = input2.read();
			}
			
			
			writetoBits(codes[256], out);
			out.close();
			
			
		
	}
	
	public static void expand(String codeFile, String fileName) {
		
		HuffmanTree t = new HuffmanTree(codeFile);
		BitInputStream input = new BitInputStream(fileName);
		
		
		t.decode(input, fileName);
		
		
	}

	private static void writetoBits(String s, BitOutputStream output) {
		for (int i = 0; i < s.length(); i++)
			if(s.charAt(i) == '0') {
				output.writeBit(0);
			} else {
				output.writeBit(1);
			}
	}
}
