package com.ninja.hashmap;

public class MapNode<T1, T2> {
	T1 key;
	T2 value;
	MapNode<T1, T2> next;
	public MapNode(T1 key, T2 value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}
}
