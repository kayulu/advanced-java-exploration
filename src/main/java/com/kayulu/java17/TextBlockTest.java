package com.kayulu.java17;

public class TextBlockTest {
    public static void main(String[] args) {
        // a text block is a String object
        String dandelions = """

            Welcome children of the Spring,
            In your garbs of green and gold,
            Lifting up your sun-crowned heads
            On the verdant plain and wold.
            
            As a bright and joyous troop
            From the breast of earth ye came
            Fair and lovely are your cheeks,
            With sun-kisses all aflame.
            """;
        System.out.println(dandelions);

        // String methods can be applied
        String upper = """
                Kayhan Uludemirciler""".toUpperCase();

        System.out.println(upper);

        String strQuote = "Nelson Mandela: \"The greatest glory in living lies not in never falling, but in rising every time we fall.\"";

        // no escaping needed
        String tbQuote = """
                Nelson Mandela: "The greatest glory in living lies not in never falling, but in rising every time we fall."
                """;

        jsonTraditionalStyle();
        jsonTextBlockStyle();
    }

    public static void jsonTraditionalStyle() {
        String json = "{\n" +
                      "   \"name\": \"Kayhan\",\n" +
                      "   \"age\": 48\n" +
                      "}";

        System.out.println(json);
    }

    public static void jsonTextBlockStyle() {
        String json = """
                {
                   "name": "Kayhan",
                   "age": 48
                }
                """;

        System.out.println(json);
        System.out.println(123);
    }
}
