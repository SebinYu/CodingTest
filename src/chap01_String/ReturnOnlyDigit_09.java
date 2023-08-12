package chap01_String;

import java.util.*;

/**
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다
 * 01a009 -> 1009
 * */
class ReturnOnlyDigit_09 {
    public int solution(String s){
        //int answer=0;
        String answer="";
        for(char x : s.toCharArray()){
            // + Character.getNumericValue(x) -- 문자의 아스키 코드값을 리턴한다
            if(Character.isDigit(x)) answer+=x;
        }

        // 첫번째 숫자가 0 일 경우 -> 지워지고 나머지 값들이 들어가게 된다
        return Integer.parseInt(answer);
    }

    public static void main(String[] args){
        ReturnOnlyDigit_09 T = new ReturnOnlyDigit_09();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}
