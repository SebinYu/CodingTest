package chap02_Array;

import java.util.*;

/**
 *  자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력
 *  첫자리 0은 무시
 *
 * 9
 * 32 55 62 20 250 370 200 30 100 -> 23 2 73 2 3
 */

/**
 * 1. 숫자 -> 문자열 -> 뒤집기 -> 숫자로 저장
 * 2. 소수인지 판별
 *
 */
class ReverseIntValAndDetermineIsPrime_06_Arr {
    public boolean isPrime(int num){
        if(num==1) return false; //1은 소수가 아님
        for(int i=2; i<num; i++){ // 소수는 1,자기자신 이외로 나눠질 수 없다 -> 자기자신보다 작은 값으로 나눠지면 의미가 없는 상황
            if(num%i==0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            int tmp=arr[i];
            int reversedVal=0;
            while(tmp>0){

                // 어떤 값을 10으로 나눈 나머지 = 마지막 자리 숫자
                // 1230 % 10 = 0
                int t=tmp%10;
                reversedVal=reversedVal*10+t; // 각 자리를 뒤집어준다
                tmp=tmp/10; // 마지막 자리 완료 -> 지워주기
            }
            if(isPrime(reversedVal)) answer.add(reversedVal);
        }
        return answer;
    }



    public static void main(String[] args){
        ReverseIntValAndDetermineIsPrime_06_Arr T = new ReverseIntValAndDetermineIsPrime_06_Arr();
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
