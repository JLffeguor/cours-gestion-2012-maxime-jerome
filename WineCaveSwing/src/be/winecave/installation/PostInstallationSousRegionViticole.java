package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.RegionViticoleRepository;
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
		loadDataFromXml();
	}
	
	@Override
	protected RegionViticole ParseXmlElement(Element element) {
		//TODO throw exception when no parent found
		return new RegionViticole(element.getAttributeValue("nom").toLowerCase(),regionViticoleRepository.findByName(element.getAttributeValue("region").toLowerCase()));
	}
	
	@Override
	protected void persistData(RegionViticole data) {
		regionViticoleRepository.persist(data);
		regionViticoleRepository.merge((RegionViticole) data.getParent());
		
	}

	@Override
	protected Element buildElement(Element element, RegionViticole data) {
		element.setAttribute("nom", data.getNom());
		element.setAttribute("region", data.getParent().getNom());
		return null;
	}

}
