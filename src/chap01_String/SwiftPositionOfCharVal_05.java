package chap01_String;

import java.util.*;


//영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기
//자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성

// 문자 교환은 char [] 을 사용해준다
class SwiftPositionOfCharVal_05 {
    public String solution(String str){
        String answer;
        char[] s=str.toCharArray();
        int leftIndex = 0, rightIndex =str.length()-1;
        while(leftIndex < rightIndex){
            // 알파벳인지 확인 -> 알파벳일때까지 계속 안쪽으로 이동
            if(!Character.isAlphabetic(s[leftIndex])) leftIndex++;
            if(!Character.isAlphabetic(s[rightIndex])) rightIndex--;

            // 둘다 알파벳이라면
            if(Character.isAlphabetic(s[leftIndex]) && Character.isAlphabetic(s[rightIndex])){

                // 문자 교환
                char tmp=s[leftIndex];
                s[leftIndex]=s[rightIndex];
                s[rightIndex]=tmp;

                // 다음 인덱스로 옮기기
                leftIndex++;
                rightIndex--;
            }
        }

        // char[] -> String으로 변환
        answer=String.valueOf(s);
        return answer;
    }

    public static void main(String[] args){
        SwiftPositionOfCharVal_05 T = new SwiftPositionOfCharVal_05();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.println(T.solution(str));
    }
}
