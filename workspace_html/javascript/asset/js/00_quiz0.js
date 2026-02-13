// 시작
window.addEventListener('load', init)

// 이닛
function init() {
    document.querySelector('#login').addEventListener('click', idpw)
    document.querySelector('#order').addEventListener('click', pizza)
    addrs()
    todo1()
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
        else if (!(chk.checked)) {
            addrs2.value = ''
            name2.value = ''
        }
    })
}

//6번

// function todo1() {
//     const tdInput = document.querySelector('#Todo_input')
//     const btnAdd = document.querySelector('#btnAdd')
//     const todo = document.querySelector('.todo')
//     /*
//         btnAdd.addEventListener('click', function () {
//             // 6-1
//             todo[todo.length - 1].innerHTML +=
//                 `<input type="checkbox" class="${todo}" value="${todo.length - 1}">
//                             ${tdInput.value} 
//                             <button class="delete" value="${dlt.length - 1}">삭제</button><br>`
//                         console.log(todo.length)
//                         })
//     }
//     */
//     // innerHTML은 실패.
//     let count = 0;
//     btnAdd.addEventListener('click', function () {
//         // 6-1

//         const row = document.createElement('div')

//         // 체크박스
//         // const chk1 = document.createElement("input")
//         // chk1.setAttribute('type', 'checkbox')
//         // chk1.setAttribute('value', count)
//         // todo.append(chk1)

//         const chk1 = document.createElement("input")
//         chk1.type = 'checkbox'
//         const br = document.createElement('br')

//         console.log(chk1) //테스트

//         // 내용
//         const span = document.createElement("span")
//         span.innerText = tdInput.value

//         console.log(span) // 테스트

//         // 6-2
//         // 삭제 버튼
//         const dlt = document.createElement("button")
//         dlt.value = count


//         dlt.innerText = '삭제'
//         todo.append(chk1, span, dlt, br)

//         todo.addEventListener('click', function (e) {
//             e.stopPropagation()
//         })

//         dlt.addEventListener('click', function () {
//             row.remove()
//         })


//         count++;

//     })
//     // 6-2
//     // dlt[dlt.length - 1].addEventListener('click', function () {
//     //     console.log('1')
//     //     todo[dlt.length - 1].remove()
//     // })
function todo1() {
    const tdInput = document.querySelector('#Todo_input')
    const btnAdd = document.querySelector('#btnAdd')
    const todo = document.querySelector('.todo')
    const dltAll = document.querySelector('#dltAll')
    const sltAll = document.querySelector('#sltAll')


    btnAdd.addEventListener('click', function () {

        // div
        const row = document.createElement('div')

        // 체크박스
        const chk = document.createElement('input')
        chk.type = 'checkbox'

        // 내용
        const span = document.createElement('span')
        span.innerText = tdInput.value

        // 개별 삭제 버튼
        const del = document.createElement('button')
        del.innerText = '삭제'

        const chkArr = document.querySelectorAll('.todo input[type="checkbox"]')

        row.append(chk, span, del)

        todo.append(row)

        del.addEventListener('click', function (e) {
            e.stopPropagation()
            row.remove()
        })

        dltAll.addEventListener('click', function () {
            todo.replaceChildren()
        })

        sltAll.addEventListener('change', function () {
            chkArr
            for (let i = 0; i < chkArr.length; i++) {
                chkArr[i].checked = this.checked
            }
        })


        //전체선택          
        select1.addEventListener('change', function () {
            const check = document.querySelectorAll('.zzz')//클래스가 zzz인애들을 변수에담음
            //변수에 담긴것들만큼 반복 (이건전달인자 이름상관no)
            check.forEach(function (checkbox) {//배열을 하나하나 뽑아쓰기위한 전달인자
                if (select1.checked) { //select1이 체크되면 
                    checkbox.checked = true//check를 체크
                } else if (!select1.checked) {
                    checkbox.checked = false
                }
                // if(!check.checked){
                //     select1.checked=false
                // }
            })
        })
    })
}


