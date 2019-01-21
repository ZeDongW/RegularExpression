package com.wzd.crawler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：ZeDongW
 * @version : 1.0
 * @ClassName : Crawler
 * @description：模拟网络爬虫
 * @modified By：
 * @date ：Created in 2019/01/21/0021 8:22
 */
public class Crawler {
    public static void main(String[] args) {
        String content = "电子邮箱格式通常为 username@domain.com 其中username为用户名 可以是字母数字下划线 domain为域名 例如QQ邮箱 123456789@qq.com 或者 abc123@163.com" +
                "沙文散发的wzd8781217@gmial.com大厦空间烦恼空间nkaiaki@kayak.com.cn";
        ArrayList<String> list = new ArrayList<>(); //接收邮箱的集合
        System.out.println(emailCrawler(list, content));
    }

    /**
     * @Author     : ZeDongW
     * @Description: 邮箱爬虫
     * @Date       : 2019/01/21/0021 8:31
     * @Param      : [list, content]
     * @return     : java.util.ArrayList<java.lang.String>
     */
    private static ArrayList<String> emailCrawler(ArrayList<String> list, String content) {
        String reg = "[a-z1-9A-Z]\\w{3,}@[a-z1-9A-Z]{2,}(\\.(com|cn|net)){1,2}";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(content);
        while (m.find()){
            list.add(m.group());
        }
        return list;
    }


}
