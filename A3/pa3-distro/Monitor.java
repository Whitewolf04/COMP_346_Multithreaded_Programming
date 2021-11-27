import java.util.ArrayList;

/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	ArrayList<Integer> chopsticks = new ArrayList<Integer>();
	int speakerAvailable = 1;


	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		// TODO: set appropriate number of chopsticks based on the # of philosophers
		for(int i = 0; i < piNumberOfPhilosophers; i++){
			chopsticks.add(1);
		}
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID)
	{
		int leftChopstick = piTID - 1;
		int rightChopstick = piTID;

		if(rightChopstick >= chopsticks.size()){
			rightChopstick = 0;
		}
		
		// Wait until both chopsticks are available
		while(this.chopsticks.get(leftChopstick) == 0 || this.chopsticks.get(rightChopstick) == 0){
			try{
				wait();
			} catch(InterruptedException e){}
		}
		// Chopsticks available
		this.chopsticks.set(leftChopstick, 0);
		this.chopsticks.set(rightChopstick, 0);
		System.out.println("Philosopher " + piTID + " has acquired the chopsticks");
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		int leftChopstick = piTID - 1;
		int rightChopstick = piTID;

		if(rightChopstick >= chopsticks.size()){
			rightChopstick = 0;
		}

		this.chopsticks.set(leftChopstick, 1);
		this.chopsticks.set(rightChopstick, 1);
		notifyAll();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{
		// Wait until the other speaker has finished talking
		while(this.speakerAvailable == 0){
			try{
				wait();
			} catch(InterruptedException e){}
		}
		// When the last speaker has done talking, lock the speaker slot
		this.speakerAvailable = 0;
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		this.speakerAvailable = 1;
	}
}

// EOF
