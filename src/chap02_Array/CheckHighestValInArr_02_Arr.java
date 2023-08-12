package chap02_Array;

import java.util.*;

/**
 * 각 숫자배열 값이 최대가 되는 순간의 개수를 출력
 *
 * 8
 * 130 135 148 140 145 150 150 153 -> 5
 * */
class CheckHighestValInArr_02_Arr {
    public int solution(int n, int[] arr){
        int answer=1, maxVal =arr[0];

        for(int i=1; i<n; i++){
            int currentVal = arr[i];

            // 현재 값이 최대가 되는 순간
            if(currentVal > maxVal){
                maxVal = currentVal; // 1. 최대값 변경
                answer++; //2. 최대가 되는 순간 누적 ++
            }
        }
        return answer;
    }



    public static void main(String[] args){
        CheckHighestValInArr_02_Arr T = new CheckHighestValInArr_02_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
