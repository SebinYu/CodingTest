package chap04_HashMap_HashSet_TreeSet;

import java.util.*;

/**
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속
 * 된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력
 *
 *
 * 7 4
 * 20 12 20 10 23 17 10  ->  3 4 4 3
 */
class HashMapAndSlidingWindow_03_HashMap {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        for(int i=0; i<k-1; i++){ // 첫번째 범위 값 넣기 - 20 12 20 [이거는 아래에서]
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }

        // 슬라이드 윈도우 진행
        int lt=0;
        for(int rt=k-1; rt<n; rt++){ //그값
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size()); // 범위 값 모두 확인 + 결과 등록

            HM.put(arr[lt], HM.get(arr[lt])-1); // 이제 슬라이드 윈도우 방식으로 기존값 지우고, 새값 넣어주기
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]); // 1개 지우고 0 => 이제 나머지중 key에 해당하는 값이 없다는 의미
            lt++; // 그리고 lt 이동
        }
        return answer;
    }





    public static void main(String[] args){
        HashMapAndSlidingWindow_03_HashMap T = new HashMapAndSlidingWindow_03_HashMap();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
    }
}
