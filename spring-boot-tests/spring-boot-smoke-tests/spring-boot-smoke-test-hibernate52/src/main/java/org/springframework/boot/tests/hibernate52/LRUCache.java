package org.springframework.boot.tests.hibernate52;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRU {
	private Map<String,Node> map = new ConcurrentHashMap<>();
	private int count;
	private int capacity;
	private Node head,tail;
	class Node {
		public int val;
		public Node pre;
		public Node next;
		Node() {

		}
	}
	public LRU(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		head = new Node();
		head.pre = null;
		tail = new Node();
		tail.next = null;
		tail.pre = head;
	}
	public void set(String key,int value) {
		Node node = map.get(key);
		if (node == null) {
			node =  new Node();
			node.val = value;
			map.put(key,node);
		} else {
			node.val = value;
			moveHead(node);
		}
	}
	public Node get(String key) throws Exception {
		Node node =  map.get(key);
		if (node == null) {
			throw new Exception("node not exist");
		}
		moveHead(node);
		return node;
	}
	public void removeNode(Node node) {
		Node pre = node.pre;
		Node next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	// 先remove 再add到head
	private void moveHead(Node node) {
		

	}


}
