package chap02_Array;

import java.util.*;

/**
 *  처음 문제는 1점으로 계산한다. 또한, 연속으로 문제의 답이 맞는 경우에서 두 번째
 * 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산
 *  총점 계산하시오
 *
 *
 *  10
 *  1 0 1 1 1 0 0 1 1 0
 * 채점 1 0 1 1 1 0 0 1 1 0
 * 점수 1 0 1 2 3 0 0 1 2 0
 *
 * -> 1+1+2+3+1+2=10 점이다.
 */
class CheckScore_07_Arr {
    public int solution(int n, int[] arr){
        int answer=0, cnt=0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                cnt++;
                answer+=cnt;
            }
            if(arr[i]==0) cnt=0;
        }
        return answer;
    }



    public static void main(String[] args){
        CheckScore_07_Arr T = new CheckScore_07_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
