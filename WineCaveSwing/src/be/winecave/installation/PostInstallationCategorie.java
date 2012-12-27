package be.winecave.installation;

import javax.annotation.PostConstruct;

import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import be.winecave.Repository.CategorieRepository;
import be.winecave.model.Categorie;
import be.winecave.util.XmlUtil;

@Component
@Lazy
@Scope("singleton")
public class PostInstallationCategorie extends PostInstallData<Categorie> {

	@Autowired
	CategorieRepository categorieRepository;

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
	protected Categorie ParseXmlElement(Element element) {
		Categorie result = new Categorie();
		result.setNom(element.getAttributeValue("nom").toLowerCase());
		return result;
	}

	@Override
	protected void persistData(Categorie data) {
		categorieRepository.persist(data);		
	}

	@Override
	protected Element buildElement(Element element, Categorie data) {
		element.setAttribute("nom", data.getNom());
		return element;
	}
}
