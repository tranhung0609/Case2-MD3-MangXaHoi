let userSettings = document.querySelector(".user-settings");
let darkBtn = document.getElementById("dark-button");
let LoadMoreBackground =document.querySelector(".btn-LoadMore");
function UserSettingToggle(){
    userSettings.classList.toggle("user-setting-showup-toggle");
}
// darkBtn.onclick = function(){
//     darkBtn.classList.toggle("dark-mode-on");
// }

function darkModeON(){
    darkBtn.classList.toggle("dark-mode-on");
   document.body.classList.toggle("dark-theme");
};

function LoadMoreToggle(){
    LoadMoreBackground.classList.toggle("loadMoreToggle");
};

// controls id="myvideo"
// onmouseover="function playyy() {document.getElementById('myvideo').play(); } playyy()"
// onmouseout="function stopp(){document.getElementById('myvideo').pause();} stopp()"

function likePost(){
    if (document.getElementById('likeThumb').className == "fa-regular fa-thumbs-up"){
        document.getElementById('likeThumb').className = "fa-solid fa-thumbs-up fa-regular"

    }else {
        document.getElementById('likeThumb').className = "fa-solid fa-thumbs-up fa-regular"
    }
}


// $(document).ready(function (){
//     $('#like-btn').click(function () {
//         $(this).toggle('like-btn');
//         $(this).children('i').className = 'fa-solid fa-thumbs-up fa-regular';
//     })
// });