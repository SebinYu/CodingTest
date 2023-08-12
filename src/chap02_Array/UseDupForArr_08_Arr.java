package chap02_Array;

import java.util.*;

/**
 * 점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고, 그 다음 학생은 4등이 된다
 *
 * 5
 * 87 89 92 100 76 -> 4 3 2 1 5
 */
class UseDupForArr_08_Arr {

    public int[] solution(int n, int[] arr){
        int[] answer = new int[n];

        // 2중 for문은 보통 - 배열 1개 값들을 각 각 비교하기 위해 사용된다
        for(int i=0; i<n; i++){
            int cnt=1;
            for(int j=0; j<arr.length; j++){
                if(arr[j]>arr[i]) cnt++; // 중복값까지 모두 처리 가능한 방식 -  같은 연산과정을 진행하기 때문
            }
            answer[i]=cnt;
        }
        return answer;
    }




    public static void main(String[] args){
        UseDupForArr_08_Arr T = new UseDupForArr_08_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x :T.solution(n, arr)) System.out.print(x+" ");
    }
}
