/**
 * Delay and Counter Utility Library for Processing 3
 * 
 * Copyright (c) 2021 ktxo.art@gmail.com
 * 
 */
package ktxo.art.processing.util;

/**
 * Counter class allowing increment/decrement a value and loop between limits
 * 
 * @author ktxo.art@gmail.com
 *
 */
public class LoopCounter {
	float currentValue = 0;
	float currentValueOri = currentValue;
	float lowerValue = 0;
	float upperValue = 255;
	float incr = 1;
	int direction = 1;
	boolean loop = true;
	boolean directionFlag = true;

	/**
	 * Constructor
	 * 
	 * @param initialValue Initial counter value
	 * @param lowerValue  Lower counter value 
	 * @param upperValue  Upper counter value 
	 * @param incrementValue  Increment counter value
	 * @param loop           Enable/disable counter loop or not after reach the
	 *                       limits
	 */
	public LoopCounter(float initialValue, float lowerValue, float upperValue, float incrementValue, boolean loop) {
		reset(initialValue, lowerValue, upperValue, incrementValue, loop);
	}

	/**
	 * Constructor
	 * 
	 * @param initialValue Initial counter value
	 * @param lowerValue  Lower counter value 
	 * @param upperValue  Upper counter value 
	 * @param incrementValue  Increment counter value
	 */
	public LoopCounter(float initialValue, float lowerValue, float upperValue, float incrementValue) {
		reset(initialValue, lowerValue, upperValue, incrementValue, true);
	}

	/**
	 * Default constructor (initialValue=0, lowerValue=0, upperValue=255,
	 * incrementValue=1
	 */
	public LoopCounter() {
		reset(0F, 0F, 255F, 1F, true);
	}

	/**
	 * Return current counter value or limits if are reached and increment/decrement the counter
	 * 
	 * @return Current counter value or limits if are reached
	 */
	public float next() {
		float val = currentValue;
		if (currentValue <= lowerValue && direction == -1) {
			if (!loop) {
				return lowerValue;
			}
			direction = 1;
		} else if (currentValue >= upperValue && direction == 1) {
			if (!loop) {
				return upperValue;
			}
			direction = -1;
		}
		currentValue += (float) direction * incr;
		return val;
	}

	/**
	 * Reset counter to the original values
	 */
	public void reset() {
		currentValue = currentValueOri;
		direction = 1;
	}

	/**
	 * Reset counter to new values
	 * 
	 * @param initialValue Initial counter value
	 * @param lowerValue  Lower counter value 
	 * @param upperValue  Upper counter value 
	 * @param incrementValue  Increment counter value
	 * @param loop Enable/disable loop
	 */
	public void reset(float initialValue, float lowerValue, float upperValue, float incrementValue, boolean loop) {
		this.currentValue = initialValue;
		this.currentValueOri = initialValue;
		this.incr = incrementValue;
		if (lowerValue < upperValue) {
			this.lowerValue = lowerValue;
			this.upperValue = upperValue;
		} else {
			this.lowerValue = upperValue;
			this.upperValue = lowerValue;
			this.direction = -1;
		}
		this.loop = loop;
	}

	/**
	 * Return current counter value
	 * 
	 * @return current counter value
	 */
	public float getCurrentValue() {
		return currentValue;
	}

	/**
	 * Return counter lower value
	 * 
	 * @return counter lower value
	 */
	public float getLowerValue() {
		return lowerValue;
	}

	/**
	 * Return counter upper value
	 * 
	 * @return counter upper value
	 */
	public float getUpperValue() {
		return upperValue;
	}

	/**
	 * @param args None
	 */
	public static void main(String[] args) {
		LoopCounter L1 = new LoopCounter(0F, 0F, 5F, 1F, false); // OK
		LoopCounter L2 = new LoopCounter(0F, 0F, 5F, 1F, true); // OK
		LoopCounter L3 = new LoopCounter(5F, 5F, 0F, 1F, false); // OK
		LoopCounter L4 = new LoopCounter(5F, 5F, 0F, 1F, true); // OK
		LoopCounter L5 = new LoopCounter(3F, 0F, 5F, 1F, true); // OK
		LoopCounter L6 = new LoopCounter(1F, 1F, 0F, 0.2F, true); // OK
		System.out.println("---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L1.next() + " | ");
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L2.next() + " | ");
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L3.next() + " | ");
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L4.next() + " | ");
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L5.next() + " | ");
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 16; i++) {
			System.out.print(L6.next() + " | ");
		}

	}
}
