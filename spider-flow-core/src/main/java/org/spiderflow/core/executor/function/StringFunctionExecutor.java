package org.spiderflow.core.executor.function;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.spiderflow.annotation.Comment;
import org.spiderflow.annotation.Example;
import org.spiderflow.executor.FunctionExecutor;
import org.springframework.stereotype.Component;

/**
 * String 工具类 防止NPE 
 * @author Administrator
 *
 */
@Component
@Comment("string常用方法")
public class StringFunctionExecutor implements FunctionExecutor{
	
	@Override
	public String getFunctionPrefix() {
		return "string";
	}

	@Comment("截取字符串方法")
	@Example("${string.substring(str,5)}")
	public static String substring(String content, int beginIndex) {
		return content != null ? content.substring(beginIndex) : null;
	}

	@Comment("截取字符串方法")
	@Example("${string.substring(str,0,str.length() - 1)}")
	public static String substring(String content, int beginIndex, int endIndex) {
		return content != null ? content.substring(beginIndex, endIndex) : null;
	}

	@Comment("将字符串转为小写")
	public static String lower(String content) {
		return content != null ? content.toLowerCase() : null;
	}

	@Comment("将字符串转为大写")
	public static String upper(String content) {
		return content != null ? content.toUpperCase() : null;
	}

	@Comment("查找指定字符在字符串在中的位置")
	public static int indexOf(String content, String str) {
		return content != null ? content.indexOf(str) : -1;
	}

	@Comment("查找指定字符在字符串在中的位置")
	public static int indexOf(String content, String str, int fromIndex) {
		return content != null ? content.indexOf(str, fromIndex) : -1;
	}
	
	@Comment("将字符串转为int")
	public static int toInt(String value){
		return Integer.parseInt(value);
	}
	
	@Comment("将字符串转为Integer")
	public static Integer toInt(String value,Integer defaultValue){
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	public static String replace(String content,String source,String target){
		return content != null ? content.replace(source, target): null;
	}
	
	public static String replaceAll(String content,String regx,String target){
		return content != null ? content.replaceAll(regx, target): null;
	}
	
	public static String replaceFirst(String content,String regx,String target){
		return content != null ? content.replaceFirst(regx, target): null;
	}
	
	public static int length(String content){
		return content != null ? content.length() : -1;
	}
	
	public static String trim(String content){
		return content != null ? content.trim() : null;
	}
	
	public static List<String> split(String content,String regx){
		return content != null ? Arrays.asList(content.split(regx)) : new ArrayList<>(0);
	}
	
	public static byte[] bytes(String content){
		return content != null ? content.getBytes() : null;
	}
	
	public static byte[] bytes(String content,String charset){
		try {
			return content != null ? content.getBytes(charset) : null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static String newString(byte[] bytes){
		return bytes != null ? new String(bytes) : null;
	}
	
	public static String newString(byte[] bytes,String charset){
		try {
			return bytes != null ? new String(bytes,charset) : null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static boolean equals(String str1,String str2){
		return str1 == null ? false : str1.equals(str2);
	}
	
	/**
	 * 生成UUID
	 * @return String UUID
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static List<String> uuids(Integer size) {
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			ids.add(UUID.randomUUID().toString().replace("-", ""));
		}
		return ids;
	}
	
}
