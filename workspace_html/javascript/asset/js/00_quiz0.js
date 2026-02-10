// 시작
window.addEventListener('load', init)

// 이닛
function init() {
    document.querySelector('#login').addEventListener('click', idpw)
    document.querySelector('#order').addEventListener('click', pizza)
    addrs()
}


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

    log2.innerHTML = "합계: " + sum

    console.log()

    //2-2
    log2_2.innerHTML = '주문하신 메뉴: '
    log2_2.innerHTML += `<br>${pizza.value}<br>`
    log2_2.innerHTML += `${size.id}<br>`
    log2_2.innerHTML += `${edge.value}<br>`
    for (let i = 0; i < pizza.length; i++) {
        log2_2.innerHTML += `${topping[i].id}<br>`
    }
}

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
            else if(!(chk.checked)){
                addrs2.value = ''
                name2.value = ''
            }
        })
}

