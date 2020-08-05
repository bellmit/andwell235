package com.andawell.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCfExample {
    /**
     * T_CF
     */
    protected String orderByClause;

    /**
     * T_CF
     */
    protected boolean distinct;

    /**
     * T_CF
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public TCfExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-09
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * T_CF 2020-05-09
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLbIsNull() {
            addCriterion("LB is null");
            return (Criteria) this;
        }

        public Criteria andLbIsNotNull() {
            addCriterion("LB is not null");
            return (Criteria) this;
        }

        public Criteria andLbEqualTo(String value) {
            addCriterion("LB =", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotEqualTo(String value) {
            addCriterion("LB <>", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbGreaterThan(String value) {
            addCriterion("LB >", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbGreaterThanOrEqualTo(String value) {
            addCriterion("LB >=", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLessThan(String value) {
            addCriterion("LB <", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLessThanOrEqualTo(String value) {
            addCriterion("LB <=", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLike(String value) {
            addCriterion("LB like", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotLike(String value) {
            addCriterion("LB not like", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbIn(List<String> values) {
            addCriterion("LB in", values, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotIn(List<String> values) {
            addCriterion("LB not in", values, "lb");
            return (Criteria) this;
        }

        public Criteria andLbBetween(String value1, String value2) {
            addCriterion("LB between", value1, value2, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotBetween(String value1, String value2) {
            addCriterion("LB not between", value1, value2, "lb");
            return (Criteria) this;
        }

        public Criteria andMcIsNull() {
            addCriterion("MC is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("MC is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("MC =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("MC <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("MC >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("MC >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("MC <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("MC <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("MC like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("MC not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("MC in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("MC not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("MC between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("MC not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andJmIsNull() {
            addCriterion("JM is null");
            return (Criteria) this;
        }

        public Criteria andJmIsNotNull() {
            addCriterion("JM is not null");
            return (Criteria) this;
        }

        public Criteria andJmEqualTo(String value) {
            addCriterion("JM =", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmNotEqualTo(String value) {
            addCriterion("JM <>", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmGreaterThan(String value) {
            addCriterion("JM >", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmGreaterThanOrEqualTo(String value) {
            addCriterion("JM >=", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmLessThan(String value) {
            addCriterion("JM <", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmLessThanOrEqualTo(String value) {
            addCriterion("JM <=", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmLike(String value) {
            addCriterion("JM like", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmNotLike(String value) {
            addCriterion("JM not like", value, "jm");
            return (Criteria) this;
        }

        public Criteria andJmIn(List<String> values) {
            addCriterion("JM in", values, "jm");
            return (Criteria) this;
        }

        public Criteria andJmNotIn(List<String> values) {
            addCriterion("JM not in", values, "jm");
            return (Criteria) this;
        }

        public Criteria andJmBetween(String value1, String value2) {
            addCriterion("JM between", value1, value2, "jm");
            return (Criteria) this;
        }

        public Criteria andJmNotBetween(String value1, String value2) {
            addCriterion("JM not between", value1, value2, "jm");
            return (Criteria) this;
        }

        public Criteria andZylbIsNull() {
            addCriterion("ZYLB is null");
            return (Criteria) this;
        }

        public Criteria andZylbIsNotNull() {
            addCriterion("ZYLB is not null");
            return (Criteria) this;
        }

        public Criteria andZylbEqualTo(String value) {
            addCriterion("ZYLB =", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotEqualTo(String value) {
            addCriterion("ZYLB <>", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbGreaterThan(String value) {
            addCriterion("ZYLB >", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbGreaterThanOrEqualTo(String value) {
            addCriterion("ZYLB >=", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLessThan(String value) {
            addCriterion("ZYLB <", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLessThanOrEqualTo(String value) {
            addCriterion("ZYLB <=", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbLike(String value) {
            addCriterion("ZYLB like", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotLike(String value) {
            addCriterion("ZYLB not like", value, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbIn(List<String> values) {
            addCriterion("ZYLB in", values, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotIn(List<String> values) {
            addCriterion("ZYLB not in", values, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbBetween(String value1, String value2) {
            addCriterion("ZYLB between", value1, value2, "zylb");
            return (Criteria) this;
        }

        public Criteria andZylbNotBetween(String value1, String value2) {
            addCriterion("ZYLB not between", value1, value2, "zylb");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andZhmcIsNull() {
            addCriterion("ZHMC is null");
            return (Criteria) this;
        }

        public Criteria andZhmcIsNotNull() {
            addCriterion("ZHMC is not null");
            return (Criteria) this;
        }

        public Criteria andZhmcEqualTo(String value) {
            addCriterion("ZHMC =", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcNotEqualTo(String value) {
            addCriterion("ZHMC <>", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcGreaterThan(String value) {
            addCriterion("ZHMC >", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZHMC >=", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcLessThan(String value) {
            addCriterion("ZHMC <", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcLessThanOrEqualTo(String value) {
            addCriterion("ZHMC <=", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcLike(String value) {
            addCriterion("ZHMC like", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcNotLike(String value) {
            addCriterion("ZHMC not like", value, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcIn(List<String> values) {
            addCriterion("ZHMC in", values, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcNotIn(List<String> values) {
            addCriterion("ZHMC not in", values, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcBetween(String value1, String value2) {
            addCriterion("ZHMC between", value1, value2, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhmcNotBetween(String value1, String value2) {
            addCriterion("ZHMC not between", value1, value2, "zhmc");
            return (Criteria) this;
        }

        public Criteria andZhIsNull() {
            addCriterion("ZH is null");
            return (Criteria) this;
        }

        public Criteria andZhIsNotNull() {
            addCriterion("ZH is not null");
            return (Criteria) this;
        }

        public Criteria andZhEqualTo(String value) {
            addCriterion("ZH =", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotEqualTo(String value) {
            addCriterion("ZH <>", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThan(String value) {
            addCriterion("ZH >", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhGreaterThanOrEqualTo(String value) {
            addCriterion("ZH >=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThan(String value) {
            addCriterion("ZH <", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLessThanOrEqualTo(String value) {
            addCriterion("ZH <=", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhLike(String value) {
            addCriterion("ZH like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotLike(String value) {
            addCriterion("ZH not like", value, "zh");
            return (Criteria) this;
        }

        public Criteria andZhIn(List<String> values) {
            addCriterion("ZH in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotIn(List<String> values) {
            addCriterion("ZH not in", values, "zh");
            return (Criteria) this;
        }

        public Criteria andZhBetween(String value1, String value2) {
            addCriterion("ZH between", value1, value2, "zh");
            return (Criteria) this;
        }

        public Criteria andZhNotBetween(String value1, String value2) {
            addCriterion("ZH not between", value1, value2, "zh");
            return (Criteria) this;
        }

        public Criteria andKhyhIsNull() {
            addCriterion("KHYH is null");
            return (Criteria) this;
        }

        public Criteria andKhyhIsNotNull() {
            addCriterion("KHYH is not null");
            return (Criteria) this;
        }

        public Criteria andKhyhEqualTo(String value) {
            addCriterion("KHYH =", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotEqualTo(String value) {
            addCriterion("KHYH <>", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhGreaterThan(String value) {
            addCriterion("KHYH >", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhGreaterThanOrEqualTo(String value) {
            addCriterion("KHYH >=", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLessThan(String value) {
            addCriterion("KHYH <", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLessThanOrEqualTo(String value) {
            addCriterion("KHYH <=", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhLike(String value) {
            addCriterion("KHYH like", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotLike(String value) {
            addCriterion("KHYH not like", value, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhIn(List<String> values) {
            addCriterion("KHYH in", values, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotIn(List<String> values) {
            addCriterion("KHYH not in", values, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhBetween(String value1, String value2) {
            addCriterion("KHYH between", value1, value2, "khyh");
            return (Criteria) this;
        }

        public Criteria andKhyhNotBetween(String value1, String value2) {
            addCriterion("KHYH not between", value1, value2, "khyh");
            return (Criteria) this;
        }

        public Criteria andGjIsNull() {
            addCriterion("GJ is null");
            return (Criteria) this;
        }

        public Criteria andGjIsNotNull() {
            addCriterion("GJ is not null");
            return (Criteria) this;
        }

        public Criteria andGjEqualTo(String value) {
            addCriterion("GJ =", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotEqualTo(String value) {
            addCriterion("GJ <>", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjGreaterThan(String value) {
            addCriterion("GJ >", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjGreaterThanOrEqualTo(String value) {
            addCriterion("GJ >=", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLessThan(String value) {
            addCriterion("GJ <", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLessThanOrEqualTo(String value) {
            addCriterion("GJ <=", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjLike(String value) {
            addCriterion("GJ like", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotLike(String value) {
            addCriterion("GJ not like", value, "gj");
            return (Criteria) this;
        }

        public Criteria andGjIn(List<String> values) {
            addCriterion("GJ in", values, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotIn(List<String> values) {
            addCriterion("GJ not in", values, "gj");
            return (Criteria) this;
        }

        public Criteria andGjBetween(String value1, String value2) {
            addCriterion("GJ between", value1, value2, "gj");
            return (Criteria) this;
        }

        public Criteria andGjNotBetween(String value1, String value2) {
            addCriterion("GJ not between", value1, value2, "gj");
            return (Criteria) this;
        }

        public Criteria andCsIsNull() {
            addCriterion("CS is null");
            return (Criteria) this;
        }

        public Criteria andCsIsNotNull() {
            addCriterion("CS is not null");
            return (Criteria) this;
        }

        public Criteria andCsEqualTo(String value) {
            addCriterion("CS =", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsNotEqualTo(String value) {
            addCriterion("CS <>", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsGreaterThan(String value) {
            addCriterion("CS >", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsGreaterThanOrEqualTo(String value) {
            addCriterion("CS >=", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsLessThan(String value) {
            addCriterion("CS <", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsLessThanOrEqualTo(String value) {
            addCriterion("CS <=", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsLike(String value) {
            addCriterion("CS like", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsNotLike(String value) {
            addCriterion("CS not like", value, "cs");
            return (Criteria) this;
        }

        public Criteria andCsIn(List<String> values) {
            addCriterion("CS in", values, "cs");
            return (Criteria) this;
        }

        public Criteria andCsNotIn(List<String> values) {
            addCriterion("CS not in", values, "cs");
            return (Criteria) this;
        }

        public Criteria andCsBetween(String value1, String value2) {
            addCriterion("CS between", value1, value2, "cs");
            return (Criteria) this;
        }

        public Criteria andCsNotBetween(String value1, String value2) {
            addCriterion("CS not between", value1, value2, "cs");
            return (Criteria) this;
        }

        public Criteria andDzIsNull() {
            addCriterion("DZ is null");
            return (Criteria) this;
        }

        public Criteria andDzIsNotNull() {
            addCriterion("DZ is not null");
            return (Criteria) this;
        }

        public Criteria andDzEqualTo(String value) {
            addCriterion("DZ =", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotEqualTo(String value) {
            addCriterion("DZ <>", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzGreaterThan(String value) {
            addCriterion("DZ >", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzGreaterThanOrEqualTo(String value) {
            addCriterion("DZ >=", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLessThan(String value) {
            addCriterion("DZ <", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLessThanOrEqualTo(String value) {
            addCriterion("DZ <=", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzLike(String value) {
            addCriterion("DZ like", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotLike(String value) {
            addCriterion("DZ not like", value, "dz");
            return (Criteria) this;
        }

        public Criteria andDzIn(List<String> values) {
            addCriterion("DZ in", values, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotIn(List<String> values) {
            addCriterion("DZ not in", values, "dz");
            return (Criteria) this;
        }

        public Criteria andDzBetween(String value1, String value2) {
            addCriterion("DZ between", value1, value2, "dz");
            return (Criteria) this;
        }

        public Criteria andDzNotBetween(String value1, String value2) {
            addCriterion("DZ not between", value1, value2, "dz");
            return (Criteria) this;
        }

        public Criteria andYbIsNull() {
            addCriterion("YB is null");
            return (Criteria) this;
        }

        public Criteria andYbIsNotNull() {
            addCriterion("YB is not null");
            return (Criteria) this;
        }

        public Criteria andYbEqualTo(String value) {
            addCriterion("YB =", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbNotEqualTo(String value) {
            addCriterion("YB <>", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbGreaterThan(String value) {
            addCriterion("YB >", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbGreaterThanOrEqualTo(String value) {
            addCriterion("YB >=", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbLessThan(String value) {
            addCriterion("YB <", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbLessThanOrEqualTo(String value) {
            addCriterion("YB <=", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbLike(String value) {
            addCriterion("YB like", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbNotLike(String value) {
            addCriterion("YB not like", value, "yb");
            return (Criteria) this;
        }

        public Criteria andYbIn(List<String> values) {
            addCriterion("YB in", values, "yb");
            return (Criteria) this;
        }

        public Criteria andYbNotIn(List<String> values) {
            addCriterion("YB not in", values, "yb");
            return (Criteria) this;
        }

        public Criteria andYbBetween(String value1, String value2) {
            addCriterion("YB between", value1, value2, "yb");
            return (Criteria) this;
        }

        public Criteria andYbNotBetween(String value1, String value2) {
            addCriterion("YB not between", value1, value2, "yb");
            return (Criteria) this;
        }

        public Criteria andLxrIsNull() {
            addCriterion("LXR is null");
            return (Criteria) this;
        }

        public Criteria andLxrIsNotNull() {
            addCriterion("LXR is not null");
            return (Criteria) this;
        }

        public Criteria andLxrEqualTo(String value) {
            addCriterion("LXR =", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotEqualTo(String value) {
            addCriterion("LXR <>", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThan(String value) {
            addCriterion("LXR >", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrGreaterThanOrEqualTo(String value) {
            addCriterion("LXR >=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThan(String value) {
            addCriterion("LXR <", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLessThanOrEqualTo(String value) {
            addCriterion("LXR <=", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrLike(String value) {
            addCriterion("LXR like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotLike(String value) {
            addCriterion("LXR not like", value, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrIn(List<String> values) {
            addCriterion("LXR in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotIn(List<String> values) {
            addCriterion("LXR not in", values, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrBetween(String value1, String value2) {
            addCriterion("LXR between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andLxrNotBetween(String value1, String value2) {
            addCriterion("LXR not between", value1, value2, "lxr");
            return (Criteria) this;
        }

        public Criteria andDhIsNull() {
            addCriterion("DH is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("DH is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(String value) {
            addCriterion("DH =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(String value) {
            addCriterion("DH <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(String value) {
            addCriterion("DH >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(String value) {
            addCriterion("DH >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(String value) {
            addCriterion("DH <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(String value) {
            addCriterion("DH <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLike(String value) {
            addCriterion("DH like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotLike(String value) {
            addCriterion("DH not like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<String> values) {
            addCriterion("DH in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<String> values) {
            addCriterion("DH not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(String value1, String value2) {
            addCriterion("DH between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(String value1, String value2) {
            addCriterion("DH not between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andCzIsNull() {
            addCriterion("CZ is null");
            return (Criteria) this;
        }

        public Criteria andCzIsNotNull() {
            addCriterion("CZ is not null");
            return (Criteria) this;
        }

        public Criteria andCzEqualTo(String value) {
            addCriterion("CZ =", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotEqualTo(String value) {
            addCriterion("CZ <>", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzGreaterThan(String value) {
            addCriterion("CZ >", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzGreaterThanOrEqualTo(String value) {
            addCriterion("CZ >=", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLessThan(String value) {
            addCriterion("CZ <", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLessThanOrEqualTo(String value) {
            addCriterion("CZ <=", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzLike(String value) {
            addCriterion("CZ like", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotLike(String value) {
            addCriterion("CZ not like", value, "cz");
            return (Criteria) this;
        }

        public Criteria andCzIn(List<String> values) {
            addCriterion("CZ in", values, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotIn(List<String> values) {
            addCriterion("CZ not in", values, "cz");
            return (Criteria) this;
        }

        public Criteria andCzBetween(String value1, String value2) {
            addCriterion("CZ between", value1, value2, "cz");
            return (Criteria) this;
        }

        public Criteria andCzNotBetween(String value1, String value2) {
            addCriterion("CZ not between", value1, value2, "cz");
            return (Criteria) this;
        }

        public Criteria andYjIsNull() {
            addCriterion("YJ is null");
            return (Criteria) this;
        }

        public Criteria andYjIsNotNull() {
            addCriterion("YJ is not null");
            return (Criteria) this;
        }

        public Criteria andYjEqualTo(String value) {
            addCriterion("YJ =", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotEqualTo(String value) {
            addCriterion("YJ <>", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThan(String value) {
            addCriterion("YJ >", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjGreaterThanOrEqualTo(String value) {
            addCriterion("YJ >=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThan(String value) {
            addCriterion("YJ <", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLessThanOrEqualTo(String value) {
            addCriterion("YJ <=", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjLike(String value) {
            addCriterion("YJ like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotLike(String value) {
            addCriterion("YJ not like", value, "yj");
            return (Criteria) this;
        }

        public Criteria andYjIn(List<String> values) {
            addCriterion("YJ in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotIn(List<String> values) {
            addCriterion("YJ not in", values, "yj");
            return (Criteria) this;
        }

        public Criteria andYjBetween(String value1, String value2) {
            addCriterion("YJ between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andYjNotBetween(String value1, String value2) {
            addCriterion("YJ not between", value1, value2, "yj");
            return (Criteria) this;
        }

        public Criteria andZsIsNull() {
            addCriterion("ZS is null");
            return (Criteria) this;
        }

        public Criteria andZsIsNotNull() {
            addCriterion("ZS is not null");
            return (Criteria) this;
        }

        public Criteria andZsEqualTo(String value) {
            addCriterion("ZS =", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotEqualTo(String value) {
            addCriterion("ZS <>", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThan(String value) {
            addCriterion("ZS >", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThanOrEqualTo(String value) {
            addCriterion("ZS >=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThan(String value) {
            addCriterion("ZS <", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThanOrEqualTo(String value) {
            addCriterion("ZS <=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLike(String value) {
            addCriterion("ZS like", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotLike(String value) {
            addCriterion("ZS not like", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsIn(List<String> values) {
            addCriterion("ZS in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotIn(List<String> values) {
            addCriterion("ZS not in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsBetween(String value1, String value2) {
            addCriterion("ZS between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotBetween(String value1, String value2) {
            addCriterion("ZS not between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsrqIsNull() {
            addCriterion("ZSRQ is null");
            return (Criteria) this;
        }

        public Criteria andZsrqIsNotNull() {
            addCriterion("ZSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZsrqEqualTo(Date value) {
            addCriterion("ZSRQ =", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotEqualTo(Date value) {
            addCriterion("ZSRQ <>", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThan(Date value) {
            addCriterion("ZSRQ >", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ZSRQ >=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThan(Date value) {
            addCriterion("ZSRQ <", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqLessThanOrEqualTo(Date value) {
            addCriterion("ZSRQ <=", value, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqIn(List<Date> values) {
            addCriterion("ZSRQ in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotIn(List<Date> values) {
            addCriterion("ZSRQ not in", values, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqBetween(Date value1, Date value2) {
            addCriterion("ZSRQ between", value1, value2, "zsrq");
            return (Criteria) this;
        }

        public Criteria andZsrqNotBetween(Date value1, Date value2) {
            addCriterion("ZSRQ not between", value1, value2, "zsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsIsNull() {
            addCriterion("WXZS is null");
            return (Criteria) this;
        }

        public Criteria andWxzsIsNotNull() {
            addCriterion("WXZS is not null");
            return (Criteria) this;
        }

        public Criteria andWxzsEqualTo(String value) {
            addCriterion("WXZS =", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsNotEqualTo(String value) {
            addCriterion("WXZS <>", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsGreaterThan(String value) {
            addCriterion("WXZS >", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsGreaterThanOrEqualTo(String value) {
            addCriterion("WXZS >=", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsLessThan(String value) {
            addCriterion("WXZS <", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsLessThanOrEqualTo(String value) {
            addCriterion("WXZS <=", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsLike(String value) {
            addCriterion("WXZS like", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsNotLike(String value) {
            addCriterion("WXZS not like", value, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsIn(List<String> values) {
            addCriterion("WXZS in", values, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsNotIn(List<String> values) {
            addCriterion("WXZS not in", values, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsBetween(String value1, String value2) {
            addCriterion("WXZS between", value1, value2, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsNotBetween(String value1, String value2) {
            addCriterion("WXZS not between", value1, value2, "wxzs");
            return (Criteria) this;
        }

        public Criteria andWxzsrqIsNull() {
            addCriterion("WXZSRQ is null");
            return (Criteria) this;
        }

        public Criteria andWxzsrqIsNotNull() {
            addCriterion("WXZSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andWxzsrqEqualTo(Date value) {
            addCriterion("WXZSRQ =", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqNotEqualTo(Date value) {
            addCriterion("WXZSRQ <>", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqGreaterThan(Date value) {
            addCriterion("WXZSRQ >", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("WXZSRQ >=", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqLessThan(Date value) {
            addCriterion("WXZSRQ <", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqLessThanOrEqualTo(Date value) {
            addCriterion("WXZSRQ <=", value, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqIn(List<Date> values) {
            addCriterion("WXZSRQ in", values, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqNotIn(List<Date> values) {
            addCriterion("WXZSRQ not in", values, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqBetween(Date value1, Date value2) {
            addCriterion("WXZSRQ between", value1, value2, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andWxzsrqNotBetween(Date value1, Date value2) {
            addCriterion("WXZSRQ not between", value1, value2, "wxzsrq");
            return (Criteria) this;
        }

        public Criteria andBmzzIsNull() {
            addCriterion("BMZZ is null");
            return (Criteria) this;
        }

        public Criteria andBmzzIsNotNull() {
            addCriterion("BMZZ is not null");
            return (Criteria) this;
        }

        public Criteria andBmzzEqualTo(String value) {
            addCriterion("BMZZ =", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzNotEqualTo(String value) {
            addCriterion("BMZZ <>", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzGreaterThan(String value) {
            addCriterion("BMZZ >", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzGreaterThanOrEqualTo(String value) {
            addCriterion("BMZZ >=", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzLessThan(String value) {
            addCriterion("BMZZ <", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzLessThanOrEqualTo(String value) {
            addCriterion("BMZZ <=", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzLike(String value) {
            addCriterion("BMZZ like", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzNotLike(String value) {
            addCriterion("BMZZ not like", value, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzIn(List<String> values) {
            addCriterion("BMZZ in", values, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzNotIn(List<String> values) {
            addCriterion("BMZZ not in", values, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzBetween(String value1, String value2) {
            addCriterion("BMZZ between", value1, value2, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmzzNotBetween(String value1, String value2) {
            addCriterion("BMZZ not between", value1, value2, "bmzz");
            return (Criteria) this;
        }

        public Criteria andBmksrqIsNull() {
            addCriterion("BMKSRQ is null");
            return (Criteria) this;
        }

        public Criteria andBmksrqIsNotNull() {
            addCriterion("BMKSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andBmksrqEqualTo(Date value) {
            addCriterion("BMKSRQ =", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqNotEqualTo(Date value) {
            addCriterion("BMKSRQ <>", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqGreaterThan(Date value) {
            addCriterion("BMKSRQ >", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqGreaterThanOrEqualTo(Date value) {
            addCriterion("BMKSRQ >=", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqLessThan(Date value) {
            addCriterion("BMKSRQ <", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqLessThanOrEqualTo(Date value) {
            addCriterion("BMKSRQ <=", value, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqIn(List<Date> values) {
            addCriterion("BMKSRQ in", values, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqNotIn(List<Date> values) {
            addCriterion("BMKSRQ not in", values, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqBetween(Date value1, Date value2) {
            addCriterion("BMKSRQ between", value1, value2, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andBmksrqNotBetween(Date value1, Date value2) {
            addCriterion("BMKSRQ not between", value1, value2, "bmksrq");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("PID like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("PID not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andZzhmIsNull() {
            addCriterion("ZZHM is null");
            return (Criteria) this;
        }

        public Criteria andZzhmIsNotNull() {
            addCriterion("ZZHM is not null");
            return (Criteria) this;
        }

        public Criteria andZzhmEqualTo(String value) {
            addCriterion("ZZHM =", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmNotEqualTo(String value) {
            addCriterion("ZZHM <>", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmGreaterThan(String value) {
            addCriterion("ZZHM >", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmGreaterThanOrEqualTo(String value) {
            addCriterion("ZZHM >=", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmLessThan(String value) {
            addCriterion("ZZHM <", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmLessThanOrEqualTo(String value) {
            addCriterion("ZZHM <=", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmLike(String value) {
            addCriterion("ZZHM like", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmNotLike(String value) {
            addCriterion("ZZHM not like", value, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmIn(List<String> values) {
            addCriterion("ZZHM in", values, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmNotIn(List<String> values) {
            addCriterion("ZZHM not in", values, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmBetween(String value1, String value2) {
            addCriterion("ZZHM between", value1, value2, "zzhm");
            return (Criteria) this;
        }

        public Criteria andZzhmNotBetween(String value1, String value2) {
            addCriterion("ZZHM not between", value1, value2, "zzhm");
            return (Criteria) this;
        }

        public Criteria andBfrqIsNull() {
            addCriterion("BFRQ is null");
            return (Criteria) this;
        }

        public Criteria andBfrqIsNotNull() {
            addCriterion("BFRQ is not null");
            return (Criteria) this;
        }

        public Criteria andBfrqEqualTo(Date value) {
            addCriterion("BFRQ =", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqNotEqualTo(Date value) {
            addCriterion("BFRQ <>", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqGreaterThan(Date value) {
            addCriterion("BFRQ >", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqGreaterThanOrEqualTo(Date value) {
            addCriterion("BFRQ >=", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqLessThan(Date value) {
            addCriterion("BFRQ <", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqLessThanOrEqualTo(Date value) {
            addCriterion("BFRQ <=", value, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqIn(List<Date> values) {
            addCriterion("BFRQ in", values, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqNotIn(List<Date> values) {
            addCriterion("BFRQ not in", values, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqBetween(Date value1, Date value2) {
            addCriterion("BFRQ between", value1, value2, "bfrq");
            return (Criteria) this;
        }

        public Criteria andBfrqNotBetween(Date value1, Date value2) {
            addCriterion("BFRQ not between", value1, value2, "bfrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqIsNull() {
            addCriterion("WXZSKSRQ is null");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqIsNotNull() {
            addCriterion("WXZSKSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqEqualTo(Date value) {
            addCriterion("WXZSKSRQ =", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqNotEqualTo(Date value) {
            addCriterion("WXZSKSRQ <>", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqGreaterThan(Date value) {
            addCriterion("WXZSKSRQ >", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqGreaterThanOrEqualTo(Date value) {
            addCriterion("WXZSKSRQ >=", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqLessThan(Date value) {
            addCriterion("WXZSKSRQ <", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqLessThanOrEqualTo(Date value) {
            addCriterion("WXZSKSRQ <=", value, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqIn(List<Date> values) {
            addCriterion("WXZSKSRQ in", values, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqNotIn(List<Date> values) {
            addCriterion("WXZSKSRQ not in", values, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqBetween(Date value1, Date value2) {
            addCriterion("WXZSKSRQ between", value1, value2, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andWxzsksrqNotBetween(Date value1, Date value2) {
            addCriterion("WXZSKSRQ not between", value1, value2, "wxzsksrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqIsNull() {
            addCriterion("BMJSRQ is null");
            return (Criteria) this;
        }

        public Criteria andBmjsrqIsNotNull() {
            addCriterion("BMJSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andBmjsrqEqualTo(Date value) {
            addCriterion("BMJSRQ =", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqNotEqualTo(Date value) {
            addCriterion("BMJSRQ <>", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqGreaterThan(Date value) {
            addCriterion("BMJSRQ >", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("BMJSRQ >=", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqLessThan(Date value) {
            addCriterion("BMJSRQ <", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqLessThanOrEqualTo(Date value) {
            addCriterion("BMJSRQ <=", value, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqIn(List<Date> values) {
            addCriterion("BMJSRQ in", values, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqNotIn(List<Date> values) {
            addCriterion("BMJSRQ not in", values, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqBetween(Date value1, Date value2) {
            addCriterion("BMJSRQ between", value1, value2, "bmjsrq");
            return (Criteria) this;
        }

        public Criteria andBmjsrqNotBetween(Date value1, Date value2) {
            addCriterion("BMJSRQ not between", value1, value2, "bmjsrq");
            return (Criteria) this;
        }
    }

    /**
     * T_CF
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * T_CF 2020-05-09
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}