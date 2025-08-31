package exceptions;

import enums.TestDataExceptionType;

public class TestDataException extends RuntimeException {
    public TestDataException(TestDataExceptionType type, String key, String location) {
        super(builder(type, key, location));
    }

    private static String builder(TestDataExceptionType type, String key, String location) {
        String message = null;
        switch (type) {
            case INVALID_KEY:
                message = "Couldn't find any test data with key " + key + " at " + location;
        }
        return message;
    }
}