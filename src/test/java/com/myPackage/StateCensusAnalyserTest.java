package com.myPackage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StateCensusAnalyserTest {
    StateCensusAnalyser stateCensusAnalyser;
    private String path="C:\\Users\\DELL\\IdeaProjects\\IndianStateCensus\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Before
    public void setup() {
        stateCensusAnalyser=new StateCensusAnalyser();
    }

    @Test
    public void to_check_if_data_is_loaded(){
        int size=stateCensusAnalyser.loadData(path);
        Assert.assertEquals(29,size);
    }
}
