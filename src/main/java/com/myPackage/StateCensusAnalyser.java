package com.myPackage;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadData(String path) throws CustomException {
        int numofEnteries=0;
        try{
            Reader reader= Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCensusAnalyser> csvToBean=new CsvToBeanBuilder(reader).withType(CSVStateCensusAnalyser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStateCensusAnalyser> csvStateCensusAnalyserIterator=csvToBean.iterator();

            while(csvStateCensusAnalyserIterator.hasNext()){
                CSVStateCensusAnalyser censusAnalyser=csvStateCensusAnalyserIterator.next();
                System.out.println("Name : " + censusAnalyser.getState());
                System.out.println("Email : " + censusAnalyser.getPopulation());
                System.out.println("PhoneNo : " + censusAnalyser.getAreaInSqKm());
                System.out.println("Country : " + censusAnalyser.getDensityPerSqKm());
                System.out.println("==========================");
                numofEnteries++;
            }
        }catch (IOException e){
            throw new CustomException(e.getMessage());
        }
        return numofEnteries;
    }
}
