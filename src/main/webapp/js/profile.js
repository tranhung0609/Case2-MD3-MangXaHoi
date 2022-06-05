function addFriend() {
    if (document.getElementById('addThumb').className == "fas fa-user-plus") {
        document.getElementById('addThumb').className = "fa-solid fa-user-check"

    } else {
        document.getElementById('addThumb').className = "fas fa-user-plus"
    }
}