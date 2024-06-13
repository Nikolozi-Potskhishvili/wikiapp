package com.freewiki.wikiapp.responses;

public class IsAuthorResponse {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static IsAuthorResponse ok() {
        IsAuthorResponse response = new IsAuthorResponse();
        response.setSuccess(true);
        return response;
    }

    public static IsAuthorResponse notFound() {
        IsAuthorResponse response = new IsAuthorResponse();
        response.setSuccess(false);
        response.setMessage("Not Found");
        return response;
    }
}
