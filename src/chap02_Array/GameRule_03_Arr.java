package chap02_Array;

import java.util.*;


/**
 * 1:가위, 2:바위, 3:보
 *
 * 5
 * A인간: 2 3 3 1 3  -> 2 vs 1 등... 가위바위보 -> 이긴사람 A -> A 출력
 * B인간: 1 1 2 2 3
 *
 * 비기면 D리턴
 * -> A
 *    B
 *    A
 *    B
 *    D
 * */

class GameRule_03_Arr {

    private static final int SCISSORS = 1;
    private static final int ROCK = 2;
    private static final int PAPER = 3;

    public String solution(int n, int[] a, int[] b){
        String answer="";
        for(int i=0; i<n; i++){

            if(a[i]==b[i]) answer+="D";
            else if(a[i]==SCISSORS && b[i]==PAPER) answer+="A";
            else if(a[i]==ROCK     && b[i]==SCISSORS) answer+="A";
            else if(a[i]==PAPER    && b[i]==ROCK) answer+="A";
            else answer+="B";
        }
        return answer;
    }





    public static void main(String[] args){
        GameRule_03_Arr T = new GameRule_03_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i]=kb.nextInt();
        }
        for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);
    }
}
