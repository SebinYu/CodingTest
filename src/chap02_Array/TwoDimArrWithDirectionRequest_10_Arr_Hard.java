package chap02_Array;

import java.util.*;

/**
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다. 각 격자
 * 판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개
 * 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 *
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2 -> 10
 *     ^
 *     |
 * 0 0 0 0 0 0 0
 * 0 5 3 7 2 3 0
 * 0 3 7 1 6 1 0
 * 0 7 2 5 3 4 0
 * 0 4 3 6 4 1 0
 * 0 8 7 3 5 2 0
 * 0 0 0 0 0 0 0
 */

class TwoDimArrWithDirectionRequest_10_Arr_Hard {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};

    public int solution(int n, int[][] arr){
        int answer=0;

        for(int rowIndex = 0; rowIndex <n; rowIndex++){
            for(int columIndex = 0; columIndex <n; columIndex++){

                boolean flag=true;
                for(int k=0; k<4; k++){ // k는 4방 돌리기 용
                    int xIndexOfOneOf4Dir = rowIndex +dx[k];
                    int yIndexOfOneOf4Dir = columIndex +dy[k];

                    // 조건 불만족 경우 판별
                    // 봉우리 인지 아닌지 판별전에, 4방 xy 인덱스 값들이 현재 배열 안에 있는지 확인 필요
                    // [0 <= 4방 xy 인덱스 < n] 일때만 봉우리 확인 진행 <- 애초에 이렇게 안하면 예외발생함
                    if(xIndexOfOneOf4Dir >=0 && xIndexOfOneOf4Dir < n
                        && yIndexOfOneOf4Dir >=0 && yIndexOfOneOf4Dir < n
                        //arr[rowIndex][columIndex]가 봉우리인지 아닌지 판별
                        && arr[xIndexOfOneOf4Dir][yIndexOfOneOf4Dir] >= arr[rowIndex][columIndex]
                    ){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }



    public static void main(String[] args){
        TwoDimArrWithDirectionRequest_10_Arr_Hard T = new TwoDimArrWithDirectionRequest_10_Arr_Hard();
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
