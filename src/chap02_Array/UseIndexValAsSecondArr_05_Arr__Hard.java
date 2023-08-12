package chap02_Array;

import java.util.*;

/**
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * 제한시간은 1초입니다.
 *
 * 20 -> 8
 */
class UseIndexValAsSecondArr_05_Arr__Hard {
    public int solution(int n){
        int cnt = 0;
        int[] ch = new int[n+1]; // n까지 검사해야해서 그럼
        for(int i=2; i<=n; i++){
            if(ch[i]==0){ // int 배열은 처음에 모두 1로 초기화
                cnt++; // 0이면 소수 , 1이면 소수x(어떤 숫자의 배수 의미)

                //j for문 - j=j+i -> i의 배수 인덱스에 값 넣어줌 -> 무언가의 배수는 소수가 아님 -> 1 표시
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        return cnt;
    }



    public static void main(String[] args){
        UseIndexValAsSecondArr_05_Arr__Hard T = new UseIndexValAsSecondArr_05_Arr__Hard();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        System.out.println(T.solution(n));
    }
}
