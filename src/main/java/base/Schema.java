package base;

import utils.Config;
import utils.Property;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import enums.TestDataExceptionType;
import exceptions.TestDataException;
import models.RequestModel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schema<R> {

    public ObjectMapper objectMapper;
    public JsonNode node;
    public RequestModel request;
    public R response;

    public Schema<R> loadTestData(String testDataKey) {
        String filePath = Config.TEST_DATA_DIR;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for (int i = 1; i < stackTraceElements.length; i++) {
            StackTraceElement element = stackTraceElements[i];
            if (!element.getClassName().equals(this.getClass().getName()) && !element.getClassName()
                    .contains("java.lang.Thread")) {
                filePath += "/" + element.getClassName().split("\\.")[1] + ".json";
                break;
            }
        }

        try {
            objectMapper = new ObjectMapper();
            node = objectMapper.readTree(new File(filePath)).get("data");
            if (node.has(testDataKey)) {
                node = node.get(testDataKey);
            }else{
                throw new TestDataException(TestDataExceptionType.INVALID_KEY,testDataKey,filePath);
            }
            replacePlaceholders(node);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data from " + filePath, e);
        }

        return this;
    }

    public Schema<R> loadResponse(Class<R> typeReference) {
        response = objectMapper.convertValue(node.get("response"), typeReference);
        return this;
    }

    public Schema<R> loadRequest() {
        request = objectMapper.convertValue(node.get("request"), RequestModel.class);
        return this;
    }

    private void replacePlaceholders(JsonNode rootNode) {
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
        Pattern pattern = Pattern.compile("\\$\\{([^}]*)}");

        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            if (field.getValue().isObject()) {
                replacePlaceholders(field.getValue());
            } else if (field.getValue().isTextual()) {
                String value = field.getValue().asText();
                Matcher matcher = pattern.matcher(value);
                StringBuffer parsedString = new StringBuffer();

                while (matcher.find()) {
                    String propertyValue = Property.get(matcher.group(1));
                    matcher.appendReplacement(parsedString, propertyValue);
                }

                matcher.appendTail(parsedString);
                ((ObjectNode) rootNode).put(field.getKey(), parsedString.toString());
            }
        }
    }
}