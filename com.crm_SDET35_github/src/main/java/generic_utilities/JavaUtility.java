package generic_utilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author MADHUSUDAN
 *
 */

public class JavaUtility 
{
	/**
	 * it is used to get a random number
	 * @return
	 */
public int getRandomNumber()
{
	Random random=new Random();
	int randNUM = random.nextInt(1000);
	return randNUM;
}

/**
 * it is used to get SystemDteAndTime in IST formate
 * @return
 */
public String getSystemDteAndTimeInIstformate()
{
	Date date=new Date();
	return date.toString();
}

/**
 * it is used to get SystemDteAndTime in required formate
 * @return
 */
public String getSystemDteAndTimeInStandardFormate()
{
	Date date=new Date();
	String dateAndTime = date.toString();
	String 	YYYY = dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
    int MM = date.getMonth()+1;
    
    String finalFormate = YYYY+" "+DD+" "+MM;
    return finalFormate;
	
}
}
