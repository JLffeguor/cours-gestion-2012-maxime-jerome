package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.PaysViticoleRepository;
import be.winecave.model.PaysViticole;
import be.winecave.model.RegionViticole;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationPays extends PostInstallData<PaysViticole> {
	
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	
	@PostConstruct
	@Override
	protected void initalization() {
		XML_FILE_NAME = "pays.xml";
		ELEMENTS_NAME = "pays";
		ROOT_ELEMENTS_NAME = "liste_pays";
		xmlDocument =  XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
	}

	@Override
	protected PaysViticole ParseXmlElement(Element element) {
		return new PaysViticole(element.getAttributeValue("nom"));
	}

	@Override
	protected List<Element> buildElementList(List<PaysViticole> dataList) {
		Element pays = null;
		List<Element> elements = new ArrayList<>();
		
		for(PaysViticole paysViticole : dataList) {
			pays= new Element(ELEMENTS_NAME);
			
			pays.setAttribute("nom", paysViticole.getNom());
			
			elements.add(pays);
		}
		
		return elements;
	}

	@Override
	protected void persistDataList() {
		for(Element pays : elementList) {
			paysViticoleRepository.persist(ParseXmlElement(pays));
			pays.setAttribute("isInDB", "true");
		}
		saveDataToXml();
	}
}
