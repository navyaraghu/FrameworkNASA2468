package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods in java
 * @author DELL
 *
 */
public class JavaUtility {

	/**
	 * This method is used generate random number
	 * @param limit
	 * @return
	 */
		public int generateRandomNumber(int limit)
		{
			Random random=new Random();
			return random.nextInt(limit);
		}
		/**
		 * This method is used to fetch current date and time
		 * @return
		 */
		public String getCurrentTime() {
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
			return sdf.format(date);
		}
	}


