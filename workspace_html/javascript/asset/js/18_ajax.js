window.addEventListener('load', bind)

function bind() {
    const btn1 = document.querySelector('#btn1')
    btn1.addEventListener('click', function () {

        // ajax 객체 생성 (기본 방법)
        // Request 요청
        const xhr = new XMLHttpRequest();

        // 보낼 준비
        // 방식 method, 주소
        xhr.open('get', 'https://jsonplaceholder.typicode.com/users')

        // 보내기
        xhr.send()
        console.log(0, xhr.responseText) // 요청 보내고 값이 아직 없음 ''

        //new open send -> 3중 세트

        // 언제 올 지 모르니 onload event로 실행. 동기화
        xhr.onload = function () {
            console.log('다녀왔어') // 값 받아 왔다.
            // 응답 상자
            console.log(xhr.responseText) // 값을 담아온 것

            const par = JSON.parse(xhr.responseText)
            console.log('1번 : ', par[1]['name'])
            console.log('2번 : ', par[2]['address']['geo']['lat'])
        }


        // 두번째 사람의 이름을 출력한다.
        // 세번째 사람의 lat 출력


    })



    document.querySelector('#btn2').addEventListener('click', function () {
        const xhr = new XMLHttpRequest();

        xhr.open('get', '17_json.html')
        xhr.send()
        xhr.onload = function () {
            console.log(xhr.responseText)
        }
    })

    document.querySelector('#btn3').addEventListener('click', function () {

        let key = 'e20edf97a4c853442a17a9e3dd6b0e3c7c41e8c1383c87c1515feed5123f46e4'
        const xhr = new XMLHttpRequest();
        let url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst'
        //기상청 양식!
        url += '?serviceKey=' + key
        url += '&numOfRows=1000'
        url += '&pageNo=1'
        url += '&dataType=JSON'
        url += '&base_date=20260212'
        url += '&base_time=1300'
        url += '&nx=63'
        url += '&ny=110'


        xhr.open('get', url)
        xhr.send()

        xhr.onload = function () {
            // console.log(xhr.responseText)
            const weather = JSON.parse(xhr.responseText)
            console.log(weather)

            const q1 = weather.response.body.items.item
            // 문제 1번
            console.log('문제1: ', q1[0]['category'], q1[0]['fcstValue'])
            // 문제 2번
            // let json = {}
            // for (let i = 0; i < q1.length; i++) {
            //     if (q1[i].category == 'T1H') {
            //         console.log(q1[i])

            //         document.querySelector('#temp').innerHTML +=
            //             `                    
            //             <tr>
            //                 <td>${q1[i].fcstTime}</td>
            //                 <td>${q1[i].fcstValue}</td>
            //             </tr>
            //             `
            //         // jason 데이터 정제
            //         if (!json[q1[i].fcstTime]) {
            //             json[q1[i].fcstTime] = {}
            //         }
            //         json[q1[i].fcstTime][q1[i].category] = q1[i].fcstTime
            //         // 이해하기
            //     }
            //     if (q1[i].category == 'RN1') {
            //         console.log(q1[i])

            //         if (!json[q1[i].fcstTime]) {
            //             json[q1[i].fcstTime] = {}
            //         }
            //         json[q1[i].fcstTime][q1[i].category] = q1[i].fcstTime
            //     }
            //     if (q1[i].category == 'REH') {
            //         console.log(q1[i])

            //         if (!json[q1[i].fcstTime]) {
            //             json[q1[i].fcstTime] = {}
            //         }
            //         json[q1[i].fcstTime][q1[i].category] = q1[i].fcstTime
            //     }
            // }
            // 문제 3번

            // forEach 연습
            q1.forEach((value, idx, all) => {
                // value(첫번째 인자) = q1[i]
                // idx(두번째 인자) = q1[i]의 상위 버전(문자열 가능해서)
                // all(세번째 인자) = 전부

                if (value.category == 'T1H') {
                    console.log(value, idx);
                    //문제 3
                    document.querySelector('#temp').innerHTML +=
                        ` 
                    <tr>
                        <td>${value.fcstTime}</td>
                        <td>${value.fcstValue}</td>
                    </tr>
                `
                }

                if (value.category == 'RN1') {
                    console.log(value, idx);
                }

                if (value.category == 'REH') {
                    console.log(value, idx);
                }

            });


        }
    })
    const btn4 = document.querySelector('#btn4')
    btn4.addEventListener('click', function () {

        // const xhr = new XMLHttpRequest();
        // xhr.open('get', 'https://jsonplaceholder.typicode.com/users')
        // xhr.send()
        // xhr.onload = function () {
        //     let response = xhr.responseText
        //     let json = JSON.parse(response)
        //     console.log(json)
        // }

        const url = 'https://jsonplaceholder.typicode.com/users'
        const option = {
            method: 'get'
        }
        // 새로운 방식
        fetch(url, option).then(function (response) {
            return response.json()
        }).then(function (json) {
            console.log(json)
        }).catch(function (error) { // 에러 발생시 catch
            console.error(error)
        })

    })

    const btn5 = document.querySelector('#btn5')
    btn5.addEventListener('click', function () {

        const xhr = new XMLHttpRequest();
        xhr.open('get', 'https://jsonplaceholder.typicode.com/users')
        xhr.send()
        xhr.onreadystatechange = function () {
            console.log(xhr.readyState)
            if (xhr.readyState == 4) { // 4가 DONE (onload 상태)
                console.log('다녀왔어')
            }
            if (xhr.readyState == XMLHttpRequest.DONE) { // DONE 상태
                console.log('다녀왔어')
            }
        }


    })


    // let json = {
    //     // T1H : {}
    //     '1400': {
    //         T1H: 8,
    //         RN1: '강수없음',
    //         REH: 48
    //     }
    // }
    // json['1400'] = {}
    // json['REH'] = {}
    // if (q1[i].category == 'REH') {
    //     console.log(q1[i])

    //     if (!true) { }
    // }


}

function bind() {
    selectAll();
}

function selectAll() {

    const chkbox_selectAll = document.querySelect("#chkbox_selectAll")

    chkbox_selectAll.addEventListener("change", function () {

        const chkbox_selectOne = document.querySelectAll(".chkbox_selectOne")
        if (chkbox_selectAll.checked) {
            // chkbox_selectOne.forEach(value => {
            //     chkbox_selectOne.checked = true
            //  })
            chkbox_selectOne.checked=true

        } else {
            chkbox_selectOne.checked=false
        }


    })
}

