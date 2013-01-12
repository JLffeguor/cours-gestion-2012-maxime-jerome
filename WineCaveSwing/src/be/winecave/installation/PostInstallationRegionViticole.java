package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.model.PaysViticole;
import be.winecave.model.Region;
import be.winecave.model.RegionViticole;
import be.winecave.repository.PaysViticoleRepository;
import be.winecave.repository.RegionViticoleRepository;
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
		loadDataFromXml();
	}
	
	@Override
	protected RegionViticole ParseXmlElement(Element element) {
		//TODO throw exception when no parent found
		return new RegionViticole(element.getAttributeValue("nom").toLowerCase(),
				paysViticoleRepository.findByName(element.getAttributeValue("nom_pays").toLowerCase()));
	}
	
	@Override
	protected Element buildElement(Element element, RegionViticole data) {
		element.setAttribute("nom", data.getNom());
		return element;
	}
	
	@Override
	protected void persistData(RegionViticole data) {
		regionViticoleRepository.persist(data);
		//assuming parent already set
		PaysViticole parent = paysViticoleRepository.findByName(((Region) data.getPaysViticoleParente()).getNom());
		parent.getRegionsEnfant().add(data);
		paysViticoleRepository.merge(parent);
	}

}
