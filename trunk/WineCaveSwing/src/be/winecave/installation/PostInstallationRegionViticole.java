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
import be.winecave.Repository.RegionViticoleRepository;
import be.winecave.model.RegionViticole;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationRegionViticole extends PostInstallData<RegionViticole> {
	
	@Autowired
	RegionViticoleRepository regionViticoleRepository;
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	
	@PostConstruct
	@Override
	protected void initalization() {
		XML_FILE_NAME = "regionV.xml";
		ELEMENTS_NAME = "regionV";
		ROOT_ELEMENTS_NAME = "liste_regionV";
		xmlDocument = XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
	}
	
	@Override
	protected RegionViticole ParseXmlElement(Element element) {
		return new RegionViticole(element.getAttributeValue("nom"),paysViticoleRepository.findByName(element.getAttributeValue("nom_pays").toLowerCase()));
	}
	
	@Override
	protected List<Element> buildElementList(List<RegionViticole> dataList) {
		Element region = null;
		List<Element> elements = new ArrayList<>();
		
		for(RegionViticole regionViticole : dataList) {
			region= new Element(ELEMENTS_NAME);
			
			region.setAttribute("nom", regionViticole.getNom());
			
			elements.add(region);
		}
		
		return elements;
	}
	
	@Override
	protected void persistDataList() {
		for(Element regionViticole : elementList) {
			regionViticoleRepository.persist(ParseXmlElement(regionViticole));
			regionViticole.setAttribute("isInDB", "true");
		}
		saveDataToXml();
	}

}
