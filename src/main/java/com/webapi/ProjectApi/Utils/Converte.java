package com.webapi.ProjectApi.Utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Converte {

  public static String jsonToString(BufferedReader bufferedReader) throws IOException{
    String resp="";
    String jsToStr="";
    while ((resp = bufferedReader.readLine())!=null){
      jsToStr +=resp;
    }
    return jsToStr;
  }

}
