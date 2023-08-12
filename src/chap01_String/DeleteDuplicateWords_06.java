package chap01_String;

import java.util.*;

// 중복된 문자를 제거하고 출력하는 프로그램을 작성
class DeleteDuplicateWords_06 {
    public String solution(String str){
        StringBuilder answer= new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            int firstIndexAmongSameChars = str.indexOf(currentChar);

            // 처음 값만 저장하고, 이후 인덱스값들은 반영하지 않는다
            if( firstIndexAmongSameChars == i) answer.append(currentChar);
        }
        return answer.toString();
    }

    public static void main(String[] args){
        DeleteDuplicateWords_06 T = new DeleteDuplicateWords_06();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.print(T.solution(str));
    }
}
