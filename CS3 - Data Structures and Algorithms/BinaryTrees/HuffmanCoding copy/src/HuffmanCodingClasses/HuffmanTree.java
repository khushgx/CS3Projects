package HuffmanCodingClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HuffmanTree {
	
	private static Node overallRoot; 
	
	 String st[] = new String[257];
	
	
	
	public HuffmanTree(int[] count) {
		
		 
		 
		 
		Queue<Node> tree = new PriorityQueue<Node>();
		
		Node node = new Node('\0',count.length, 1, null, null);
		tree.add(node);
		
		for (char c = 0; c < 256; c++) {
            if (count[c] > 0) {
                tree.add(new Node('\0',c, count[c], null, null));
                
            }
		}
		
		
		
		
		
		while(tree.size() > 1) {
			
			Node nod1 = tree.poll();
			Node nod2 = tree.poll();
			
			int totalFreq = nod1.countFrequency + nod2.countFrequency;
			
			Node combined = new Node('\0', -1, totalFreq, nod1, nod2);
			
			tree.add(combined);
			
			
		}
		
				
		overallRoot = tree.poll();
		
		
	
		
		
	}
	
	

	
	
	public void write(String filename) {

		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(filename + ".code");
			
			
			
		}
		catch(Exception e) {
			System.out.println("Could not create file: " + filename);
			
		}
		
		writeHelper(overallRoot, diskFile, "");
		diskFile.close();
		
		
	}
	


	private void writeHelper(Node node, PrintWriter diskFile, String path) {
		
	
		if(node != null) {
			if(node.left == null && node.right == null) {
				
				st[node.asciiCharacter] = path;
				diskFile.println(node.asciiCharacter + "\n" + path);
				
				
			} else {
				
				writeHelper(node.left, diskFile, path +"0");
				writeHelper(node.right, diskFile, path +"1");
				
			}
		
		
	}
	}
	//returns the lookup table
	public String[] codes() {
		
		
			
		
		return st;
	}
	
	public HuffmanTree(String codeFile) {
		
		overallRoot = new Node(-1, -1);
		
		try {
			Scanner x = new Scanner (new File(codeFile));
			
			while(x.hasNextLine()) {
				
				int asc = Integer.parseInt(x.nextLine());
				String code = x.nextLine();
				
				overallRoot = createTree(overallRoot, asc, code, 0);
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TreePrinter.printTree(overallRoot);
		
	}
	

	private Node createTree( Node node , int asc, String code, int index) {
		
		if(index == code.length()) {
			
			node = new Node(asc, -1);
			
		} else {
			
			char current = code.charAt(index);
			
			if(current == '0') {
				if(node.left == null) {
					node.left = new Node(-1, -1);
				}
				
				node.left = createTree(node.left, asc, code, index + 1);
			}
			
			if(current == '1') {
				if(node.right == null) {
					node.right = new Node (-1, -1);
				}
				
				node.right = createTree(node.right, asc, code, index + 1);
			}
			
		}
		
		
		
		return node;
	}
	
	public void decode(BitInputStream in, String outFile) {
		
		int ascii; 
		
		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(outFile + ".new");
			
			
			
			
		}
		catch(Exception e) {
			System.out.println("Could not create file: " + outFile);
			
		}
		
		while(true) {
			
			ascii = decodeHelper(in);
			
			if(ascii != 256) {
				diskFile.print((char) ascii);

				
			} else {
				break;
			}
			
			
		}
		
		
		diskFile.close();
		
		
	}
	
	public int decodeHelper(BitInputStream in) {
		Node temp = overallRoot;
		
		while(temp.left != null && temp.right !=null) {
			
			if(in.readBit() == 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
				
			}
			
		}
		
		return temp.asciiCharacter;
	}

} 
 