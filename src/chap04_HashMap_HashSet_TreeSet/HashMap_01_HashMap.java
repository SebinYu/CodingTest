package chap04_HashMap_HashSet_TreeSet;

import java.util.*;

/**
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그
 * 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작
 * 성하세요. 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 *
 *
 * 15
 * BACBACCACCBDEDE  ->  C
 */
class HashMap_01_HashMap {
    public char solution(int n, String s){
        char answer=' ';

        // 누적횟수 저장
        HashMap<Character, Integer> map=new HashMap<>();
        for(char key : s.toCharArray()){
            map.put(key, map.getOrDefault(key, 0)+1); //getOrDefault -> 기존값 가져오던가 새로운 값을 넣어줌
        }
        //System.out.println(map.containsKey('F'));
        //System.out.println(map.size());
        //System.out.println(map.remove('C'));

        // 최대값 알기
        int max=Integer.MIN_VALUE;
        for(char key : map.keySet()){
            //System.out.println(key+" "+map.get(key));

            if(map.get(key)>max){
                max=map.get(key);
                answer=key;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        HashMap_01_HashMap T = new HashMap_01_HashMap();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String str=kb.next();
        System.out.println(T.solution(n, str));
    }
}
