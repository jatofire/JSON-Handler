package com.syntaxcandy.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHandler {
	
	private JSONObject ob;
	private JSONArray ar;
	private JSONObject[] objects;
	
	public JSONHandler(String data) 
	{
		if(data.charAt(0) == '{')
		{
			try {
				parseObject(data);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(data.charAt(0) == '[')
		{
			try {
				parseArray(data);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void parseObject(String data) throws JSONException
	{
		ob = new JSONObject(data);
	}

	public void parseArray(String data) throws JSONException
	{
		ar = new JSONArray(data);
		objects = new JSONObject[ar.length()];
		for(int i = 0; i<objects.length; i++ )
		{
			objects[i] = ar.getJSONObject(i);
		}
	}
	
	public JSONObject getObject()
	{
		return ob;
	}

	public JSONObject getObjectAt(int index)
	{
		return objects[index];
	}
	
	public JSONObject[] getObjectArray()
	{
		return objects;
	}
	
	public String getString(String name)
	{
		try {
			return ob.getString(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getString(String name, int objectIndex)
	{
		try {
			return objects[objectIndex].getString(name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
