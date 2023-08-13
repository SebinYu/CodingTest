package chap03_ArrEffective;

import java.util.*;


/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변
 * 경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의
 * 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 [ 1 1 1 1 1 1 1 1 ] 0 1 이며 그
 * 길이는 8
 *
 *
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1   ->  8
 */
class TwoPointers_06_Arr_Hard {
    public int solution(int n, int chanceNum, int[] arr){
        int answer=0, cnt =0, lt=0; //lt = 1 시작점, rt는 마지막 1 탐색점
        for(int rt=0; rt<n; rt++){

            // rt 0만나면 1로 바꿔주고, 기회 소진 + 이동 -> 아직 기회 남아있다면
            if(arr[rt]==0) cnt++; //cnt는 0을 1로 바꾼횟수 = 0을 만난횟수

            //cnt 3되면 시작
            while(cnt > chanceNum){ // 0을 만났는데 바꾸는 횟수 초과 -> while문 동작시작-> lt점 찾기
                if(arr[lt]==0) cnt--; // 1로 바꾸어주고 -> 증가
                lt++;
            }
            answer=Math.max(answer, rt-lt+1); // rt-lt+1는 거리 구하는 공식
        }
        return answer;
    }


    public static void main(String[] args){
        TwoPointers_06_Arr_Hard T = new TwoPointers_06_Arr_Hard();
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