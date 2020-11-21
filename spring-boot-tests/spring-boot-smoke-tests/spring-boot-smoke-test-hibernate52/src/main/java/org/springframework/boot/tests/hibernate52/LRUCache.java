package org.springframework.boot.tests.hibernate52;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
	private Map<Integer,Node> map = new ConcurrentHashMap<>();
	private int count;
	private int capacity;
	private Node head,tail;
	class Node {
		public int key;
		public int val;
		public Node pre;
		public Node next;
		Node() {

		}
		Node(int key,int value) {
			this.key = key;
			this.val = value;
		}
	}
	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		head = new Node();
		head.pre = null;
		tail = new Node();
		tail.next = null;
		tail.pre = head;
	}
	public void set(int key,int value) {
		Node node = map.get(key);
		if (node == null) {
			node =  new Node(key,value);
			map.put(key,node);
			addToHead(node);
			count++;
			if (count > capacity) {
				Node tail = removeTail();
				map.remove(tail);
				count--;
			}
		} else {
			node.val = value;
			moveHead(node);
		}
	}

	private Node removeTail() {
		Node node = tail.pre;
		removeNode(node);
		return node;
	}

	public Node get(int key) throws Exception {
		Node node =  map.get(key);
		if (node == null) {
			throw new Exception("node not exist");
		}
		moveHead(node);
		return node;
	}
	public void removeNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	// 先remove 再add到head
	private void moveHead(Node node) {
		removeNode(node);
		addToHead(node);
	}
	private void addToHead(Node node) {
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}
}
