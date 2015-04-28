package com.tranware.cordova;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for parsing track 2 data.  To use it, create an instance and
 * call {@link #find(String)}.  Call the other methods only if <tt>find</tt>
 * returned true.  Similarly, the methods that get the expiration date should
 * only be called if {@link #hasExpiration()} returns true.  An instance can
 * be reused by calling <tt>find</tt> again with new data.
 *
 * @author Kevin Krumwiede
 */
public class Track2MatcherX {
	// this will not match if the input does not include the sentinels
	// it could be made to if required
	private final Matcher matcher = Pattern.compile(";([0-9]+)(=([0-9]{4})([0-9]*))?\\?").matcher("");
	
	/**
	 * Tests if the track data contains a track 2.
	 * 
	 * @param trackData the track data
	 * @return true if the track data contains a track 2; otherwise false
	 */
	public boolean find(String trackData) {
		matcher.reset(trackData);
		return matcher.find();
	}
	
	/**
	 * Gets the complete track 2 including the sentinels.
	 * 
	 * @return the track 2
	 */
	public String getTrack2() {
		return matcher.group();
	}
	
	/**
	 * Gets the card number.
	 * 
	 * @return the card number
	 */
	public String getCard() {
		return matcher.group(1);
	}
	
	/**
	 * Tests if the track 2 includes an expiration date.
	 * 
	 * @return true if the track 2 includes an expiration date; otherwise
	 * false
	 */
	public boolean hasExpiration() {
		return matcher.group(3) != null;
	}
	
	/**
	 * Gets the expiration date in YYMM format.
	 * 
	 * @return the expiration date in YYMM format
	 */
	public String getExpYYMM() {
		return matcher.group(3);
	}
	
	/**
	 * Gets the expiration date in MMYY format.
	 * 
	 * @return the expiration date in MMYY format
	 */
	public String getExpMMYY() {
		return matcher.group(3).substring(2, 4) + matcher.group(3).substring(0, 2);
	}
	
	/**
	 * Tests if the track 2 includes discretionary data.
	 * 
	 * @return true if the track 2 includes discretionary data; otherwise
	 * false
	 */
	public boolean hasDiscretionaryData() {
		return matcher.group(4) != null;
	}
	
	/**
	 * Gets the track 2 discretionary data.
	 * 
	 * @return the discretionary data
	 */
	public String getDiscretionaryData() {
		return matcher.group(4);
	}
}
