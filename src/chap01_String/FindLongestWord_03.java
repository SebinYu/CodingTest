package chap01_String;

// 가장 긴 단어 출력하기
class FindLongestWord_03 {
    private static final int OUT_OF_INDEX_VAL = -1;

    public String solution(String str){
        String answer="";
        int currnetLongestLenght = Integer.MIN_VALUE; // 길이 비교용
        int indexPos;

        /**
         * 1. indexOf -> 처음으로 발견되는 인덱스 값을 리턴
         *              -> 발견 못하면 -1을 리턴
         * */
        while((indexPos = str.indexOf(' ')) != OUT_OF_INDEX_VAL){
            String valAfterSubstring = str.substring(0, indexPos); //indexPos제외하고 자른다
            int lengthAfterSubstring = valAfterSubstring.length();
            if(lengthAfterSubstring > currnetLongestLenght){ // 여기서 > 를 사용 -> 길이가 동일하다면 처음것을 반영해야 하기 때문
                currnetLongestLenght = lengthAfterSubstring;
                answer=valAfterSubstring;
            }
            str=str.substring(indexPos+1); //indexPos+1 부터 끝까지
        }

        // 마지막 단어는 띄어쓰기가 없어서 반영이 안되므로 직접 대소를 비교해준다
        // 항상 처음, 마지막 값을 표를 통해 정확히 파악한다
        if(str.length() > currnetLongestLenght) answer=str;
        return answer;
    }

    public static void main(String[] args){
        FindLongestWord_03 T = new FindLongestWord_03();
        String str="it is time to study";
        System.out.print(T.solution(str));
    }
}
