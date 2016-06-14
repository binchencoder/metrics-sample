package com.jingoal.chenbin.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class CopyTest {

	public static void main(String[] args) {
		
		Node node1 = new Node();
		node1.setId(1);
		
		List<String> names = new ArrayList<>();
		names.add("a");
		names.add("b");
		names.add("c");
		node1.setNames(names);
		
		
		Node node2 = new Node();
		BeanUtils.copyProperties(node1, node2);
		node2.getNames().remove(1);
		
		System.out.println(node1);
		System.out.println(node2);
		
	}

}

class Node {
	
	private long id;

	private List<String> names;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
