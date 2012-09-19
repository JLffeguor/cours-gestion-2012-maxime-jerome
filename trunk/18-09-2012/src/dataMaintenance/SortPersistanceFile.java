package dataMaintenance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class SortPersistanceFile {
	
	/**
	 * this method sort a correct csv file 
	 * it keep the first line without change (keep the field name)
	 * 
	 * @param fieldName the criteria to sort on
	 */
	public void sortFile(Path path,String fieldName,String charset){
		
		BufferedReader reader = null;
		CSVReader csvReader = null; 
		
		BufferedWriter writer = null;
		CSVWriter csvWriter = null;
		try{
			reader = Files.newBufferedReader(path, Charset.forName(charset));
			csvReader = new CSVReader(reader);
			
			List<String[]> unsorted = csvReader.readAll(); 
			
			//We read all the file so we don't want to read it anymore
			csvReader.close();
			reader.close();
			
			writer = Files.newBufferedWriter(path, Charset.forName(charset), StandardOpenOption.WRITE);
			
			
			
		}catch(IOException ioe){
			throw new RuntimeException(this.getClass().getName()+" can't sort ",ioe);
		}
		
	}
}
