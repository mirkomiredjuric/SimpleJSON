package com.code.jsonparsiranje;

import com.code.jsonparsiranje.pojo.CoursePOJO;
import com.code.jsonparsiranje.pojo.DayPOJO;
import com.code.jsonparsiranje.pojo.LearnerPOJO;
import com.code.jsonparsiranje.pojo.SimpleTestCaseJsonPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONTest {

    private String  jsonString = "{  \"title\": \"Mire test\", \"author\": \"Bane\" }";

    private String dan1 = "{\n" +
            "  \"date\": \"2020-07-29\",\n" +
            "  \"name\": \"Ponedeljak\"\n" +
            "}";

    private String learnerCourse = "{\n" +
            "  \"learner\": \"Mirko\",\n" +
            "  \"courses\": [\n" +
            "    {\n" +
            "      \"title\": \"Spring Boot 2\",\n" +
            "      \"learning\": true,\n" +
            "      \"startDay\": \"2020-06-15\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"AWS\",\n" +
            "      \"learning\": false,\n" +
            "      \"startDay\": \"2020-08-20\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @org.junit.jupiter.api.Test
    void parse() {

        try {
            JsonNode node = JSONUtil.parse(jsonString);
            assertEquals(node.get("title").asText(), "Mire test");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fromJson() throws JsonProcessingException {
        JsonNode node = JSONUtil.parse(jsonString);
        SimpleTestCaseJsonPOJO simpleTestCaseJsonPOJO =  JSONUtil.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(simpleTestCaseJsonPOJO.getTitle(), "Mire test");
    }

    @Test
    void toJSON(){
        SimpleTestCaseJsonPOJO simpleTestCaseJsonPOJO = new SimpleTestCaseJsonPOJO();
        simpleTestCaseJsonPOJO.setTitle("Test123");

        JsonNode node = JSONUtil.toJSON(simpleTestCaseJsonPOJO);

        assertEquals(node.get("title").asText(), "Test123");
    }

    @Test
    void stingify() throws JsonProcessingException {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setTitle("Test123");

        JsonNode node = JSONUtil.toJSON(pojo);

        System.out.printf(JSONUtil.stingify(node));
    }

    @Test
    void day1Test() throws JsonProcessingException {
        JsonNode node = JSONUtil.parse(dan1);
        DayPOJO dayPOJO =  JSONUtil.fromJson(node, DayPOJO.class);

        assertEquals(dayPOJO.getDate().toString(), "2020-07-29");
        assertEquals(dayPOJO.getName(), "Ponedeljak");

    }

    @Test
    void learnerCourseTest() throws JsonProcessingException {
        JsonNode node = JSONUtil.parse(learnerCourse);
        LearnerPOJO learnerPOJO =  JSONUtil.fromJson(node, LearnerPOJO.class);

        System.out.println("Learner: " + learnerPOJO.getLearner());
        System.out.println("*******************************");
        for (CoursePOJO cp : learnerPOJO.getCourses()){
            System.out.println("Course: " + cp.getTitle());
            System.out.println("Learning: " + cp.isLearning());
            System.out.println("Start day: " + cp.getStartDay());
            System.out.println("---------------------------");
        }

    }
}