package chap04_HashMap_HashSet_TreeSet;

import java.util.*;

/**
 * S문자열에서 [T문자열과 아나그램이 되는 S]의 [부분문자열의 개수]를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열
 * T문자열은 S문자열보다 길이가 작거나 같습니다
 *
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 * bacaAacba
 * abc         ->  3
 *
 *
 */
class HashMapAndSlidingWindow_04_HashMap {
    public int solution(String s, String t){
        int answer=0;
        HashMap<Character, Integer> sm =new HashMap<>();
        HashMap<Character, Integer> tm =new HashMap<>();
        for(char x : t.toCharArray()) tm.put(x, tm.getOrDefault(x, 0)+1); // 작은 것 맵으로 등록
        int L = t.length()-1;
        for(int i=0; i<L; i++) sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0)+1); // 큰것 초반부만 1개빼고 등록, 나머지는 슬라이딩 윈도우로 검색

        //슬라이딩 윈도우
        int lt=0;
        for(int rt = L; rt< s.length(); rt++){
            char rtValue = s.charAt(rt);
            int CntRtValue = sm.getOrDefault(rtValue, 0)+1;
            sm.put(rtValue, CntRtValue);

            if(sm.equals(tm)) answer++;// 맞는 지 확인

            char ltValue = s.charAt(lt);
            int CntLtValue = sm.get(s.charAt(lt))-1;
            sm.put(ltValue,CntLtValue); //이제 범위 확인 끝났으니 1개씩 지우기 시작
            if(sm.get(ltValue)==0) sm.remove(s.charAt(lt)); // 이제 0으로 유효하지 않음 -> 필요없으므로 지우기
            lt++; //이제 1+ 하고 자리 이동
        }
        return answer;
    }


    public static void main(String[] args){
        HashMapAndSlidingWindow_04_HashMap T = new HashMapAndSlidingWindow_04_HashMap();
        Scanner kb = new Scanner(System.in);
        String a=kb.next();
        String b=kb.next();
        System.out.print(T.solution(a, b));
    }
}