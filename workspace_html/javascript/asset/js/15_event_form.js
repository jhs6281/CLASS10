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
    form.addEventListener('submit', function(event){
        
        // 기본 기능을 막는다.
        // event.preventDefault()

        // 검색어가 두글자 이하면
        if(id.value.length <= 2){
            alert('검색어는 두글자 이상입니다')
        } else {
            // submit 함수
            form.submit()
        }
    })

    // addEventListener('copy', function(event){
    //     event.preventDefault()
    //     this.alert('복사금지')
    // })

    // addEventListener('selectstart', function(event){
    //     event.preventDefault()
    // })
})