package be.winecave.installation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.PaysViticoleRepository;
import be.winecave.model.PaysViticole;
import be.winecave.util.FileUtil;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationPays implements PostInstallData<List<PaysViticole>> {
	
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	
	private static final String XML_FILE_NAME =  ("pays.xml");
	private static final String ELEMENTS_NAME = "pays";
	private static final String ROOT_ELEMENTS_NAME = "liste_pays";
	private static Document xmlDocument =  XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
	
	private List<PaysViticole> listePays = new ArrayList<>();

	@Override
	public void loadDataFromXml() {
		List<Element> elementList = xmlDocument.getRootElement().getChildren();
		
		for(Element element :  elementList) {
			getData().add(getPaysViticoleFormXmlElement(element));
		}
	}

	@Override
	public void saveDataToXml() {
		//assuming correct data are already in listePays var
		Document doc = new Document(new Element("liste_pays"));
		
		Element pays = null;
		for(PaysViticole paysViticole : listePays) {
			pays= new Element("pays");
			pays.setAttribute("nom", paysViticole.getNom());
			
			doc.getRootElement().addContent(pays);
		}
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, Files.newOutputStream(FileUtil.getPathIntoInstallationFolder("PostInstallationData" + FileUtil.getFileSystemSeparator() + XML_FILE_NAME), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING));
		} catch (IOException e) {
			throw new RuntimeException("can't save pays.xml",e);
		}
	}

	@Override
	public void saveDataToDb() {
		for(PaysViticole pays : listePays) {
			paysViticoleRepository.persist(pays);
		}
	}

	@Override
	public List<PaysViticole> getData() {
		return listePays;
	}

	@Override
	public void setData(List<PaysViticole> postInstallData) {
		listePays = postInstallData;
	}
	
	private PaysViticole getPaysViticoleFormXmlElement(Element element) {
		return new PaysViticole(element.getAttributeValue("nom"));
	}

}
