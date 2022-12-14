package fancybank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class GsonTest {

    @Test
    public void shouldAnswerWithTrue() {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals("[1,2,3,4,5]", json);
    }

}
