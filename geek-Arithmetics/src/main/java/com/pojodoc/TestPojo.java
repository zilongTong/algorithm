package com.pojodoc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Smile.Wu
 * @version 2015-10-13
 */
public class TestPojo {

	@SolrInputDocumentField(field = "name", boost = 1000)
	private String name = "wjyuian";

	@SolrInputDocumentField(field = "age")
	private Integer age = 28;

	@SolrInputDocumentField(field = "add_time")
	private Long time = System.currentTimeMillis();

	@SolrInputDocumentField(field = "data_tags")
	private List<String> tags = new ArrayList<String>();

	@SolrInputDocumentField(field = "times")
	private List<Long> times = new ArrayList<Long>();

	@SolrInputDocumentField(field = "set")
	private Set<Long> set = new HashSet<>();
	
	public TestPojo() {
		tags.add("tags1");
		tags.add("tags2");
		tags.add("tags3");
		
		times.add(123456L);
		times.add(654321L);
		times.add(777777L);
		
		set.add(11111L);
		set.add(3333L);
	}

	
	public Set<Long> getSet() {
		return set;
	}

	public void setSet(Set<Long> set) {
		this.set = set;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<Long> getTimes() {
		return times;
	}

	public void setTimes(List<Long> times) {
		this.times = times;
	}
	
}
