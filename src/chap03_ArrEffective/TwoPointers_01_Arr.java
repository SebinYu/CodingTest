package chap03_ArrEffective;

import java.util.*;

/**
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
 *
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9   ->  1 2 3 3 5 6 7 9
 *
 *
 * 정렬이 된 두 배열 -> Two pointers 진행가능
 * */

class TwoPointers_01_Arr {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0; // 포인터 <- for 변수 대신 사용

        //  O(n^2)-->O(n) - 이중 for문 대신 추천하는 방식
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) answer.add(a[p1++]);// p1++ <- 후위 연산 - add 된 이후 증가됨
            else answer.add(b[p2++]); // 이때 꼭 else를 넣어준다 - 다른거 넣으면 에러뜸
        }

        // 각자 값이 달라서 한 포인터라도 인덱스를 넘으면 아래 작업 수행
        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args){
        TwoPointers_01_Arr T = new TwoPointers_01_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        int m=kb.nextInt();
        int[] b=new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }
        for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
    }
}