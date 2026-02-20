window.addEventListener('load', init)

function init() {
    bind()
}

function bind() {

    const playerImage = new Image();
    playerImage.src = "player.png";
    const canvas = document.getElementById("gameCanvas");
    const ctx = canvas.getContext("2d");
    const message = document.getElementById("message");

    canvas.width = 800;
    canvas.height = 500;

    ctx.imageSmoothingEnabled = false;

    const player = {
        x: 100,
        y: 100,
        width: 32,
        height: 32,
        speed: 3,

        frameX: 0,      // 가로 프레임
        frameY: 0,      // 세로 방향
        maxFrame: 3,
        frameDelay: 10,
        frameTimer: 0,
        moving: false
    };

    const portals = [
        { x: 100, y: 100, size: 50, name: "숲", link: "forest.html" },
        { x: 300, y: 150, size: 50, name: "던전", link: "dungeon.html" },
        { x: 600, y: 120, size: 50, name: "마을", link: "village.html" },
        { x: 200, y: 350, size: 50, name: "광산", link: "mine.html" },
        { x: 550, y: 320, size: 50, name: "성", link: "castle.html" }
    ];

    let keys = {};
    let currentPortal = null;

    document.addEventListener("keydown", e => {
        keys[e.key] = true;

        if (e.key === "Enter" && currentPortal) {
            window.location.href = currentPortal.link;
        }
    });

    document.addEventListener("keyup", e => {
        keys[e.key] = false;
    });

    function update() {

        player.moving = false;

        if (keys["ArrowRight"]) {
            player.x += player.speed;
            player.frameY = 2; // 오른쪽 줄
            player.moving = true;
        }
        if (keys["ArrowLeft"]) {
            player.x -= player.speed;
            player.frameY = 1; // 왼쪽 줄
            player.moving = true;
        }
        if (keys["ArrowUp"]) {
            player.y -= player.speed;
            player.frameY = 3; // 위 줄
            player.moving = true;
        }
        if (keys["ArrowDown"]) {
            player.y += player.speed;
            player.frameY = 0; // 아래 줄
            player.moving = true;
        }

        if (player.moving) {
            player.frameTimer++;
            if (player.frameTimer >= player.frameDelay) {
                player.frameX++;
                if (player.frameX >= player.maxFrame)
                    player.frameX = 0;
                player.frameTimer = 0;
            }
        } else {
            player.frameX = 0; // 멈추면 첫 프레임
        }
        checkPortalCollision();
    }

    function checkPortalCollision() {
        currentPortal = null;

        portals.forEach(portal => {
            if (
                player.x < portal.x + portal.size &&
                player.x + player.width > portal.x &&
                player.y < portal.y + portal.size &&
                player.y + player.height > portal.y
            ) {
                currentPortal = portal;
            }
        });

        if (currentPortal) {
            message.style.display = "block";
            message.style.left = player.x + "px";
            message.style.top = (player.y - 20) + "px";
        } else {
            message.style.display = "none";
        }
    }

    function draw() {

        ctx.clearRect(0, 0, canvas.width, canvas.height);

        // 배경
        ctx.fillStyle = "#4caf50";
        ctx.fillRect(0, 0, canvas.width, canvas.height);

        // 포탈
        portals.forEach(portal => {

            // 포탈 원형
            ctx.fillStyle = "purple";
            ctx.beginPath();
            ctx.arc(
                portal.x + portal.size / 2,
                portal.y + portal.size / 2,
                portal.size / 2,
                0,
                Math.PI * 2
            );
            ctx.fill();

            // 포탈 이름
            ctx.fillStyle = "white";
            ctx.font = "14px Arial";
            ctx.textAlign = "center";
            ctx.fillText(
                portal.name,
                portal.x + portal.size / 2,
                portal.y - 10
            );
        });

        // 플레이어
        ctx.drawImage(
            playerImage,
            player.frameX * player.width,   // 스프라이트 X
            player.frameY * player.height,  // 스프라이트 Y
            player.width,
            player.height,
            player.x,
            player.y,
            player.width,
            player.height
        );
    }

    function gameLoop() {
        playerImage.onload = function () {
            gameLoop();
        };
        update();
        draw();
        requestAnimationFrame(gameLoop);
    }

}