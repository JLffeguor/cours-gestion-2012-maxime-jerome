import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeUser {

	private String FILE_PATH="18-09-2012.txt";
	private String ENCODING="UTF-8";
	private Path path = null;

	public SerializeUser() throws IOException {
		path = FileSystems.getDefault().getPath(FILE_PATH);
		if(Files.notExists(path)){
			Files.createFile(path);
		}
	}
	
	public void writeUsersToFile(List<User> users) {
		for (User user : users) {
			writeUserToFile(user);
		}

	}

	public void writeUserToFile(User user) {

		ArrayList<OpenOption> options = new ArrayList<>();
		options.add(StandardOpenOption.WRITE);
		options.add(StandardOpenOption.APPEND);
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName(ENCODING),StandardOpenOption.WRITE,StandardOpenOption.APPEND)) {
		    writer.write(user.toString());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}

	}

}
