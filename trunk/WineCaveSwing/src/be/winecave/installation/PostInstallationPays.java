package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.model.PaysViticole;
import be.winecave.repository.PaysViticoleRepository;
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
		loadDataFromXml();
	}

	@Override
	protected PaysViticole ParseXmlElement(Element element) {
		return new PaysViticole(element.getAttributeValue("nom").toLowerCase());
	}

	@Override
	protected void persistData(PaysViticole data) {
		paysViticoleRepository.persist(data);
	}

	@Override
	protected Element buildElement(Element element, PaysViticole data) {
		element.setAttribute("nom", data.getNom());
		return element;
	}
}
