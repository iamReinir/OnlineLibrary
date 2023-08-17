//Add the stylesheet
let css = document.createElement("link");
css.setAttribute("rel", "stylesheet");
css.setAttribute("href", "./css/defaultStyle.css");
document.getElementsByTagName("head")[0].appendChild(css);

//Add font awesome icon;
let fa = document.createElement("link");
fa.setAttribute("rel", "stylesheet");
fa.setAttribute(
  "href",
  "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
);
document.getElementsByTagName("head")[0].appendChild(fa);

// header should have a h1 and a nav element
// turn the first element of the header into a section
let header = document.getElementsByTagName("header")[0];
let section = document.createElement("section");
let button = document.createElement("span");
let buttonContain = document.createElement("div");
buttonContain.appendChild(button);
button.onclick = navbarVisibilityFlip;
button.classList.add("clickable");
button.innerHTML = "<i class='fa fa-bars' aria-hidden='true'></i>";
section.appendChild(header.children[0]);
section.appendChild(buttonContain);
header.insertBefore(section, header.children[0]);

function navbarVisibilityFlip() {
  let navBar = document.getElementsByTagName("nav")[0];
  navBar.style.display = navBar.style.display === "none" ? "flex" : "none";
}

navbarVisibilityFlip();