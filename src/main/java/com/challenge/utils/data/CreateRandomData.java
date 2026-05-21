package com.challenge.utils.data;
import net.datafaker.Faker;

public class CreateRandomData {
    static Faker faker = new Faker();
    
    private CreateRandomData() {
        // Private constructor to prevent instantiation
    }

    public static String generateName() {
        return faker.name().fullName();
    }

    public static String generateSentence() {
        return faker.lorem().sentence();
    }

    public static int generateNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

}
