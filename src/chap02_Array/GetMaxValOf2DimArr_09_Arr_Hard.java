package chap02_Array;

import java.util.*;

/**
 * N*N의 격자판이 주어지면
 * 각 행의 합
 * 각 열의 합
 * 두 대각선의 합
 *
 * 중 가 장 큰 합을 출력
 *
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19   -> 150
 */
class GetMaxValOf2DimArr_09_Arr_Hard {
    public int solution(int n, int[][] arr){
        int answer=-2147000000;
        int rowSum=0, columSum =0;

        // 이중 for 경우 i 기준 변경 가능한 것을 생각 필요
        for(int i=0; i<n; i++){
            rowSum= columSum =0;
            for(int j=0; j<n; j++){
                rowSum+=arr[i][j]; // 열 증가 -> 각 값 더함
                columSum +=arr[j][i]; // 행 증가
            }
            answer=Math.max(answer, rowSum);
            answer=Math.max(answer, columSum);
        }

        int xSum= 0, reversedXSum =0;
        for(int i=0; i<n; i++){
            xSum+=arr[i][i];
            reversedXSum += arr[i][n-i-1];
        }
        answer=Math.max(answer, xSum);
        answer=Math.max(answer, reversedXSum);

        //answer는 항상 max 만 가져서 별 문제 없다
        return answer;
    }

    public static void main(String[] args){
        GetMaxValOf2DimArr_09_Arr_Hard T = new GetMaxValOf2DimArr_09_Arr_Hard();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=kb.nextInt();
            }
        }
        System.out.print(T.solution(n, arr));
    }
}
