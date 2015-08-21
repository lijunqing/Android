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
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();//����sax��������
		try {
			SAXParser saxParser = saxFactory.newSAXParser();
			//���sax������ʵ��
			PersonHandler handler = new PersonHandler();
			XMLReader reader = saxParser.getXMLReader();//�õ�һ������
			reader.parse(new InputSource(stream));//��ȡxml�ļ���Ϣ�Ĺ��߶���
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
			perList=new ArrayList<Person>();//ʵ����list
			super.startDocument();
		}
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			mytagname=localName;//�õ���ʼ��ǩ������
			if(PER_TAG.equals(mytagname)){//�жϵõ���ǩ���Ƿ����ǩ����ͬ
				per=new Person();//�����ͬ�򴴽�person��
			}
			super.startElement(uri, localName, qName, attributes);
		}
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String str=new String(ch,start,length);//��char����ת����String�ַ�
			if(per!=null){//�ж�Per�ǲ���Ϊ��
				if(NAME_TAG.equals(mytagname)){//�����Ϊ�����жϵõ��ı�ǩ���ǲ���name
					per.setName(str);//�������ֵ��ӵ�per������
				}else if(AGE_TAG.equals(mytagname)){//�жϵõ��ı�ǩ���ǲ���age
					per.setAge(Integer.parseInt(str));//�������ֵ��ӵ�per������
				}
			}
			super.characters(ch, start, length);
		}
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			mytagname = localName;//�õ�������ǩ������
			if(PER_TAG.equals(mytagname)){//���������ǩ��person����ʾ������ѧ����Ϣ������ɣ������ռ���
				perList.add(per);//������person����ӵ�list��������
				per = null;//Ȼ��person���
			}
			mytagname = "";//ֱ�ӽ�mytagname���
			super.endElement(uri, localName, qName);
		}
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();//Z0709V
		}
	}
}
