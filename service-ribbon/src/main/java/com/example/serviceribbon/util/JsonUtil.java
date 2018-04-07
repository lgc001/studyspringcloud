package com.example.serviceribbon.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class JsonUtil {
	public static String toJson(Object obj)
	{
		if(obj==null)
		{
			return "{}";
		}

		Gson gson=new Gson();
		return gson.toJson(obj);
	}

	/**
	 * T是不含泛型时,如CompetitionDto
	 * @param <T>
	 * @param json
	 * @return
	 */
	public static <T> T fromJson(String json,Class<T> tClass)
	{
		if (isEmpty(json)) {
			return null;
		}

		Gson gson=new Gson();
		return gson.fromJson(json,tClass);
	}

	public static <T> T fromJson(String json, TypeToken<T> token) {
		return fromJson(json,token.getType());
	}

	/**
	 * T是含泛型时,如ResponseDto<CompetitionDto>
	 * @param json
	 * @param typeOfT
	 * @param <T>
	 * @return
	 */
	public static <T> T fromJson(String json,Type typeOfT)
	{
		if (isEmpty(json)) {
			return null;
		}

		Gson gson=new Gson();
		return gson.fromJson(json, typeOfT);
	}

	private static boolean isEmpty(String json) {
		return json == null || json.trim().length() == 0;
	}
}
