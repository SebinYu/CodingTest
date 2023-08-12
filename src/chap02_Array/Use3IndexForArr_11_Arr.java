package chap02_Array;

import java.util.*;

/**
 * 1학년부터 5학년까지 지내오면서, 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로
 *  임시반장이 여러명될 수 있다면, 가장 작은 번호 학생이 ㄱㄱ
 *
 *         1학년 2학년 3학년 4학년 5학년
 * 1번 학생 2 3 1 7 3
 * 2번 학생 4 1 9 6 8
 * 3번 학생 5 5 2 4 4
 * 4번 학생 6 5 2 6 7
 * 5번 학생 8 4 2 2 2  -> 4
 */
class Use3IndexForArr_11_Arr {
    public int solution(int n, int[][] arr){
        int answer=0, max=0;

        for(int studentNum = 1; studentNum <=n; studentNum++){ // 이 경우 인덱스가 1번학생/1학년 이므로 1로 시작
            int cnt=0;
            for(int comparedStudentNum = 1; comparedStudentNum <=n; comparedStudentNum++){

                for(int gradeNum = 1; gradeNum <=5; gradeNum++){
                    if(arr[studentNum][gradeNum]==arr[comparedStudentNum][gradeNum]){
                        cnt++;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer= studentNum;
            }
        }
        return answer;
    }






    public static void main(String[] args){
        Use3IndexForArr_11_Arr T = new Use3IndexForArr_11_Arr();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr=new int[n+1][6];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                arr[i][j]=kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
