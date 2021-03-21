package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CensusAnalyserTest {
    CensusAnalyser censusAnalyser;
    private String State_Census_Correct_Path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\test\\resources\\IndiaStateCensusData.csv";
    private String Wrong_Path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\main\\resources\\IndiaStateCensusData.csv";
    private String Wrong_file_type="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\test\\resources\\IndiaStateCensusData.txt";
    private String State_Code_Correct_path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\test\\resources\\IndiaStateCode.csv";

    @Before
    public void setup() {
        censusAnalyser =new CensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCensusData(State_Census_Correct_Path);
        Assert.assertEquals(29, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCensusData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCensusData(Wrong_file_type);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type,CustomException.ExceptionType.Wrong_File_Type);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception(){
        try{
            censusAnalyser.loadStateCensusData(State_Census_Correct_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type, CustomException.ExceptionType.Wrong_File_Delimiter);
        }
    }

    @Test
    public void given_wrong_header_should_throw_custom_exception(){
        try {
            censusAnalyser.loadStateCensusData(State_Code_Correct_path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type, CustomException.ExceptionType.Wrong_Header);
        }
    }

    @Test
    public void given_correct_path_should_return_count() throws CustomException {
        int numofEnteries = censusAnalyser.loadStateCodeData(State_Code_Correct_path);
        Assert.assertEquals(37, numofEnteries);
    }

    @Test
    public void given_wrong_path_should_return_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCodeData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_throw_custom_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCodeData(Wrong_file_type);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type,CustomException.ExceptionType.Wrong_File_Type);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_exception() throws CustomException{
        try{
            censusAnalyser.loadStateCodeData(State_Code_Correct_path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type, CustomException.ExceptionType.Wrong_File_Delimiter);
        }
    }

    @Test
    public void given_wrong_header_should_throw_custom_exceptio() throws CustomException{
        try {
            censusAnalyser.loadStateCensusData(State_Census_Correct_Path);
        }catch (CustomException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(e.type, CustomException.ExceptionType.Wrong_Header);
        }
    }
}
