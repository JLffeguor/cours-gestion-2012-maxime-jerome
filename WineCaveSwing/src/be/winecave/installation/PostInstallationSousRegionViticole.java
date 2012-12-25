package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.RegionViticoleRepository;
import be.winecave.model.PaysViticole;
import be.winecave.model.RegionViticole;
import be.winecave.util.XmlUtil;
@Component
@Lazy
@Scope("singleton")
public class PostInstallationSousRegionViticole extends PostInstallData<RegionViticole> {

	@Autowired
	RegionViticoleRepository regionViticoleRepository;
	
	@PostConstruct
	@Override
	protected void initalization() {
		XML_FILE_NAME = "ss_regionV.xml";
		ELEMENTS_NAME = "ss_regionV";
		ROOT_ELEMENTS_NAME = "liste_ss_regionV";
		xmlDocument = XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
	}
	
	@Override
	protected RegionViticole ParseXmlElement(Element element) {
		return new RegionViticole(element.getAttributeValue("nom").toLowerCase(),regionViticoleRepository.findByName(element.getAttributeValue("region").toLowerCase()));
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
			RegionViticole region = ParseXmlElement(regionViticole);
			
			regionViticoleRepository.persist(region);
			
			RegionViticole parent =  regionViticoleRepository.findByName(regionViticole.getAttributeValue("region").toLowerCase());
			regionViticoleRepository.merge(parent);
			regionViticole.setAttribute("isInDB", "true");
		}
		saveDataToXml();
	}

}
