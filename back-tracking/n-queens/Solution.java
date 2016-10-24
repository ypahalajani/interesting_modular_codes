//INPUT: a dimension of chessboard
//OUTPUT: all possible permutation of n-queen solution
//Note: that the '.'(dot or period) represents the empty spaces on the chessboard
//Note: and, the 'Q' represents the position of 'n' Queens.

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Solution {
    private ArrayList<ArrayList<String>> result=null;
    public Solution(){
        result=new ArrayList<ArrayList<String>>();
    }
    public boolean isSafe(int[][] arr, int row, int col, int n){
        //i=row and j=col is checked to assure whether the current place does not already contains a queen
        //checking the upper-left diagonal for queen
        int i, j;
        for( i=row, j=col; i>=0 && j>=0; i--, j-- ){
            if(arr[i][j]==1){
                return false;
            }
        }
        
        //checking the whether there is no queen in that column
        for(i=0; i<=row; i++){
            if(arr[i][col]==1){
                return false;
            }
        }
        
        //checking the upper-right diagonal for queens
        for(i=row, j=col; i>=0 && j<n; i--, j++){
            if(arr[i][j]==1){
                return false;
            }
        }
        
        return true;
    }
    public void solveNQueenProblem(int[][] board, int row, int n){
        if(row>=n){
            //all queens are placed
            return;
        }
        
        for(int i=0; i<n; i++){
            if(isSafe(board, row , i, n)){
                board[row][i]=1;
                if(row==n-1){
                    result.add(setResult(board, n));
                }
                solveNQueenProblem(board, row+1, n);
                //backtracking
                //reset the position for the other permutation of n-queens solution
                board[row][i]=0;
            }
            
        }
    }
    public ArrayList<String> setResult(int[][] arr, int n){
        ArrayList<String> temp=new ArrayList<String>();
        for(int i=0; i<n; i++){
            StringBuilder str=new StringBuilder();
            str.setLength(0);
            for(int j=0; j<n; j++){
                char c='.';
                if(arr[i][j]==1){
                    c='Q';
                }
                str=str.append(c);
            }
            temp.add(str.toString());
        }
        return temp;
    }
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    //n is the dimension of the chessboard
    	int n=a;
    	//initialize the board with zeroes i.e. no queens
    	int board[][]=new int[n][n];
    	for(int i=0; i<n; i++){
    	    for(int j=0; j<n; j++){
    	        board[i][j]=0;
    	    }   
    	}
    	
    	solveNQueenProblem(board, 0, n);
    	return result;
	}
	public void printResult(ArrayList<ArrayList<String>> arr){
		int n=arr.size();
		System.out.println("[");
		System.out.println();
		for(int i=0; i<n; i++){
			ArrayList<String> temp=arr.get(i);
			System.out.println("[");			
			for(String j: temp){
				System.out.println(j);
			}
			System.out.println("]");			
			System.out.println();
		}
		System.out.println("]");	
	}
	public static void main(String args[]){
		Solution s=new Solution();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a dimension for your chessboard:");
		int a=scanner.nextInt();
		System.out.println();
		scanner.close();
		s.printResult(s.solveNQueens(a));
	}
}

