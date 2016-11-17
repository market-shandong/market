package com.zbss.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author zbss
 * @desc 序列化工具类 
 * @date 2016-4-25 上午10:43:05
 */
public class SerializeUtils {
	
	// 序列化
	public static byte[] serialize(Object source) throws IOException {
		try (
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream(byteOut);	
		){
			objOut.writeObject(source);
			objOut.flush();
			
			return byteOut.toByteArray();
		}
	}

	// 反序列化
	public static Object deserialize(byte[] source) throws IOException, ClassNotFoundException {
		try(
			ByteArrayInputStream byteIn = new ByteArrayInputStream(source);
			ObjectInputStream objIn = new ObjectInputStream(byteIn);
		) {
			return objIn.readObject();
		} 
	}
}
