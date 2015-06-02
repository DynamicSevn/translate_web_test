package com.translation.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public CommentExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	protected CommentExample(CommentExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table comment
	 * @ibatorgenerated  Thu Apr 16 10:33:39 CST 2015
	 */
	public static class Criteria {
		protected List criteriaWithoutValue;
		protected List criteriaWithSingleValue;
		protected List criteriaWithListValue;
		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andComidIsNull() {
			addCriterion("comid is null");
			return this;
		}

		public Criteria andComidIsNotNull() {
			addCriterion("comid is not null");
			return this;
		}

		public Criteria andComidEqualTo(Integer value) {
			addCriterion("comid =", value, "comid");
			return this;
		}

		public Criteria andComidNotEqualTo(Integer value) {
			addCriterion("comid <>", value, "comid");
			return this;
		}

		public Criteria andComidGreaterThan(Integer value) {
			addCriterion("comid >", value, "comid");
			return this;
		}

		public Criteria andComidGreaterThanOrEqualTo(Integer value) {
			addCriterion("comid >=", value, "comid");
			return this;
		}

		public Criteria andComidLessThan(Integer value) {
			addCriterion("comid <", value, "comid");
			return this;
		}

		public Criteria andComidLessThanOrEqualTo(Integer value) {
			addCriterion("comid <=", value, "comid");
			return this;
		}

		public Criteria andComidIn(List values) {
			addCriterion("comid in", values, "comid");
			return this;
		}

		public Criteria andComidNotIn(List values) {
			addCriterion("comid not in", values, "comid");
			return this;
		}

		public Criteria andComidBetween(Integer value1, Integer value2) {
			addCriterion("comid between", value1, value2, "comid");
			return this;
		}

		public Criteria andComidNotBetween(Integer value1, Integer value2) {
			addCriterion("comid not between", value1, value2, "comid");
			return this;
		}

		public Criteria andDocidIsNull() {
			addCriterion("docid is null");
			return this;
		}

		public Criteria andDocidIsNotNull() {
			addCriterion("docid is not null");
			return this;
		}

		public Criteria andDocidEqualTo(Integer value) {
			addCriterion("docid =", value, "docid");
			return this;
		}

		public Criteria andDocidNotEqualTo(Integer value) {
			addCriterion("docid <>", value, "docid");
			return this;
		}

		public Criteria andDocidGreaterThan(Integer value) {
			addCriterion("docid >", value, "docid");
			return this;
		}

		public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
			addCriterion("docid >=", value, "docid");
			return this;
		}

		public Criteria andDocidLessThan(Integer value) {
			addCriterion("docid <", value, "docid");
			return this;
		}

		public Criteria andDocidLessThanOrEqualTo(Integer value) {
			addCriterion("docid <=", value, "docid");
			return this;
		}

		public Criteria andDocidIn(List values) {
			addCriterion("docid in", values, "docid");
			return this;
		}

		public Criteria andDocidNotIn(List values) {
			addCriterion("docid not in", values, "docid");
			return this;
		}

		public Criteria andDocidBetween(Integer value1, Integer value2) {
			addCriterion("docid between", value1, value2, "docid");
			return this;
		}

		public Criteria andDocidNotBetween(Integer value1, Integer value2) {
			addCriterion("docid not between", value1, value2, "docid");
			return this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userid =", value, "userid");
			return this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userid <>", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userid >", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userid >=", value, "userid");
			return this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userid <", value, "userid");
			return this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userid <=", value, "userid");
			return this;
		}

		public Criteria andUseridIn(List values) {
			addCriterion("userid in", values, "userid");
			return this;
		}

		public Criteria andUseridNotIn(List values) {
			addCriterion("userid not in", values, "userid");
			return this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userid between", value1, value2, "userid");
			return this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return this;
		}

		public Criteria andCreattimeIsNull() {
			addCriterion("creattime is null");
			return this;
		}

		public Criteria andCreattimeIsNotNull() {
			addCriterion("creattime is not null");
			return this;
		}

		public Criteria andCreattimeEqualTo(Date value) {
			addCriterion("creattime =", value, "creattime");
			return this;
		}

		public Criteria andCreattimeNotEqualTo(Date value) {
			addCriterion("creattime <>", value, "creattime");
			return this;
		}

		public Criteria andCreattimeGreaterThan(Date value) {
			addCriterion("creattime >", value, "creattime");
			return this;
		}

		public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
			addCriterion("creattime >=", value, "creattime");
			return this;
		}

		public Criteria andCreattimeLessThan(Date value) {
			addCriterion("creattime <", value, "creattime");
			return this;
		}

		public Criteria andCreattimeLessThanOrEqualTo(Date value) {
			addCriterion("creattime <=", value, "creattime");
			return this;
		}

		public Criteria andCreattimeIn(List values) {
			addCriterion("creattime in", values, "creattime");
			return this;
		}

		public Criteria andCreattimeNotIn(List values) {
			addCriterion("creattime not in", values, "creattime");
			return this;
		}

		public Criteria andCreattimeBetween(Date value1, Date value2) {
			addCriterion("creattime between", value1, value2, "creattime");
			return this;
		}

		public Criteria andCreattimeNotBetween(Date value1, Date value2) {
			addCriterion("creattime not between", value1, value2, "creattime");
			return this;
		}

		public Criteria andEdittimeIsNull() {
			addCriterion("edittime is null");
			return this;
		}

		public Criteria andEdittimeIsNotNull() {
			addCriterion("edittime is not null");
			return this;
		}

		public Criteria andEdittimeEqualTo(Date value) {
			addCriterion("edittime =", value, "edittime");
			return this;
		}

		public Criteria andEdittimeNotEqualTo(Date value) {
			addCriterion("edittime <>", value, "edittime");
			return this;
		}

		public Criteria andEdittimeGreaterThan(Date value) {
			addCriterion("edittime >", value, "edittime");
			return this;
		}

		public Criteria andEdittimeGreaterThanOrEqualTo(Date value) {
			addCriterion("edittime >=", value, "edittime");
			return this;
		}

		public Criteria andEdittimeLessThan(Date value) {
			addCriterion("edittime <", value, "edittime");
			return this;
		}

		public Criteria andEdittimeLessThanOrEqualTo(Date value) {
			addCriterion("edittime <=", value, "edittime");
			return this;
		}

		public Criteria andEdittimeIn(List values) {
			addCriterion("edittime in", values, "edittime");
			return this;
		}

		public Criteria andEdittimeNotIn(List values) {
			addCriterion("edittime not in", values, "edittime");
			return this;
		}

		public Criteria andEdittimeBetween(Date value1, Date value2) {
			addCriterion("edittime between", value1, value2, "edittime");
			return this;
		}

		public Criteria andEdittimeNotBetween(Date value1, Date value2) {
			addCriterion("edittime not between", value1, value2, "edittime");
			return this;
		}

		public Criteria andLiketimesIsNull() {
			addCriterion("liketimes is null");
			return this;
		}

		public Criteria andLiketimesIsNotNull() {
			addCriterion("liketimes is not null");
			return this;
		}

		public Criteria andLiketimesEqualTo(Integer value) {
			addCriterion("liketimes =", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesNotEqualTo(Integer value) {
			addCriterion("liketimes <>", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesGreaterThan(Integer value) {
			addCriterion("liketimes >", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesGreaterThanOrEqualTo(Integer value) {
			addCriterion("liketimes >=", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesLessThan(Integer value) {
			addCriterion("liketimes <", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesLessThanOrEqualTo(Integer value) {
			addCriterion("liketimes <=", value, "liketimes");
			return this;
		}

		public Criteria andLiketimesIn(List values) {
			addCriterion("liketimes in", values, "liketimes");
			return this;
		}

		public Criteria andLiketimesNotIn(List values) {
			addCriterion("liketimes not in", values, "liketimes");
			return this;
		}

		public Criteria andLiketimesBetween(Integer value1, Integer value2) {
			addCriterion("liketimes between", value1, value2, "liketimes");
			return this;
		}

		public Criteria andLiketimesNotBetween(Integer value1, Integer value2) {
			addCriterion("liketimes not between", value1, value2, "liketimes");
			return this;
		}

		public Criteria andIsacceptIsNull() {
			addCriterion("isaccept is null");
			return this;
		}

		public Criteria andIsacceptIsNotNull() {
			addCriterion("isaccept is not null");
			return this;
		}

		public Criteria andIsacceptEqualTo(String value) {
			addCriterion("isaccept =", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptNotEqualTo(String value) {
			addCriterion("isaccept <>", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptGreaterThan(String value) {
			addCriterion("isaccept >", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptGreaterThanOrEqualTo(String value) {
			addCriterion("isaccept >=", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptLessThan(String value) {
			addCriterion("isaccept <", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptLessThanOrEqualTo(String value) {
			addCriterion("isaccept <=", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptLike(String value) {
			addCriterion("isaccept like", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptNotLike(String value) {
			addCriterion("isaccept not like", value, "isaccept");
			return this;
		}

		public Criteria andIsacceptIn(List values) {
			addCriterion("isaccept in", values, "isaccept");
			return this;
		}

		public Criteria andIsacceptNotIn(List values) {
			addCriterion("isaccept not in", values, "isaccept");
			return this;
		}

		public Criteria andIsacceptBetween(String value1, String value2) {
			addCriterion("isaccept between", value1, value2, "isaccept");
			return this;
		}

		public Criteria andIsacceptNotBetween(String value1, String value2) {
			addCriterion("isaccept not between", value1, value2, "isaccept");
			return this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("content =", value, "content");
			return this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("content <>", value, "content");
			return this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("content >", value, "content");
			return this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("content >=", value, "content");
			return this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("content <", value, "content");
			return this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("content <=", value, "content");
			return this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("content like", value, "content");
			return this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("content not like", value, "content");
			return this;
		}

		public Criteria andContentIn(List values) {
			addCriterion("content in", values, "content");
			return this;
		}

		public Criteria andContentNotIn(List values) {
			addCriterion("content not in", values, "content");
			return this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("content between", value1, value2, "content");
			return this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("content not between", value1, value2, "content");
			return this;
		}

		public Criteria andDelflagIsNull() {
			addCriterion("delflag is null");
			return this;
		}

		public Criteria andDelflagIsNotNull() {
			addCriterion("delflag is not null");
			return this;
		}

		public Criteria andDelflagEqualTo(String value) {
			addCriterion("delflag =", value, "delflag");
			return this;
		}

		public Criteria andDelflagNotEqualTo(String value) {
			addCriterion("delflag <>", value, "delflag");
			return this;
		}

		public Criteria andDelflagGreaterThan(String value) {
			addCriterion("delflag >", value, "delflag");
			return this;
		}

		public Criteria andDelflagGreaterThanOrEqualTo(String value) {
			addCriterion("delflag >=", value, "delflag");
			return this;
		}

		public Criteria andDelflagLessThan(String value) {
			addCriterion("delflag <", value, "delflag");
			return this;
		}

		public Criteria andDelflagLessThanOrEqualTo(String value) {
			addCriterion("delflag <=", value, "delflag");
			return this;
		}

		public Criteria andDelflagLike(String value) {
			addCriterion("delflag like", value, "delflag");
			return this;
		}

		public Criteria andDelflagNotLike(String value) {
			addCriterion("delflag not like", value, "delflag");
			return this;
		}

		public Criteria andDelflagIn(List values) {
			addCriterion("delflag in", values, "delflag");
			return this;
		}

		public Criteria andDelflagNotIn(List values) {
			addCriterion("delflag not in", values, "delflag");
			return this;
		}

		public Criteria andDelflagBetween(String value1, String value2) {
			addCriterion("delflag between", value1, value2, "delflag");
			return this;
		}

		public Criteria andDelflagNotBetween(String value1, String value2) {
			addCriterion("delflag not between", value1, value2, "delflag");
			return this;
		}

		public Criteria andIsnewIsNull() {
			addCriterion("isnew is null");
			return this;
		}

		public Criteria andIsnewIsNotNull() {
			addCriterion("isnew is not null");
			return this;
		}

		public Criteria andIsnewEqualTo(String value) {
			addCriterion("isnew =", value, "isnew");
			return this;
		}

		public Criteria andIsnewNotEqualTo(String value) {
			addCriterion("isnew <>", value, "isnew");
			return this;
		}

		public Criteria andIsnewGreaterThan(String value) {
			addCriterion("isnew >", value, "isnew");
			return this;
		}

		public Criteria andIsnewGreaterThanOrEqualTo(String value) {
			addCriterion("isnew >=", value, "isnew");
			return this;
		}

		public Criteria andIsnewLessThan(String value) {
			addCriterion("isnew <", value, "isnew");
			return this;
		}

		public Criteria andIsnewLessThanOrEqualTo(String value) {
			addCriterion("isnew <=", value, "isnew");
			return this;
		}

		public Criteria andIsnewLike(String value) {
			addCriterion("isnew like", value, "isnew");
			return this;
		}

		public Criteria andIsnewNotLike(String value) {
			addCriterion("isnew not like", value, "isnew");
			return this;
		}

		public Criteria andIsnewIn(List values) {
			addCriterion("isnew in", values, "isnew");
			return this;
		}

		public Criteria andIsnewNotIn(List values) {
			addCriterion("isnew not in", values, "isnew");
			return this;
		}

		public Criteria andIsnewBetween(String value1, String value2) {
			addCriterion("isnew between", value1, value2, "isnew");
			return this;
		}

		public Criteria andIsnewNotBetween(String value1, String value2) {
			addCriterion("isnew not between", value1, value2, "isnew");
			return this;
		}

		public Criteria andAcceptnewIsNull() {
			addCriterion("acceptnew is null");
			return this;
		}

		public Criteria andAcceptnewIsNotNull() {
			addCriterion("acceptnew is not null");
			return this;
		}

		public Criteria andAcceptnewEqualTo(String value) {
			addCriterion("acceptnew =", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewNotEqualTo(String value) {
			addCriterion("acceptnew <>", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewGreaterThan(String value) {
			addCriterion("acceptnew >", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewGreaterThanOrEqualTo(String value) {
			addCriterion("acceptnew >=", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewLessThan(String value) {
			addCriterion("acceptnew <", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewLessThanOrEqualTo(String value) {
			addCriterion("acceptnew <=", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewLike(String value) {
			addCriterion("acceptnew like", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewNotLike(String value) {
			addCriterion("acceptnew not like", value, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewIn(List values) {
			addCriterion("acceptnew in", values, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewNotIn(List values) {
			addCriterion("acceptnew not in", values, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewBetween(String value1, String value2) {
			addCriterion("acceptnew between", value1, value2, "acceptnew");
			return this;
		}

		public Criteria andAcceptnewNotBetween(String value1, String value2) {
			addCriterion("acceptnew not between", value1, value2, "acceptnew");
			return this;
		}
	}
}