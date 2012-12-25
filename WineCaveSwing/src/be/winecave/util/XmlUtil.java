package be.winecave.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlUtil {
	
	public static Document getPostInstallXmlDocument(String fileName) {
		return getXmlDocument(FileUtil.getPathIntoInstallationFolder("PostInstallationData" + FileUtil.getFileSystemSeparator() + fileName));
	}
	
	public static Document getXmlDocument(Path filePath) {
		SAXBuilder builder = new SAXBuilder();
		
		try {
			return builder.build(filePath.toUri().toURL());
		} catch (JDOMException | IOException e) {
			throw new RuntimeException("can't get xmlDocument",e);
		}
	}
	
	public static void saveElements(String xmlFileName, String rootElementName, List<Element> elements) {
		Document doc = new Document(new Element(rootElementName));
		doc.setDocType(new DocType(rootElementName, "data.dtd"));
		
		for(Element element : elements) {
			doc.getRootElement().addContent(detachElement(element));
		}
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, Files.newOutputStream(FileUtil.getPathIntoPostInstallationFolder(xmlFileName), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING));
		} catch (IOException e) {
			throw new RuntimeException("can't save " + xmlFileName + ".xml",e);
		}
	}
	
	public static Element detachElement(Element element) {
		List<Attribute> attributes = new ArrayList<>();
		for(Attribute attr : element.getAttributes()) {
			attributes.add(new Attribute(attr.getName(), attr.getValue()));
		}
		
		return new Element(element.getName()).setAttributes(attributes);
	}
	
}
