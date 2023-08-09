document.querySelectorAll('.form-select').forEach((el)=>{
    let values = {};
    new TomSelect(el,values);
});

function generateForm(nbPrepa) {
    let fieldContainer = $("#derive");
    fieldContainer.empty();
    for (let i = 1; i <= nbPrepa ; i++) {
        fieldContainer.append("<div class=\"col-6\">\n" +
            "    <div class=\"\">\n" +
            "        <label class='form-label' for=\"nbDerive\">Nombre d'échantillons Dérivés:</label>\n" +
            "        <input type=\"number\" class='form-control' \"nbDerive\" name=\"nbDerive\" id=\"nbDerive\">\n" +
            "    </div>\n" +
            "</div>")
    }
}

$(document).ready(function (){
    $("#nombre").change(function () {
        let nbPrepa = $(this).val();
        generateForm(nbPrepa);
    })

    $("#nbDerive").change(function () {
        let nbDerive = $(this).val();
        generateFormD(nbDerive);
    })
})