package chap01_String;

import java.util.*;

/**
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기
 *
 * KKHSSSSSSSE -> K2HS7E
 * */
class GetNumOfDuplicateChar_11 {
    public String solution(String s){
        StringBuilder answer= new StringBuilder();
        s = s+" "; // 앞자리와 비교하는 로직 존재 - 마지막 문자 확인할때 사용전용
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){ // 마지막은 빈문자이기 때문에 -1 넣어줌
            // 바로 앞에 있는 값과 비교해준다
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer.append(s.charAt(i));
                if(cnt>1) answer.append(String.valueOf(cnt));
                cnt=1; // 처음상태로 돌려주기
            }
        }
        return answer.toString();
    }

    public static void main(String[] args){
        GetNumOfDuplicateChar_11 T = new GetNumOfDuplicateChar_11();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.println(T.solution(str));
    }
}
