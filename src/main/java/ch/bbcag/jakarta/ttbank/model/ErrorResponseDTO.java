package ch.bbcag.jakarta.ttbank.model;

public class ErrorResponseDTO {

    private String errorMessage;

    public ErrorResponseDTO(){}

    public ErrorResponseDTO(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
