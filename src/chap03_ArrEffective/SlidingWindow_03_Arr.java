package chap03_ArrEffective;

import java.util.*;

/**
 * N일 동안의 매출기록을 주고 연속
 * 된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 15 11 20 25 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원 출력
 *
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15  -> 56
 *
 * Sliding window 문제
 */
class SlidingWindow_03_Arr {
    public int solution(int n, int k, int[] arr){
        int answer, sum=0;
        for(int i=0; i<k; i++) sum+=arr[i]; //초반 누적값
        answer=sum;
        for(int i=k; i<n; i++){
            sum+=(arr[i]-arr[i-k]); // 초반 누적값 sum에 new 값 넣고(arr[i]), 빠지는 값 빼주기(arr[i-k])
            answer=Math.max(answer, sum); // 큰,작 값 비교시 해당 값 넣기
        }
        return answer;
    }




    public static void main(String[] args){
        SlidingWindow_03_Arr T = new SlidingWindow_03_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
    }
}
