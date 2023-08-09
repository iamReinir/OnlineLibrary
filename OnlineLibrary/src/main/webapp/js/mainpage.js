/**
 * Author : Nguyen Xuan Trung
 */

let currentPage = 1;
function pager(pageNumber)
{
    //Init
    console.log("paper is called");
    let element = document.getElementById("books");
    let elementPerPage = 5;
    let maxPageFullyVisiblePager = 7;
    let pageChangeRangePerSide = 3
    let pageCount = Math.ceil(element.childElementCount / elementPerPage);
    pageNumber--; //index start at 0

    //Show only the books in the page
    for (let i = 0; i < element.childElementCount; ++i) {
        element.children[i].style.display = "none";
    }
    for (let i = pageNumber*elementPerPage; i < element.childElementCount; ++i) {
        element.children[i].style.display = "none";
    }

    //Create a page switcher
    let pager = document.createElement("div");
    pager.id = "pager";
    if (pageCount < maxPageFullyVisiblePager)
    {        
        pager.appendChild(createPageButton(currentPage-1, "<-"));
        for (let i = 0; i < pageCount; ++i)
        {
            pager.appendChild(createPageButton(i,""+i));
        }                
        pager.appendChild(createPageButton(currentPage+1,"->"));
    }
    element.appendChild(pager);
}

function createPageButton(pageNum,symbol){
    let leftBtn = document.createElement("button");
    leftBtn.onclick = "pager(" + pageNum + ")";
    leftBtn.innerHTML = symbol;
    return leftBtn;
}

//pager(currentPage);