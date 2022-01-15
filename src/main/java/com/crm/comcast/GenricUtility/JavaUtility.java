package com.crm.comcast.GenricUtility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Mamatha
 *
 */

public class JavaUtility {
	
	/**
	 * this method gives random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	/**
	 * this method gives date and time
	 * @return
	 */
	
	public String getSystemDateAndTime()
	{
		Date date =new Date();
		String dateAndTime = date.toString();
		return dateAndTime;
	}

}
