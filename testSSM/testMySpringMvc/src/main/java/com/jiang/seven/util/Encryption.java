package com.jiang.seven.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	public static final String MD5 = "MD5";

	/**
	 * 采用加密算法加密字符串数据
	 * 
	 * @param str
	 *            需要加密的数据
	 * @param algorithm
	 *            采用的加密算法
	 * @return 字节数据
	 */
	public static byte[] EncryptionStr(String str, String algorithm) {
		// 加密之后所得字节数组
		byte[] bytes = null;
		try {
			// 获取MD5算法实例 得到一个md5的消息摘要
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 添加要进行计算摘要的信息
			md.update(str.getBytes());
			// 得到该摘要
			bytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("加密算法: " + algorithm + " 不存在: ");
		}
		return null == bytes ? null : bytes;
	}

	// 测试上述方法
	public static void main(String[] args) {
		String test1 = "test1";
		String test2 = "QWERFVDSCX";
		String test3 = "23423KJHkdfg";
		String[] test = { test1, test2, test3 };
		for (String s : test) {
			byte[] bytes = EncryptionStr(s, MD5);
			/*try {
				String string = new String(bytes,"UTF-8");
				System.out.println(string);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			System.out.println("数据：" + s + " 加密之后的结果为：" + bytes.toString()
					+ " 字节数组长度为：" + bytes.length);
		}
	}

}
