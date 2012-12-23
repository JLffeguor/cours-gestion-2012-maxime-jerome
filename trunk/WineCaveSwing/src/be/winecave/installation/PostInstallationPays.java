package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import be.winecave.Repository.PaysViticoleRepository;
import be.winecave.model.PaysViticole;
import be.winecave.util.XmlUtil;

@Service
@Scope("singleton")
public class PostInstallationPays implements PostInstallData<List<PaysViticole>> {
	
	@Autowired 
	PaysViticoleRepository paysViticoleRepository;
	
	private static final String XmlFileName =  ("pays.xml");
	private static Document xmlDocument =  XmlUtil.getXmlDocumentIntoInstallationDirectory(XmlFileName);
	
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
		// TODO Auto-generated method stub
		
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
