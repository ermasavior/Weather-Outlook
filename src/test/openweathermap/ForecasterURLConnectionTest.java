package test.openweathermap;

import openweathermap.ForecasterException;
import openweathermap.ForecasterURLConnection;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForecasterURLConnectionTest {
    ForecasterURLConnection connection = new ForecasterURLConnection("20a37921e6b890f1c14a60c19afdf8ec");

    @Test
    public void makeRequest() {
        try {
            assertNotNull(connection.makeRequest("indo"));
        } catch (ForecasterException a) {
            a.printStackTrace();
        }
    }
}