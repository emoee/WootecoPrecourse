# WootecoPrecourse
📌 우아한테크코스 프리코스 <br/>
총 4개의 프로젝트를 구현하였으며 한달동안 진행되었다.

## 4주차: 12월 이벤트 플래너
### 💡 기능 목록
    [v] 이벤트 참여 가능 여부 확인
        [v] 총 주문 금액 10,000 이상인지 확인
        [v] 음료만 주문 시 이벤트 참여 불가
        [v] 메뉴는 한번에 최대 20개까지 가능
    [v] 크리스마스 디데이 할인
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.25 )
        [v] 할인 금액 계산 ( e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인 )
    [v] 평일 할인
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.31 ), 평일인지 확인 (일 ~ 목)
        [v] 디저트 메뉴 주문 시 할인 금액 계산
    [v] 주말 할인
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.31 ), 주말인지 확인 (금 ~ 토)
        [v] 메인 메뉴 주문 시 할인 금액 계산
    [v] 특별 할인
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.31 ), 일요일이거나 25일인지 확인
        [v] 총 주문 금액에서 1,000원 할인 계산
    [v] 증정 이벤트
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.31 )
        [v] 할인 전 총 주문 금액 확인하여 12만원 이상이면 샴페인 1개 증정
    [v] 12월 이벤트 배지
        [v] 이벤트 기간 확인 ( 12.1 ~ 12.31 )
        [v] 총 해택 금액 계산 ( 할인 금액의 합계 + 증정 메뉴의 가격 )
        [v] 금액대 별로 다른 배지 부여
    [v] 입력 클래스
        [v] 방문날짜 1 ~ 31의 범위가 아닐 시 에러 메세지 출력 후 다시 받음
        [v] 메뉴판 없는 메뉴 입력 시 에러 메세지 출력 후 다시 받음
        [v] 주문 형식이 다른 경우 에러 메세지 출력 후 다시 받음
        [v] 메뉴의 개수는 1 이상의 숫자만 유효 이외의 값 에러 메세지 출력 후 다시 받음
        [v] 중복 메뉴 입력 시 에러 메세지 출력 후 다시 받음
    [v] 출력 클래스
        [v] 주문 메뉴는 한줄에 한 메뉴씩 ( 순서 상관 없음 )
        [v] 혜택 내역은 각 이벤트 별로 있는 경우만 출력( 순서 상관 없음 ), 없으면 "없음" 출력
        [v] 할인 후 예상 결제 금액 계산 ( 할인 전 총주문 금액 - 할인 금액 )
        [v] 예외 상황 확인하여 수정
    [v] 테스트 코드 작성
        [v] 예외 상황  발생 시 확인해 수정

## 3주차: 로또 게임
### 📝 로또 게임 규칙
    로또 번호의 숫자 범위는 1 ~ 45
    로또 1장의 가격은 1,000원
    1개의 로또의 숫자는 중복되지 않는 6개의 숫자로 이루어짐
    당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개로 이루어짐
    당첨은 1등부터 5등까지 존재
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
### 💡 기능 구현 목록
    [v] 로또 구입 금액 유효성 체크(1,000원 단위)
    [v] 로또 구입 금액 만큼의 게임 횟수 셋팅
    [v] 로또 구입 금액만큼 로또 생성
    [v] 로또 번호 입력 -> 쉼표(,)를 기준으로 구분, 숫자범위 중 중복되지 않는 숫자 6개
    [v] 보너스 번호 입력 -> 로또 번호와 중복되지 않아야함
    [v] 발행된 로또 출력 -> 로또 수량 및 번호 출력, 로또 번호는 오름차순으로 정렬
    [v] 당첨 내역 출력 -> 실행결과와 같이 출력
    [v] 수익률 출력 -> 소수점 둘째 자리에서 반올림
    [v] Lotto 클래스 상속 받아 로또 번호 생성하도록 수정
    [v] 로또 번호 에러/예외 설정 및 출력 -> 에러 문구는 "[ERROR]"로 시작할 것
    [v] else, switch 문 사용하지 않고 메소드 15라인 안쪽으로 하도록 할 것
    [v] Java Enum을 적용할 것
    [v] 여러 테스트 케이스 작성

## 2주차: 자동차 경주 게임
### 📝 정리
    자동차 이름을 입력 받는다. (이름의 길이는 5 이하)
    게임을 반복할 횟수를 입력 받는다.
    게임의 한 턴마다 자동차 각각 랜덤 숫자를 생성한다.
    해당 랜덤 숫자가 4 이상인 경우 전진한다. (랜덤 값은 0~9)
    게임이 완료된 후 가장 많이 전진한 자동차가 우승한다.
    우승자는 한 명 이상일 수 있으며 여려명인 경우 쉼표로 구분한다.
### 💡 기능 목록
    [v] 자동차 클래스 설계 : 이름, 전진 횟수 - RCar : name, forwardCount
    [v] 입력 처리
        [v] 자동차 이름 입력받아 쉼표를 기준으로 자동차 분리해 자동차 객체 생성 - separateCar()
        [v] 이동할 횟수 저장 - racingCount()
    [v] 전진 기능 구현
        [v] 랜덤 숫자 생성 : 범위 0 ~ 9 - createRandomNumber()
        [v] 랜덤 숫자 4 이상이면 전진 - forwardCar()
        [v] 전진하면 자동차의 전진 횟수 업데이트 - updateforwardCount()
    [v] 전진 결과 출력 : 자동차 별로 전진 결과 화면 출력 - forwardResult()
    [v] 우승자 출력 : 전진 횟수가 가장 높은 자동차 우승, 여러 명인 경우 쉼표로 구분해 출력 - findWinner()
    [v] 테스트 코드 작성


## 1주차: 숫자 야구 게임
### 💡 [구현해야하는 기능]
    랜덤한 3자리 숫자 생성하기 : 1부터 9까지 서로 다른 숫자 3개를 랜덤하게 선택하여 컴퓨터의 숫자로 설정한다.
    3자리 서로 다른 숫자를 입력받는다.
    입력값이 숫자가 아니거나, 3자리 숫자가 아니거나, 중복된 숫자가 있으면 예외를 발생시킨다.
    입력한 숫자와 컴퓨터 숫자 비교하기
    입력한 숫자와 컴퓨터의 숫자를 비교하여 볼, 스트라이크 개수를 계산한다.
    볼은 같은 수가 다른 자리에 있는 경우의 개수를 의미하고, 스트라이크는 같은 수가 같은 자리에 있는 경우의 개수를 의미한다.
    결과를 출력한다.
    게임 종료 및 재시작/종료 선택 : 3스트라이크를 달성하면 게임을 종료하고 게임을 다시 시작할지 종료할지 선택할 수 있다.
    1을 입력하면 게임을 재시작하고, 2를 입력하면 게임을 종료한다.
    사용자가 잘못된 값을 입력하면 예외를 발생시키고 프로그램을 종료한다.

### 📝 [순서도]
    컴퓨터 숫자 랜덤 생성
    사용자 값 입력
    입력값 검증 -> 예외 발생 시 프로그램 종료
    정답 비교 결과 출력 -> 정답인 경우 게임 종료 재시작 여부 판단 -> 재시작 시 1번부터 반복 / 프로그램 종료 -> 정답이 아닌 경우 2번부터 반복 진행
