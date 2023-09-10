document.querySelectorAll('.form-select').forEach((el)=>{
    let values = {};
    new TomSelect(el,values);
});

document.getElementById("soumettreTous").addEventListener("click", function() {
    var forms = document.querySelectorAll("form"); // Sélectionne tous les formulaires

    forms.forEach(function(form) {
        form.submit(); // Soumet chaque formulaire
    });
});