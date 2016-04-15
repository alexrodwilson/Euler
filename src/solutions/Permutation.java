/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alex
 */
    public class Permutation<T>{
        private List<T> list;
        
        private  List<T> makeCopy(List<T> list){
            List<T> copy = new LinkedList<>();
            copy.addAll(list);
            return copy;
        }
        
        public Permutation(List<T> list){
            this.list = list;
        }
        
        public Permutation swap(int i0, int i1){
            //List list2 = ((List) ((ArrayList) list).clone());
            List<T> copy = makeCopy(list);
            list.set(i1, copy.get(i0));
            list.set(i0, copy.get(i1));
            return this;
        }
        
        @Override
        public String toString(){
            return list.toString();
        }
    } 
