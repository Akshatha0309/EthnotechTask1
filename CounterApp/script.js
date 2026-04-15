let count = 0;

const MIN_LIMIT = -10;
const MAX_LIMIT = 20;

// Load saved data
window.onload = function () {
    const saved = localStorage.getItem("counterValue");
    const theme = localStorage.getItem("theme");

    if (saved !== null) count = parseInt(saved);

    if (theme === "dark") {
        document.body.classList.add("dark");
    }

    updateDisplay();
};

// Sound
function playSound(type) {
    let sound;
    if (type === "increase") {
        sound = new Audio("https://www.soundjay.com/button/sounds/button-4.mp3");
    } else if (type === "decrease") {
        sound = new Audio("https://www.soundjay.com/button/sounds/button-10.mp3");
    } else {
        sound = new Audio("https://www.soundjay.com/button/sounds/button-3.mp3");
    }
    sound.play();
}

// Update UI
function updateDisplay() {
    const el = document.getElementById("count");

    el.textContent = count;
    localStorage.setItem("counterValue", count);

    // Color
    if (count > 0) el.style.color = "green";
    else if (count < 0) el.style.color = "red";
    else el.style.color = "black";

    // Animation
    el.classList.add("animate");
    setTimeout(() => el.classList.remove("animate"), 200);
}

// Dark Mode Toggle
function toggleTheme() {
    document.body.classList.toggle("dark");

    const isDark = document.body.classList.contains("dark");
    localStorage.setItem("theme", isDark ? "dark" : "light");
}

// Custom Input
function setCustomValue() {
    const input = document.getElementById("customValue").value;

    if (input === "") return;

    let value = parseInt(input);

    // Apply limits
    if (value > MAX_LIMIT) value = MAX_LIMIT;
    if (value < MIN_LIMIT) value = MIN_LIMIT;

    count = value;
    playSound("reset");
    updateDisplay();
}

// Controls
function increase() {
    if (count < MAX_LIMIT) {
        count++;
        playSound("increase");
        updateDisplay();
    }
}

function decrease() {
    if (count > MIN_LIMIT) {
        count--;
        playSound("decrease");
        updateDisplay();
    }
}

function increaseStep() {
    count = Math.min(count + 5, MAX_LIMIT);
    playSound("increase");
    updateDisplay();
}

function decreaseStep() {
    count = Math.max(count - 5, MIN_LIMIT);
    playSound("decrease");
    updateDisplay();
}

function reset() {
    count = 0;
    playSound("reset");
    updateDisplay();
}