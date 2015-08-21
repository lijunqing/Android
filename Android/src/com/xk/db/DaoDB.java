package com.xk.db;

import android.database.sqlite.SQLiteDatabase;

public class DaoDB {
	private SQLiteDatabase db;
	
	public DaoDB(SQLiteDatabase db) {
		super();
		this.db = db;
	}
	public void insert(){
		db.execSQL("insert into ");
	}
	public void select()
	{
		db.rawQuery("setlect * from ",null);
	}
	public void update(){
		db.execSQL("updata   set ");
	}
	public void delete(int id){
		db.execSQL("delete   where id=");
	}
}
