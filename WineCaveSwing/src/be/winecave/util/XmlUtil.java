package be.winecave.util;

import java.io.IOException;
import java.nio.file.Path;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlUtil {
	
	public static Document getXmlDocumentIntoInstallationDirectory(String fileName) {
		return getXmlDocument(FileUtil.getFilePathIntoInstallationFolder(fileName));
	}
	
	public static Document getXmlDocument(Path filePath) {
		SAXBuilder builder = new SAXBuilder();
		
		try {
			return builder.build(filePath.toFile());
		} catch (JDOMException | IOException e) {
			throw new RuntimeException("can't get xmlDocument",e);
		}
	}

}
