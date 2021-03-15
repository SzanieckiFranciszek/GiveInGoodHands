document.addEventListener("DOMContentLoaded", function () {

    let checkboxes = document.querySelectorAll(".form-group--checkbox input[type='hidden']");

    checkboxes.forEach(function (e) {
        e.remove()
    });
    let form = document.querySelector("form#donation");

    let sumDiv = document.querySelector("div[data-step='5']");

    let sumBtn = document.querySelector("div[data-step='4'] button.next-step");

    //Information to summary donation
    sumBtn.addEventListener("click", function (e) {
        let sumQuantity = sumDiv.querySelector('span.summary-quantity');
        let sumCategory = sumDiv.querySelector('span.summary-category');
        let sumInstitution = sumDiv.querySelector('span.summary-institution');
        sumQuantity.innerHTML = form.querySelector("div[data-step='2'] input").value;

        form.querySelectorAll("div[data-step='1'] div.form-group--checkbox label input").forEach(function (item) {
            if (item.checked) {
                let text = item.parentElement.querySelector("span.description").innerText;
                sumCategory.innerText = sumCategory.innerText + text + " ";
            }
        });
        form.querySelectorAll("div[data-step='3'] div.form-group--checkbox label input")
            .forEach(function (item) {
                if (item.checked) {
                    sumInstitution.innerText = item.parentElement.querySelector("span.description div.title").innerText;
                }
            });
        let address = form.querySelectorAll("div[data-step='4'] input");
        sumDiv.querySelector("#street").innerHTML = address[0].value;
        sumDiv.querySelector("#city").innerHTML = address[1].value;
        sumDiv.querySelector("#zipCode").innerHTML = address[2].value;
        sumDiv.querySelector("#pickUpDate").innerHTML = address[4].value;
        sumDiv.querySelector("#pickUpTime").innerHTML = address[5].value;
        sumDiv.querySelector("#pickUpComment").innerHTML = form.querySelector("div[data-step='4'] textarea").value;


    })

});