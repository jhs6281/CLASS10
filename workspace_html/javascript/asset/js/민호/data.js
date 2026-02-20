// ===============================
// Sports Income Race (1960–2025)
// 5개 종목 × 10명 = 50명
// 안전 Wikimedia 이미지 사용
// 단위 : 억 달러 (가상 누적 데이터)
// ===============================
// ===============================
// 🔥 수익 생성 함수 (필수)
// ===============================
function generateIncome(start, end, multiplier) {

    const income = {};

    for (let year = 1960; year <= 2025; year++) {

        if (year < start || year > end) {
            income[year] = 0;
        } else {

            // 성장 곡선 (영화 느낌 상승)
            const progress = (year - start) / (end - start);
            const curve = Math.sin(progress * Math.PI);

            income[year] = Math.floor(curve * multiplier * 1000);
        }
    }

    return income;
}
const players = [

/* =======================
   🏀 농구 (10)
======================= */

{
    name: "마이클 조던",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/a/ae/Michael_Jordan_in_2014.jpg",
    income: generateIncome(1984, 2003, 2.5)
},
{
    name: "르브론 제임스",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/25/LeBron_James_Lakers.jpg",
    income: generateIncome(2003, 2025, 3.0)
},
{
    name: "코비 브라이언트",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/34/Kobe_Bryant_2014.jpg",
    income: generateIncome(1996, 2016, 2.2)
},
{
    name: "매직 존슨",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/1/1c/Magic_Johnson_2014.jpg",
    income: generateIncome(1979, 1996, 1.8)
},
{
    name: "래리 버드",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/80/Larry_Bird_2004.jpg",
    income: generateIncome(1979, 1992, 1.7)
},
{
    name: "샤킬 오닐",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/26/Shaquille_O%27Neal_2011.jpg",
    income: generateIncome(1992, 2011, 2.1)
},
{
    name: "스테판 커리",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/8d/Stephen_Curry_2016.jpg",
    income: generateIncome(2009, 2025, 2.8)
},
{
    name: "케빈 듀란트",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/31/Kevin_Durant_2017.jpg",
    income: generateIncome(2007, 2025, 2.7)
},
{
    name: "팀 던컨",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/e/e0/Tim_Duncan_2015.jpg",
    income: generateIncome(1997, 2016, 1.9)
},
{
    name: "찰스 바클리",
    sport: "농구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/50/Charles_Barkley_2010.jpg",
    income: generateIncome(1984, 2000, 1.5)
},

/* =======================
   ⚽ 축구 (10)
======================= */

{
    name: "펠레",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/3e/Pele_con_brasil.jpg",
    income: generateIncome(1960, 1977, 1.4)
},
{
    name: "디에고 마라도나",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/2e/Maradona_1986.jpg",
    income: generateIncome(1976, 1997, 1.6)
},
{
    name: "리오넬 메시",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/89/Lionel_Messi_20180626.jpg",
    income: generateIncome(2004, 2025, 3.2)
},
{
    name: "크리스티아누 호날두",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
    income: generateIncome(2003, 2025, 3.1)
},
{
    name: "네이마르",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5c/Neymar_2018.jpg",
    income: generateIncome(2009, 2025, 2.6)
},
{
    name: "지네딘 지단",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5c/Zinedine_Zidane_2006.jpg",
    income: generateIncome(1988, 2006, 1.8)
},
{
    name: "데이비드 베컴",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5f/David_Beckham_2011.jpg",
    income: generateIncome(1993, 2013, 2.0)
},
{
    name: "킬리안 음바페",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5d/Kylian_Mbappe_2019.jpg",
    income: generateIncome(2016, 2025, 2.4)
},
{
    name: "호나우두",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/7/74/Ronaldo_2002.jpg",
    income: generateIncome(1993, 2011, 2.1)
},
{
    name: "로베르트 레반도프스키",
    sport: "축구",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/3b/Robert_Lewandowski_2018.jpg",
    income: generateIncome(2008, 2025, 2.3)
},

/* =======================
   🥊 복싱 (10)
======================= */

{
    name: "무하마드 알리",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/8e/Muhammad_Ali_NYWTS.jpg",
    income: generateIncome(1960, 1981, 1.5)
},
{
    name: "마이크 타이슨",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/2c/Mike_Tyson_2019.jpg",
    income: generateIncome(1985, 2005, 2.3)
},
{
    name: "플로이드 메이웨더",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/2d/Floyd_Mayweather_2010.jpg",
    income: generateIncome(1996, 2017, 3.5)
},
{
    name: "매니 파퀴아오",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/2b/Manny_Pacquiao_2011.jpg",
    income: generateIncome(1995, 2021, 2.8)
},
{
    name: "조 프레이저",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/86/Joe_Frazier_1971.jpg",
    income: generateIncome(1965, 1981, 1.2)
},
{
    name: "조지 포먼",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/2f/George_Foreman_1973.jpg",
    income: generateIncome(1969, 1997, 1.9)
},
{
    name: "카넬로 알바레즈",
    sport: "복싱",
    image: "https://upload.wikimedia.org/wikipedia/commons/7/73/Canelo_Alvarez_2019.jpg",
    income: generateIncome(2005, 2025, 2.7)
},

/* =======================
   ⛳ 골프 (10)
======================= */

{
    name: "잭 니클라우스",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/3b/Jack_Nicklaus_2006.jpg",
    income: generateIncome(1962, 2005, 1.9)
},
{
    name: "아놀드 파머",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5c/Arnold_Palmer_2012.jpg",
    income: generateIncome(1955, 2006, 2.2)
},
{
    name: "타이거 우즈",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/4/4d/Tiger_Woods_2018.jpg",
    income: generateIncome(1996, 2025, 3.8)
},
{
    name: "필 미켈슨",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/0/02/Phil_Mickelson_2018.jpg",
    income: generateIncome(1992, 2025, 2.6)
},
{
    name: "그렉 노먼",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/8/8a/Greg_Norman_2014.jpg",
    income: generateIncome(1976, 2010, 1.7)
},
{
    name: "세베 바예스테로스",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/1/15/Seve_Ballesteros_1983.jpg",
    income: generateIncome(1974, 2007, 1.5)
},
{
    name: "로리 매킬로이",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/4/4a/Rory_McIlroy_2013.jpg",
    income: generateIncome(2007, 2025, 2.5)
},
{
    name: "더스틴 존슨",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/0/09/Dustin_Johnson_2016.jpg",
    income: generateIncome(2008, 2025, 2.2)
},
{
    name: "브라이슨 디섐보",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/2/29/Bryson_DeChambeau_2018.jpg",
    income: generateIncome(2016, 2025, 2.1)
},
{
    name: "저스틴 토머스",
    sport: "골프",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/5e/Justin_Thomas_2018.jpg",
    income: generateIncome(2013, 2025, 2.0)
},


/* =======================
   ⚾ 야구 (10)
======================= */

{
    name: "베이브 루스",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/1/13/Babe_Ruth2.jpg",
    income: generateIncome(1960, 1935, 1.0)
},
{
    name: "데릭 지터",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/3/30/Derek_Jeter_2010.jpg",
    income: generateIncome(1995, 2014, 1.8)
},
{
    name: "알렉스 로드리게스",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/6/60/Alex_Rodriguez_2015.jpg",
    income: generateIncome(1994, 2016, 2.4)
},
{
    name: "배리 본즈",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/1/1c/Barry_Bonds_2006.jpg",
    income: generateIncome(1986, 2007, 2.0)
},
{
    name: "미키 맨틀",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/0/0b/Mickey_Mantle_1952.jpg",
    income: generateIncome(1960, 1968, 1.2)
},
{
    name: "윌리 메이스",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/58/Willie_Mays_1971.jpg",
    income: generateIncome(1960, 1973, 1.4)
},
{
    name: "오타니 쇼헤이",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/1/1c/Shohei_Ohtani_2018.jpg",
    income: generateIncome(2018, 2025, 3.2)
},
{
    name: "마이크 트라웃",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/5/59/Mike_Trout_2019.jpg",
    income: generateIncome(2011, 2025, 2.8)
},
{
    name: "클레이튼 커쇼",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/6/63/Clayton_Kershaw_2015.jpg",
    income: generateIncome(2008, 2025, 2.3)
},
{
    name: "알버트 푸홀스",
    sport: "야구",
    image: "https://upload.wikimedia.org/wikipedia/commons/4/47/Albert_Pujols_2019.jpg",
    income: generateIncome(2001, 2022, 2.4)
}


];
