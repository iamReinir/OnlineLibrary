// Author : Nguyen Xuan Trung
function navbarVisibilityFlip(){
    let navBar = document.getElementById("navBar");
    navBar.style.display = (navBar.style.display === "none" ? "block" : "none");
}

function logoutConfirm()
{
    return confirm("Do you really want to log out?");
}