package chap01_String;

import java.util.*;
class FindLetter_01 {
    public int solution(String str, char letter){
        // 메모리 아끼기 위해 기존 파라미터 활용 <- 현업에서는 절대 하면 안되는 것만 기억하기
        str=str.toUpperCase();
        letter=Character.toUpperCase(letter);

        // 사용 직전에 변수 선언하기 -> 더 보기 편해진다
        int answer=0;
        for(char x : str.toCharArray()){
            if(x==letter) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        FindLetter_01 T = new FindLetter_01();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char letter =kb.next().charAt(0);
        System.out.print(T.solution(str, letter));
    }
}
