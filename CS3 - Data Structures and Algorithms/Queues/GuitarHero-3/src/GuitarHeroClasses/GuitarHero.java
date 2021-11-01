package GuitarHeroClasses;

public class GuitarHero {
	
	

	    public static void main(String[] args) {

	        
	        double CONCERT_A = 440.0;
	        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	        GuitarString[] notes = new GuitarString[37];
	        int sample = 0;

	        // the main input loop
	        while (true) {

	            // check if the user has typed a key, and, if so, process it
	            if (StdDraw.hasNextKeyTyped()) {
	 
	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                // pluck the corresponding string
	                 for(int i = 0; i < notes.length; i++ ) {
	                	 notes[i] = new GuitarString(( (CONCERT_A * Math.pow(1.05956, keyboard.indexOf(key) - 24))));
	                	 notes[i].pluck();
	                	  sample += notes[i].sample();
	                	 StdAudio.play(sample);
	                	 notes[i].tic();
	                 
	                 }
	            }

	            // compute the superposition of the samples
	            

	            // send the result to standard audio
	           

	            // advance the simulation of each guitar string by one step
	           
	        }
	    }

	}


