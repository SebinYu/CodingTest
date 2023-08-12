package chap01_String;

import java.util.*;

// 각 단어를 뒤집어 출력하는 프로그램
class ReverseString_04 {
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer=new ArrayList<>();
        for(String x : str){
            // StringBuilder 메서드 사용 -> 다시 String으로 변환
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp); // ArrayList 추가 문법
        }
        return answer;
    }

    public static void main(String[] args){
        ReverseString_04 T = new ReverseString_04();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String[] str=new String[n];
        for(int i=0; i<n; i++){
            str[i]=kb.next();
        }
        for(String x : T.solution(n, str)){
            System.out.println(x);
        }
    }
}