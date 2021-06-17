package com.bridgelabz;


import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_TYPE = "./src/test/resources/IndiaStateCensusData.txt";
    private static final String FILE_PATH_DELIMITER ="./src/test/resources/IndiaStateCensusDataDelivetor.csv";
    private static final String FILE_PATH_HEADER = "./src/test/resources/IndiaStateCensusDataHeader.csv";
    private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";

    @Test
    public void givenIndianCensusCSVFile_shouldReturns_correctRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int noOfRecord = censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println("File not found ");
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WhenWrongType_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
           int noOfRecord = censusAnalyser.loadIndiaCensusData(WRONG_CSV_TYPE);
        }catch (CensusAnalyserException e){
            System.out.println("File not found ");
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }
    @Test
    public void givenIndiaStateCode_whenDelimiterIncorrect_ShouldThrowException() {
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(FILE_PATH_DELIMITER);
        }catch(CensusAnalyserException  e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WhenHeaderIncorrect_ShouldThrowException() {
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(FILE_PATH_HEADER);
        }catch(CensusAnalyserException  e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }



    @Test
    public void givenIndianStateCodeCSVFile_returns_correctRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaStateCode_withWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateCode(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaStateCode_whenWrongType_shouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateCode(WRONG_CSV_TYPE);
        }catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }
    @Test
    public void givenIndiaStateCode_whenDelimiterIncorrect_shouldThrowException() {
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
           censusAnalyser.loadIndiaStateCode(FILE_PATH_DELIMITER);
        }catch(CensusAnalyserException  e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }
    @Test
    public void givenIndiaStateCode_WhenHeaderIncorrect_ShouldThrowException() {
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateCode(FILE_PATH_HEADER);
        }catch(CensusAnalyserException  e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }

}
