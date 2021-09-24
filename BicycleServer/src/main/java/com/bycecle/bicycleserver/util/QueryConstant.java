package com.bycecle.bicycleserver.util;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryConstant {
    static final Logger log = Logger.getLogger(QueryConstant.class);

    public static String callQuery(String property, String query, Object... parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append(" call ").append(getGenericName()).append(property);
        sql.append(query).append(getGenericName());
        sql.append("(");
        if (parameters != null && parameters.length != 0) {
            sql.append("?");
            for (int i = 0; i < parameters.length; i++) {
                if (i >= 1) {
                    sql.append(getGenericName()).append(", ?");
                }
            }
        }
        sql.append(")");
        log.info("query property ====> " + sql);
        return sql.toString();
    }

    public static String getGenericName() {
        String s = QueryConstant.class.getGenericSuperclass().toString();
        Pattern pattern = Pattern.compile("\\<(.*?)\\>");
        Matcher m = pattern.matcher(s);
        String generic = "";
        if (m.find()) {
            generic = m.group(1);
        }
        return generic;
    }
}
