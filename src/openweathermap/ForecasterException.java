package openweathermap;

public class ForecasterException extends Exception {
    private String message;

    public ForecasterException(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}