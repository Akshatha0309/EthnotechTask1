import React, { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [time, setTime] = useState("");
  const [date, setDate] = useState("");
  const [timezone, setTimezone] = useState("Asia/Kolkata");
  const [theme, setTheme] = useState("dark");
  const [alarmTime, setAlarmTime] = useState("");

  const timezoneNames = {
    "Asia/Kolkata": "India (IST)",
    "America/New_York": "New York (EST)",
    "Europe/London": "London (GMT)",
    "Asia/Tokyo": "Tokyo (JST)",
  };

  useEffect(() => {
    const interval = setInterval(updateClock, 1000);
    return () => clearInterval(interval);
  }, [timezone, alarmTime]);

  const updateClock = () => {
    const now = new Date().toLocaleString("en-US", { timeZone: timezone });
    const dateObj = new Date(now);

    let h = dateObj.getHours();
    let m = dateObj.getMinutes();
    let s = dateObj.getSeconds();

    let period = "AM";

    if (h >= 12) {
      period = "PM";
      if (h > 12) h -= 12;
    }

    if (h === 0) h = 12;

    h = h < 10 ? "0" + h : h;
    m = m < 10 ? "0" + m : m;
    s = s < 10 ? "0" + s : s;

    const currentTime = `${h}:${m}:${s} ${period}`;

    setTime(currentTime);
    setDate(dateObj.toDateString());

    // Alarm
    if (alarmTime && `${h}:${m}` === alarmTime) {
      alert("⏰ Alarm Ringing!");
      setAlarmTime("");
    }
  };

  return (
    <div className={`app ${theme}`}>
      <div className="card">

        <h1 className="title">Live Clock</h1>

        <p className="date">{date}</p>
        <h2 className="time">{time}</h2>

        <p className="timezone">{timezoneNames[timezone]}</p>

        <div className="controls">
          <select onChange={(e) => setTimezone(e.target.value)}>
            <option value="Asia/Kolkata">India</option>
            <option value="America/New_York">New York</option>
            <option value="Europe/London">London</option>
            <option value="Asia/Tokyo">Tokyo</option>
          </select>

          <button onClick={() => setTheme(theme === "dark" ? "light" : "dark")}>
            Toggle Theme
          </button>
        </div>

        <div className="alarm">
          <input
            type="time"
            onChange={(e) => setAlarmTime(e.target.value)}
          />
          <button onClick={() => alert("Alarm Set!")}>Set Alarm</button>
        </div>

      </div>
    </div>
  );
}

export default App;