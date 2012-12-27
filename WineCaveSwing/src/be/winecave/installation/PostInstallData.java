package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;

import be.winecave.Repository.PaysViticoleRepository;
import be.winecave.model.BaseEntity;
import be.winecave.util.XmlUtil;


public abstract class PostInstallData<E extends BaseEntity>{
	
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	
	protected String XML_FILE_NAME;
	protected String ELEMENTS_NAME;
	protected String ROOT_ELEMENTS_NAME;
	protected Document xmlDocument;
	
	protected List<Element> elementList = null;
	
	public final void loadDataFromXml() {
		elementList = xmlDocument.getRootElement().getChildren();
	}

	public final void saveDataToXml() {
		XmlUtil.saveElements(XML_FILE_NAME, ROOT_ELEMENTS_NAME,elementList);//really crapy solution but otherwise i get exception with element has already parent and if i try to detch in deppe method i get exception too --maxime 24/12/12
	}

	public final void saveDataToDb() {
		persistDataList();
	}
	
	/**
	 * create a local variable containing datalist form elementList
	 * @see setData(List<E> dataList) to modify the dataList
	 */
	public final List<E> getData() {
		List<E> dataList = new ArrayList<>();
		for (Element element : elementList) {
			dataList.add(ParseXmlElement(element));
		} 
		return dataList;
	}
	
	public final void setData(List<E> dataList) {
		elementList = buildElementList(dataList);
	}
	
	
	private final void persistDataList() {
		for(Element element : elementList) {
			String isINDB = element.getAttributeValue("isInDB");
			if (isINDB == null || isINDB.isEmpty() || isINDB.equals("false")) {//defensive coding : in normal case isINDB attribute must be true or false
				persistData(ParseXmlElement(element));
				element.setAttribute("isInDB", "true");
			}
		}
		saveDataToXml();
	}

	private final List<Element> buildElementList(List<E> dataList) {
		List<Element> elements = new ArrayList<>();
		
		for(E data : dataList) {
			elements.add(buildElement(new Element(ELEMENTS_NAME), data));
		}
		
		return elements;
	}
	
	protected abstract void initalization();
	
	protected abstract E ParseXmlElement(Element element);
	
	protected abstract void persistData(E data);
	
	protected abstract Element buildElement(Element element, E data);
	
	
}
