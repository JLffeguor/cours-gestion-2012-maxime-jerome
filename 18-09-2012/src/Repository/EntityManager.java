package Repository;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import au.com.bytecode.opencsv.CSVWriter;

import model.BaseEntity;


public class EntityManager<E extends BaseEntity> {

	private String ENCODING="UTF-8";
	private Path path = null;

	public EntityManager(String filePath,E entity) {
		path = FileSystems.getDefault().getPath(filePath);


		if(Files.notExists(path)){

			BufferedWriter writer = null;
			CSVWriter csvWriter = null;

			try {
				Files.createFile(path);
				
				writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND);
				csvWriter = new CSVWriter(writer);

				csvWriter.writeNext(entity.getCsvFieldsName().split(","));//it's easier to write field name in a unique String in user so we split in a array of String every name

			} catch (IOException ioe) {
				throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
			} finally{
				try {

					writer.close();
					csvWriter.close();
				} catch (IOException ioe) {
					throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
				}

			}
		}
	}

	public E persist(E entity)
	{
		BufferedWriter writer = null;
		CSVWriter csvWriter = null;

		try {
			writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND);
			csvWriter = new CSVWriter(writer);

			csvWriter.writeNext(entity.toCsv());

		} catch (IOException ioe) {
			throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
		} finally{
			try {

				writer.close();
				csvWriter.close();
			} catch (IOException ioe) {
				throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
			}

		}
		return entity;
	}

}
