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

function generateFormD(nbDerive) {
    let fieldContainer = $("#derive");
    for (let i = 1; i <= nbDerive ; i++) {
        fieldContainer.append('<div class="mb-2">\n' +
            '                            <form id="derive" th:action="@{/preparation/add}" th:object="${echantillonDerive}" method="post">\n' +
            '                                <div class="row">\n' +
            '                                    <div class="mb-4 col-12">\n' +
            '                                        <label class="form-label" for="typePrelevement">Technique:</label>\n' +
            '                                        <select th:field="*{typePrelevement}" class="form-select" name="technique" id="typePrelevement">\n' +
            '                                            <option value=" " selected></option>\n' +
            '                                            <option th:each="typePrelevement : ${techniquePreparations}" th:value="${typePrelevement.id}" th:text="${typePrelevement.libelle}"></option>\n' +
            '                                        </select>\n' +
            '                                        <span th:if="${#fields.hasErrors(\'typePrelevements\')}" th:errors="*{typePrelevement}" class="text-danger"></span>\n' +
            '                                    </div>\n' +
            '                                    \n' +
            '                                    <div class="mb-4 col-2">\n' +
            '                                        <label class="form-label" for="volume">Volume:</label>\n' +
            '                                        <input type="text" id="volume" th:field="*{volume}" class="form-control">\n' +
            '                                        <span th:if="${#fields.hasErrors(\'volume\')}" th:errors="*{volume}" class="text-danger"></span>\n' +
            '                                    </div>\n' +
            '\n' +
            '                                    <div class="mb-4 col-1">\n' +
            '                                        <label class="form-label" for="unite">Unité:</label>\n' +
            '                                        <select th:field="*{unite}" class="form-select" name="unite" id="unite">\n' +
            '                                            <option th:value="ml" th:text="ml"></option>\n' +
            '                                            <option th:value="g" th:text="g"></option>\n' +
            '                                        </select>\n' +
            '                                        <span th:if="${#fields.hasErrors(\'unite\')}" th:errors="*{unite}" class="text-danger"></span>\n' +
            '                                    </div>\n' +
            '                                </div>\n' +
            '                            </form>
            '                        ')
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