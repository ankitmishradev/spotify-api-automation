package utils;

import enums.RequestMethod;
import models.RequestModel;
import org.apache.logging.log4j.Logger;

public class Log {
    public static void sendingApiRequest(Logger logger, RequestMethod method, RequestModel request) {
        logger.info("Sending {} request to {} endpoint", method, request.getEndpoint());
    }

    public static void apiRequestSent(Logger logger, int statusCode) {
        logger.info("API request sent and got {} response code", statusCode);
    }

    public static void responseCodeValidation(Logger logger, int statusCode) {
        logger.info("Response code validated against {}", statusCode);
    }

    public static void responseParsedAs(Logger logger, String target){
        logger.info("Response parsed as {}",target);
    }

    public static void responseValidatedAgainst(Logger logger){
        logger.info("Response validated against expected response");
    }
}