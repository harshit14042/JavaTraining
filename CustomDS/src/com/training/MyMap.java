package com.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K,V> {
	private int size;
	private int capacity;
	
	public MyMap(){
		super();
		this.size=0;
		this.capacity=10;
		entries=new MapEntry[this.capacity];
	}
	
	private MapEntry<K, V>[] entries;
	
	public boolean isValidIndex(int index){
		boolean status=false;
		if(size<capacity){
			status=true;
		}
		return status;
	}
	
	public V put(K key,V value){
		
		V val=null;
		
		for(int i=0;i<size;i++){
			if(entries[i].getKey().equals(key)){
				val=(V) entries[i].getValue();
				entries[i].setValue(value);
				break;
			}
		}
		if(val==null){
			if(isValidIndex(size)){
				MapEntry entry=new MapEntry(key,value);
				entries[size]=entry;
				size++;
			}
			else{
				capacity*=2;
				entries=Arrays.copyOf(entries, capacity);
			}
		}
		return val;
		
	}
	
	public <V> V get(K key){
		V val=null;
		for(int i=0;i<size;i++){
			if(entries[i].getKey().equals(key)){
				val=(V) entries[i].getValue();
				break;
			}
		}
		return val;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public MyMap(int size, int capacity, MapEntry<K, V>[] entries) {
		super();
		this.size = size;
		this.capacity = capacity;
		this.entries = entries;
	}

	@Override
	public String toString() {
		String str="";
		for(int i=0;i<size;i++){
			str+=entries[i].toString()+",";
		}
		return str;
	}
	
	public Set<MapEntry<K,V>> convertToSet(){
		Set<MapEntry<K,V>> set=new HashSet<MapEntry<K,V>>();
		
		for(int i=0;i<size;i++){
			set.add(entries[i]);
		}
		return set;
	}
}
