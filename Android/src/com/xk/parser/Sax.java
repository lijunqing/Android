package com.xk.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;



public class Sax {
	private final String PER_TAG = "person";
	private final String NAME_TAG = "name";
	private final String AGE_TAG = "age";
	private ArrayList<Person> perList ;
	public ArrayList<Person> saxParse(InputStream stream){
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();//创建sax解析工厂
		try {
			SAXParser saxParser = saxFactory.newSAXParser();
			//获得sax解析器实例
			PersonHandler handler = new PersonHandler();
			XMLReader reader = saxParser.getXMLReader();//得到一个解析
			reader.parse(new InputSource(stream));//读取xml文件信息的工具对象
			reader.setContentHandler(handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return perList;
		
	}
	class PersonHandler extends DefaultHandler{
		private Person per;
		private String mytagname;
		@Override
		public void startDocument() throws SAXException {
			perList=new ArrayList<Person>();//实例化list
			super.startDocument();
		}
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			mytagname=localName;//得到开始标签的名字
			if(PER_TAG.equals(mytagname)){//判断得到标签名是否与标签名相同
				per=new Person();//如果相同则创建person类
			}
			super.startElement(uri, localName, qName, attributes);
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String str=new String(ch,start,length);//将char数组转换成String字符
			if(per!=null){//判断Per是不是为空
				if(NAME_TAG.equals(mytagname)){//如果不为空则判断得到的标签名是不是name
					per.setName(str);//如果是则将值添加到per类里面
				}else if(AGE_TAG.equals(mytagname)){//判断得到的标签名是不是age
					per.setAge(Integer.parseInt(str));//如果是则将值添加到per类里面
				}
			}
			super.characters(ch, start, length);
		}
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			mytagname = localName;//得到结束标签的名字
			if(PER_TAG.equals(mytagname)){//如果结束标签是person，表示此条的学生信息解析完成，可以收集了
				perList.add(per);//将整个person类添加到list集合里面
				per = null;//然后将person清空
			}
			mytagname = "";//直接将mytagname清空
			super.endElement(uri, localName, qName);
		}
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();//Z0709V
		}
	}
}
