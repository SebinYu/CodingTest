package chap01_String;


// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열 인지?
// 문자열 이외 값은 무시
// 입력예제 1
//한문장 -- found7, time: study; Yduts; emit, 7Dnuof
import java.util.*;
class ReplaceAllSyntax_08 {
    public String solution(String s){
        String answer="NO";

        // ReplaceAllSyntax_08 - 기본은 대문자로 전환
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println(s);
        String tmp=new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        ReplaceAllSyntax_08 T = new ReplaceAllSyntax_08();
        Scanner kb = new Scanner(System.in);
        String str=kb.nextLine();
        System.out.print(T.solution(str));
    }
}
