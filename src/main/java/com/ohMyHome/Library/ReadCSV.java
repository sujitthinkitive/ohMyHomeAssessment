package com.ohMyHome.Library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSV {
	
	
	public Object[] readCSVFile(String CSVFileName) throws IOException, CsvException
	{
	
	File file = new File("Resources"+File.separator+CSVFileName);
	FileReader fr = new FileReader(file);
	CSVReader readCSV = new CSVReader(fr);
	List<String[]> csvData = readCSV.readAll();
	
	Object[] data = csvData.toArray();
	
	fr.close();
	
	return data;
	
	}

}
