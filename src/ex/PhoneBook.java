package ex;

import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    //중복등록 방지 - set + hashSet
    //외부 수정 막기 - private
    //변경 불가하도록 final
    private final Set<Person> people;

    // 외부에서 접근 할 수 없도록 private로 선언
    private PhoneBook(){
        people = new HashSet<>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public Person search(PhoneNumber phoneNumber){
        return people.stream()
                .filter(p -> p.hasPhoneNumber(phoneNumber))
                // stream 에서 findFirst, orElse 2가지는 세트로 활용하자
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "people=" + people +
                "}";
    }

    public static void main(String[] args){

        //1. 중복없는 사람 정보 등록 / 이때 핸드폰 번호는 여러개 등록이 가능하다
        Person person = new Person("유세빈");
        person.addPhoneNumber(new PhoneNumber("010"));
        person.addPhoneNumber(new PhoneNumber("012313120"));

        Person person2 = new Person("빈");
        person2.addPhoneNumber(new PhoneNumber("989080980"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person);
        phoneBook.addPerson(person); // set 중복막기 잘되는지 확인용
        phoneBook.addPerson(person2);

        System.out.println(phoneBook);

        //2. search 메서드 테스트용
        Person searchedPhoneBookPerson = phoneBook.search(new PhoneNumber("010"));
        System.out.println(searchedPhoneBookPerson);

        // 코딩테스트는 코드단계를 나눌줄 아는 것이 가장 중요하다, 자료구조 + 알고리즘을 적제 적소에 적용하기도 중요하지만
    }
}
