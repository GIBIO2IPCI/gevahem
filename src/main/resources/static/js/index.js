const nombre = document.getElementById("nbn");
document.querySelectorAll('.form-select').forEach((el)=>{
    let values = {};
    new TomSelect(el,values);
});