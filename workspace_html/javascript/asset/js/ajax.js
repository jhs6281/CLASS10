window.addEventListener('load', bind);

function bind() {
    console.log("hello world");
    const btn1 = document.querySelector('#btn1')
    // ajax 객체 생성 (기본 방법)
    // Request 요청
    const xhr = new XMLHttpRequest();

    // 보낼 준비
    // 방식 method, 주소
    xhr.open('get', 'http://192.168.0.25:8080/proj02_request/req');

    // 보내기
    xhr.send();

    //new open send -> 3중 세트

    // 언제 올 지 모르니 onload event로 실행. 동기화
    xhr.onload = function () {
        // 응답 상자
        console.log(xhr.responseText); // 값을 담아온 것
        const par = JSON.parse(xhr.responseText);

        par.forEach(value => {
            document.querySelector("div").textContent +=
                ` 
                    <div>
                    <span>${Objectkeys(value)}</span>
                    :
                    <span>${value.key}</span>
                    </div>
                `
        });

    }
}

window.addEventListener('load', bind);

function bind() {

    console.log("hello world");

    const url = 'http://192.168.0.25:8080/proj02_request/req'
    const option = {
        method: 'get'
    }

    fetch(url, option).then(function (response) {
        return response.json()
    }).then(function (json) {

        console.log(json); // 값을 담아온 것

    json.forEach(value => {
            document.querySelector("div").textContent +=
                ` 
            <div>
            <span>${Objectkeys(value)}</span>
            :
            <span>${value.key}</span>
            </div>
        `
        });

    }).catch(function (error) { // 에러 발생시 catch
        console.error(error)
    })



}
