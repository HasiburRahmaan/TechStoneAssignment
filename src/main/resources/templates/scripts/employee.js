let employeeData = [];
const getUserData = async () => {
    employeeData = await fetchData(GET_ALL_EMPLOYEE_INFORMATION);
    generateTable();
};

const generateTable = () => {
    let table = document.createElement("TABLE");
    // Added some bootstrap class into table
    ["table", "table-bordered", "w-75", "mx-auto", "text-center", "table-hover"].map((e) =>
        table.classList.add(e)
    );

    let tableHead = document.createElement("THEAD");
    let headRow = document.createElement("TR");

    // Added some bootstrap class into headRow
    ["bg-info", "text-white"].map((e) => headRow.classList.add(e));

    tableHead.appendChild(headRow);

    let headerArray = [
        { text: "Id", value: "employeeId" },
        { text: "Name", value: "employeeName" },
        { text: "Grade", value: "gradeName" },
        { text: "Basic Salary", value: "gradeBasicSalary" },
        { text: "House rent", value: "gradeHouseRent" },
        { text: "Medical allowance", value: "gradeMedicalAllowance" },
        { text: "Current Balance", value: "currentBalance" },
    ];

    // Generate Table Head row from headerArray array
    headerArray.map((e, i) => {
        let tableData = document.createElement("TD");
        tableData.appendChild(document.createTextNode(e.text));
        headRow.appendChild(tableData);
    });

    let tableBody = document.createElement("TBODY");
    table.appendChild(tableHead);
    table.appendChild(tableBody);

    // Generating Row
    employeeData.map((employee, index) => {
        let tr = document.createElement("TR");

        // Generating TD for single row
        headerArray.map((e, i) => {
            let td = document.createElement("TD");
            if(employee[e.value]!=undefined && employee[e.value]!=null){
                td.appendChild(document.createTextNode(employee[e.value]));
            }else{
                td.appendChild(document.createTextNode(""));
            }
            tr.appendChild(td);
        });

        tableBody.appendChild(tr);
    });



    let tableDiv = document.getElementById("tableDiv");
    tableDiv.innerHTML = null;
    tableDiv.appendChild(table);
};

getUserData();
