package com.example.validationUserManagement.utility;

import com.example.validationUserManagement.model.User;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private static final String DATE_PATTERN = "^((?:19|20)[0-9][0-9])-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    private static final String PHONE_PATTERN = "^\\d{12}$";
    public static boolean validateName(String userName) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (userName == null) {
            return false;
        }
        Matcher m = p.matcher(userName);
        return m.matches();
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        boolean result = false;
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (matcher.matches()) {
            result = true;
            int year = Integer.parseInt(matcher.group(1));
            String month = matcher.group(2);
            String day = matcher.group(3);
            if ((month.equals("4") || month.equals("6") || month.equals("9") ||
                    month.equals("04") || month.equals("06") || month.equals("09") ||
                    month.equals("11")) && day.equals("31")) {
                result = false;
            } else if (month.equals("2") || month.equals("02")) {
                if (day.equals("30") || day.equals("31")) {
                    result = false;
                } else if (day.equals("29")) {  // leap year? feb 29 days.
                    if (!isLeapYear(year)) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static boolean validateEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.compile(PHONE_PATTERN).matcher(phoneNumber).matches();
    }
}
