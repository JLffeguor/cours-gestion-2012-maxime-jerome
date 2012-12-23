package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import be.winecave.model.PaysViticole;
import be.winecave.util.XmlUtil;

public class PostInstallationPays implements PostInstallData<List<PaysViticole>> {
	
	private static PostInstallationPays instance;
	
	private static final String XmlFileName =  ("pays.xml");
	private static Document xmlDocument;
	
	private List<PaysViticole> listePays = new ArrayList<>();

	private PostInstallationPays() {
	}
	
	public static PostInstallationPays getInstance() {
		if (instance == null) {
			instance = new PostInstallationPays();
			//load xmlFile with instantiation to avoid fileLock problem
			xmlDocument = XmlUtil.getXmlDocumentIntoInstallationDirectory(XmlFileName);
		}
		return instance;
	}
	
	@Override
	public void loadDataFromXml() {
		List<Element> elementList = xmlDocument.getRootElement().getChildren();
		
		for(Element element :  elementList) {
			getData().add(getPaysViticoleFormXmlElement(element));
		}
	}

	@Override
	public void saveDataToXml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDataToDb() {
		// TODO Auto-generated method stub
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
