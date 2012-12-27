package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.CouleurRepository;
import be.winecave.model.Couleur;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationCouleur extends PostInstallData<Couleur> {
	
	@Autowired
	CouleurRepository couleurRepository;

	@Override
	@PostConstruct
	protected void initalization() {
		XML_FILE_NAME = "couleur.xml";
		ELEMENTS_NAME = "couleur";
		ROOT_ELEMENTS_NAME = "liste_couleur";
		xmlDocument = XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
		loadDataFromXml();
	}
	
	@Override
	protected Couleur ParseXmlElement(Element element) {
		Couleur result = new Couleur();
		result.setNom(element.getAttributeValue("nom").toLowerCase());
		return result;
	}

	@Override
	protected void persistData(Couleur data) {
		couleurRepository.persist(data);		
	}

	@Override
	protected Element buildElement(Element element, Couleur data) {
		element.setAttribute("nom", data.getNom());
		return element;
	}
}
