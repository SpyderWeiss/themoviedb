package Structure;

import org.testng.Reporter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.List;

/**
 * Created by spyderweiss on 7/8/17.
 */
public class Logging
{
	public static void log(String msg)
	{
		Reporter.log(msg, true);
	}

	public static void log(String msg, Object... args)
	{
		Reporter.log(String.format(msg, (Object[]) args), true);
	}

	/**
	 * Method to add the TestNG log to an Allure report
	 *
	 * @param strings Log lines
	 */
	@Attachment
	public static String attachTestNGlog(List<String> strings)
	{
		StringBuilder builder = new StringBuilder();
		for (String s : strings)
		{
			builder.append(s).append("\n");
		}
		Logging.log("Attach Allure log file");
		return builder.toString();
	}

}
