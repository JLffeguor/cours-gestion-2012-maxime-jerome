package dataMaintenance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class SortPersistanceFile {
	
	/**
	 * this method sort a correct csv file 
	 * it keep the first line without change (keep the field name)
	 * 
	 */
	public static void sortFile(Path path,String charset){
		
		BufferedReader reader = null;
		CSVReader csvReader = null; 
		
		BufferedWriter writer = null;
		CSVWriter csvWriter = null;
		
		List<String[]> unsorted = null;
		
		try{
			reader = Files.newBufferedReader(path, Charset.forName(charset));
			csvReader = new CSVReader(reader);

			unsorted = csvReader.readAll(); 
		}catch(IOException ioe){
			throw new RuntimeException("SortPersistanceFile can't sort ",ioe);
		}finally
		{
			try {
				//We read all the file so we don't want to read it anymore
				csvReader.close();
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException("SortPersistanceFile can write the sorted file ",e);
			}
		}
		
		try{
			
			if(unsorted == null || unsorted.isEmpty()){
				throw new RuntimeException("something goes wrong if we read nothing from the csvn we can't sort");
			}
			
			writer = Files.newBufferedWriter(path, Charset.forName(charset), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
			csvWriter = new CSVWriter(writer);
			
			//we write the name of the fields and we do not need it anymore
			csvWriter.writeNext(unsorted.get(0));
			unsorted.remove(0);

			ArrayList<String> result = new ArrayList<>(); 
			String temp = null;
			
			//it's easier to sort String instead of String[] so we create a new list of string with the list of String[]
			for(String[] str : unsorted){
				temp = "";
				//str.toString() give the address not the array element
				for(String tmp : str){
					temp+=tmp+",";
				}
				result.add(temp);
			}
			String toSub = result.get(result.size()-1);
			result.set(result.size()-1, toSub.substring(0, toSub.length()-1));
			Collections.sort(result);
			
			//csvWriter need String[] so we iterate on the sorted list of string and split every element in an array			
			for(String string : result){
				csvWriter.writeNext(string.split(","));
			}
			
		}catch(IOException ioe){
			throw new RuntimeException("SortPersistanceFile can't sort ",ioe);
		}finally
		{
			try {
				csvWriter.close();
				writer.close();
			} catch (IOException e) {
				throw new RuntimeException("SortPersistanceFile can write the sorted file ",e);
			}
		}
		
	}
}
