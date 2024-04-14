package com.SD.MHT.entity;

public class Response {
    private String status;
    private String message;
    private String description;

    public Response(String status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{\"Response\": {" +
                "\"status\": \"" + status + "\"" +
                ", \"message\": \"" + message + "\"" +
                ", \"description\": \"" + description + "\"" +
                "}}";
    }

    public String toString2() {
        return "{\"Response\": {" +
                "\"status\": \"" + status + "\"" +
                ", \"message\": \"" + message + "\"" +
                ", \"description\": " + description + "}}";
    }
}
