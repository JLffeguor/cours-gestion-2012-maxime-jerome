package JUnit;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Users;

import org.junit.Test;

import Repository.EntityManager;
import au.com.bytecode.opencsv.CSVReader;
import dataMaintenance.SortPersistanceFile;

public class Sorting {

	private final static String ENCODING="UTF-8";

	@Test
	public void simpleSortUserCsv()
	{
		/////Initialize/////
		String csvStateExpected="firstname,name,adress,childrenCount,matricule,phone,test01,,,0,,0,test02,,,0,,0,test03,,,0,,0,test05,,,0,,0,";

		Path testFilePath = FileSystems.getDefault().getPath("JUnitTestSortUser.csv");
		EntityManager<Users> em = new EntityManager<Users>(testFilePath, new Users());

		//////Create testing data/////
		Users testUsers;
		ArrayList<Users> testUsersList = new ArrayList<>();

		testUsers = new Users();
		testUsers.setFirstName("test03");//we set the firstName only because we sort about this
		testUsersList.add(testUsers);
		testUsers = new Users();
		testUsers.setFirstName("test05");
		testUsersList.add(testUsers);
		testUsers = new Users();
		testUsers.setFirstName("test01");
		testUsersList.add(testUsers);
		testUsers = new Users();
		testUsers.setFirstName("test02");
		testUsersList.add(testUsers);


		for(Users user : testUsersList){
			try {
				em.persist(user);
			} catch (Exception e) {
				fail("can't register an use");
			}
		}

		/////The sorting/////
		SortPersistanceFile.sortFile(testFilePath, ENCODING);
		
		String csvState = readCsv(testFilePath);//we get the state and delete the file because when test failed , it stop the execution.
		
		/////Delete test trace////
		try {
			Files.delete(testFilePath);
		} catch (IOException e) {
			fail("can't delete the test file");
		}

		/////The result////
		assertEquals(csvStateExpected,csvState);


	}

	private static String readCsv(Path path)
	{
		BufferedReader reader = null;
		CSVReader csvReader = null;
		String csvState="";


		try {

			////the reading
			reader = Files.newBufferedReader(path, Charset.forName(ENCODING));
			csvReader = new CSVReader(reader);

			////we put all into a single String
			List<String[]> after = csvReader.readAll(); 
			for(String[] usersAfter : after){
				for(String str : usersAfter){
					csvState+=str+",";
				}
			}

		} catch (IOException e) {
			fail("can't read the csv file "+path.toString());
		}finally
		{
			try {
				csvReader.close();
				reader.close();
			} catch (IOException e) {
				fail("can't read the csv file "+path.toString());
			}

		}

		return csvState;
	}

}
