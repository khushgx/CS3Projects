package Runner;

import java.util.*;

import java.io.*;

public class FindWords {

	private Set<String> dictionary;

	private Set used;

	private Queue wordLadder;

	/**
	 * 
	 * Constructor.
	 * 
	 * Initialize private data fields
	 * 
	 */

	public FindWords() throws IOException {

		dictionary = new HashSet<String>();

		wordLadder = new LinkedList<>();

		used = new HashSet<>();

		readDictionary("dictionary.txt");

	}

	/**
	 * 
	 * Reads the dictionary and store it in the hash table
	 * 
	 */

	public void readDictionary(String urlString) throws IOException {

		FileInputStream dataStream = new FileInputStream(urlString);

		Scanner fileIn = new Scanner(dataStream);

		String word;

		while (fileIn.hasNextLine()) {

			word = fileIn.nextLine();

			dictionary.add(word);

		}

	}

	public Stack buildLadder(String start, String end) {

		Stack ladder = new Stack<>();

		Queue q = new LinkedList<>();

		Stack temp = new Stack<>();

		temp.push(start);

		q.offer(temp);

		dictionary.remove(start);

		while (!q.isEmpty()) {

			temp = (Stack) q.poll();

			String last = (String) temp.peek();

// System.out.println(temp);

			Iterator<String> iter = dictionary.iterator();

			while (iter.hasNext()) {

				String s = iter.next();

				if (isAnEdge(last, s)) {

// System.out.println(last);

// System.out.println(s);

					Stack stack2 = (Stack) temp.clone();

					stack2.push(s);

					iter.remove();

					q.offer(stack2);

					if (s.equals(end)) {

						ladder = stack2;

						return ladder;

					}

				}

			}

		}

		return ladder;

	}

	private boolean isAnEdge(String w1, String w2) {

		if (w1.length() != w2.length())
			return false;

		int numdiff = 0;

		for (int i = 0; i < w1.length(); i++) {

			if (w1.charAt(i) != w2.charAt(i))
				numdiff++;

			if (numdiff > 1)
				break;

		}

		return numdiff == 1;

	}

}
