package chap01_String;

import java.util.*;


/**
 * #*조합 일곱 개 분할 문자인식 ->  #은 이진수의 1로, *이진수의 0으로 변환
 * -> 변환된 이진수 -> 10진수로 변환 -> 아스키 코드로 변환
 * -> 모든 아스키값 누적해서 문자열로 변환
 *
 * 4
 * #****###**#####**#####**##**
 * 이 신호를 4개의 문자신호로 구분하면
 * #****## --> 'C'
 * #**#### --> 'O'
 * #**#### --> 'O'
 * #**##** --> 'L'
 * 최종적으로 “COOL" 출력
 * */
class ReplaceAndChangeRadixSyntax_12 {
    public String solution(int n, String s){
        String answer="";
        for(int i=0; i<n; i++){
            String tmp= s.substring(0, 7)
                    .replace('#', '1').replace('*', '0');

            // 2진수 스트링 - 2진수 radix로 변환
            // Integer.parseInt--> 문자열을 그 진법(radix)에 맞게 변환 시켜준다
            // 2, 10, 16, 8 진법 모두 가능 - 자세한 내용은 내장함수를 확인하자
            int num=Integer.parseInt(tmp, 2);
            answer +=(char)num; // 명시적 변환
            s=s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args){
        ReplaceAndChangeRadixSyntax_12 T = new ReplaceAndChangeRadixSyntax_12();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String str=kb.next();
        System.out.println(T.solution(n, str));
    }
}