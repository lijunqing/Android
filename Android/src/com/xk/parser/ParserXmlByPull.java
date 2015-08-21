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
		//创建一个list集合
		ArrayList<Person> list = new ArrayList<Person>();
		//创建应pull对象
		XmlPullParser parser = Xml.newPullParser();
		try {
			//读取文件
			parser.setInput(is, "utf-8");
			//触发第一个节点解析事件，得到节点类型
			int eventType = parser.getEventType();
			String tagName = "";
			Person per = null;
			//开始解析
			while(eventType != XmlPullParser.END_DOCUMENT){
				//判断获得的标签是哪个
				switch (eventType) {
					//如果是文档开始标签则跳出循环
					case XmlPullParser.START_DOCUMENT:
						break;
					//如果是元素开始标签
					case XmlPullParser.START_TAG:
						tagName = parser.getName();//得到获得的标签名
						if(PERSON_TAG.equals(tagName)){//判断是不是person的开始标签
							per = new Person();//如果是则创建一个person容器
							String id = parser.getAttributeValue(0);//通过getAttributeValue得到id的值
							per.setId(Integer.parseInt(id));//将id的值添加到person类里
						}
						break;
						//如果获得的标签是文本
					case XmlPullParser.TEXT:
						String text = parser.getText();//取出属性值
						if(per != null){//判断per类是否为空
							if(NAME_TAG.equals(tagName)){//判断获得的标签是否是名字的标签
								per.setName(text);//如果相同则添加到person类里
							}else if(AGE_TAG.equals(tagName)){//判断得到的是否是age的标签
								per.setAge(Integer.parseInt(text));//如果相同则添加到person类里
							}
						}
						break;
						//如果是元素结束标签
					case XmlPullParser.END_TAG:
						tagName = parser.getName();//得到标签名
						if(PERSON_TAG.equals(tagName)){//判断得到的名字是否是person的结束标签
							list.add(per);//如果是则将person类添加到list集合里面
							per = null;//然后将person类清空
						}
						tagName = "";//将获得的标签名清空
						break;//跳出循环
						//如果是文档结束标签，则直接跳出循环
					case XmlPullParser.END_DOCUMENT:
						break;
					default:
						break;
				}
				eventType = parser.next();//触发解析下一个节点，得到节点的类型
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
