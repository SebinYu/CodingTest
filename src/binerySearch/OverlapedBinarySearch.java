package binerySearch;

import java.util.Arrays;
import java.util.Scanner;

//백준 10816번

public class OverlapedBinarySearch {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);	// 이분 탐색을 하기 위해서는 반드시 정렬되어있어야 한다.

        int M = in.nextInt();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = in.nextInt();

            // upperBound와 lowerBound의 차이 값을 구한다.
            stringBuilder.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(stringBuilder);
    }


    private static int lowerBound(int[] arr, int targetVal) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {

            int mid = lo + ((hi - lo) / 2); // 중간위치를 구한다. + int 오버플로우를 방지해준다
            int currentMidVal = arr[mid];
            /*
             *  targetValInArr 값이 중간 위치의 값보다 작거나 같을 경우
             *
             *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
             */
            if (targetVal <= currentMidVal) {
                hi = mid;
            }

            else {
                lo = mid + 1;
            }

        }

        return lo;
    }

    private static int upperBound(int[] arr, int targetVal) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {

            int mid = lo + ((hi - lo) / 2); // 중간위치를 구한다. + int 오버플로우를 방지해준다
            int currentMidVal = arr[mid];

            // key값이 중간 위치의 값보다 작을 경우
            if (targetVal < currentMidVal) {
                hi = mid;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                lo = mid + 1;
            }

        }

        return lo;
    }

}