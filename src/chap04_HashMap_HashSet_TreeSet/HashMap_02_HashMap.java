package chap04_HashMap_HashSet_TreeSet;

import java.util.*;

/**
 * AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면
 * A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재
 * 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분 -> 별다른 작업을 안해도 된다는 의미
 *
 * abaCC
 * Caaab -> NO
 */
class HashMap_02_HashMap {
    public String solution(String s1, String s2){
        String answer="YES";
        HashMap<Character, Integer> map=new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x)==0) return "NO"; //해당 알파벳 없음을, key, value 2곳에서 모두 확인
            //map.get(x)==0 경우 - 이미 0으로 확인 끝났는데, 또확인하려해서 NO
            map.put(x, map.get(x)-1); // key는 같으나 개수가 다른 경우를 확인
        }
        return answer;
    }

    public static void main(String[] args){
        HashMap_02_HashMap T = new HashMap_02_HashMap();
        Scanner kb = new Scanner(System.in);
        String a=kb.next();
        String b=kb.next();
        System.out.print(T.solution(a, b));
    }
}
