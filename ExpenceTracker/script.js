// =========================
// FILE: script.js
// =========================

let transactions =
JSON.parse(localStorage.getItem("transactions")) || [];

let budget =
localStorage.getItem("budget") || 0;

const balance = document.getElementById("balance");
const income = document.getElementById("income");
const expense = document.getElementById("expense");
const savings = document.getElementById("savings");

const transactionsDiv =
document.getElementById("transactions");

const progressBar =
document.getElementById("progressBar");

const budgetStatus =
document.getElementById("budgetStatus");

const search =
document.getElementById("search");

const filterType =
document.getElementById("filterType");

// DARK MODE
const themeToggle =
document.getElementById("themeToggle");

themeToggle.onclick = () => {

  document.body.classList.toggle("dark");

  localStorage.setItem(
    "theme",
    document.body.classList.contains("dark")
  );

};

if(localStorage.getItem("theme") === "true"){
  document.body.classList.add("dark");
}

// SET BUDGET
function setBudget(){

  budget =
  document.getElementById("budgetInput").value;

  localStorage.setItem("budget",budget);

  updateUI();
}

// ADD TRANSACTION
function addTransaction(){

  const text =
  document.getElementById("text").value;

  const amount =
  Number(document.getElementById("amount").value);

  const type =
  document.getElementById("type").value;

  const category =
  document.getElementById("category").value;

  if(text === "" || amount === 0){
    alert("Fill all fields");
    return;
  }

  const transaction = {

    id:Date.now(),

    text,

    amount,

    type,

    category,

    date:new Date().toLocaleString()

  };

  transactions.unshift(transaction);

  localStorage.setItem(
    "transactions",
    JSON.stringify(transactions)
  );

  updateUI();

  document.getElementById("text").value = "";
  document.getElementById("amount").value = "";
}

// DELETE
function deleteTransaction(id){

  transactions =
  transactions.filter(item => item.id !== id);

  localStorage.setItem(
    "transactions",
    JSON.stringify(transactions)
  );

  updateUI();
}

// UPDATE UI
function updateUI(){

  transactionsDiv.innerHTML = "";

  let totalIncome = 0;
  let totalExpense = 0;

  let filtered = transactions.filter(item => {

    const matchesSearch =
    item.text.toLowerCase()
    .includes(search.value.toLowerCase());

    const matchesType =
    filterType.value === "all" ||
    item.type === filterType.value;

    return matchesSearch && matchesType;
  });

  filtered.forEach(item => {

    if(item.type === "income"){
      totalIncome += item.amount;
    }else{
      totalExpense += item.amount;
    }

    const div = document.createElement("div");

    div.classList.add("transaction");

    div.innerHTML = `

      <div class="transaction-left">

        <strong>${item.text}</strong>

        <small>
          ${item.category} |
          ${item.date}
        </small>

      </div>

      <div class="transaction-right">

        <span class="${
          item.type === "income"
          ? "plus"
          : "minus"
        }">

        ${
          item.type === "income"
          ? "+"
          : "-"
        }

        ₹${item.amount}

        </span>

        <button class="delete-btn"
        onclick="deleteTransaction(${item.id})">

          Delete

        </button>

      </div>

    `;

    transactionsDiv.appendChild(div);

  });

  const totalBalance =
  totalIncome - totalExpense;

  balance.innerText = `₹${totalBalance}`;

  income.innerText = `₹${totalIncome}`;

  expense.innerText = `₹${totalExpense}`;

  savings.innerText =
  `₹${totalBalance}`;

  // BUDGET
  let percent =
  (totalExpense / budget) * 100;

  if(percent > 100){
    percent = 100;
    alert("⚠ Budget Exceeded!");
  }

  progressBar.style.width =
  percent + "%";

  budgetStatus.innerText =
  `Budget Used: ${Math.round(percent)}%`;

  updateChart(totalExpense,totalIncome);
}

// SEARCH
search.addEventListener("input",updateUI);

filterType.addEventListener("change",updateUI);

// CHART
const ctx =
document.getElementById("expenseChart");

let chart;

function updateChart(expenseValue,incomeValue){

  if(chart){
    chart.destroy();
  }

  chart = new Chart(ctx,{

    type:"doughnut",

    data:{

      labels:["Income","Expense"],

      datasets:[{

        data:[incomeValue,expenseValue],

        backgroundColor:[
          "#38ef7d",
          "#ff416c"
        ]

      }]

    }

  });

}

// EXPORT CSV
function exportCSV(){

  let csv =
  "Description,Amount,Type,Category,Date\n";

  transactions.forEach(item => {

    csv +=
    `${item.text},
    ${item.amount},
    ${item.type},
    ${item.category},
    ${item.date}\n`;

  });

  const blob =
  new Blob([csv],{type:"text/csv"});

  const a =
  document.createElement("a");

  a.href =
  URL.createObjectURL(blob);

  a.download =
  "expenses.csv";

  a.click();
}

// INITIAL
updateUI();