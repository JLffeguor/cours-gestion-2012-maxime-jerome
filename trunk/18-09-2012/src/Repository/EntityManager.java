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

	public EntityManager(String filePath) {
		path = FileSystems.getDefault().getPath(filePath);
		if(Files.notExists(path)){
			try {
				Files.createFile(path);
			} catch (IOException ioe) {
				throw new RuntimeException(this.getClass().getName()+" can't create the persistence file ",ioe);
			}
		}
	}

	public E persist(E entity)
	{
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND)) {
			writer.write(entity.toString());
		} catch (IOException ioe) {
			throw new RuntimeException(this.getClass().getName()+" can't persist ",ioe);
		}
		return entity;
	}

}
