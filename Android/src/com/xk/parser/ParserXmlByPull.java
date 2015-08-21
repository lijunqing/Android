package com.xk.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;



public class ParserXmlByPull {
	public static final String PERSON_TAG = "person";
	public static final String NAME_TAG = "name";
	public static final String AGE_TAG = "age";
	
	public ArrayList<Person> parserPerson(InputStream is){
		//����һ��list����
		ArrayList<Person> list = new ArrayList<Person>();
		//����Ӧpull����
		XmlPullParser parser = Xml.newPullParser();
		try {
			//��ȡ�ļ�
			parser.setInput(is, "utf-8");
			//������һ���ڵ�����¼����õ��ڵ�����
			int eventType = parser.getEventType();
			String tagName = "";
			Person per = null;
			//��ʼ����
			while(eventType != XmlPullParser.END_DOCUMENT){
				//�жϻ�õı�ǩ���ĸ�
				switch (eventType) {
					//������ĵ���ʼ��ǩ������ѭ��
					case XmlPullParser.START_DOCUMENT:
						break;
					//�����Ԫ�ؿ�ʼ��ǩ
					case XmlPullParser.START_TAG:
						tagName = parser.getName();//�õ���õı�ǩ��
						if(PERSON_TAG.equals(tagName)){//�ж��ǲ���person�Ŀ�ʼ��ǩ
							per = new Person();//������򴴽�һ��person����
							String id = parser.getAttributeValue(0);//ͨ��getAttributeValue�õ�id��ֵ
							per.setId(Integer.parseInt(id));//��id��ֵ��ӵ�person����
						}
						break;
						//�����õı�ǩ���ı�
					case XmlPullParser.TEXT:
						String text = parser.getText();//ȡ������ֵ
						if(per != null){//�ж�per���Ƿ�Ϊ��
							if(NAME_TAG.equals(tagName)){//�жϻ�õı�ǩ�Ƿ������ֵı�ǩ
								per.setName(text);//�����ͬ����ӵ�person����
							}else if(AGE_TAG.equals(tagName)){//�жϵõ����Ƿ���age�ı�ǩ
								per.setAge(Integer.parseInt(text));//�����ͬ����ӵ�person����
							}
						}
						break;
						//�����Ԫ�ؽ�����ǩ
					case XmlPullParser.END_TAG:
						tagName = parser.getName();//�õ���ǩ��
						if(PERSON_TAG.equals(tagName)){//�жϵõ��������Ƿ���person�Ľ�����ǩ
							list.add(per);//�������person����ӵ�list��������
							per = null;//Ȼ��person�����
						}
						tagName = "";//����õı�ǩ�����
						break;//����ѭ��
						//������ĵ�������ǩ����ֱ������ѭ��
					case XmlPullParser.END_DOCUMENT:
						break;
					default:
						break;
				}
				eventType = parser.next();//����������һ���ڵ㣬�õ��ڵ������
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
