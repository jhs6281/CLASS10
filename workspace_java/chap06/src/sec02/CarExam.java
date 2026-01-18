package sec02;

public class CarExam {

    public static void main(String[] args) {

        //Car 클래스에 myCar라는 변수 new Car()라는 메소드를 가져온다 
        Car myCar = new Car();

        System.out.println(myCar.company);
        myCar.company = "레이";
        System.out.println(myCar.company);

        System.out.println(myCar.speed);
        myCar.speed = 170;
        System.out.println(myCar.speed);

        Car myCar2 = new Car();
        System.out.println(myCar2.company);
        
        // quiz
        
        // China 클래스 만들기
        // 필드 
        // name // 가게 이름
        // address // 주소
        // menus // 두 개 이상의 메뉴를 가지는 메뉴 목록
        
        // ChinaExam 만들고 
        // 중국집 2개 생성
        // 1. 필드값 출력
        // 2. 필드값 바꾸고 출력
    }

}