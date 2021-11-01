package MelodyMakerClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Melody {

	Queue<Note> notes;

	public Melody(Queue<Note> song) {
		notes = new LinkedList<>(song);
	}

	public double getTotalDuration() {
		
		Queue<Note> temp = new LinkedList<>(notes);
		double total = 0;
		int count = 0;

		for (int i = 0; i < notes.size(); i++) {
			Note note = temp.poll();
			total += note.getDuration();

			if (note.isRepeat()) {
				count++;
				total += note.getDuration() * 2;
				while (count == 1) {

					total += note.getDuration() * 2;

					if (note.isRepeat()) {

						count++;
					}
				}

			}

		}
		return total;

	}

	public String toString() {
		
		Queue<Note> temp = new LinkedList<>(notes);
		String s = "";
		
		
		for(int i = 0; i < notes.size(); i++) {
			Note note= temp.poll();
			s += " Pitch: "  + note.getPitch() + " Octave: " + note.getOctave() + " Duration: " + note.getDuration() + " Accidental: "  + note.getAccidental();
		}
		
		return s;
	}

	public void changeTempo(double tempo) {
		
		
		Queue<Note> temp = new LinkedList<>(notes);
		
		for(int i = 0; i < notes.size(); i++) {
			Note note= temp.poll();
			
			note.setDuration(note.getDuration() * 1/tempo);
		}
		
		
		
		 
		
		
	}

	public void reverse() {
		
		ArrayList<Note> temp = new ArrayList<>();
		
		while(!notes.isEmpty()) {
			temp.add(notes.poll());
			
		}
		
		 Collections.reverse(temp);
		 
		 for(int i = 0; i < temp.size(); i++) {
			 
			 notes.offer(temp.get(i));
			 
		 }

	}

	public void append(Melody other) {
		
		Queue<Note> temp = new LinkedList<>(other.getNotes());
		
		while(!temp.isEmpty()) {
			
			notes.offer(temp.poll());
			
		}

	}

	public void play() {
		
		Queue<Note> temp = new LinkedList<>(notes);
		Queue<Note> repeat = new LinkedList<>();
		boolean isRepeat = false;
		
		for(int i = 0; i < notes.size(); i++) {
			
			Note note = temp.poll();
			
			
			note.play();
			
			if(note.isRepeat()) {
				if(isRepeat) {
					repeat.offer(note);
					
				}
				while(!repeat.isEmpty()) {
					repeat.poll().play();
				}
				
				isRepeat =  !isRepeat;
				
			}
			if(isRepeat) {
				repeat.offer(note);
			}
			
			
			
		}
		
		

	}

	public Queue<Note> getNotes() {

		return notes;
	}

}
