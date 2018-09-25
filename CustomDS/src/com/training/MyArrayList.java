package com.training;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	private int size=0;
	private Object[] array;
	private int no_of_ele=0;
	
	private Iterator<T> it=new Iterator<T>() {

		int index=0;
		
		@Override
		public boolean hasNext() {
			boolean status=false;
			if(index<no_of_ele){
				status=true;
			}
			return status;
		}

		@Override
		public T next() {
			return (T) array[index++];
		}
		
	};
	
	public MyArrayList(){
		super();
		this.array=new Object[this.size];
	}
	
	public boolean addElement(Object ele){
		if(this.no_of_ele==size){
			size+=10;
			array=Arrays.copyOf(array, size);
		}
		array[no_of_ele]=ele;
		no_of_ele++;
		return true;
	}
	private boolean isValidIndex(int index){
		boolean status=true;
		if(index>=this.no_of_ele || index<0){
			status=false;
			throw new IndexOutOfBoundsException("Index Out of Bounds provide from 0 to "+this.no_of_ele);
		}
		return status;
	}
	public Object getElement(int index){
		Object obj=null;
		if(isValidIndex(index)){
			obj=array[index];
		}
		return obj;
	}
	
	public int size(){
		return this.no_of_ele;
	}
	
	@Override
	public String toString(){
		String str="ArrayList: [";
		str+=this.array[0].toString();
		for(int i=1;i<this.no_of_ele;i++){
			str+=","+this.array[i].toString();
		}
		str+="]";
		return str;
	}
	
	public void removeElement(int index){
		if(isValidIndex(index)){
			for(int i=index+1;i<this.no_of_ele;i++){
				this.array[i-1]=this.array[i];
			}
			this.no_of_ele--;
		}
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return it;
	}
}
