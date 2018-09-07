package com.airusheng.tech.wechat.admin.platform.common.utils.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * 请求相关工具类
 * @author Alex
 */
public class RequestUtil {

	/**
	 * 获取IP地址
	 * @param request 请求信息
	 * @return ip
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-real-ip");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (StringUtils.isEmpty(ip)) {
			return "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 通过ip地址获取mac地址
	 * @param ip ip
	 * @return mac
	 */
	public static String getMacAddrByIp(String ip) {
		String macAddr = null;
		try {
			Process process = Runtime.getRuntime().exec("nbtstat -a " + ip);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			Pattern pattern = Pattern.compile("([A-F0-9]{2}-){5}[A-F0-9]{2}");
			Matcher matcher;
			for (String strLine = br.readLine(); strLine != null;
					strLine = br.readLine()) {
				matcher = pattern.matcher(strLine);
				if (matcher.find()) {
					macAddr = matcher.group();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (StringUtils.isEmpty(macAddr)) {
			return "00-00-00-00-00-00";
		}
		return macAddr;
	}
}
