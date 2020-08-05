package com.andawell.common.util;
import java.util.regex.Pattern;

/**
 * 验证各种字符串格式是否正确
 */
public class RuleUtil {
    /**
     * 验证Email
     * @param email
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证身份证号码
     * @param idCard
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex,idCard);
    }

    /**
     * 验证手机号码
     * @param mobile
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String mobile) {
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex,mobile);
    }
    /**
     * 验证固定电话号码
     * @param phone
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

}
