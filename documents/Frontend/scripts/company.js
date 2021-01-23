let initialBalance = 0;
let totalAmountOfSalaryOfAllEmployees = 0;

//To check if both the initial value and totalAmountOfSalary been loaded. when counter is 2, all data has been loaded
let counter = 0;

const updateCompanyDataFields = (companyData) => {
  initialBalance = companyData.initialBalance ? companyData.initialBalance : 0;
  document.getElementById("basicSalaryOfFirstGrade").value = companyData.basicSalaryOfLowestGrade;
  document.getElementById("balance").innerText = initialBalance;
  document.getElementById("initialBalanceOfCompany").value = 0
  generateWarningMsg();
  updateBalanceMsgGenerator();
};

const generateWarningMsg = () => {
  let warningMsg = "";
  if (initialBalance < totalAmountOfSalaryOfAllEmployees) {
    warningMsg =
      "Company Balance is lower than total salary of all employee. Increase the balance";
  }
  document.getElementById("warningText").innerText = warningMsg;
};

const updateBalanceMsgGenerator = ()=>{
  let value = document.getElementById('initialBalanceOfCompany').value; 
  let msg = "";
  console.log("value===>", value);
  if(value && value!=0){
    msg = "Updated balance will be "+ Number(Number(initialBalance)+Number(value));
  }
  document.getElementById("updateBalanceMsg").innerText = msg; 
  console.log("msg===>", msg)
}

//Api Call
// Get
const fetchingCompanyInformation = async () => {
  let companyData = await fetchData(GET_COMPANY_INFO);
  updateCompanyDataFields(companyData);
  if (++counter == 2) {
    generateWarningMsg();
  }
};

const getTotalAmountOfSalaryOfAllEmployee = async () => {
  totalAmountOfSalaryOfAllEmployees = await fetchData(
    TOTAL_AMOUNT_OF_SALARY_OF_ALL_EMPLOYEES
  );

  document.getElementById(
    "totalAmountOfSalaryOfAllEmployees"
  ).innerText = totalAmountOfSalaryOfAllEmployees;
  if (++counter == 2) {
    generateWarningMsg();
  }
};

// update initial balance
const updateInitialBalance = async () => {
  let initialBalanceText = document.getElementById("initialBalanceOfCompany")
    .value;
  let response = await postData(UPDATE_COMPANY_INITIAL_BALANCE, "PUT", {
    amount: initialBalanceText,
  });
  updateCompanyDataFields(response);

  alert("updated");
};
// update lowest basic salary
const updateLowestBasicSalary = async () => {
  let lowestBasic = document.getElementById("basicSalaryOfFirstGrade").value;
  let response = await postData(UPDATE_LOWEST_BASIC_SALARY, "PUT", {
    amount: lowestBasic,
  });
  updateCompanyDataFields(response);
  getUserData();
  getTotalAmountOfSalaryOfAllEmployee();
  alert("updated");
};
//Send Salary
const sendSalary = async () => {
  if (initialBalance < totalAmountOfSalaryOfAllEmployees) {
    alert("Balance is low");
  } else {
    await postData(SEND_SALARY, "PUT");
    await fetchingCompanyInformation();
    await getUserData();
    alert("Success");
  }
};


//Mounted
fetchingCompanyInformation();
getTotalAmountOfSalaryOfAllEmployee();
