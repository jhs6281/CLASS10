// 시작
window.addEventListener('load', init)

// 이닛
function init() {
    document.querySelector('#login').addEventListener('click', idpw)
    document.querySelector('#order').addEventListener('click', pizza)
    addrs()
    strong()
    todo1()
    thumbnail()
}

// 문제 1번 
function idpw() {
    const id = document.querySelector('#id')
    const pw = document.querySelector('#pw')
    const login = document.querySelector('#login') //버튼 
    const log = document.querySelector('#log')

    // console.log(id.value)

    if (id.value.trim().length == 0) {
        log.innerHTML = "id를 입력하세요"
    }
    if (pw.value.trim().length == 0) {
        log.innerHTML = "pw를 입력하세요"
    }

    else if (id.value != '' && pw.value != "") {
        // 출력
        console.log(id.value); // id 콘솔
        console.log(pw.value); // pw 콘솔
        log.innerHTML = ''
    }
}

// 문제 2번
function pizza() {

    //옵션
    const pizza = document.querySelector('#pizza')
    const size = document.querySelector('input[name="size"]:checked')
    const edge = document.querySelector('input[name="edge"]:checked')
    const topping = document.querySelectorAll('input[name="topping"]:checked')
    //출력기
    const log2 = document.querySelector('#log2')
    const log2_2 = document.querySelector('#log2_2')



    //가격표
    let sum = 0;
    let sum2;

    //2-1
    console.log(size.value)
    sum += parseInt(size.value)
    for (let i = 0; i < topping.length; i++) {
        sum += parseInt(topping[i].value)
    }

    log2.innerHTML = "총 금액: " + sum

    console.log()

    //2-2
    log2_2.innerHTML = '주문 내역: '
    log2_2.innerHTML += `<br>피자 종류: ${pizza.value}<br>`
    log2_2.innerHTML += `사이즈: ${size.id}<br>`
    log2_2.innerHTML += `엣지: ${edge.value}<br>`
    for (let i = 0; i < pizza.length; i++) {
        log2_2.innerHTML += `토핑${i + 1}: ${topping[i].id}<br>`
    }
}

// 문제 3번
function addrs() {
    const name1 = document.querySelector('#name1')
    const name2 = document.querySelector('#name2')
    const addrs1 = document.querySelector('#addrs1')
    const addrs2 = document.querySelector('#addrs2')

    const chk = document.querySelector('#check')
    chk.addEventListener('change', function () {
        if (chk.checked) {
            addrs2.value = addrs1.value
            name2.value = name1.value
        }
        else if (!(chk.checked)) {
            addrs2.value = ''
            name2.value = ''
        }
    })
}

// 문제 4번
function strong() {
    const parent = document.querySelector('#parent4')
    parent.addEventListener('click', function (event) {

        const arr = parent.querySelectorAll('.arr')
        arr.forEach(val => {
            val.classList.remove('bold') // 클래스 전부 제거
        })
        event.target.classList.add('bold') // 클릭한 것에 클래스 추가
    })
}

// 문제 5번

// 전략: 썸네일.addEventListener('mouseover', function (event){
// 오른쪽에 크게
//}
function thumbnail() {
    const thumb = document.querySelector('#img5')
    const img = document.querySelector('#img5_')

    thumb.addEventListener('mouseover', function () {
        img.classList.remove('display5')
    })

    thumb.addEventListener('mouseout', function () {
        img.classList.add('display5')
    })
}

// 문제 6번

function todo1() {
    const tdInput = document.querySelector('#Todo_input') // todo 내용
    const btnAdd = document.querySelector('#btnAdd') // 추가 버튼
    const dltAll = document.querySelector('#dltAll') // 선택 삭제 버튼
    const sltAll = document.querySelector('#sltAll') // 전체 체크박스
    const table = document.querySelector('#board6') // 전체 테이블


    // 6-1
    btnAdd.addEventListener('click', function () {
        // 전략: [btnAdd] 클릭 시 [tr>td체크박스, td할일, 삭제버튼] 추가되게.

        // 열
        const row = document.createElement('tr')
        row.setAttribute('class', 'rowIdx')

        // 체크박스
        const chk = document.createElement('input')
        chk.type = 'checkbox'
        chk.classList.add('chkbx')

        // 내용
        const span = document.createElement('span')
        span.innerText = tdInput.value

        // 개별 삭제 버튼
        const del = document.createElement('button')
        del.innerText = '삭제'

        // 테이블>열>객체
        row.append(chk, span, del)
        table.append(row)

        // 6-2 삭제 버튼 클릭 시 행 삭제
        del.addEventListener('click', function () {
            row.remove()
        })

        // 6-3 전체선택 [인풋 -> 바뀌면] 모든 체크박스 선택/해제
        sltAll.addEventListener('change', function () {
            // 모든 체크박스 = sltAll
            // 개별 체크박스 = chk
            if (sltAll.checked) {
                chk.checked = true;
            }
            else {
                chk.checked = false;
            }
        })

        // 6-4 전체 선택 후 하나라도 해제되면 전체 선택도 해제/ 전체면 체크

        // 전략: selectAll, 배열 개별 검사 -> 해제
        // flag 통과 -> 전체선택

        chk.addEventListener('change', function () {
            const chkbx = document.querySelectorAll('.chkbx') // 배열 길이 상시 체크
            let flag = true; // 깃발 세우고
            for (const item of chkbx) { // 깃발 내리면 체크(전체)해제.
                if (!(item.checked)) {
                    flag = false
                    sltAll.checked = false
                    break;
                }
            } // 깃발 생존 = 전체 체크
            if (flag) sltAll.checked = true
        })

        // 6-5 선택 삭제
        // 전략: 선택 삭제 버튼 클릭 시 - 반복문으로 체크된 것 검사 -> if(chkbx.checked)row.remove
        
        dltAll.addEventListener('click', function () {

            const rowIdx = table.querySelectorAll('.rowIdx') // 행 번호
            const chkbx = document.querySelectorAll('.chkbx') // 체크박스 번호
            // 참고: 체크박스 인덱스 == row 인덱스 / 순서대로 만들어져서 동일함
            
            chkbx.forEach((val, idx) => { // forEach 돌면서 번호 반환
                // forEach idx === 체크박스 인덱스 === 행 인덱스
                if (val.checked) rowIdx[idx].remove() 
            })
        })


    })
}


