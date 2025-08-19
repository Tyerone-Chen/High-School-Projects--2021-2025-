var secretNumber = 42;
var secretDiscount = "LakeviewSavings";

window.localStorage.setItem("secretNum", secretNumber);
window.sessionStorage.setItem("secretDisc", secretDiscount);

let userNum = localStorage.getItem('secretNum');
let userDisc = sessionStorage.getItem('secretDisc');

alert(userNum);
alert(userDisc);

localStorage.removeItem("secretNum");