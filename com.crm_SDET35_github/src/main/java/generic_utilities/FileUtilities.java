package generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author MADHUSUDAN
 *
 */
public class FileUtilities 
{
	/**
	 * It is used to get common data from property file based on the key which you have specified as an argument
	 * @return
	 * @throws IOException 
	 */
public String getPropertyKeyValue(String key) throws IOException
{
	FileInputStream fileinputstream=new FileInputStream("src/main/resources/prop.properties");
	Properties properties=new Properties();
	properties.load(fileinputstream);
	String value = properties.getProperty(key);
	 return value;
}

}