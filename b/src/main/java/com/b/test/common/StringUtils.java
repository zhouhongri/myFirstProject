package com.b.test.common;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author LiszAdmin
 */
public class StringUtils {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    private static final String[] labelColor = {"226dd6", "eb6238", "009687", "fa8c8c", "ffd080"};

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 检查是不是都是数字
     *
     * @param number
     * @return
     */
    public static boolean checkNumber(String number) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile("^[0-9]*$");
            Matcher matcher = regex.matcher(number);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");
            Matcher matcher = regex.matcher(phone);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 验证身份证号
     * @param idCard
     * @return
     */
    public static boolean checkIdCard(String idCard) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile("^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$");
            Matcher matcher = regex.matcher(idCard);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     * 比较两个用","分割的字符串，之间的内容是否一样
     *
     * @param firstStr
     * @param secondStr
     * @return
     */
    public static boolean compareStrSplitByComma(String firstStr, String secondStr) {
        if (firstStr == null || secondStr == null) {
            return false;
        }
        String[] firstArray = firstStr.split(",");
        String[] secondArray = secondStr.split(",");
        Map secondStrMap = new HashMap();
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int i = 0; i < secondArray.length; i++) {
            secondStrMap.put(secondArray[i], secondArray[i]);
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (!secondStrMap.containsKey(firstArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将指定double类型转换为金钱格式字符
     *
     * @param doubleValue
     * @return String
     */
    public static String doubleToCurrency(double doubleValue) {
        Object[] args = {new Double(doubleValue)};
        return MessageFormat.format("{0,number,￥,#,###,###,###,###,###,##0.00}", args);
    }

    /**
     * 将字符串对象按srcEncoding编码转换为destEncoding编码格
     *
     * @param stringValue
     * @param srcEncoding
     * @param destEncoding
     * @return String
     */
    public static String encodeString(String stringValue, String srcEncoding, String destEncoding) {
        // 如果参数为null，返回null
        if (stringValue == null || srcEncoding == null || destEncoding == null) {
            return null;
        }
        String value = null;
        try {
            value = new String(stringValue.getBytes(srcEncoding), destEncoding);
        } catch (UnsupportedEncodingException ex) {
            value = stringValue;
        }
        return value;
    }

    /**
     * 判断是否指定字符串为空字符串(null或者长度为0
     *
     * @param stringValue
     * @return boolean
     */
    public static boolean isEmptyString(String stringValue) {
        if (stringValue == null || stringValue.trim().length() < 1 || stringValue.trim().equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否指定字符串为空字符串(null或者长度为0
     *
     * @param stringValue
     * @return boolean
     */
    public static boolean isEmpty(String stringValue) {
        if (stringValue == null || stringValue.trim().length() < 1 || stringValue.trim().equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * isEmpty:判断数组是否为空. <br/>
     *
     * @param stringArray
     * @return
     * @author Haibo
     * @since JDK 1.6
     */
    public static boolean isEmpty(String[] stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否指定字符串为空字符串(null或者长度为0
     *
     * @param stringValue
     * @return boolean
     */
    public static boolean isNotEmpty(String stringValue) {
        if (stringValue == null || stringValue.trim().length() < 1 || stringValue.trim().equalsIgnoreCase("null")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isEmptyString(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch < '0' || ch > '9') {
                return false;

            }
        }
        return true;
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 将十进制数字字符串转换为整型数字，如果转换失败返回-
     *
     * @param stringValue
     * @return int
     */
    public static int stringToInt(String stringValue) {
        return stringToInt(stringValue, -1);
    }

    /**
     * 将十进制数字字符串转换为整型数字，如果转换失败返回默认
     *
     * @param stringValue
     * @param defaultValue
     * @return int
     */
    public static int stringToInt(String stringValue, int defaultValue) {
        int intValue = defaultValue;
        if (stringValue != null) {
            try {
                intValue = Integer.parseInt(stringValue);
            } catch (NumberFormatException ex) {
                intValue = defaultValue;
            }
        }
        return intValue;

    }

    /**
     * 将指定字符串对象默认编码IOS8859_1编码转为GBK编码的字符串对
     *
     * @param stringValue
     * @return String
     */
    public static String toGBKString(String stringValue) {
        return encodeString(stringValue, "ISO8859_1", "GBK");

    }

    /**
     * 构造函数
     */
    public StringUtils() {
    }


    /**
     * 两个值是否相等 (参数如果是空则为false)
     *
     * @param string
     * @param value
     * @return
     */
    public static boolean isEquals(Object string, Object value) {
        return string != null && value != null && string.toString().equals(value.toString());
    }

    public static boolean isNotNull(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    public static boolean isNULL(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return isEmpty((String) o);
        }
        return false;
    }

    public static boolean isNotNULL(Object o) {
        return !isNULL(o);
    }

    /**
     * 修改字符串加‘’ 比如：str=1,2,3 改成str='1','2','3'
     *
     * @param strs
     * @return
     * @author Haibo-W 2016年2月1日 下午6:00:03
     */
    public static String stradd(String strs) {
        StringBuffer stradd = new StringBuffer();
        String[] str = strs.split(",");
        if (str.length > 0) {
            for (int i = 0; i < str.length; i++) {
                String strEnd = str[i].replace("&&**", "");
                stradd.append("'" + strEnd + "',");
            }
            String result = stradd.toString().substring(0, stradd.toString().length() - 1);
            return result;
        }
        return "";
    }

    /**
     * 去掉左右空格 如果有值就去除空格 否則默认值
     *
     * @param strs
     * @return
     */
    public static String strRemoveNull(String strs) {
        String strNoNull = "";
        if (StringUtils.isNotEmpty(strs)) {
            strNoNull = strs.trim();
        }
        return strNoNull;
    }

    /**
     * strConvertInt:字符串转换成
     *
     * @param str
     * @param defaultVal
     * @author yingmm
     * @since JDK 1.6
     */
    public static Integer strConvertInt(String str, Integer defaultVal) {
        Integer returnVal = 0;
        try {
            if (StringUtils.isNotEmpty(str)) {
                returnVal = Integer.valueOf(str);
            }
        } catch (Exception e) {
            return defaultVal = defaultVal != null ? defaultVal : returnVal;
        }
        return returnVal;
    }

    /**
     * 随机获取几位包含数字和英文的验证码
     *
     * @return
     */
    public static String getFourAuth(int lenght) {
        if (lenght < 1) {
            lenght = 4;
        }
        String str = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String str2[] = str.split(",");
        Random rand = new Random();
        int index = 0;
        String randStr = "";
        randStr = "";
        for (int i = 0; i < lenght; ++i) {
            index = rand.nextInt(str2.length - 1);
            randStr += str2[index];
        }
        return randStr.toUpperCase();
    }


    /**
     * splitStr: 字符串转 字符串数组
     *
     * @author yingmm
     * @date:Mar 24, 2015 2:56:21 PM
     * @description
     */
    public static String[] splitCovStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return new String[]{};
        }
        return str.split(",");
    }

    /**
     * strConvertInt:字符串数组转换成字符串
     *
     * @param str
     * @author yuse
     * @since JDK 1.6
     */
    public static String strArrayConvertString(String[] str) {
        StringBuffer sb = new StringBuffer();
        String s = "";
        try {
            if (str.length > 0) {
                for (int i = 0; i < str.length; i++) {
                    sb.append(str[i]);
                    sb.append(",");
                }
                s = sb.substring(0, sb.length() - 1);
            }
        } catch (Exception e) {
            return "";
        }
        return s;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static String UrlDecode(String value, String encode) {
        String returnValue = "";
        try {
            returnValue = URLDecoder.decode(value, encode);
        } catch (Exception e) {
            logger.error("url解析错误" + e.getMessage(), e);
        }
        return returnValue;
    }

    /**
     * 获取请求的内网ip
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static String getIpAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmptyString(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmptyString(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    /**
     * 获取操作系统，浏览器及浏览器版本信息
     *
     * @param request
     * @return
     */
    public static String getOsAndBrowserInfo(HttpServletRequest request) {
        String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;
        if (isNotEmpty(userAgent)) {
            String user = userAgent.toLowerCase();
            //获取操作系统
            String os = "";
            //获取浏览器 和版本信息
            String browser = "";

            //=================OS Info=======================
            if (userAgent.toLowerCase().indexOf("windows") >= 0) {
                os = "Windows";
            } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
                os = "Mac";
            } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
                os = "Unix";
            } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
                os = "Android";
            } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
                os = "IPhone";
            } else {
                os = "UnKnown, More-Info: " + userAgent;
            }
            //===============Browser===========================
            if (isNotEmpty(user)) {
                if (user.contains("edge")) {
                    browser = (userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
                } else if (user.contains("msie")) {
                    String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
                    browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
                } else if (user.contains("safari") && user.contains("version")) {
                    browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
                            + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                } else if (user.contains("opr") || user.contains("opera")) {
                    if (user.contains("opera")) {
                        browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
                                + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
                    } else if (user.contains("opr")) {
                        browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
                                .replace("OPR", "Opera");
                    }

                } else if (user.contains("chrome")) {
                    browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
                } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) ||
                        (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
                        (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
                    browser = "Netscape-?";

                } else if (user.contains("firefox")) {
                    browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
                } else if (user.contains("rv")) {
                    String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
                    browser = "IE" + IEVersion.substring(0, IEVersion.length() - 1);
                } else {
                    browser = "UnKnown, More-Info: " + userAgent;
                }
            }
            return "" + browser;
        }
        return null;
    }

    /**
     * 随机生成产品号
     * @return
     */
    public static String randomOrderId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
        int i = (int)(Math.random()*900+100);
        String s = "T"+sdf.format(new Date()) + i;
        return s;
    }

    /**
     * 随机生成邀请码
     * @return
     */
    public static String randomInvitationCode(){
        int i = RandomUtils.nextInt(1000000);
        return i+"";
    }

    /**
     * 生成单号前面的日期
     * @return
     */
    public static String randomOrderCode(String px){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String s = px+sdf.format(new Date());
        return s;
    }

    /**
     * 获取当前时间时分秒并返回字符串
     * @return
     */
    public static String getDateHms(){
        Date date =new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("HHmmss");
        String time=sdf.format(date);
        return time;
    }

    public static String randomLabelColor(){
        int len = RandomUtils.nextInt(labelColor.length);
        return labelColor[len];
    }
}
