let total = 0
let cart = "<td id=\"giohang\">GIỎ (" + total+")</td>\n"
document.getElementById("cart").innerHTML = cart
function addtocart() {
    total++
    console.log(total)
    data = "<td id=\"giohang\">GIỎ (" + total+")</td>\n"
    document.getElementById("cart").innerHTML = data
}