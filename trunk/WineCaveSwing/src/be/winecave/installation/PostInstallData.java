package be.winecave.installation;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;

import be.winecave.Repository.PaysViticoleRepository;
import be.winecave.util.XmlUtil;


public abstract class PostInstallData<E>{
	
	@Autowired
	PaysViticoleRepository paysViticoleRepository;
	
	protected String XML_FILE_NAME;
	protected String ELEMENTS_NAME;
	protected String ROOT_ELEMENTS_NAME;
	protected Document xmlDocument;
	
	protected List<Element> elementList = null;
	
	public void loadDataFromXml() {
		elementList = xmlDocument.getRootElement().getChildren();
	}

	public void saveDataToXml() {
		//assuming correct data are already in listePays var
		XmlUtil.saveElements(XML_FILE_NAME, ROOT_ELEMENTS_NAME,elementList);//really crapy solution but otherwise i get exception with element has already parent and if i try to detch in deppe method i get exception too --maxime 24/12/12
	}

	public void saveDataToDb() {
		if (elementList == null) {
			loadDataFromXml();
		}
		persistDataList();
	}

	/**
	 * create a local variable containing datalist form elementList
	 * @see setData(List<E> dataList) to modify the dataList
	 */
	public List<E> getData() {
		List<E> dataList = new ArrayList<>();
		for (Element element : elementList) {
			dataList.add(ParseXmlElement(element));
		} 
		return dataList;
	}
	
	public void setData(List<E> dataList) {
		elementList = buildElementList(dataList);
	}
	
	
	protected abstract E ParseXmlElement(Element element);
	
	protected abstract List<Element> buildElementList(List<E> dataList);
	
	protected abstract void persistDataList();
	
	protected abstract void initalization();
}
