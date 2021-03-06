package com.translation.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public UserExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	protected UserExample(UserExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table user
	 * @ibatorgenerated  Thu Apr 09 21:28:14 CST 2015
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

		public Criteria andUseridIsNull() {
			addCriterion("userId is null");
			return this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userId is not null");
			return this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userId =", value, "userid");
			return this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userId <>", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userId >", value, "userid");
			return this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userId >=", value, "userid");
			return this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userId <", value, "userid");
			return this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userId <=", value, "userid");
			return this;
		}

		public Criteria andUseridIn(List values) {
			addCriterion("userId in", values, "userid");
			return this;
		}

		public Criteria andUseridNotIn(List values) {
			addCriterion("userId not in", values, "userid");
			return this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userId between", value1, value2, "userid");
			return this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userId not between", value1, value2, "userid");
			return this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("userName is null");
			return this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("userName is not null");
			return this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("userName =", value, "username");
			return this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("userName <>", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("userName >", value, "username");
			return this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("userName >=", value, "username");
			return this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("userName <", value, "username");
			return this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("userName <=", value, "username");
			return this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("userName like", value, "username");
			return this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("userName not like", value, "username");
			return this;
		}

		public Criteria andUsernameIn(List values) {
			addCriterion("userName in", values, "username");
			return this;
		}

		public Criteria andUsernameNotIn(List values) {
			addCriterion("userName not in", values, "username");
			return this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("userName between", value1, value2, "username");
			return this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("userName not between", value1, value2, "username");
			return this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return this;
		}

		public Criteria andPasswordIn(List values) {
			addCriterion("password in", values, "password");
			return this;
		}

		public Criteria andPasswordNotIn(List values) {
			addCriterion("password not in", values, "password");
			return this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return this;
		}

		public Criteria andEmailIn(List values) {
			addCriterion("email in", values, "email");
			return this;
		}

		public Criteria andEmailNotIn(List values) {
			addCriterion("email not in", values, "email");
			return this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return this;
		}

		public Criteria andWebIsNull() {
			addCriterion("web is null");
			return this;
		}

		public Criteria andWebIsNotNull() {
			addCriterion("web is not null");
			return this;
		}

		public Criteria andWebEqualTo(String value) {
			addCriterion("web =", value, "web");
			return this;
		}

		public Criteria andWebNotEqualTo(String value) {
			addCriterion("web <>", value, "web");
			return this;
		}

		public Criteria andWebGreaterThan(String value) {
			addCriterion("web >", value, "web");
			return this;
		}

		public Criteria andWebGreaterThanOrEqualTo(String value) {
			addCriterion("web >=", value, "web");
			return this;
		}

		public Criteria andWebLessThan(String value) {
			addCriterion("web <", value, "web");
			return this;
		}

		public Criteria andWebLessThanOrEqualTo(String value) {
			addCriterion("web <=", value, "web");
			return this;
		}

		public Criteria andWebLike(String value) {
			addCriterion("web like", value, "web");
			return this;
		}

		public Criteria andWebNotLike(String value) {
			addCriterion("web not like", value, "web");
			return this;
		}

		public Criteria andWebIn(List values) {
			addCriterion("web in", values, "web");
			return this;
		}

		public Criteria andWebNotIn(List values) {
			addCriterion("web not in", values, "web");
			return this;
		}

		public Criteria andWebBetween(String value1, String value2) {
			addCriterion("web between", value1, value2, "web");
			return this;
		}

		public Criteria andWebNotBetween(String value1, String value2) {
			addCriterion("web not between", value1, value2, "web");
			return this;
		}

		public Criteria andFirstnameIsNull() {
			addCriterion("firstName is null");
			return this;
		}

		public Criteria andFirstnameIsNotNull() {
			addCriterion("firstName is not null");
			return this;
		}

		public Criteria andFirstnameEqualTo(String value) {
			addCriterion("firstName =", value, "firstname");
			return this;
		}

		public Criteria andFirstnameNotEqualTo(String value) {
			addCriterion("firstName <>", value, "firstname");
			return this;
		}

		public Criteria andFirstnameGreaterThan(String value) {
			addCriterion("firstName >", value, "firstname");
			return this;
		}

		public Criteria andFirstnameGreaterThanOrEqualTo(String value) {
			addCriterion("firstName >=", value, "firstname");
			return this;
		}

		public Criteria andFirstnameLessThan(String value) {
			addCriterion("firstName <", value, "firstname");
			return this;
		}

		public Criteria andFirstnameLessThanOrEqualTo(String value) {
			addCriterion("firstName <=", value, "firstname");
			return this;
		}

		public Criteria andFirstnameLike(String value) {
			addCriterion("firstName like", value, "firstname");
			return this;
		}

		public Criteria andFirstnameNotLike(String value) {
			addCriterion("firstName not like", value, "firstname");
			return this;
		}

		public Criteria andFirstnameIn(List values) {
			addCriterion("firstName in", values, "firstname");
			return this;
		}

		public Criteria andFirstnameNotIn(List values) {
			addCriterion("firstName not in", values, "firstname");
			return this;
		}

		public Criteria andFirstnameBetween(String value1, String value2) {
			addCriterion("firstName between", value1, value2, "firstname");
			return this;
		}

		public Criteria andFirstnameNotBetween(String value1, String value2) {
			addCriterion("firstName not between", value1, value2, "firstname");
			return this;
		}

		public Criteria andLastnameIsNull() {
			addCriterion("lastName is null");
			return this;
		}

		public Criteria andLastnameIsNotNull() {
			addCriterion("lastName is not null");
			return this;
		}

		public Criteria andLastnameEqualTo(String value) {
			addCriterion("lastName =", value, "lastname");
			return this;
		}

		public Criteria andLastnameNotEqualTo(String value) {
			addCriterion("lastName <>", value, "lastname");
			return this;
		}

		public Criteria andLastnameGreaterThan(String value) {
			addCriterion("lastName >", value, "lastname");
			return this;
		}

		public Criteria andLastnameGreaterThanOrEqualTo(String value) {
			addCriterion("lastName >=", value, "lastname");
			return this;
		}

		public Criteria andLastnameLessThan(String value) {
			addCriterion("lastName <", value, "lastname");
			return this;
		}

		public Criteria andLastnameLessThanOrEqualTo(String value) {
			addCriterion("lastName <=", value, "lastname");
			return this;
		}

		public Criteria andLastnameLike(String value) {
			addCriterion("lastName like", value, "lastname");
			return this;
		}

		public Criteria andLastnameNotLike(String value) {
			addCriterion("lastName not like", value, "lastname");
			return this;
		}

		public Criteria andLastnameIn(List values) {
			addCriterion("lastName in", values, "lastname");
			return this;
		}

		public Criteria andLastnameNotIn(List values) {
			addCriterion("lastName not in", values, "lastname");
			return this;
		}

		public Criteria andLastnameBetween(String value1, String value2) {
			addCriterion("lastName between", value1, value2, "lastname");
			return this;
		}

		public Criteria andLastnameNotBetween(String value1, String value2) {
			addCriterion("lastName not between", value1, value2, "lastname");
			return this;
		}

		public Criteria andDelflagIsNull() {
			addCriterion("delFlag is null");
			return this;
		}

		public Criteria andDelflagIsNotNull() {
			addCriterion("delFlag is not null");
			return this;
		}

		public Criteria andDelflagEqualTo(String value) {
			addCriterion("delFlag =", value, "delflag");
			return this;
		}

		public Criteria andDelflagNotEqualTo(String value) {
			addCriterion("delFlag <>", value, "delflag");
			return this;
		}

		public Criteria andDelflagGreaterThan(String value) {
			addCriterion("delFlag >", value, "delflag");
			return this;
		}

		public Criteria andDelflagGreaterThanOrEqualTo(String value) {
			addCriterion("delFlag >=", value, "delflag");
			return this;
		}

		public Criteria andDelflagLessThan(String value) {
			addCriterion("delFlag <", value, "delflag");
			return this;
		}

		public Criteria andDelflagLessThanOrEqualTo(String value) {
			addCriterion("delFlag <=", value, "delflag");
			return this;
		}

		public Criteria andDelflagLike(String value) {
			addCriterion("delFlag like", value, "delflag");
			return this;
		}

		public Criteria andDelflagNotLike(String value) {
			addCriterion("delFlag not like", value, "delflag");
			return this;
		}

		public Criteria andDelflagIn(List values) {
			addCriterion("delFlag in", values, "delflag");
			return this;
		}

		public Criteria andDelflagNotIn(List values) {
			addCriterion("delFlag not in", values, "delflag");
			return this;
		}

		public Criteria andDelflagBetween(String value1, String value2) {
			addCriterion("delFlag between", value1, value2, "delflag");
			return this;
		}

		public Criteria andDelflagNotBetween(String value1, String value2) {
			addCriterion("delFlag not between", value1, value2, "delflag");
			return this;
		}

		public Criteria andPointIsNull() {
			addCriterion("point is null");
			return this;
		}

		public Criteria andPointIsNotNull() {
			addCriterion("point is not null");
			return this;
		}

		public Criteria andPointEqualTo(Integer value) {
			addCriterion("point =", value, "point");
			return this;
		}

		public Criteria andPointNotEqualTo(Integer value) {
			addCriterion("point <>", value, "point");
			return this;
		}

		public Criteria andPointGreaterThan(Integer value) {
			addCriterion("point >", value, "point");
			return this;
		}

		public Criteria andPointGreaterThanOrEqualTo(Integer value) {
			addCriterion("point >=", value, "point");
			return this;
		}

		public Criteria andPointLessThan(Integer value) {
			addCriterion("point <", value, "point");
			return this;
		}

		public Criteria andPointLessThanOrEqualTo(Integer value) {
			addCriterion("point <=", value, "point");
			return this;
		}

		public Criteria andPointIn(List values) {
			addCriterion("point in", values, "point");
			return this;
		}

		public Criteria andPointNotIn(List values) {
			addCriterion("point not in", values, "point");
			return this;
		}

		public Criteria andPointBetween(Integer value1, Integer value2) {
			addCriterion("point between", value1, value2, "point");
			return this;
		}

		public Criteria andPointNotBetween(Integer value1, Integer value2) {
			addCriterion("point not between", value1, value2, "point");
			return this;
		}
	}
}