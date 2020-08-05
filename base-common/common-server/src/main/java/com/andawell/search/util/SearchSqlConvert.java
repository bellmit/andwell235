package com.andawell.search.util;

import com.andawell.search.entity.XmlTableColumns;
import com.andawell.search.entity.XmlTableHeader;
import com.andawell.search.enumeration.FieldTypeEnum;
import com.andawell.search.enumeration.SearchConditionEnum;
import com.andawell.search.query.CommonListQuery;
import com.andawell.search.query.CommonListSqlQuery;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SearchSqlConvert {
    public static String getSql(CommonListSqlQuery commonListSqlQuery, XmlTableColumns xmlTableColumns) {
        String sql = commonListSqlQuery.getSql().toUpperCase();
        String newSql = null;
        List<CommonListQuery> innerQuery = new ArrayList<>();
        List<CommonListQuery> queries = new ArrayList<>();
        List<CommonListQuery> commonListQueries = commonListSqlQuery.getCommonListQuery();//查询条件

        List<XmlTableHeader> xmlTableHeaders = xmlTableColumns.getColumns();
        if (commonListQueries != null && commonListQueries.size() > 0) {
            commonListQueries.stream().forEach(
                    cond -> {
                        xmlTableHeaders
                                .stream()
                                .forEach(
                                        header -> {
                                            if (cond.getName().equals(header.getProp()) || cond.getName().equals(header.getProp() + "_start") || cond.getName().equals(header.getProp() + "_end")) {
                                                if (header.getIsInner() != null && header.getIsInner().booleanValue()) {
                                                    innerQuery.add(cond);
                                                } else {
                                                    queries.add(cond);
                                                }
                                            }
                                        });
                    }
            );
        }
        if (innerQuery != null && innerQuery.size() > 0) {

            StringBuffer sbInner = new StringBuffer();
            sbInner.append(" WHERE 1=1 ");
            splitSql(sbInner, innerQuery);
            newSql = sql.replace("WHERE 1=1", sbInner.toString());
        } else {
            newSql = sql;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("select * from ( ");
        sb.append(newSql);
        sb.append(" )");
        sb.append(" WHERE 2=2 ");
        splitSql(sb, queries);
        if (StringUtils.isNotEmpty(commonListSqlQuery.getSortField())) {
            sb.append(" order by " + commonListSqlQuery.getSortField() + " " + commonListSqlQuery.getSortOrder());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    private static void splitSql(StringBuffer sb, List<CommonListQuery> condition) {
        if (condition != null && condition.size() > 0) {
            condition.stream().forEach(query -> {
                SearchConditionEnum searchCondition = query.getCondition();
                if (FieldTypeEnum.date.name().equals(query.getType()) && query.getName().endsWith("_start") && isNotEmpty(query.getValue())) {
                    sb.append(" and " + query.getName().replace("_start", "") + " > to_date('" + query.getValue()+" 00:00:00" + "','YYYY-MM-DD HH24:MI:SS') ");
                }
                if (FieldTypeEnum.date.name().equals(query.getType()) && query.getName().endsWith("_end") && isNotEmpty(query.getValue())) {
                    sb.append(" and " + query.getName().replace("_end", "") + " < to_date('" + query.getValue()+" 23:59:59" + "','YYYY-MM-DD HH24:MI:SS') ");
                }
                if (isNotEmpty(query.getValue()) && !query.getName().endsWith("_end") && !query.getName().endsWith("_start")) {
                    if (SearchConditionEnum.greater.equals(searchCondition)) {
                        if (FieldTypeEnum.date.name().equals(query.getType())) {
                            sb.append(" and " + query.getName() + " > to_date('" + query.getValue() +" 00:00:00" + "','YYYY-MM-DD HH24:MI:SS') ");
                        } else {
                            sb.append(" and " + query.getName() + " > '" + query.getValue() + "' ");
                        }
                    }
                    if (SearchConditionEnum.less.equals(searchCondition)) {
                        if (FieldTypeEnum.date.name().equals(query.getType())) {
                            sb.append(" and " + query.getName() + " < to_date('" + query.getValue() +" 23:59:59" + "','YYYY-MM-DD HH24:MI:SS') ");
                        } else {
                            sb.append(" and " + query.getName() + " < '" + query.getValue() + "' ");
                        }
                    }
                    if (SearchConditionEnum.leftLike.equals(searchCondition) && FieldTypeEnum.string.name().equals(query.getType())) {
                        sb.append(" and " + query.getName() + " like '" + query.getValue() + "%' ");
                    }
                    if (SearchConditionEnum.like.equals(searchCondition) && FieldTypeEnum.string.name().equals(query.getType())) {
                        sb.append(" and " + query.getName() + " like '%" + query.getValue() + "%' ");
                    }
                    if (SearchConditionEnum.rightLike.equals(searchCondition) && FieldTypeEnum.string.name().equals(query.getType())) {
                        sb.append(" and " + query.getName() + " like '%" + query.getValue() + "' ");
                    }
                    if (SearchConditionEnum.notEqual.equals(searchCondition)) {
                        sb.append(" and （ " + query.getName() + " <> '" + query.getValue() + "' or "+query.getName()+" is null )");
                    }
                    if (SearchConditionEnum.equal.equals(searchCondition) && FieldTypeEnum.string.name().equals(query.getType())) {
                        Object value = query.getValue();
                        if (value instanceof String) {
                            sb.append(" and " + query.getName() + " = '" + query.getValue() + "' ");
                        }
                        if (value instanceof List) {
                            List<String> setList = new ArrayList<>();
                            List<String> value1 = (List<String>) value;
                            Set set = new HashSet();
                            StringBuffer sbValue = new StringBuffer();
                            for (int i = 1; i <= value1.size(); i++) {
                                set.add("'" + value1.get(i - 1) + "'");
                            }
                            if (!set.isEmpty()) {
                                setList.add(StringUtils.join(set.iterator(), ","));
                            }
                            sb.append(" and " + query.getName() + " in ( " + setList.get(0) + " ) ");
                        }

                    }
                    if (SearchConditionEnum.equal.equals(searchCondition) && FieldTypeEnum.date.name().equals(query.getType()) && !query.getName().endsWith("_end") && !query.getName().endsWith("_start")) {
                        sb.append(" and " + query.getName() + " = to_date('" + query.getValue() + "','YYYY-MM-DD HH24:MI:SS') ");
                    }
                    if (SearchConditionEnum.equal.equals(searchCondition) && FieldTypeEnum.integer.name().equals(query.getType()) ) {
                        sb.append(" and " + query.getName() + " = " + query.getValue() + " ");
                    }
                    if (FieldTypeEnum.dateString.name().equals(query.getType())) {
                        if (SearchConditionEnum.equal.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') = '" + query.getValue() + "'");
                        }
                        if (SearchConditionEnum.notEqual.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') <> '" + query.getValue() + "'");
                        }
                        if (SearchConditionEnum.greater.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') > '" + query.getValue() + "'");
                        }
                        if (SearchConditionEnum.less.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') < '" + query.getValue() + "'");
                        }
                        if (SearchConditionEnum.greaterAndEqual.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') >= '" + query.getValue() + "'");
                        }
                        if (SearchConditionEnum.lessAndEqual.equals(searchCondition)) {
                            sb.append(" to_char(" + query.getName() + ",'YYYY-MM-DD') <= '" + query.getValue() + "'");
                        }

                    }

                }

            });
        }
    }


    private static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof List) {
            //判断对象所属类型
            return ((List) obj).size() == 0;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().equals("");
        }
        if (obj instanceof Map) {
            return ((Map) obj).size() == 0;
        }
        return false;
    }


    private static boolean isNotEmpty(Object obj) {

        return !isEmpty(obj);
    }

}
