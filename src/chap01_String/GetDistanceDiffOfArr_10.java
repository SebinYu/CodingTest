package chap01_String;

import java.util.*;


/**
 * 한 개의 문자열, 문자가 주어지면 문자열의 각 문자가 문자 t와 떨어진 최소거리를 출력
 * 참고로 문자열은 최대 100길이 이다
 * teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
 * */

/** 문풀 방식
 *
 * 1. 예시로 나온 입력값을 직접 시뮬레이션 해본다
 * 2. 조건이 않맞는게 대부분 -> 만족시키는 방법을 찾는다
 * */
class GetDistanceDiffOfArr_10 {
    public int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000; // 문자열 길이 100보다 크게 임의로 설정


        // 배열간의 거리를 구할때는 2가지 - 순방향/역방향을 확인 -> 두 배열값 중 - 조건에 맞는 값을 비교해서 넣어준다
        for(int i=0; i<s.length(); i++){

            // t와 같으면 0
            if(s.charAt(i)==t){
                p=0;
                answer[i]=p;
            }

            // t와 다르면 벌어지는 갭 누적 추가
            if(s.charAt(i) != t){
                p++; // 갭 누적추가
                answer[i]=p;
            }
        }

        p=1000; // 초기화
        //역방향으로 순환
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == t) p=0;
            if(s.charAt(i) != t){
                p++;
                answer[i]=Math.min(answer[i], p); // 기존 배열값 vs 역방향 비교 위치값 p <- 둘중 작은 값을 최종 위치값으로 지정해준다
            }
        }

        return answer;
    }

    public static void main(String[] args){
        GetDistanceDiffOfArr_10 T = new GetDistanceDiffOfArr_10();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char c=kb.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
