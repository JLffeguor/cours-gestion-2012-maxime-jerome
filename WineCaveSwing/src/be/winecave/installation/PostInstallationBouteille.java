package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.model.Bouteille;
import be.winecave.repository.BouteilleRepository;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationBouteille extends PostInstallData<Bouteille> {

	@Autowired
	BouteilleRepository bouteilleRepository;

	@Override
	@PostConstruct
	protected void initalization() {
		XML_FILE_NAME = "bouteille.xml";
		ELEMENTS_NAME = "bouteille";
		ROOT_ELEMENTS_NAME = "liste_bouteille";
		xmlDocument = XmlUtil.getPostInstallXmlDocument(XML_FILE_NAME);
		loadDataFromXml();
	}
	
	@Override
	protected Bouteille ParseXmlElement(Element element) {
		Bouteille result = new Bouteille();
		result.setNom(element.getAttributeValue("nom_bouteille").toLowerCase());
		try {
			result.setCapaciteLitre(Double.parseDouble(element.getAttributeValue("capaciteLitre")));
		} catch (NumberFormatException e) {
			throw new RuntimeException("can't parse xml element : " + element, e);
		}
		return result;
	}

	@Override
	protected void persistData(Bouteille data) {
		bouteilleRepository.persist(data);		
	}

	@Override
	protected Element buildElement(Element element, Bouteille data) {
		element.setAttribute("nom_bouteille", data.getNom());
		element.setAttribute("capaciteLitre", data.getCapaciteLitre().toString());
		return element;
	}

}
