package chap02_Array;

import java.util.*;

/**
 * 앞 수보다 큰 수만 출력
 *
 * 6
 * 7 3 9 5 6 12 -> 7 9 6 12
 * */

class GetBiggerVal_01_Arr {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]); // 첫 값은 무조건 넣어주어야해서
        for(int i=1; i<n; i++){ // 첫값 제외 넣기

            // 배열문제는 수도코드를 작성하는 것도 좋은방법 -> if(앞수 < 나) add(나)
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        GetBiggerVal_01_Arr T = new GetBiggerVal_01_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}
