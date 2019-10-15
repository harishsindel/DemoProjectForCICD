package supportFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class logWriter {
	/**
	 * 
	 * @param msgType - Type of Message (INFO,PASS,FAIL)
	 * @param classMethodName
	 * @param msg - The log information
	 * @throws IOException
	 */
	public static void writeLog(String msgType,String classMethodName, String msg) throws IOException 
	{
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("MM:dd:yyyy HH:mm:ss");
        String currentTime = df.format(now);
        File file = new File(System.getProperty("user.dir")+"/"+"Logs"+"/"+"ExecutionLog.LOG");
     // if file doesn't exists, then create it
 		if (!file.exists()) 
 		{
 			file.createNewFile();
 			FileWriter aWriter = new FileWriter(file, true);
 			aWriter.write("DateTime\t"+"    ||"+"Type\t"+"||"+"Log");
 			aWriter.flush();
 			aWriter.close();
 		}
 		FileWriter aWriter = new FileWriter(file, true);
 		aWriter.write(System.getProperty( "line.separator" ));
 	    aWriter.append('\n'+currentTime +"||" +msgType.toUpperCase()+"||"+ msg);
 	    aWriter.flush();
 	    aWriter.close();
    }
}
