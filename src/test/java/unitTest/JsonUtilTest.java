package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JsonUtil;

public class JsonUtilTest {

    @Test
    public void verifyJsonEqual(){

        String expected="{ \"key1\": \"value1\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        String actual="{ \"key1\": \"value1\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        Assertions.assertTrue(JsonUtil.areEqualJson(expected,actual));
    }

    @Test
    public void verifyJsonNotEqual(){

        String expected="{ \"key1\": \"diferente\" , \"key2\": \"value22222\" , \"key3\": \"value2\" }";
        String actual="{ \"key1\": \"value1\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        Assertions.assertFalse(JsonUtil.areEqualJson(expected,actual));
    }

    @Test
    public void verifyStructureJsonNotEqual(){

        String expected="{ \"key1\": \"value11\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        String actual="{  \"key2\": \"value2\" , \"key3\": \"value2\" }";
        Assertions.assertFalse(JsonUtil.areEqualJson(expected,actual));
    }

    @Test
    public void verifyJsonEqualIgnore(){

        String expected="{ \"key1\": \"IGNORE\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        String actual="{ \"key1\": \"value1\" , \"key2\": \"value2\" , \"key3\": \"value2\" }";
        Assertions.assertTrue(JsonUtil.areEqualJson(expected,actual));
    }

}
