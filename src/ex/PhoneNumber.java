package ex;

class PhoneNumber {

    // 생성자로 매개변수 선언 -> 이후 바뀔 일이 없다면 final로 선언 -> 이후 의도치 않은 변경 상황을 막아주어야한다
    public final String phoneNumber;

    public PhoneNumber(String rawPhoneNumber) {
        // 정규표현식, 이후 실제 코테에서 사용할 수 있는 환경을 만드는 것이 필요하다
        this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
    }

    @Override
    public String toString(){
        return "\n PhoneNumber: " + phoneNumber;
    }

    // list.contain() 메서드 -> 각 리스트 요소에 equals() 메서드를 사용 -> 객체 비교
    // 문제는 equals()경우 오버라이팅 안하면 -> 객체가 같은지만 확인하고 boolean값을 전달한다
    // 이 경우 핸드폰 번호 내용물이 같아야 하므로 -> 객체 비교 x, 내용물인 String 핸드폰 번호를 비교해 주어야 한다
    @Override
    public boolean equals (Object o){
        if(!(o instanceof PhoneNumber)) return false;
        //(PhonNumber) o 와 같이 형변환을 해주어야  equals 메서드 명령어 동작 가능
        return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
    }

    public static void main(String[] args) {
        System.out.println(new PhoneNumber("010-8332-2698"));
    }

}

