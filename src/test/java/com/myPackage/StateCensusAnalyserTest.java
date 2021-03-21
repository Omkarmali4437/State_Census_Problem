package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StateCensusAnalyserTest {
    StateCensusAnalyser stateCensusAnalyser;
    private String Correct_Path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\test\\resources\\IndiaStateCensusData.csv";
    private String Wrong_Path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\main\\resources\\IndiaStateCensusData.csv";
    private String Wrong_file_type="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\test\\resources\\IndiaStateCensusData.txt";

    @Before
    public void setup() {
        stateCensusAnalyser=new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded() throws CustomException {
        int numofEnteries = stateCensusAnalyser.loadData(Correct_Path);
        Assert.assertEquals(29, numofEnteries);
    }

    @Test
    public void given_Wrong_file_path_should_return_custom_exception() throws CustomException{
        try{
            stateCensusAnalyser.loadData(Wrong_Path);
        }catch (CustomException e){
            System.out.println(e.type);
            Assert.assertEquals(CustomException.ExceptionType.Wrong_File,e.type);
        }
    }

    @Test
    public void given_wrong_file_type_should_throw_custom_exception() throws CustomException{
        try{
            stateCensusAnalyser.loadData(Wrong_file_type);
        }catch (CustomException e){
            System.out.println(e.type);
            Assert.assertEquals(e.type,CustomException.ExceptionType.Wrong_File_Type);
        }
    }

    @Test
    public void given_wrong_delimiter_should_throw_custom_exception(){
        try{
            stateCensusAnalyser.loadData(Correct_Path);
        }catch (CustomException e){
            System.out.println(e.type);
            Assert.assertEquals(e.type, CustomException.ExceptionType.Wrong_File_Delimiter);
        }
    }

}
