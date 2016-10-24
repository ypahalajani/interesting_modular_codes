/*
* author: @ypahalajani(Yash Pahalajani: ypahalajani@gmail.com)
*/

//Create all possible permutations of input sequence/permutaion using "back-tracking"
//INPUT: ArrayList of Integers e.g. [1,2,3]
//OUTPUT: ArrayList of ArrayList of Integers e.g. [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
//This is a ready solution( just compile and run the java file using the following commands)
//$ javac Solution.java
//$ java Solution

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
public class Solution {
    public Solution(){
        result=new ArrayList<ArrayList<Integer>>();
    }
    private ArrayList<ArrayList<Integer>> result=null;
    public void swapPos(ArrayList<Integer> a, int pos1, int pos2){
        int temp=a.get(pos1);
        a.set(pos1, a.get(pos2));
        a.set(pos2, temp);
    }
    public void permuteComb(ArrayList<Integer> a, int l, int r){
        if(l==r){
            ArrayList<Integer> temp=new ArrayList<Integer>(a);
            result.add(temp);
            return;
        }else{
            for(int i=l; i<=r; i++){
                swapPos(a, l, i);
                permuteComb(a, l+1, r);
                swapPos(a, l, i);
            }
        }
    }
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        permuteComb(a, 0, a.size()-1);
        return result;
	}
	public void printResult(ArrayList<ArrayList<Integer>> arr){
		int n=arr.size();
		System.out.println("[");
		for(int i=0; i<n; i++){
			System.out.print("[ ");
			for(int j: arr.get(i)){
				System.out.print(j+" ");	
			}
			System.out.println("]");
		}
		System.out.println("]");
	}
	public static void main(String args[]){
		Solution s=new Solution();
		s.printResult(s.permute(new ArrayList<Integer>(Arrays.asList(1,2,3))));
	}
}

