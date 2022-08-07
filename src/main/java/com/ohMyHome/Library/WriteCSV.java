package com.ohMyHome.Library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class WriteCSV {
	
	
	public void writeCSV(String fileName, List<String[]> allTickets) throws IOException
	{
		File file = new File("Resources"+File.separator+fileName);
		if(file.exists())
		{
			file.delete();
		}
		
		FileWriter fw = new FileWriter(file);
		CSVWriter write = new CSVWriter(fw);
		write.writeAll(allTickets);
		write.flush();
		
		
		
		
	}

}
