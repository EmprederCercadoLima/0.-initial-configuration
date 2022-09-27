package com.initial.configuration.util;

public class ConstantsUtil {

  public static final String REGEX_ONLY_ALL = ".*";
  public static final String REGEX_REQUEST_DATE =
      "(19|20)\\d\\d-(0[1-9]|1[012])-([012]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)."
      + "([0-9][0-9][0-9])((\\+|-)(\\d{2}):(\\d{2}))";
  public static final String REGEX_ONLY_ALFA = "^[a-zA-Z0-9]+$";
  public static final String REGEX_REQ_DI = "([a-fA-F0-9]{8}(-[a-fA-F0-9]{4}){4}[a-fA-F0-9]{8})";
  public static final String REGEX_APP_CODE = ".{2,5}";
  public static final String REGEX_CALLER_NAME = ".{5,100}";
  public static final String REGEX_ORG_CODE = ".{1,100}";
  public static final String REGEX_IP_ADD = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.)"
      + "{3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}
