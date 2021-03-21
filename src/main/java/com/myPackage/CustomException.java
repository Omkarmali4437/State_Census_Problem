package com.myPackage;

public class CustomException extends Exception{
    public enum ExceptionType {
        Wrong_File,
        Wrong_File_Type,
        Wrong_File_Delimiter,
        Wrong_Header
    }
    public ExceptionType type;

    public CustomException(String s,ExceptionType type){
        super(s);
        this.type=type;
    }

}
