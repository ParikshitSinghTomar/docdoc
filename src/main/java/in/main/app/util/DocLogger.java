package in.main.app.util;

import org.apache.log4j.Logger;

public class DocLogger {

	public static void error(String message) {
		Logger.getLogger(DocLogger.class).error(message);
	}

	public static void debug(String message) {
		Logger.getLogger(DocLogger.class).debug(message);
	}

}
