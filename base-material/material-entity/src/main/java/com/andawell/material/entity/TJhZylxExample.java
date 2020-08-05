package com.andawell.material.entity;

import java.util.ArrayList;
import java.util.List;

public class TJhZylxExample {
    /**
     * T_JH_ZYLX
     */
    protected String orderByClause;

    /**
     * T_JH_ZYLX
     */
    protected boolean distinct;

    /**
     * T_JH_ZYLX
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public TJhZylxExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-11
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
     * @mbg.generated 2020-05-11
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2020-05-11
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * T_JH_ZYLX 2020-05-11
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
    }

    /**
     * T_JH_ZYLX
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * T_JH_ZYLX 2020-05-11
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