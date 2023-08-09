package chap01;

import java.util.HashSet;
import java.util.Set;

public class Person {

    public final String name;

    // LIST 자료형은 외부에서 해당 객체를 변경(add,pop)할 수 없도록, private로 선언해 주어야한다
    // 바로 위 string 자료형은 불변이기때문에 별다른 작업 없이 public으로 선언해주면된다
    private final Set<PhoneNumber> phoneNumbers;

    public Person(String name) {
        this.name = name;
        phoneNumbers = new HashSet<>();
    }

    // 2. 핸드폰 번호 추가
    // 인자값을 PhonNumber 객체 -> 객체 생성시 자동으로 핸드폰 번호 유효성을 검사해줌 -> 효율성 대폭 향상 -> 이렇게 안하면 아래 주석 코드처럼 불필요한 for문을 돌려야한다
    public void addPhoneNumber(PhoneNumber num){
        phoneNumbers.add(num);
    }

    //주석표시된 코드가 좋지 못한 코드인데,
    //한개 메서드에 형식검사 + list에 값 추가 2가지를  한번에 하는 코드는 이후 코드 복잡도가 올라면 좋지 못한 코드가 되니 절대적으로 지양해야한다

//    public boolean addPhoneNumber(String number){
//        for (char c : number.toCharArray()){
//            if(!Character.isDigit(c)) return false;
//        }
//        numbers.add(number);
//        return true;
//    }

    @Override
    public String toString(){
        return "Person{" + "\n" +
                "name = " + name + "\n" +
                "numbers = " + phoneNumbers +
                "}";
    }

    public boolean hasPhoneNumber(PhoneNumber num){
        return phoneNumbers.contains(num);
    }

    public static void main(String[] args) {
        Person person = new Person("제이크");
        person.addPhoneNumber(new PhoneNumber("010-1"));

        //set 자료형 -> 중복 없애고 싶으면 같은 객체로 넣어야 한다 / new 로 객체 생성하면 주소 값이 다르기 때문에 다른 객체로 판단한다
        PhoneNumber phoneNumber = new PhoneNumber("010-2");
        person.addPhoneNumber(phoneNumber);
        person.addPhoneNumber(phoneNumber);
        person.addPhoneNumber(phoneNumber);


        person.addPhoneNumber(new PhoneNumber("010-3"));
        person.addPhoneNumber(new PhoneNumber("010-4"));
        System.out.println(person);

        boolean result = person.hasPhoneNumber(new PhoneNumber("010-1234"));
        System.out.println(result);

    }


}
