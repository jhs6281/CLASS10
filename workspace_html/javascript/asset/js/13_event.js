console.log('hello js')

// id btn1을 변수 btn1에 담기
const btn1 = document.querySelector('#btn1')
// console.log로 버튼1 출력
console.log(1, 'btn1', btn1)

// window.onload = init; //init 만드는 방법
window.addEventListener('load', init);
//load : 이벤트 페이지 접속할 때 한번 발동된다

function init() { // 이닛 함수

    // btn1 = btn1 아이디 값을 가진 태그  
    const btn1 = document.querySelector('#btn1')
    // 출력
    console.log(2, 'btn1', btn1)

    // ID : game 태그 (고양이 이미지 = game)
    const game = document.querySelector('#game')

    // 좌 우 위치 조정
    game.style.left = '10px'
    game.style.top = '300px'

    //함수 호출
    bind()
    idpw()
}

//버튼 3 클릭 함수(아직 실행 안함)
function btn3click() {
    // 초기 세팅 
    const log = document.querySelector('#log')
    log.innerHTML += '<br>버튼3 클릭'

}

function bind() {
    // 로그 (호출용 태그)
    const log = document.querySelector('#log')

    // 버튼 1
    const btn1 = document.querySelector('#btn1')
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 클릭'
    }
    // onclick은 변수라서 하나의 값만 저장된다. (클릭2만 출력됨)
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 클릭2'
    }

    // 버튼 2
    const btn2 = document.querySelector('#btn2')
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 click!'
    })
    //addEventListener()는 메소드라서 동일한 이벤트에 추가되어 적용. (두 개씩 출력됨)
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 클리익~~'
    })

    // 키 다운
    const id = document.querySelector('#id')
    document.querySelector('#id').addEventListener('keydown', function () {
        log.innerHTML += '<br>keydown 발생' // 누를 때 작동
    })
    // 키 업
    document.querySelector('#id').addEventListener('keyup', function (event) {
        log.innerHTML += '<br>keyup 발생' // 땔 때 작동
        console.log(event) // 키 업 내용
        console.log(event.key) // 키 이벤트
        console.log(event.keyCode)

        console.log(event.shiftkey)
        console.log(event.ctrlkey)
        console.log(event.altkey)

        //키 다운 이벤트
        if (event.keyCode == 13) {
            log.innerHTML += "엔터 빵!!"
            document.querySelector('#pw').focus()
        }
        //컨트롤 누른 상태에서 > c(67) 누르면
        if (event.ctrlKey == true && event.keyCode == 67) {
            alert('복사할라고??')
        }
    })

    // 이해 됐는지
    document.querySelector('#pw').addEventListener('keyup', function (event) {
        if (event.keyCode == 13) { // 엔터누르면
            document.querySelector('#login').click() // DOM에 click 발생
        }
    })

    // 이벤트 시작
    document.querySelector('body').addEventListener('keydown', function (event) {
        console.log('body event.keyCode :', event.keyCode)

        const game = document.querySelector('#game')


        console.log('game.keyCode : ', game.style.left)
        // if (event.keyCode == 39) { // 오른쪽
        //     // game.style.left -= 
        // }
        // 좌, 우
        if (event.keyCode == 39) {
            game.style.left = (parseInt(game.style.left) + 10) + 'px'
        } else if (event.keyCode == 37) {
            game.style.left = (parseInt(game.style.left) - 10) + 'px'
        }

        else if (event.keyCode == 38) {
            game.style.top = (parseInt(game.style.top) - 10) + 'px'
        } else if (event.keyCode == 40) {
            game.style.top = (parseInt(game.style.top) + 10) + 'px'
        }

    })


    document.querySelector('#top').addEventListener
        ('click', function (event) {
            console.log(document.documentElement.scrollTop)
            // document.documentElement.scrollTop = 0;

            //좋은 예시
            window.scrollTo({
                top: 0,
                behavior: 'smooth'
            })

            //나쁜 예시
            // while (top > 0) {
            //     document.documentElement.scrollTop -= 10
            //     top = document.documentElement.scrollTop
            //     let now = new Date().getTime()
            //     while((new Date().getTime() - now) < 100 ){

            //     }
            // }

            // 시간에 따라서 setTimeout 대량으로 만들어서
            // 부드럽게 보이길 예상하는
            for (let i = document.documentElement.scrollTop; i>=0; i -=10){
                let delay = 2000 - i
                setTimeout(function(){
                    document.documentElement.scrollTop = i
                }, delay)
            }
    })



}

//로그인 버튼 ->
//비어있지 않다면 아이디 / 비번 출력
// 하나라도 비어있다면
// 아이디 필수
// 비밀번호 필수 출력
function idpw() {
    const id = document.querySelector('#id')
    const pw = document.querySelector('#pw')
    const login = document.querySelector('#login') //버튼 
    const log = document.querySelector('#log')

    // console.log(id.value)

    if (id.value == "") {
        log.innerHTML += "id를 입력하세요"
    }
    if (pw.value.trim().length == 0) {
        log.innerHTML += "pw를 입력하세요"
    }
    else if (id.value != '' && pw.value != "") {
        // 출력
        log.innerHTML = '<br>id: ' + id.value;

        log.innerHTML += '<br>pw: ' + pw.value;

    }
    const btn4 = document.querySelector('#btn4')
    btn4.addEventListener('click', btn4click)
    // removeEventListener
    // 이벤트 제거
    // 단, 익명 함수는 불가능
    btn4.removeEventListener('click', btn4click)

    // add - 'scroll'
    window.addEventListener('scroll', function(){
        console.log('window.scrollY', window.scrollY)
    })


}

function btn4click() {
    const btn4 = document.querySelector('#btn4')
    log.innerHTML += "버튼 4 클릭"
}

