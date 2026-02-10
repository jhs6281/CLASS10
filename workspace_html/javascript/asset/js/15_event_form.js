window.addEventListener('load', function () {
    const log = this.document.querySelector('#log')

    this.window.addEventListener('resize', function () {
        const w = this.window.innerWidth;
        const h = this.window.innerHeight;

        log.innerHTML = `<br>너비: ${w}, 높이: ${h}`

    })
    const id = this.document.querySelector('#id')
    id.addEventListener('focus', function () {
        id.style.backgroundColor = 'yellow';
    })
    id.addEventListener('blur', function () {
        id.style.backgroundColor = '';
    })
    id.addEventListener('input', function () {
        const r = parseInt(Math.random() * 256)
        const g = parseInt(Math.random() * 256)
        const b = parseInt(Math.random() * 256)
        const a = Math.random()

        id.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
    })


    const form = document.querySelector('#form')
    const site = document.querySelector('#site')
    site.addEventListener('change', () => {
        console.log(site.value)

        if (site.value == 1) {
            // naver
            form.setAttribute('action', 'https://search.naver.com/search.naver')
        } else if (site.value == 2) {
            // google
            form.setAttribute('action', 'https://www.google.com/search')
        }
    })

    // submit 이벤트
    form.addEventListener('submit', function (event) {

        // 기본 기능을 막는다.
        event.preventDefault()

        // 검색어가 두글자 이하면
        if (id.value.length <= 2) {
            alert('검색어는 두글자 이상입니다')
        } else {
            // submit 함수
            form.submit()
        }
    })

    addEventListener('copy', function (event) {
        event.preventDefault()
        this.alert('복사금지')
    })

    addEventListener('selectstart', function (event) {
        event.preventDefault()
    })

    document.querySelector('#parent')
        .addEventListener('click', function (event) {
            console.log('부모 클릭')

            // event.target : 실제 이벤트가 발생한 DOM
            console.log('target', event.target)
            // event.currentTarget : 이벤트가 적용되어 있는 DOM
            console.log('current-target', event.currentTarget)

            console.log('this', this)
            console.log('this 같음?', this === event.currentTarget)
            // 화살표 arrow 함수인 경우 this를 변경하지 않음
            // 즉 this === window

        }) //true를 넣음으로써 순서가 바뀜

    document.querySelector('#child1')
        .addEventListener('click', function (event) {
            event.stopPropagation() //버블 단계에서 전파를 끝낸다(부모와 연결 끊기)
            console.log('자식1 클릭')
        })
    document.querySelector('#child2')
        .addEventListener('click', function (event) {
            console.log('자식2 클릭')
        })

    // 같이 해보자
    // 1. table 태그에 click 이벤트 주기
    // 2. click된 dom을 출력
    // 3. DOM.classList.contains('chk')로
    // 4. checkbox일 경우만 value 출력

    // id가 board인 요소(테이블)를 선택
    // → 이벤트를 부모(table)에 1개만 주기 위해 선택 (이벤트 위임)
    let board = document.querySelector('#board')


    // board 영역 안에서 클릭이 발생하면 실행되는 이벤트 등록
    board.addEventListener('click', function (event) {

        // // event.target
        // // → 실제로 "클릭된 요소"를 의미
        // // (checkbox, td, span 등 진짜 눌린 애)
        // console.log(event.target)


        // // 클릭된 요소가 'chk' 클래스를 가지고 있는지 검사
        // // classList.contains('클래스명')
        // // 점(.) 붙이지 않는다
        // if (event.target.classList.contains('chk')) {

        //     // checkbox의 value 값 출력
        //     // 예: <input value="10"> → 10
        //     console.log(event.target.value)
        // }
        // // 5. 제목을 클릭했을 때만 내용을 출력

        // if (event.target.classList.contains('title')) {

        //     // checkbox의 value 값 출력
        //     // 예: <input value="10"> → 10
        //     console.log(event.target.innerText)
        // }

        let tr123 = document.querySelectorAll('#board tr')
        //all 쓰면 무조건 반복문 떠올리기

        for (let i = 0; i < tr123.length; i++) {
            tr123[i].addEventListener('click', function (event) {
                //7. 제목만 출력되게
                // console.log(event.currentTarget.querySelector('.title').textContent)
                //8. 체크박스 눌렀을 때만 제목이 안 나오게
                if (event.target.classList.contains('chk')) {
                    //체크 값 리턴
                }
                else {
                    console.log(event.currentTarget.querySelector('.title').textContent)
                }

            })
            tr123[i].querySelector('input.chk')
                .addEventListener('click', function (event) {
                    event.stopPropagation()

                    // 부모로 이동
                    console.log('this.parentNode : ', this.parentNode)

                    //9. checkbox를 클릭했을 때 제목 N 출력
                    console.log(this.parentNode.parentNode.querySelector('.title').textContent)
                    
                })
        }


    })
    //아이디 비번 


    console.log('밖에서 this', this)
    console.log('밖에서 window', this === window)
})