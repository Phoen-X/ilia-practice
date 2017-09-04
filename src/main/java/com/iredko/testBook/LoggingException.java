package com.iredko.testBook;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by IRedko on 18.08.2017.
 */
class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trace =  new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
