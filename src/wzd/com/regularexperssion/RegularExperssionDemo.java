package wzd.com.regularexperssion;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：ZeDongW
 * @date ：Created in 2019/01/19/0019 7:38
 * @description：Java正则表达式演示
 * @modified By：
 * @version: 1.00$
 */
public class RegularExperssionDemo {
    /**
     * create by: ZeDongW
     * description: Java正则表达式演示
     * create time: 2019/01/19/0019 7:39
     *
     * @return
     * @Param: null
     */
    public static void main(String[] args) {
        RegularExperssionDemo demo = new RegularExperssionDemo();
        demo.checkMobileNum("13164892378");
        demo.matchesMobile("13164899878");
        demo.matchesPhone("0715-8828524");
        demo.splitSymbol("世   界      如 此 美   好");
        demo.splitReduplicatedWord("祝大大大大大家新新新年快乐乐乐乐乐");
        demo.replaceAd("如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，" +
                "如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，" +
                "如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878，如有需求，请联系13164899878");
        demo.replaceReduplicatedWord("祝大大大大大家新新新年快乐乐乐乐乐");
        demo.find("zhu da jia xin nian kuai le");
    }

    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: //手机号码校验
     * @Date : 2019/01/19/0019 8:34
     * @Param : [mobile]
     */
    private void checkMobileNum(String mobile) {
        if (mobile.startsWith("1")) {
            if (mobile.length() == 11) {
                try {
                    Long.parseLong(mobile);
                    System.out.println("合法手机号");
                } catch (NumberFormatException e) {
                    System.out.println("非法手机号，手机号只能为数字");
                }
            } else {
                System.out.println("手机号非法，手机号长度只能为11位");
            }
        } else {
            System.out.println("手机号非法，手机号只能以1开头");
        }
    }

    /**
     * @return : void
     * @Author : ZeDongW
     * @Description: 正则匹配手机号，手机号11位
     *                  13，15，17，18，19 开头
     * @Date : 2019/01/20/0020 8:18
     * @Param : [phone]
     */
    private void matchesMobile(String mobile1) {
        String reg = "1[35789]\\d{9}";
        System.out.println(mobile1.matches(reg) ? "合法手机号" : "非法和手机号");
    }

    /**
     * @Author     : ZeDongW
     * @Description: 正则匹配固定电话，区号-主机号
     *                      区号0开头，3-4位
     *                      主机号不能以0开头， 7-8位
     * @Date       : 2019/01/20/0020 8:32
     * @Param      : [phone]
     * @return     : void
     */
    private void matchesPhone(String phone){
        String reg = "0\\d{2,3}-[1-9]\\d{6,7}";
        System.out.println(phone.matches(reg)?"合法固定电话":"非法固定电话");
    }

    /**
     * @Author     : ZeDongW
     * @Description: 根据空格符切割字符串
     * @Date       : 2019/01/20/0020 11:57
     * @Param      : [str]
     * @return     : void
     */
    private void splitSymbol(String str){
        String reg = " +";
        String[] arr = str.split(reg);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @Author     : ZeDongW
     * @Description: 根据叠词切割字符串
     * @Date       : 2019/01/20/0020 12:45
     * @Param      : [str]
     * @return     : void
     */
    private void splitReduplicatedWord(String str){
        String reg = "(.)\\1+";
        String[] arr = str.split(reg);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @Author     : ZeDongW
     * @Description: 论坛屏蔽手机号
     * @Date       : 2019/01/21/0021 6:24
     * @Param      : [str]
     * @return     : void
     */
    private void replaceAd(String str){
        String reg = "1[35789]\\d{9}";
        str = str.replaceAll(reg, "****");
        System.out.println("屏蔽后内容为：" + str);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 将叠词替换为单个字
     * @Date       : 2019/01/21/0021 6:55
     * @Param      : [str]
     * @return     : void
     */
    private void replaceReduplicatedWord(String str){
        String reg = "(.)\\1+";
        str = str.replaceAll(reg,"$1");
        System.out.println("替换后内容为:" + str);
    }

    /**
     * @Author     : ZeDongW
     * @Description: 使用证则匹配器
     * @Date       : 2019/01/21/0021 7:27
     * @Param      : [str]
     * @return     : void
     */
    private void find(String str){
    Pattern p = Pattern.compile("\\b[a-zA-Z]{3}\\b");
        Matcher m = p.matcher(str);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
