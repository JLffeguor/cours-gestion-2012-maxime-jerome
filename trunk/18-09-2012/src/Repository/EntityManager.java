package Repository;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import model.BaseEntity;


public class EntityManager<E extends BaseEntity> {

	private String ENCODING="UTF-8";
	private Path path = null;

	public EntityManager(String filePath,E entity) {
		path = FileSystems.getDefault().getPath(filePath);
		BufferedWriter writer = null;
		if(Files.notExists(path)){
			try {
				Files.createFile(path);
				writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND);
				System.out.println("i'm going to write fieldname");
				writer.write(entity.getCsvFieldsName()+"\n");
			} catch (IOException ioe) {
				throw new RuntimeException(this.getClass().getName()+" can't create the persistence file ",ioe);
			}finally{
				try {
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(this.getClass().getName()+" can't create the persistence file ",e);
				}
			}
		}
	}

	public E persist(E entity)
	{
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND)) {
			writer.write(entity.toCsv()+"\n");
		} catch (IOException ioe) {
			throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
		}
		return entity;
	}

}
