
console.log("Скрипт загрузился");
function sortTable(n) {
    var table,
        rows,
        switching,
        i,
        x,
        y,
        shouldSwitch,
        dir,
        switchcount = 0;
    table = document.getElementById("mainTable");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < rows.length - 1; i++) { //Change i=0 if you have the header th a separate table.
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
            based on the direction, asc or desc:*/
            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount++;
        } else {
            /*If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

function openDeleteForm() {
    var form = document.getElementById('deleteForm');
        form.style.display = "block";
        var id = document.getElementById("workerId").textContent;
        document.getElementById("workerIdField").value = id;

}
function openVacationForm() {
    var form = document.getElementById('vacationForm');
    form.style.display = "block";
    var id = document.getElementById("workerId").textContent;
    document.getElementById("workerIdFieldVacation").value = id;

}
function openSickleaveForm() {
    var form = document.getElementById('sickleaveForm');
    form.style.display = "block";
    var id = document.getElementById("workerId").textContent;
    document.getElementById("workerIdFieldSickleave").value = id;

}
function openPunishmentForm() {
    var form = document.getElementById('punishmentForm');
    form.style.display = "block";
    var id = document.getElementById("workerId").textContent;
    document.getElementById("workerIdFieldPunishment").value = id;

}
function openFileForm() {
    var form = document.getElementById('add_file_form');
    form.style.display = "block";

}
$(document).ready(function(){

    $("#search").keyup(function(){

        _this = this;

        $.each($("#mainTable tbody tr"), function() {

            if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1) {

                $(this).hide();

            } else {

                $(this).show();

            }

        });

    });

});

$(window).on('load', function() {
    var status = document.getElementById("workerStatus");

    console.log(status);
    if(status.textContent =="Активен") {
        console.log("Активный статус");
        status.style.background = "#7FFF7F";
    }
    if(status.textContent == "Уволен")
        status.style.background = "#AA0000";
    if(status.textContent == "В отпуске")
        status.style.background = "#00b8ff";
    if(status.textContent == "На больничном")
        status.style.background = "#ffe700";
})