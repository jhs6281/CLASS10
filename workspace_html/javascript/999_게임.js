window.addEventListener('load', init)

function init() {
    bind()
}

function bind() {
    const player = document.getElementById("player");
    const portals = document.querySelectorAll(".portal");
    const game = document.getElementById("game");
    const message = document.getElementById("message");
    let currentPortal = null;
    const objects = [
        { x: 150, y: 200, type: "tree" },
        { x: 500, y: 300, type: "rock" },
        { x: 300, y: 150, type: "flower" },
        { x: 650, y: 400, type: "tree" }
    ];
    // 오브젝트 생성
    objects.forEach(obj => {
        const el = document.createElement("div");
        el.classList.add("object", obj.type);
        el.style.left = obj.x + "px";
        el.style.top = obj.y + "px";
        game.appendChild(el);
    });

    let x = 100;
    let y = 100;
    const speed = 4;

    let keys = {};

    document.addEventListener("keydown", e => {
        keys[e.key] = true;

        // Enter 눌렀을 때
        if (e.key === "Enter" && currentPortal) {
            window.location.href = currentPortal.dataset.link;
        }
    });

    document.addEventListener("keyup", e => {
        keys[e.key] = false;
    });

    function movePlayer() {

        if (keys["ArrowRight"]) x += speed;
        if (keys["ArrowLeft"]) x -= speed;
        if (keys["ArrowUp"]) y -= speed;
        if (keys["ArrowDown"]) y += speed;

        // 맵 경계 제한
        const maxX = game.clientWidth - player.offsetWidth;
        const maxY = game.clientHeight - player.offsetHeight;

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > maxX) x = maxX;
        if (y > maxY) y = maxY;

        player.style.left = x + "px";
        player.style.top = y + "px";

        checkCollision();

        requestAnimationFrame(movePlayer);
    }

    function checkCollision() {
        const playerRect = player.getBoundingClientRect();
        currentPortal = null;

        portals.forEach(portal => {
            const portalRect = portal.getBoundingClientRect();

            if (
                playerRect.left < portalRect.right &&
                playerRect.right > portalRect.left &&
                playerRect.top < portalRect.bottom &&
                playerRect.bottom > portalRect.top
            ) {
                currentPortal = portal;
            }
        });

        if (currentPortal) {
            message.style.display = "block";
            message.style.left = x + "px";
            message.style.top = (y - 30) + "px";
        } else {
            message.style.display = "none";
        }
    }

    movePlayer();

}