package com.bridgelabz;

public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        UNABLE_TO_PARSE, CENSUS_FILE_PROBLEM, NOT_A_CSV_TYPE
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}