package chap02_Array;

import java.util.*;

/**
 * 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
 *
 * 10 -> 1 1 2 3 5 8 13 21 34 55
 */
class GetFibonacciArr_04_Arr {
    public int[] solution(int n){
        int[] answer=new int[n];
        answer[0]=1;
        answer[1]=1;

        for(int i=2; i<n; i++){ // 앞에서 값 2개 이미 지정
            answer[i] = answer[i-2]+answer[i-1];
        }
        return answer;
    }

    public static void main(String[] args){
        GetFibonacciArr_04_Arr T = new GetFibonacciArr_04_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        for(int x :T.solution(n)) System.out.print(x+" ");
    }
}
