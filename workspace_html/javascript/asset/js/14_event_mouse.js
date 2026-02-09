// window.onload 창 로딩 시 발생(한번만)
window.onload = function () {
    bind()
}

function bind() {
    const log = document.querySelector('#log')
    const area = document.querySelector('#area')

    // 마우스 오른쪽 버튼 방지 / 우클릭 = oncontextmenu
    area.oncontextmenu = function () {
        // alert(1)
        return false;
    }
    // area.addEventListener('contextmenu', function(){
    //  alert(1)
    //  return false
    //  }) //추후 알게됨

    // 마우스로 drag 방지 / 드래그 = onselectstart
    area.onselectstart = function () {
        return false;
    }

    area, addEventListener('dblclick', function () {
        let div = document.createElement('div')
        div.innerHTML = '더블클릭 발생'
        log.prepend(div)
    })

    // mousedown = 마우스 눌렸을 때
    area, addEventListener('mousedown', function () {
        let div = document.createElement('div')
        div.innerHTML = 'mousedown 발생'
        log.prepend(div)
    })

    // mouseup = 마우스 땔 때
    area, addEventListener('mouseup', function () {
        let div = document.createElement('div')
        div.innerHTML = 'mouseup 발생'
        log.prepend(div)
    })

    // click = 클릭 이벤트
    area, addEventListener('click', function () {
        let div = document.createElement('div')
        div.innerHTML = 'click 발생'
        log.prepend(div)
    })

    area, addEventListener('click', function () {
        // let div = document.createElement('div')
        // div.innerHTML = 'click 발생'
        // log.prepend(div)
        showLog('click 발생')
    })

    area.addEventListener('mouseover', function () {
        showLog('mouseover 발생')
        area.style.backgroundColor = 'yellow'
    })
    area.addEventListener('mouseout', function () {
        showLog('mouseout 발생')
        area.style.backgroundColor = 'white'
    })

    area.addEventListener('mousemove', function () {
        showLog('mousemove 발생')
        area.style.backgroundColor = 'white'
    })

    /*
        offset : DOM 최상단 기준 얼마나 떨어졌는가
        page : 스크롤에 관계없이 문서 최상단 기준
        client : 스크롤에 따른 문서 최상단 기준
        screen : 모니터 기준

    */

    area.addEventListener('click', function (evt) {
        // showLog('mousemove 발생')
        console.log('offsetY', evt.offsetY)
        console.log('pageY', evt.pageY)
        console.log('clientY', evt.clientY)
        console.log('screenY', evt.screenY)
        showLog('좌표:')
    })

    // 마우스 움직인다, offsetX 좌표 / offsetY 좌표 
    area.addEventListener('mousemove', function (evt) {

        const offsetX = evt.offsetX
        const offsetY = evt.offsetY
        showLog(`offsetX : ${offsetX}, offsetY : ${offsetY}`)
    })

    //body 안에서, mousemove 할때마다, evt() 함수 / 커서(이미지) 선택 
    // document.querySelector('body').addEventListener('mousemove', function (evt) {
    //     const cursor = document.querySelector('#cursor')

    //     const offsetX = evt.offsetX
    //     const offsetY = evt.offsetY

    //     // img의 X 값은 = evt.offsetX
    //     cursor.offsetX = evt.offsetX
    //     // img의 Y 값은 = evt.offsetY
    //     cursor.offsetY = evt.offsetY

    //     offsetX = cursorX

    //이미지가 마우스 커서를 따라다니는 기능
        document.querySelector('body')
            .addEventListener('mousemove', function (evt) {
                const cursor = document.querySelector('#cursor')
                const pageX = evt.pageX
                const pageY = evt.pageY

                cursor.style.top = pageY + 10 + 'px'
                cursor.style.left = pageX + 10 + 'px'
            })

            // 이미지가 마우스를 따라다니는 코드
            // 조건 : mouse down 시!
        document.querySelector('body')
        .addEventListener('mousemove', function(evt){
            if(isDrag){
                let drag = document.querySelector('#drag')
                drag.style.top = evt.pageY-drag_offset_y + 'px'
                drag.style.left = evt.pageX-drag_offset_x + 'px'
            }
        })
        document.querySelector('#drag')
        .addEventListener('mousedown', function(evt){
            isDrag=true;
            drag_offset_x = evt.offsetX
            drag_offset_y = evt.offsetY
        })
        document.querySelector('#drag')
        .addEventListener('mouseup', function(evt){
            isDrag=false;
        })
        // showLog(`offsetX : ${offsetX}, offsetY : ${offsetY}`)
}
let isDrag = false;
let drag_offset_x = 0;
let drag_offset_y = 0;

function showLog(message) {
    let div = document.createElement('div')
    div.innerHTML = message
    log.prepend(div)
}
