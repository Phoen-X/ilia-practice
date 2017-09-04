package com.iredko.testBook;

import java.util.logging.Logger;

/**
 * Created by IRedko on 18.08.2017.
 */
public class LoggingException  {
    class LoggingExceotion extends Exception{
        private Logger logger = Logger.getLogger("LoggingException");
    }
}
