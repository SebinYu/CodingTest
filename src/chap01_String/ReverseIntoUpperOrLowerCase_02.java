package chap01_String;

import java.util.*;

class ReverseIntoUpperOrLowerCase_02 {
    public String solution(String str){
        StringBuffer answer = new StringBuffer();

        for(char x : str.toCharArray()){ // + str.charAt(int index) <- 특정 인덱스의 값을 불러온다
            if(Character.isLowerCase(x)) answer.append(Character.toUpperCase(x));
            if(Character.isUpperCase(x)) answer.append(Character.toLowerCase(x));
        }

        // 선언은 StringBuffer -> 리턴값은 String이므로 전환해준다
        return answer.toString();
    }

    public static void main(String[] args){
        ReverseIntoUpperOrLowerCase_02 T = new ReverseIntoUpperOrLowerCase_02();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}
