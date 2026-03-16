
window.addEventListener("load", () => {
    init();
})

function init() {
    const params = new URLSearchParams(window.location.search);
    const postNo = params.get("postNo");

    loadPost(postNo);
    bind();
}

function bind() {

    let isLogin = localStorage.getItem("loginPossible");

    if (isLogin == "true") {
        changeLogin();
    } else {
        changeLogout();
    }

    const btn_comm = document.querySelector("#btn-comm");
    // const btn_main = document.querySelector("#btn-main");
    const logo = document.querySelector(".logo");
    const btn_login = document.querySelector("#btn-login");
    const btn_join = document.querySelector("#btn-join");
    const btn_logout = document.querySelector("#btn-logout");


    // 목록 버튼 누르면 목록으로 이동
    btn_comm.addEventListener("click", () => {
        window.location.href = "./community.html";
    })

    // 메인페이지 버튼 누르면 창 이동
    // btn_main.addEventListener("click", () => {
    //     window.location.href = "./main.html";
    // })
    // 로고로 변경됨
    logo.addEventListener("click", () => {
        window.location.href = "./main.html";
    })

    // 로그인 버튼 누르면 창 이동
    btn_login.addEventListener("click", () => {
        window.location.href = "./login.html";
    })

    // 회원가입 버튼 누르면 창 이동
    btn_join.addEventListener("click", () => {
        window.location.href = "./join.html";
    })

    // 로그아웃 클릭 시 로그인 상태 변경
    btn_logout.addEventListener("click", function () {
        localStorage.removeItem("loginUser");

        localStorage.setItem("loginPossible", "false");
        isLogin = localStorage.getItem("loginPossible");
        changeLogout();
    })




    function changeLogin() {
        // beforeLogin, afterLogin
        const beforeLogin = document.querySelector(".beforeLogin");
        const afterLogin = document.querySelector(".afterLogin");

        beforeLogin.style.display = "none";
        afterLogin.style.display = "flex";
    }

    function changeLogout() {
        // beforeLogin, afterLogin
        const beforeLogin = document.querySelector(".beforeLogin");
        const afterLogin = document.querySelector(".afterLogin");

        login = false;
        beforeLogin.style.display = "flex";
        afterLogin.style.display = "none";
    }

    // 추천 / 비추천
    const like = document.querySelector("#like");
    const unlike = document.querySelector("#unlike");
    let likeCount = 1;
    let unlikeCount = 1;

    like.onclick = () => {
        // 버튼처럼 만들기 위해 드래그 더블클릭 제어한 것
        like.onselectstart = function () {
            return false;
        }
        like, addEventListener('dblclick', function () {
            return false;
        })
        // 카운트
        document.querySelector("#like>span").textContent = likeCount;
        // 상단 추천수 같이쓰기ㅎ
        document.querySelector("#postInfo-right-likes>span").textContent = likeCount;
        likeCount++;
    }
    unlike.onclick = () => {
        unlike.onselectstart = function () {
            return false;
        }
        unlike, addEventListener('dblclick', function () {
            return false;
        })
        document.querySelector("#unlike>span").textContent = unlikeCount;
        unlikeCount++;
    }

    document.querySelector('#post-btn-dlt')
        .addEventListener('click', function () {
            modal(/*post*/)
        })

    document.querySelector('#post-btn-edit')
        .addEventListener('click', function () {
            window.open('post_Writer.html') 
        })

    ///////////////////////////////////////////////////////////
    // 댓글
    let count = 1
    const inputCmtarea = document.querySelector('.inputCmt')
    const mainInput = createInputComment()

    inputCmtarea.append(mainInput.cmt)

    mainInput.add_txt.addEventListener('click', function () {
        //isLogin 정보 가져오기
        // let isLogin = localStorage.getItem("loginPossible");

        // console.log(isLogin);

        // if (isLogin == "true") {
        //     const val = mainInput.txtarea.value.trim()
        //     if (!val) return
        //     createRow(document.querySelector('.cmt_Space'), val)
        //     mainInput.txtarea.value = ""
        // } else {
        //     alert("댓글을 입력하려면 로그인 해주세요.")
        // }
        //!!!!!!!!
        const val = mainInput.txtarea.value.trim()
        createRow(document.querySelector('.cmt_Space'), val)
        mainInput.txtarea.value = ""
        cntComment()
    })

    function getFormattedDate() {
        const today = new Date()
        const year = today.getFullYear()
        const month = String(today.getMonth() + 1).padStart(2, '0')
        const day = String(today.getDate()).padStart(2, '0')
        const hour = String(today.getHours()).padStart(2, '0')
        const minute = String(today.getMinutes()).padStart(2, '0')
        const second = String(today.getSeconds()).padStart(2, '0')

        return `${year}.${month}.${day} ${hour}:${minute}:${second}`
    }

    function createRow(parent, text) {
        const row = document.createElement('div');
        row.className = 'commentRow';

        //localStorage 정보 가져오기
        let loginUser = JSON.parse(localStorage.getItem("loginUser"));

        const row_top = document.createElement("div");
        row_top.className = "commentRow-top";

        // 왼쪽 묶음
        const span_left = document.createElement('span');
        // <닉네임>
        // const nickname = document.createElement('em');
        // nickname.textContent = loginUser.userId;
        // <댓글 번호>
        const count_CommentNum = document.createElement('span');
        count_CommentNum.textContent = "(댓글 번호: " + count + ")";
        // 왼쪽 묶음 조립

        span_left.append(count_CommentNum)
        //nickname,

        // 중간 묶음
        const div_middle = document.createElement('div');
        // <내용>
        const contents = document.createElement('p');
        contents.textContent = text;
        // 중간 묶음 조립
        div_middle.append(contents)


        // 오른쪽 묶음
        const span_right = document.createElement('span')
        span_right.className = "span_right"
        // <날짜>
        const timestamp = document.createElement('span')
        timestamp.textContent = getFormattedDate()
        // <수정>
        const edit = document.createElement('div')
        edit.className = "edit"
        const edit_text = document.createElement('span')
        edit_text.textContent = '수정'
        edit.append(edit_text)
        // <삭제 버튼>
        const dlt_cmt = document.createElement('button')
        dlt_cmt.textContent = 'x'
        // 오른쪽 묶음 조립
        span_right.append(timestamp, edit, dlt_cmt)

        // [삭제 버튼 이벤트]
        dlt_cmt.addEventListener('click', function (e) {
            e.stopPropagation()
            modal(row)
        })
        // [수정 버튼 이벤트]
        edit.onclick = (e) => {
            e.stopPropagation()
            if (row.querySelector('.cmt')) return
            const Ptxt = div_middle.querySelector('p')

            const editInput = createInputComment()
            editInput.txtarea.value = Ptxt.textContent
            row.append(editInput.cmt)

            editInput.add_txt.onclick = () => {
                Ptxt.textContent = editInput.txtarea.value
                editInput.cmt.remove()
            }
        }

        // 조립
        row.append(span_left, div_middle, span_right);

        // [중요] 답글 토글 이벤트 (무한 대댓글용)
        row.addEventListener('click', function (e) {

            e.stopPropagation();
            if (e.target.tagName === 'INPUT' || e.target.tagName === 'BUTTON' || e.target.tagName === 'SPAN') return;

            // 다른 창 끄기 로직
            document.querySelectorAll('.cmt_Space .cmt').forEach(el => {
                if (el.parentElement !== this) el.remove()
            })
            const existingInput = this.querySelector(':scope > .cmt')
            if (existingInput) {
                existingInput.remove()
                cntComment()
            } else {
                const subInput = createInputComment() // 위에서 만드신 공장 함수 호출
                this.append(subInput.cmt)

                subInput.add_txt.onclick = (event) => {
                    event.stopPropagation()
                    const val = subInput.txtarea.value.trim()
                    if (val) {
                        createRow(row, val)
                        subInput.cmt.remove()
                        cntComment()
                    }
                }
            }
        })
        count++
        parent.append(row)
    }

} // bind


async function loadPost(postNo) {
    try {
        const postRes = await DD.V1.SJ.Posts.get(postNo);
        console.log("게시글 정보:", postRes);

        renderPost(postRes);
    } catch (e) {
        console.log("게시글 조회 실패", e)
    }
}

function renderPost(postRes) {
    document.querySelector("#title").innerText = postRes.item.title;
    document.querySelector("#postInfo-left-userName").innerText = postRes.item.authorId;
    document.querySelector("#postInfo-left-postingTime").innerText = postRes.item.createdAt.split("T")[0];
    document.querySelector(".post-content").innerText = postRes.item.content;
    document.querySelector("#postInfo-right-views").innerText = postRes.item.viewCount;
}

function createInputComment() { // 댓글 입력창 생성기
    const cmt = document.createElement('div')
    cmt.className = 'cmt'

    const input_wrap = document.createElement('div')
    input_wrap.className = 'input_wrap'

    const txtarea = document.createElement('input')
    txtarea.type = 'text'
    txtarea.className = 'cmt_input'
    txtarea.placeholder = "댓글을 입력하세요...";

    const add_txt = document.createElement('button')
    add_txt.className = 'add_txt'
    add_txt.textContent = '등록'

    input_wrap.append(txtarea, add_txt)
    cmt.append(input_wrap)
    return { cmt, txtarea, add_txt }
}

let currentVisibleStep = 10; // 처음에 보여줄 댓글 개수

function cntComment() { // 댓글 카운팅
    const allComments = document.querySelectorAll('.commentRow');
    const currentCount = allComments.length;

    const targets = document.querySelectorAll('#btn-comment > span, #cmt_commentCount > span');
    targets.forEach(el, idx => el.textContent = currentCount)
    
    // 댓글이 10개 이상일 때,
    if ((idx + 1) > 10) {

        // 더보기 버튼 생성 (?)
        const cmt_Plus_wrap = document.querySelector('#cmt_Plus_wrap')

        const cmt_pagination = document.createElement('div')
        cmt_pagination.className = "cmt_pagination"
        cmt_pagination.textContent = "+더보기"

        cmt_Plus_wrap.after(cmt_pagination)
        
        // 스크롤 내리면 > 
            for(let i=0; i<currentCount; i++){

            }
        // { 댓글 11~20개 } 보여주기.

        // 어펜드 더보기 div (스크롤로 할거면 안하고.)

    }


}

function modal(evtTarget) { // 모달
    const popup = document.querySelector('#Delete-Popup')
    popup.style.display = 'flex'

    // 삭제 버튼 클릭
    popup.querySelector('.btn-confirm').onclick = (evt) => {
        evtTarget.remove()
        cntComment()
        popup.style.display = 'none'
    }

    // 취소 버튼 클릭
    popup.querySelector('.btn-cancel').onclick = () => {
        popup.style.display = 'none'
    }
}