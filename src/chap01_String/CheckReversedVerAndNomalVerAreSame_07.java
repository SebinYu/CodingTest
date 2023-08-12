package chap01_String;

import java.util.*;

// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열인지 확인
// 대소문자 구분을 하지는 않음
class CheckReversedVerAndNomalVerAreSame_07 {
    public String solution(String str){
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        // 대소문자 상관 없이 비교 - equalsIgnoreCase()
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        CheckReversedVerAndNomalVerAreSame_07 T = new CheckReversedVerAndNomalVerAreSame_07();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}

