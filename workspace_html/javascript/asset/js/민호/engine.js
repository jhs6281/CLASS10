// ==============================
// 🎬 SAFE PRO ENGINE
// ==============================

let timer = null;
const START_YEAR = 1960;
const END_YEAR = 2025;
let currentYear = START_YEAR;
let mode = "all";

const YEAR_DURATION = 1500;

// DOMContentLoaded 이후 실행
document.addEventListener("DOMContentLoaded", function () {

    const chart = document.getElementById("chart");
    const yearDisplay = document.getElementById("yearDisplay");

    if (!chart || !yearDisplay) {
        console.error("chart 또는 yearDisplay 없음");
        return;
    }

    function easeOutCubic(t) {
        return 1 - Math.pow(1 - t, 3);
    }

    function preloadImages(callback) {
        let loaded = 0;
        const total = players.length;

        players.forEach(p => {
            const img = new Image();
            img.src = p.image;
            img.onload = img.onerror = () => {
                loaded++;
                if (loaded === total) callback();
            };
        });
    }

    function animateYear(target) {
        let start = parseInt(yearDisplay.innerText);
        let startTime = performance.now();

        function update(now) {
            let progress = (now - startTime) / 600;
            if (progress > 1) progress = 1;

            let eased = easeOutCubic(progress);
            let value = Math.floor(start + (target - start) * eased);
            yearDisplay.innerText = value;

            if (progress < 1) requestAnimationFrame(update);
        }

        requestAnimationFrame(update);
    }

    let barElements = {};

    function renderChart(year) {

        let filtered = players
            .filter(p => {
                if (mode === "all") return true;

                const sportMap = {
                    "농구": ["농구", "basketball"],
                    "축구": ["축구", "soccer"],
                    "복싱": ["복싱", "boxing"],
                    "골프": ["골프", "golf"],
                    "야구": ["야구", "baseball"]
                };

                return sportMap[mode]?.includes(p.sport);
            })
            .map(p => ({
                ...p,
                value: p.income[year] || 0
            }))
            .filter(p => p.value > 0)
            .sort((a, b) => b.value - a.value)
            .slice(0, 10);

        filtered.forEach((player, index) => {

            let row = barElements[player.name];

            // 처음 생성
            if (!row) {
                row = document.createElement("div");
                row.className = "bar-row";

                row.innerHTML = `
                <div class="info">
                    <img src="${player.image}" 
                         style="width:40px;height:40px;border-radius:50%;object-fit:cover;margin-right:10px;">
                    <span class="name">${player.name}</span>
                </div>
                <div class="bar">
                    <div class="fill"></div>
                    <span class="value"></span>
                </div>
            `;

                chart.appendChild(row);
                barElements[player.name] = row;
            }

            // 순위 이동 애니메이션
            row.style.transform = `translateY(${index * 70}px)`;
            row.style.transition = "transform 0.8s ease";

            // 1위 강조
            row.classList.toggle("leader", index === 0);

            // 값 업데이트
            const fill = row.querySelector(".fill");
            const value = row.querySelector(".value");

            fill.style.width = `${player.value / 40}%`;
            value.innerText = `${Math.floor(player.value)}억`;
        });
    }

    function nextYear() {

        if (currentYear > END_YEAR) {
            clearTimeout(timer);
            return;
        }

        animateYear(currentYear);
        renderChart(currentYear);

        currentYear++;

        timer = setTimeout(nextYear, YEAR_DURATION);
    }

    // 전역에서 접근 가능하게
    window.setMode = function (newMode) {
        mode = newMode;
        currentYear = START_YEAR;
        clearTimeout(timer);
        nextYear();
    };

    // 시작
    preloadImages(() => {
        nextYear();
    });

    window.setMode = function (newMode) {

        mode = newMode;
        currentYear = START_YEAR;

        clearTimeout(timer); // 기존 루프 중지

        // 바 초기화
        chart.innerHTML = "";
        barElements = {};

        nextYear();
    }

});
