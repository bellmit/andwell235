package com.andawell.material.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TQxYhExample {
    /**
     * T_QX_YH
     */
    protected String orderByClause;

    /**
     * T_QX_YH
     */
    protected boolean distinct;

    /**
     * T_QX_YH
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public TQxYhExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-08
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
     * @mbg.generated 2020-05-08
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-08
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * T_QX_YH 2020-05-08
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

        public Criteria andYhmIsNull() {
            addCriterion("YHM is null");
            return (Criteria) this;
        }

        public Criteria andYhmIsNotNull() {
            addCriterion("YHM is not null");
            return (Criteria) this;
        }

        public Criteria andYhmEqualTo(String value) {
            addCriterion("YHM =", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotEqualTo(String value) {
            addCriterion("YHM <>", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmGreaterThan(String value) {
            addCriterion("YHM >", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmGreaterThanOrEqualTo(String value) {
            addCriterion("YHM >=", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLessThan(String value) {
            addCriterion("YHM <", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLessThanOrEqualTo(String value) {
            addCriterion("YHM <=", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmLike(String value) {
            addCriterion("YHM like", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotLike(String value) {
            addCriterion("YHM not like", value, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmIn(List<String> values) {
            addCriterion("YHM in", values, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotIn(List<String> values) {
            addCriterion("YHM not in", values, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmBetween(String value1, String value2) {
            addCriterion("YHM between", value1, value2, "yhm");
            return (Criteria) this;
        }

        public Criteria andYhmNotBetween(String value1, String value2) {
            addCriterion("YHM not between", value1, value2, "yhm");
            return (Criteria) this;
        }

        public Criteria andDlmIsNull() {
            addCriterion("DLM is null");
            return (Criteria) this;
        }

        public Criteria andDlmIsNotNull() {
            addCriterion("DLM is not null");
            return (Criteria) this;
        }

        public Criteria andDlmEqualTo(String value) {
            addCriterion("DLM =", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotEqualTo(String value) {
            addCriterion("DLM <>", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmGreaterThan(String value) {
            addCriterion("DLM >", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmGreaterThanOrEqualTo(String value) {
            addCriterion("DLM >=", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLessThan(String value) {
            addCriterion("DLM <", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLessThanOrEqualTo(String value) {
            addCriterion("DLM <=", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmLike(String value) {
            addCriterion("DLM like", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotLike(String value) {
            addCriterion("DLM not like", value, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmIn(List<String> values) {
            addCriterion("DLM in", values, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotIn(List<String> values) {
            addCriterion("DLM not in", values, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmBetween(String value1, String value2) {
            addCriterion("DLM between", value1, value2, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmNotBetween(String value1, String value2) {
            addCriterion("DLM not between", value1, value2, "dlm");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNull() {
            addCriterion("DLMM is null");
            return (Criteria) this;
        }

        public Criteria andDlmmIsNotNull() {
            addCriterion("DLMM is not null");
            return (Criteria) this;
        }

        public Criteria andDlmmEqualTo(String value) {
            addCriterion("DLMM =", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotEqualTo(String value) {
            addCriterion("DLMM <>", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThan(String value) {
            addCriterion("DLMM >", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmGreaterThanOrEqualTo(String value) {
            addCriterion("DLMM >=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThan(String value) {
            addCriterion("DLMM <", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLessThanOrEqualTo(String value) {
            addCriterion("DLMM <=", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmLike(String value) {
            addCriterion("DLMM like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotLike(String value) {
            addCriterion("DLMM not like", value, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmIn(List<String> values) {
            addCriterion("DLMM in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotIn(List<String> values) {
            addCriterion("DLMM not in", values, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmBetween(String value1, String value2) {
            addCriterion("DLMM between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDlmmNotBetween(String value1, String value2) {
            addCriterion("DLMM not between", value1, value2, "dlmm");
            return (Criteria) this;
        }

        public Criteria andDwIsNull() {
            addCriterion("DW is null");
            return (Criteria) this;
        }

        public Criteria andDwIsNotNull() {
            addCriterion("DW is not null");
            return (Criteria) this;
        }

        public Criteria andDwEqualTo(String value) {
            addCriterion("DW =", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotEqualTo(String value) {
            addCriterion("DW <>", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThan(String value) {
            addCriterion("DW >", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThanOrEqualTo(String value) {
            addCriterion("DW >=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThan(String value) {
            addCriterion("DW <", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThanOrEqualTo(String value) {
            addCriterion("DW <=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLike(String value) {
            addCriterion("DW like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotLike(String value) {
            addCriterion("DW not like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwIn(List<String> values) {
            addCriterion("DW in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotIn(List<String> values) {
            addCriterion("DW not in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwBetween(String value1, String value2) {
            addCriterion("DW between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotBetween(String value1, String value2) {
            addCriterion("DW not between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andZwIsNull() {
            addCriterion("ZW is null");
            return (Criteria) this;
        }

        public Criteria andZwIsNotNull() {
            addCriterion("ZW is not null");
            return (Criteria) this;
        }

        public Criteria andZwEqualTo(String value) {
            addCriterion("ZW =", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotEqualTo(String value) {
            addCriterion("ZW <>", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThan(String value) {
            addCriterion("ZW >", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwGreaterThanOrEqualTo(String value) {
            addCriterion("ZW >=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThan(String value) {
            addCriterion("ZW <", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLessThanOrEqualTo(String value) {
            addCriterion("ZW <=", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwLike(String value) {
            addCriterion("ZW like", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotLike(String value) {
            addCriterion("ZW not like", value, "zw");
            return (Criteria) this;
        }

        public Criteria andZwIn(List<String> values) {
            addCriterion("ZW in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotIn(List<String> values) {
            addCriterion("ZW not in", values, "zw");
            return (Criteria) this;
        }

        public Criteria andZwBetween(String value1, String value2) {
            addCriterion("ZW between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andZwNotBetween(String value1, String value2) {
            addCriterion("ZW not between", value1, value2, "zw");
            return (Criteria) this;
        }

        public Criteria andJbIsNull() {
            addCriterion("JB is null");
            return (Criteria) this;
        }

        public Criteria andJbIsNotNull() {
            addCriterion("JB is not null");
            return (Criteria) this;
        }

        public Criteria andJbEqualTo(String value) {
            addCriterion("JB =", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotEqualTo(String value) {
            addCriterion("JB <>", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThan(String value) {
            addCriterion("JB >", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThanOrEqualTo(String value) {
            addCriterion("JB >=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThan(String value) {
            addCriterion("JB <", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThanOrEqualTo(String value) {
            addCriterion("JB <=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLike(String value) {
            addCriterion("JB like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotLike(String value) {
            addCriterion("JB not like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbIn(List<String> values) {
            addCriterion("JB in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotIn(List<String> values) {
            addCriterion("JB not in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbBetween(String value1, String value2) {
            addCriterion("JB between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotBetween(String value1, String value2) {
            addCriterion("JB not between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andJxIsNull() {
            addCriterion("JX is null");
            return (Criteria) this;
        }

        public Criteria andJxIsNotNull() {
            addCriterion("JX is not null");
            return (Criteria) this;
        }

        public Criteria andJxEqualTo(String value) {
            addCriterion("JX =", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotEqualTo(String value) {
            addCriterion("JX <>", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThan(String value) {
            addCriterion("JX >", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThanOrEqualTo(String value) {
            addCriterion("JX >=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThan(String value) {
            addCriterion("JX <", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThanOrEqualTo(String value) {
            addCriterion("JX <=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLike(String value) {
            addCriterion("JX like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotLike(String value) {
            addCriterion("JX not like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxIn(List<String> values) {
            addCriterion("JX in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotIn(List<String> values) {
            addCriterion("JX not in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxBetween(String value1, String value2) {
            addCriterion("JX between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotBetween(String value1, String value2) {
            addCriterion("JX not between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("CSRQ is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("CSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(Date value) {
            addCriterion("CSRQ =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(Date value) {
            addCriterion("CSRQ <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(Date value) {
            addCriterion("CSRQ >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("CSRQ >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(Date value) {
            addCriterion("CSRQ <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(Date value) {
            addCriterion("CSRQ <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<Date> values) {
            addCriterion("CSRQ in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<Date> values) {
            addCriterion("CSRQ not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(Date value1, Date value2) {
            addCriterion("CSRQ between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(Date value1, Date value2) {
            addCriterion("CSRQ not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andRwrqIsNull() {
            addCriterion("RWRQ is null");
            return (Criteria) this;
        }

        public Criteria andRwrqIsNotNull() {
            addCriterion("RWRQ is not null");
            return (Criteria) this;
        }

        public Criteria andRwrqEqualTo(Date value) {
            addCriterion("RWRQ =", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqNotEqualTo(Date value) {
            addCriterion("RWRQ <>", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqGreaterThan(Date value) {
            addCriterion("RWRQ >", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqGreaterThanOrEqualTo(Date value) {
            addCriterion("RWRQ >=", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqLessThan(Date value) {
            addCriterion("RWRQ <", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqLessThanOrEqualTo(Date value) {
            addCriterion("RWRQ <=", value, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqIn(List<Date> values) {
            addCriterion("RWRQ in", values, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqNotIn(List<Date> values) {
            addCriterion("RWRQ not in", values, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqBetween(Date value1, Date value2) {
            addCriterion("RWRQ between", value1, value2, "rwrq");
            return (Criteria) this;
        }

        public Criteria andRwrqNotBetween(Date value1, Date value2) {
            addCriterion("RWRQ not between", value1, value2, "rwrq");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNull() {
            addCriterion("ZZMM is null");
            return (Criteria) this;
        }

        public Criteria andZzmmIsNotNull() {
            addCriterion("ZZMM is not null");
            return (Criteria) this;
        }

        public Criteria andZzmmEqualTo(String value) {
            addCriterion("ZZMM =", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotEqualTo(String value) {
            addCriterion("ZZMM <>", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThan(String value) {
            addCriterion("ZZMM >", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmGreaterThanOrEqualTo(String value) {
            addCriterion("ZZMM >=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThan(String value) {
            addCriterion("ZZMM <", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLessThanOrEqualTo(String value) {
            addCriterion("ZZMM <=", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmLike(String value) {
            addCriterion("ZZMM like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotLike(String value) {
            addCriterion("ZZMM not like", value, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmIn(List<String> values) {
            addCriterion("ZZMM in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotIn(List<String> values) {
            addCriterion("ZZMM not in", values, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmBetween(String value1, String value2) {
            addCriterion("ZZMM between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andZzmmNotBetween(String value1, String value2) {
            addCriterion("ZZMM not between", value1, value2, "zzmm");
            return (Criteria) this;
        }

        public Criteria andRdtrqIsNull() {
            addCriterion("RDTRQ is null");
            return (Criteria) this;
        }

        public Criteria andRdtrqIsNotNull() {
            addCriterion("RDTRQ is not null");
            return (Criteria) this;
        }

        public Criteria andRdtrqEqualTo(Date value) {
            addCriterion("RDTRQ =", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqNotEqualTo(Date value) {
            addCriterion("RDTRQ <>", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqGreaterThan(Date value) {
            addCriterion("RDTRQ >", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqGreaterThanOrEqualTo(Date value) {
            addCriterion("RDTRQ >=", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqLessThan(Date value) {
            addCriterion("RDTRQ <", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqLessThanOrEqualTo(Date value) {
            addCriterion("RDTRQ <=", value, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqIn(List<Date> values) {
            addCriterion("RDTRQ in", values, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqNotIn(List<Date> values) {
            addCriterion("RDTRQ not in", values, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqBetween(Date value1, Date value2) {
            addCriterion("RDTRQ between", value1, value2, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andRdtrqNotBetween(Date value1, Date value2) {
            addCriterion("RDTRQ not between", value1, value2, "rdtrq");
            return (Criteria) this;
        }

        public Criteria andJsIsNull() {
            addCriterion("JS is null");
            return (Criteria) this;
        }

        public Criteria andJsIsNotNull() {
            addCriterion("JS is not null");
            return (Criteria) this;
        }

        public Criteria andJsEqualTo(String value) {
            addCriterion("JS =", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotEqualTo(String value) {
            addCriterion("JS <>", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThan(String value) {
            addCriterion("JS >", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsGreaterThanOrEqualTo(String value) {
            addCriterion("JS >=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThan(String value) {
            addCriterion("JS <", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLessThanOrEqualTo(String value) {
            addCriterion("JS <=", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsLike(String value) {
            addCriterion("JS like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotLike(String value) {
            addCriterion("JS not like", value, "js");
            return (Criteria) this;
        }

        public Criteria andJsIn(List<String> values) {
            addCriterion("JS in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotIn(List<String> values) {
            addCriterion("JS not in", values, "js");
            return (Criteria) this;
        }

        public Criteria andJsBetween(String value1, String value2) {
            addCriterion("JS between", value1, value2, "js");
            return (Criteria) this;
        }

        public Criteria andJsNotBetween(String value1, String value2) {
            addCriterion("JS not between", value1, value2, "js");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNull() {
            addCriterion("CJSJ is null");
            return (Criteria) this;
        }

        public Criteria andCjsjIsNotNull() {
            addCriterion("CJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjsjEqualTo(Date value) {
            addCriterion("CJSJ =", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotEqualTo(Date value) {
            addCriterion("CJSJ <>", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThan(Date value) {
            addCriterion("CJSJ >", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
            addCriterion("CJSJ >=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThan(Date value) {
            addCriterion("CJSJ <", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjLessThanOrEqualTo(Date value) {
            addCriterion("CJSJ <=", value, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjIn(List<Date> values) {
            addCriterion("CJSJ in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotIn(List<Date> values) {
            addCriterion("CJSJ not in", values, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjBetween(Date value1, Date value2) {
            addCriterion("CJSJ between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andCjsjNotBetween(Date value1, Date value2) {
            addCriterion("CJSJ not between", value1, value2, "cjsj");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNull() {
            addCriterion("XGSJ is null");
            return (Criteria) this;
        }

        public Criteria andXgsjIsNotNull() {
            addCriterion("XGSJ is not null");
            return (Criteria) this;
        }

        public Criteria andXgsjEqualTo(Date value) {
            addCriterion("XGSJ =", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotEqualTo(Date value) {
            addCriterion("XGSJ <>", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThan(Date value) {
            addCriterion("XGSJ >", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjGreaterThanOrEqualTo(Date value) {
            addCriterion("XGSJ >=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThan(Date value) {
            addCriterion("XGSJ <", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjLessThanOrEqualTo(Date value) {
            addCriterion("XGSJ <=", value, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjIn(List<Date> values) {
            addCriterion("XGSJ in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotIn(List<Date> values) {
            addCriterion("XGSJ not in", values, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjBetween(Date value1, Date value2) {
            addCriterion("XGSJ between", value1, value2, "xgsj");
            return (Criteria) this;
        }

        public Criteria andXgsjNotBetween(Date value1, Date value2) {
            addCriterion("XGSJ not between", value1, value2, "xgsj");
            return (Criteria) this;
        }

        public Criteria andSpqxIsNull() {
            addCriterion("SPQX is null");
            return (Criteria) this;
        }

        public Criteria andSpqxIsNotNull() {
            addCriterion("SPQX is not null");
            return (Criteria) this;
        }

        public Criteria andSpqxEqualTo(String value) {
            addCriterion("SPQX =", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxNotEqualTo(String value) {
            addCriterion("SPQX <>", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxGreaterThan(String value) {
            addCriterion("SPQX >", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxGreaterThanOrEqualTo(String value) {
            addCriterion("SPQX >=", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxLessThan(String value) {
            addCriterion("SPQX <", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxLessThanOrEqualTo(String value) {
            addCriterion("SPQX <=", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxLike(String value) {
            addCriterion("SPQX like", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxNotLike(String value) {
            addCriterion("SPQX not like", value, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxIn(List<String> values) {
            addCriterion("SPQX in", values, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxNotIn(List<String> values) {
            addCriterion("SPQX not in", values, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxBetween(String value1, String value2) {
            addCriterion("SPQX between", value1, value2, "spqx");
            return (Criteria) this;
        }

        public Criteria andSpqxNotBetween(String value1, String value2) {
            addCriterion("SPQX not between", value1, value2, "spqx");
            return (Criteria) this;
        }
    }

    /**
     * T_QX_YH
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * T_QX_YH 2020-05-08
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