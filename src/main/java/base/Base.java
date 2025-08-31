package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Base {
    public final Logger logger = LogManager.getLogger(this.getClass());
    public final ObjectMapper objectMapper = new ObjectMapper();

    public Class<?> getCurrentClassName() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for (int i = 1; i < stackTraceElements.length; i++) {
            StackTraceElement element = stackTraceElements[i];
            if (!element.getClassName().equals(this.getClass().getName()) && !element.getClassName()
                    .contains("java.lang.Thread")) {
                return element.getClass();
            }
        }
        return null;
    }
}