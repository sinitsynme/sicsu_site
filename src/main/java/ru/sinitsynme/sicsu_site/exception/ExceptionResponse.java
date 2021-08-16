package ru.sinitsynme.sicsu_site.exception;

import java.util.Date;

public class ExceptionResponse {

    private String message;

    private Date occurrenceDate;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, Date occurrenceDate) {
        this.message = message;
        this.occurrenceDate = occurrenceDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }
}
