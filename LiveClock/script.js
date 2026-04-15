let alarmTime = null;

function updateClock() {
    const tz = document.getElementById("timezone").value;

    const now = new Date().toLocaleString("en-US", { timeZone: tz });
    const dateObj = new Date(now);

    let hours = dateObj.getHours();
    let minutes = dateObj.getMinutes();
    let seconds = dateObj.getSeconds();

    let period = "AM";

    if (hours >= 12) {
        period = "PM";
        if (hours > 12) hours -= 12;
    }

    if (hours === 0) hours = 12;

    hours = hours < 10 ? "0" + hours : hours;
    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    const timeString = `${hours}:${minutes}:${seconds} ${period}`;
    document.getElementById("clock").innerText = timeString;

    // Date
    const dateString = dateObj.toDateString();
    document.getElementById("date").innerText = dateString;

    // Alarm check
    if (alarmTime === `${hours}:${minutes}`) {
        alert("⏰ Alarm Ringing!");
        alarmTime = null;
    }
}

// Run every second
setInterval(updateClock, 1000);
updateClock();


// 🌙 Toggle Theme
function toggleTheme() {
    const body = document.body;
    body.classList.toggle("dark");
    body.classList.toggle("light");
}


// 🔔 Set Alarm
function setAlarm() {
    const input = document.getElementById("alarmTime").value;
    if (!input) {
        alert("Please select time");
        return;
    }

    alarmTime = input;
    alert("Alarm set for " + alarmTime);
}