package com.airusheng.tech.wechat.admin.platform.common.utils.api;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {
    /**
     * 以JSON格式输出
     * @param response
     */
    public static void responseOutWithJson(HttpServletResponse response, Object responseObject) {
        //将实体对象转换为JSON Object转换
        String responseBody = JSON.toJSONString(responseObject);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
